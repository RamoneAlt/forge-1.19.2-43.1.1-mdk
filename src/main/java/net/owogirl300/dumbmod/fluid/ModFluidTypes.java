package net.owogirl300.dumbmod.fluid;

import com.mojang.math.Vector3f;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.owogirl300.dumbmod.DumbMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluidTypes {
    public static final ResourceLocation LAVA_STILL_RL = new ResourceLocation("block/lava_still");
    public static final ResourceLocation LAVA_FLOWING_RL = new ResourceLocation("block/lava_flow");
    public static final ResourceLocation ACID_OVERLAY_RL = new ResourceLocation(DumbMod.MODID, "misc/in_acid");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, DumbMod.MODID);

    public static final RegistryObject<FluidType> ACID_FLUID_TYPE = register("acid_fluid",
            FluidType.Properties.create().lightLevel(1).density(7).viscosity(12).temperature(200).canDrown(false)
                    .fallDistanceModifier(1.2f).supportsBoating(false).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK));


    public void randomTick(Level p_230572_, BlockPos p_230573_, FluidState p_230574_, RandomSource p_230575_) {
        if (p_230572_.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
            int i = p_230575_.nextInt(3);
            if (i > 0) {
                BlockPos blockpos = p_230573_;

                for(int j = 0; j < i; ++j) {
                    blockpos = blockpos.offset(p_230575_.nextInt(3) - 1, 1, p_230575_.nextInt(3) - 1);
                    if (!p_230572_.isLoaded(blockpos)) {
                        return;
                    }


                }
            } else {
                for(int k = 0; k < 3; ++k) {
                    BlockPos blockpos1 = p_230573_.offset(p_230575_.nextInt(3) - 1, 0, p_230575_.nextInt(3) - 1);
                    if (!p_230572_.isLoaded(blockpos1)) {
                        return;
                    }


                }
            }

        }
    }


    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(LAVA_STILL_RL, LAVA_FLOWING_RL, ACID_OVERLAY_RL,
                0xA1008000, new Vector3f(00f / 255f, 80f / 255f, 00f / 255f), properties));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}