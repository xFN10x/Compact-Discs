package fn10.musicexpansion.generation.features;

import com.mojang.serialization.Codec;
import fn10.musicexpansion.blocks.DiscMonolithBlock;
import fn10.musicexpansion.items.CompactDiscItem;
import fn10.musicexpansion.music.CDTracks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.ArrayList;
import java.util.List;

public class MonolithFeature extends Feature<NoneFeatureConfiguration> {

    public static final ArrayList<ItemStack> randomDiscs = new ArrayList<>(List.of(
            CompactDiscItem.makeDiscStackWithTracks(CDTracks.C418_13),
            CompactDiscItem.makeDiscStackWithTracks(CDTracks.C418_11),
            CompactDiscItem.makeDiscStackWithTracks(CDTracks.C418_CAT)
    ));

    public MonolithFeature() {
        super(NoneFeatureConfiguration.CODEC);
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

            //must be at least 3 air above
            for (int i = 0; i < 3; i++) {
                BlockPos pos = origin.atY(y + i);
                BlockState block = level.getBlockState(pos);
                if (block.isAir()) return false;
            }

            DiscMonolithBlock monlith = new DiscMonolithBlock();
            ItemStack disc = randomDiscs.get(random.nextInt(randomDiscs.size()));
            BlockState state = monlith.defaultBlockState();

            level.setBlock(origin, state, 0);
            monlith.useItemOn(disc, state, level.getLevel(), origin, null, null, null);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
