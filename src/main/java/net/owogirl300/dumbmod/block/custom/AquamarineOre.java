package net.owogirl300.dumbmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class AquamarineOre extends Block {
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;

    public AquamarineOre(Properties p_55453_) {
        super(p_55453_);
        this.registerDefaultState(this.defaultBlockState().setValue(LIT, Boolean.valueOf(false)));
    }

    public void attack(BlockState p_55467_, Level p_55468_, BlockPos p_55469_, Player p_55470_) {
        interact(p_55467_, p_55468_, p_55469_);
        super.attack(p_55467_, p_55468_, p_55469_, p_55470_);
    }

    public void stepOn(Level p_154299_, BlockPos p_154300_, BlockState p_154301_, Entity p_154302_) {
        if (!p_154302_.isSteppingCarefully()) {
            interact(p_154301_, p_154299_, p_154300_);
        }

        super.stepOn(p_154299_, p_154300_, p_154301_, p_154302_);
    }

    public InteractionResult use(BlockState p_55472_, Level p_55473_, BlockPos p_55474_, Player p_55475_, InteractionHand p_55476_, BlockHitResult p_55477_) {
        if (p_55473_.isClientSide) {

        } else {
            interact(p_55472_, p_55473_, p_55474_);
        }

        ItemStack itemstack = p_55475_.getItemInHand(p_55476_);
        return itemstack.getItem() instanceof BlockItem && (new BlockPlaceContext(p_55475_, p_55476_, itemstack, p_55477_)).canPlace() ? InteractionResult.PASS : InteractionResult.SUCCESS;
    }

    private static void interact(BlockState p_55493_, Level p_55494_, BlockPos p_55495_) {
        if (!p_55493_.getValue(LIT)) {
            p_55494_.setBlock(p_55495_, p_55493_.setValue(LIT, Boolean.valueOf(true)), 3);
        }

    }

    public boolean isRandomlyTicking(BlockState p_55486_) {
        return p_55486_.getValue(LIT);
    }

    public void randomTick(BlockState p_221918_, ServerLevel p_221919_, BlockPos p_221920_, RandomSource p_221921_) {
        if (p_221918_.getValue(LIT)) {
            p_221919_.setBlock(p_221920_, p_221918_.setValue(LIT, Boolean.valueOf(false)), 3);
        }

    }


    public void animateTick(BlockState p_221913_, Level p_221914_, BlockPos p_221915_, RandomSource p_221916_) {
        if (p_221913_.getValue(LIT)) {
        }

    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_55484_) {
        p_55484_.add(LIT);
    }

}





