package net.owogirl300.dumbmod.world.feature;

import com.google.common.base.Suppliers;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.owogirl300.dumbmod.DumbMod;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.owogirl300.dumbmod.block.ModBlocks;


import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
        public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
                DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, DumbMod.MODID);

        //list of what can be replaced v
        //what can custom blocks replace ;-;?

        public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_MARBLE_ORES = Suppliers.memoize(() -> List.of(
                OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.MARBLE_ORE.get().defaultBlockState()),
                OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_MARBLE_ORE.get().defaultBlockState())));
        public static final Supplier<List<OreConfiguration.TargetBlockState>> END_AQUAMARINE_ORES = Suppliers.memoize(() -> List.of(
               OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.AQUAMARINE_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> END_TANZANITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.TANZANITE_ORE.get().defaultBlockState())));
       // public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_ZIRCON_ORES = Suppliers.memoize(() -> List.of(
            //    OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHERRACK_ZIRCON_ORE//.get().defaultBlockState())));
//replace these with other ores uwu

        public static final RegistryObject<ConfiguredFeature<?, ?>> MARBLE_ORE = CONFIGURED_FEATURES.register("marble_ore",
                () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_MARBLE_ORES.get(),7)));

          public static final RegistryObject<ConfiguredFeature<?, ?>> AQUAMARINE_ORE = CONFIGURED_FEATURES.register("aquamarine_ore",
               () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(END_AQUAMARINE_ORES.get(), 6)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> TANZANITE_ORE = CONFIGURED_FEATURES.register("tanzanite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(END_TANZANITE_ORES.get(), 9)));
    //    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_ZIRCON_ORE = CONFIGURED_FEATURES.register("nether_zircon_ore",
           //     () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_ZIRCON_ORES.get(), 9)));


    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);


    }
}
