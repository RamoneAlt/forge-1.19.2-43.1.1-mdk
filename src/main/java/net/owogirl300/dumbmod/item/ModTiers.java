package net.owogirl300.dumbmod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier REINFORCEDMEAT = new ForgeTier(2, 3300, -2.4f,
            -2.7f, 22, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.PIG_BLOCK_CHUNK.get()));
}