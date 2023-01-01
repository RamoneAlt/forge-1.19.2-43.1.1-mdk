package net.owogirl300.dumbmod.fluid;

import net.owogirl300.dumbmod.DumbMod;
import net.owogirl300.dumbmod.block.ModBlocks;
import net.owogirl300.dumbmod.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, DumbMod.MODID);

    public static final RegistryObject<FlowingFluid> SOURCE_ACID = FLUIDS.register("acid_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.ACID_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_ACID = FLUIDS.register("flowing_acid",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.ACID_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties ACID_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.ACID_FLUID_TYPE, SOURCE_ACID, FLOWING_ACID)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.ACID_BLOCK)
            .bucket(ModItems.ACID_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}