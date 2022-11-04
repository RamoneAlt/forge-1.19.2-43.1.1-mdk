package net.owogirl300.dumbmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab DUMB_TAB = new CreativeModeTab("dumbtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.MARBLE.get());
        }
    };
}
