package net.owogirl300.dumbmod.world.feature;

import com.google.common.base.Suppliers;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
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



    public static final RegistryObject<ConfiguredFeature<?, ?>> BLUE_FATHOM =
            CONFIGURED_FEATURES.register("blue_fathom", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.BLUE_FATHOM_LOG.get()),
                            new StraightTrunkPlacer(5, 6, 3),
                            BlockStateProvider.simple(ModBlocks.BLUE_FATHOM_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                            new TwoLayersFeatureSize(1, 0, 2)).build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> BLUE_FATHOM_SPAWN =
            CONFIGURED_FEATURES.register("blue_fathom_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.BLUE_FATHOM_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.BLUE_FATHOM_CHECKED.getHolder().get())));







    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);


    }
}
