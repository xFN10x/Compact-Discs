package fn10.musicexpansion.blocks.entity;

import fn10.musicexpansion.MusicExpanded;
import fn10.musicexpansion.blocks.DiscMonolithBlock;
import fn10.musicexpansion.blocks.StereoBlock;
import fn10.musicexpansion.blocks.entity.base.BasicCDPlayerEntity;
import fn10.musicexpansion.reg.MusicExpandedBlockEntitys;
import fn10.musicexpansion.reg.MusicExpandedItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class DiscMonolithEntity extends BasicCDPlayerEntity {
    public DiscMonolithEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState, MusicExpandedBlockEntitys.MONOLITH_BENTITY);
        showNowPlaying = false;
    }

    public static void tick(Level world, BlockPos blockPos, BlockState blockState, DiscMonolithEntity entity) {
        if (world.isClientSide())
            return;
        boolean bool = !entity.inventory.getFirst().isEmpty();
        if (blockState.getValue(DiscMonolithBlock.LOADED) != bool)
            world.setBlockAndUpdate(blockPos,
                    blockState.setValue(DiscMonolithBlock.LOADED, bool));
       // MusicExpanded.LOGGER.info(String.valueOf(entity.playing));
        if (entity.inventory.getFirst().is(MusicExpandedItems.CD)) {
            if (entity.nextTrackTime > 0) {
                entity.nextTrackTime--;
            } else if (entity.playing) {
                entity.playing = false;
                entity.nextTrack();
            }
        }
    }
}
