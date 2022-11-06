package net.owogirl300.dumbmod.world.feature.tree;

import net.owogirl300.dumbmod.world.feature.ModConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.owogirl300.dumbmod.world.feature.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class BlueFathomTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pLargeHive) {
        return ModConfiguredFeatures.BLUE_FATHOM.getHolder().get();
    }
}