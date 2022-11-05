package net.owogirl300.dumbmod.block;


import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.owogirl300.dumbmod.DumbMod;
import net.owogirl300.dumbmod.block.custom.AquamarineOre;
import net.owogirl300.dumbmod.block.custom.GarlicCropBlock;
import net.owogirl300.dumbmod.block.custom.JumpyBlock;
import net.owogirl300.dumbmod.block.custom.MossGlowBlock;
import net.owogirl300.dumbmod.item.ModCreativeModeTab;
import net.owogirl300.dumbmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DumbMod.MODID);

    public static final RegistryObject<Block> MARBLE_BLOCK = registerBlock("marble_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.3f).requiresCorrectToolForDrops()), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> POLISHED_MARBLE_BLOCK = registerBlock("polished_marble_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.3f).requiresCorrectToolForDrops()), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> MARBLE_BRICKS = registerBlock("marble_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> MARBLE_ORE = registerBlock("marble_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4.7f).requiresCorrectToolForDrops(),
                    UniformInt.of(2, 4)), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> AQUAMARINE_ORE = registerBlock("aquamarine_ore",
            () -> new AquamarineOre(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.6f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(AquamarineOre.LIT) ? 7 : 2 )), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> DEEPSLATE_MARBLE_ORE = registerBlock("deepslate_marble_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5.8f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> BROWN_QUARTZ_BLOCK = registerBlock("brown_quartz_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.1f).requiresCorrectToolForDrops()), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> AROWQUA_BRICK = registerBlock("arowqua_brick",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f)), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> END_DIRT = registerBlock("end_dirt",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(1f)), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> JUMPY_BLOCK = registerBlock("jumpy_block",
            () -> new JumpyBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> GARLIC_CROP = BLOCKS.register("garlic_crop",
            () -> new GarlicCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> MOSS_GLOW_BLOCK = registerBlock("moss_glow_block",
            () -> new MossGlowBlock(BlockBehaviour.Properties.of(Material.SAND)
                    .strength(1.8f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(MossGlowBlock.LIT) ? 12 : 0 )), ModCreativeModeTab.DUMB_TAB);






    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }


    public static void register(IEventBus eventbus) {
        BLOCKS.register(eventbus);
    }
}
