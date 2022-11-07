package net.owogirl300.dumbmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class MoonCrustBlock extends Block {

    public MoonCrustBlock(BlockBehaviour.Properties p_54800_) {
        super(p_54800_);
    }

    public void stepOn(Level p_153777_, BlockPos p_153778_, BlockState p_153779_, Entity p_153780_) {
        if (!p_153780_.isSteppingCarefully() && p_153780_ instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)p_153780_)) {
            p_153780_.hurt(DamageSource.HOT_FLOOR, 1.5F);
        }

        super.stepOn(p_153777_, p_153778_, p_153779_, p_153780_);
    }

    public void randomTick(BlockState p_221420_, ServerLevel p_221421_, BlockPos p_221422_, RandomSource p_221423_) {
        BlockPos blockpos = p_221422_.above();
        if (p_221421_.getFluidState(p_221422_).canExtinguish(p_221421_, p_221422_)) {
            p_221421_.playSound((Player)null, p_221422_, SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, 0.5F, 2.6F + (p_221421_.random.nextFloat() - p_221421_.random.nextFloat()) * 0.8F);
            p_221421_.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.25D, (double)blockpos.getZ() + 0.5D, 8, 0.5D, 0.25D, 0.5D, 0.0D);
        }

    }

    public void onPlace(BlockState p_54823_, Level p_54824_, BlockPos p_54825_, BlockState p_54826_, boolean p_54827_) {
        p_54824_.scheduleTick(p_54825_, this, 20);
    }
}



