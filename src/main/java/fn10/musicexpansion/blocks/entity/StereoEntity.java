package fn10.musicexpansion.blocks.entity;

import fn10.musicexpansion.blocks.StereoBlock;
import fn10.musicexpansion.blocks.entity.base.BasicCDPlayerEntity;
import fn10.musicexpansion.reg.MusicExpandedBlockEntitys;
import fn10.musicexpansion.reg.MusicExpandedItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class StereoEntity extends BasicCDPlayerEntity {
    public StereoEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState, MusicExpandedBlockEntitys.STEREO_BENTITY);
    }

    public static void tick(Level world, BlockPos blockPos, BlockState blockState, StereoEntity entity) {
        if (world.isClientSide())
            return;
        boolean bool = !entity.inventory.getFirst().isEmpty();
        if (blockState.getValue(StereoBlock.LOADED) != bool)
            world.setBlockAndUpdate(blockPos,
                    blockState.setValue(StereoBlock.LOADED, bool));

        if (blockState.getValue(StereoBlock.PLAYING) != entity.playing)
            world.setBlockAndUpdate(blockPos,
                    blockState.setValue(StereoBlock.PLAYING, entity.playing));

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
