package net.owogirl300.dumbmod.world.feature;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.owogirl300.dumbmod.DumbMod;


import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.owogirl300.dumbmod.block.ModBlocks;
import net.owogirl300.dumbmod.block.custom.AquamarineOre;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, DumbMod.MODID);


   public static final RegistryObject<PlacedFeature> MARBLE_ORE_PLACED = PLACED_FEATURES.register("marble_ore_placed",
           () -> new PlacedFeature(ModConfiguredFeatures.MARBLE_ORE.getHolder().get(),
                   commonOrePlacement(32, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-69), VerticalAnchor.aboveBottom(80)))));


    public static final RegistryObject<PlacedFeature> AQUAMARINE_ORE_PLACED = PLACED_FEATURES.register("aquamarine_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.AQUAMARINE_ORE.getHolder().get(),
                    commonOrePlacement(15, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> MOON_CRUST_BLOCK_PLACED = PLACED_FEATURES.register("moon_crust_block_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MOON_CRUST_BLOCK.getHolder().get(),
                    commonOrePlacement(11, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

//Moon Crust hurts when walked on-- Add other harmful blocks to generate

    public static final RegistryObject<PlacedFeature> TANZANITE_ORE_PLACED = PLACED_FEATURES.register("tanzanite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.TANZANITE_ORE.getHolder().get(),
                    commonOrePlacement(8, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    //public static final RegistryObject<PlacedFeature> AQUAMARINE_ORE_PLACED = PLACED_FEATURES.register("aquamarine_ore_placed",
    //     () -> new PlacedFeature(ModConfiguredFeatures.AQUAMARINE_ORE.getHolder().get(), commonOrePlacement(7, // VeinsPerChunk
     //         HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));



    public static final RegistryObject<PlacedFeature> BLUE_FATHOM_CHECKED = PLACED_FEATURES.register("blue_fathom_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.BLUE_FATHOM.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.BLUE_FATHOM_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> BLUE_FATHOM_PLACED = PLACED_FEATURES.register("blue_fathom_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BLUE_FATHOM_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2))));




    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}