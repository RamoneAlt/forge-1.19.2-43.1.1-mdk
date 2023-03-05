package net.owogirl300.dumbmod.block.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class JumpyBlock extends Block {
    public JumpyBlock(Properties properties) {
        super(properties);
    }




    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos blockPos, Player player,
                                 InteractionHand hand, BlockHitResult blockHitResult) {
        //Server: main hand and off-hand Client: main and off-hand (called 4 times in total)



        player.sendSystemMessage(Component.literal("Right Clicked this!"));



        return super.use(state, level, blockPos, player, hand, blockHitResult);
    }


    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof LivingEntity livingEntity) {

            livingEntity.addEffect(new MobEffectInstance(MobEffects.JUMP, 2000));


        }
        super.stepOn(level, pos, state, entity);
    }



}
