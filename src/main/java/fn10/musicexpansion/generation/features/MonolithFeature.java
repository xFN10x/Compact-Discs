package fn10.musicexpansion.generation.features;

import fn10.musicexpansion.MusicExpanded;
import fn10.musicexpansion.items.CompactDiscItem;
import fn10.musicexpansion.music.CDTracks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static fn10.musicexpansion.reg.MusicExpandedBlocks.DISC_MONOLITH_BLOCK;

public class MonolithFeature extends Feature<NoneFeatureConfiguration> {

    public static final ArrayList<ItemStack> randomDiscs = new ArrayList<>(List.of(
            CompactDiscItem.makeDiscStackWithTracks(CDTracks.C418_13),
            CompactDiscItem.makeDiscStackWithTracks(CDTracks.C418_11),
            CompactDiscItem.makeDiscStackWithTracks(CDTracks.C418_CAT)
    ));

    public MonolithFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }


    public boolean doesBlockHaveNeighbor(Level level, BlockPos pos, boolean ignoreDown) {
        BlockState Tblock = level.getBlockState(pos.above());
        BlockState Dblock = level.getBlockState(pos.below());
        BlockState Nblock = level.getBlockState(pos.north());
        BlockState Eblock = level.getBlockState(pos.east());
        BlockState Sblock = level.getBlockState(pos.south());
        BlockState Wblock = level.getBlockState(pos.west());

        return (
                !Tblock.isAir() ||
                        (!Dblock.isAir() && !ignoreDown) ||
                        !Nblock.isAir() ||
                        !Eblock.isAir() ||
                        !Sblock.isAir() ||
                        !Wblock.isAir()
        );
    }

    public Map<String, Boolean> getBlockNeighbors(Level level, BlockPos pos) {
        BlockState Tblock = level.getBlockState(pos.above());
        BlockState Dblock = level.getBlockState(pos.below());

        BlockState Nblock = level.getBlockState(pos.north());
        BlockState Eblock = level.getBlockState(pos.east());
        BlockState Sblock = level.getBlockState(pos.south());
        BlockState Wblock = level.getBlockState(pos.west());

        HashMap<String, Boolean> map = new HashMap<>();
        map.put("UP", !Tblock.isAir());
        map.put("DOWN", !Dblock.isAir());
        map.put("NORTH", !Nblock.isAir());
        map.put("SOUTH", !Sblock.isAir());
        map.put("EAST", !Eblock.isAir());
        map.put("WEST", !Wblock.isAir());
        return map;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
        try {
            BlockPos origin = featurePlaceContext.origin();
            WorldGenLevel level = featurePlaceContext.level();
            RandomSource random = featurePlaceContext.random();

            int y = origin.getY();
            //y must be between -10 and 40
            if (!(y < 40 && y > -10)) return false;

            boolean foundPlacement = false;

            for (int i = 0; i < 5; i++) {
                BlockPos pos = origin.atY(y - i);
                BlockState block = level.getBlockState(pos);
                if (!block.isAir()) {
                    origin = origin.atY((y - i) + 1);
                    foundPlacement = true;
                    break;
                }
            }
            if (!foundPlacement)
                for (int i = 0; i < 5; i++) {
                    BlockPos pos = origin.atY((y + 5) - i);
                    BlockState block = level.getBlockState(pos);
                    if (!block.isAir()) {
                        origin = origin.atY(((y + 5) - i) + 1);
                        break;
                    }
                }
            y = origin.getY();

            //must be in cave (not working)
            //if (!originBlock.is(Blocks.CAVE_AIR)) return false;

            //must be at least 3 air above
            for (int i = 0; i < 3; i++) {
                BlockPos pos = origin.atY(y + i);
                BlockState block = level.getBlockState(pos);
                if (!block.isAir()) return false;
            }

            ItemStack disc = randomDiscs.get(random.nextInt(randomDiscs.size()));
            BlockState state = DISC_MONOLITH_BLOCK.defaultBlockState();

            level.getLevel().updateNeighboursOnBlockSet(origin, state);
            level.getLevel().setBlockAndUpdate(origin, state);

            for (int x = -3; x < 3; x++) {
                for (int z = -3; z < 3; z++) {
                    for (int y2 = -3; y2 < 3; y2++) {
                        BlockPos pos = origin.offset(x, y2, z);
                        BlockState block = level.getBlockState(pos);
                        BlockState vinesState = Blocks.VINE.defaultBlockState();

                        if (doesBlockHaveNeighbor(level.getLevel(), pos, true) && block.isAir() && random.nextBoolean()) {
                            final Map<String, Boolean> blockNeighbors = getBlockNeighbors(level.getLevel(), pos);
                            vinesState = vinesState.setValue(VineBlock.UP, blockNeighbors.get("UP"));
                            vinesState = vinesState.setValue(VineBlock.NORTH, blockNeighbors.get("NORTH"));
                            vinesState = vinesState.setValue(VineBlock.SOUTH, blockNeighbors.get("SOUTH"));
                            vinesState = vinesState.setValue(VineBlock.EAST, blockNeighbors.get("EAST"));
                            vinesState = vinesState.setValue(VineBlock.WEST, blockNeighbors.get("WEST"));

                            //level.getLevel().updateNeighboursOnBlockSet(pos, vinesState);
                            level.setBlock(pos, vinesState, 3);
                        }
                    }
                }
            }

            //DISC_MONOLITH_BLOCK.useItemOn(disc, state, level.getLevel(), origin, null, null, null);

            return true;
        } catch (Exception e) {
            MusicExpanded.LOGGER.error("Failed to generate monolith feature with exception", e);
            return false;
        }
    }
}
