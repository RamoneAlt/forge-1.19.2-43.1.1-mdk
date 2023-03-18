package net.owogirl300.dumbmod.block;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.owogirl300.dumbmod.fluid.ModFluids;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.owogirl300.dumbmod.DumbMod;
import net.owogirl300.dumbmod.block.custom.*;
import net.minecraft.world.level.block.LiquidBlock;
import net.owogirl300.dumbmod.item.ModCreativeModeTab;
import net.owogirl300.dumbmod.item.ModItems;
import net.owogirl300.dumbmod.world.feature.tree.BlueFathomTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

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

    public static final RegistryObject<Block> WEATHERED_MARBLE_BRICKS_STONE = registerBlock("weathered_marble_bricks_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> WEATHERED_MARBLE_BRICKS_STONE_SLAB = registerBlock("weathered_marble_bricks_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> WEATHERED_MARBLE_BRICKS_STTWO = registerBlock("weathered_marble_bricks_sttwo",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> MARBLE_BUTTON = registerBlock("marble_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(0.9f).requiresCorrectToolForDrops().noCollission()), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> MARBLE_BRICK_SLAB = registerBlock("marble_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> MARBLE_BRICK_STAIRS = registerBlock("marble_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.MARBLE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.DUMB_TAB);





    public static final RegistryObject<Block> MARBLE_ORE = registerBlock("marble_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4.7f).requiresCorrectToolForDrops(),
                    UniformInt.of(2, 4)), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> AQUAMARINE_ORE = registerBlock("aquamarine_ore",
            () -> new AquamarineOre(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.6f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(AquamarineOre.LIT) ? 7 : 2 )), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> TANZANITE_ORE = registerBlock("tanzanite_ore",
            () -> new TanzaniteOre(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.6f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(AquamarineOre.LIT) ? 11 : 3 )), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> DEEPSLATE_MARBLE_ORE = registerBlock("deepslate_marble_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5.8f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> BROWN_QUARTZ_BLOCK = registerBlock("brown_quartz_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.1f).requiresCorrectToolForDrops()), ModCreativeModeTab.DUMB_TAB);
    public static final RegistryObject<Block> BROWN_QUARTZ_BRICKS = registerBlock("brown_quartz_bricks",
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

            // Start of Meat blocks section
    public static final RegistryObject<Block> RAW_PIG_BLOCK = registerBlock("raw_pig_block",
            () -> new RawPigBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(0.4f)), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> COOKED_PIG_BLOCK = registerBlock("cooked_pig_block",
            () -> new CookedPigBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(0.4f)), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> REINFORCED_MEAT_BLOCK = registerBlock("reinforced_meat_block",
            () -> new ReinforcedMeatBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.2f)), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<LiquidBlock> ACID_BLOCK = BLOCKS.register("acid_block",
            () -> new LiquidBlock(ModFluids.SOURCE_ACID, BlockBehaviour.Properties.copy(Blocks.LAVA)));
    public static final RegistryObject<Block> GARLIC_CROP = BLOCKS.register("garlic_crop",
            () -> new GarlicCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> BLACKCURRANT_CROP = BLOCKS.register("blackcurrant_crop",
            () -> new BlackcurrantCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> MOSS_GLOW_BLOCK = registerBlock("moss_glow_block",
            () -> new MossGlowBlock(BlockBehaviour.Properties.of(Material.SAND)
                    .strength(1.2f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(MossGlowBlock.LIT) ? 7 : 0 )), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> MOON_CRUST_BLOCK = registerBlock("moon_crust_block",
            () -> new MoonCrustBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.7f).requiresCorrectToolForDrops()
                    ), ModCreativeModeTab.DUMB_TAB);



    //WOOD

    public static final RegistryObject<Block> BLUE_FATHOM_LOG = registerBlock("blue_fathom_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.DUMB_TAB);
    public static final RegistryObject<Block> BLUE_FATHOM_WOOD = registerBlock("blue_fathom_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.DUMB_TAB);
    public static final RegistryObject<Block> STRIPPED_BLUE_FATHOM_LOG = registerBlock("stripped_blue_fathom_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.DUMB_TAB);
    public static final RegistryObject<Block> STRIPPED_BLUE_FATHOM_WOOD = registerBlock("stripped_blue_fathom_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> BLUE_FATHOM_PLANKS = registerBlock("blue_fathom_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .requiresCorrectToolForDrops()) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            }, ModCreativeModeTab.DUMB_TAB);
    public static final RegistryObject<Block> BLUE_FATHOM_LEAVES = registerBlock("blue_fathom_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .requiresCorrectToolForDrops()){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            }, ModCreativeModeTab.DUMB_TAB);

    public static final RegistryObject<Block> BLUE_FATHOM_SAPLING = registerBlock("blue_fathom_sapling",
            () -> new SaplingBlock(new BlueFathomTreeGrower(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.DUMB_TAB);







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
