package net.owogirl300.dumbmod.item;


import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.owogirl300.dumbmod.DumbMod;
import net.owogirl300.dumbmod.block.ModBlocks;
import net.owogirl300.dumbmod.fluid.ModFluids;
import net.owogirl300.dumbmod.item.custom.EightBallItem;
import net.owogirl300.dumbmod.item.custom.RawPigBlockChunk;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DumbMod.MODID);

    public static final RegistryObject<Item> MARBLE = ITEMS.register( "marble",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DUMB_TAB)));

    public static final RegistryObject<Item> RAW_MARBLE = ITEMS.register( "raw_marble",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DUMB_TAB)));

    public static final RegistryObject<Item> EIGHT_BALL = ITEMS.register( "eight_ball",
            () -> new EightBallItem(new Item.Properties().tab(ModCreativeModeTab.DUMB_TAB).stacksTo(1)));

    public static final RegistryObject<Item> GARLIC_SEEDS = ITEMS.register( "garlic_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GARLIC_CROP.get(), new Item.Properties().tab(ModCreativeModeTab.DUMB_TAB).stacksTo(64)));


    public static final RegistryObject<Item> GARLIC = ITEMS.register( "garlic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DUMB_TAB)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(2f).build())));


    public static final RegistryObject<Item> PIG_BLOCK_CHUNK = ITEMS.register( "pig_block_chunk",
            () -> new RawPigBlockChunk(new Item.Properties().tab(ModCreativeModeTab.DUMB_TAB)
                    .food(new FoodProperties.Builder().nutrition(5).saturationMod(2.6f).build())));

    public static final RegistryObject<Item> BLACKCURRANT = ITEMS.register( "blackcurrant",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DUMB_TAB)
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(3f).build())));

    public static final RegistryObject<Item> BLACKCURRANT_SEEDS = ITEMS.register( "blackcurrant_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BLACKCURRANT_CROP.get(), new Item.Properties().tab(ModCreativeModeTab.DUMB_TAB).stacksTo(64)));

    public static final RegistryObject<Item> ACID_BUCKET = ITEMS.register("acid_bucket",
            () -> new BucketItem(ModFluids.SOURCE_ACID,
                    new Item.Properties().tab(ModCreativeModeTab.DUMB_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    // Meat sword
    public static final RegistryObject<Item> REINFORCEDMEAT_SWORD = ITEMS.register("reinforcedmeat_sword",
            () -> new SwordItem(ModTiers.REINFORCEDMEAT, 2, 3f,
                    new Item.Properties().tab(ModCreativeModeTab.DUMB_TAB)));




    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);

    }



}
