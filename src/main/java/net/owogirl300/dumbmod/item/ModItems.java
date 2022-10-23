package net.owogirl300.dumbmod.item;


import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.owogirl300.dumbmod.DumbMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DumbMod.MODID);

    public static final RegistryObject<Item> ZIRCON = ITEMS.register( "zircon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DUMB_TAB)));

    public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register( "raw_zircon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DUMB_TAB)));

    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);

    }



}
