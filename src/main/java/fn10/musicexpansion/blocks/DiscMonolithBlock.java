package fn10.musicexpansion.blocks;

import com.mojang.serialization.MapCodec;
import fn10.musicexpansion.blocks.entity.BasicCDPlayerEntity;
import fn10.musicexpansion.reg.MusicExpandedBlockEntitys;
import fn10.musicexpansion.reg.MusicExpandedItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

import java.util.Optional;

public class DiscMonolithBlock extends StereoBlock {

    public DiscMonolithBlock(Properties properties) {
        super(properties.noOcclusion());
        registerDefaultState(
                defaultBlockState().setValue(FACING, Direction.NORTH).setValue(LOADED, false).setValue(PLAYING, false));
    }

    @Override
    public InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player,
            BlockHitResult blockHitResult) {
        Optional<BasicCDPlayerEntity> entity = level.getBlockEntity(blockPos,
                MusicExpandedBlockEntitys.STEREO_BENTITY);
        BasicCDPlayerEntity realEntity = entity.get();
        if (player.isCrouching()) {
            realEntity.nextTrack();
        } else {
            realEntity.ejectCD();
        }
        return InteractionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state,
            BlockEntityType<T> type) {
        return createTickerHelper(type, MusicExpandedBlockEntitys.MONOLITH_BENTITY, BasicCDPlayerEntity::tick);
    }

}
