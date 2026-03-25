package fn10.musicexpansion.blocks.entity;

import fn10.musicexpansion.blocks.entity.base.BasicCDPlayerEntity;
import fn10.musicexpansion.reg.MusicExpandedBlockEntitys;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class DiscMonolithEntity extends BasicCDPlayerEntity {
    public DiscMonolithEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState, MusicExpandedBlockEntitys.MONOLITH_BENTITY);
    }
}
