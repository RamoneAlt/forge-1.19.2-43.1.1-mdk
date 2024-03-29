package net.owogirl300.dumbmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.owogirl300.dumbmod.painting.ModPaintings;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.owogirl300.dumbmod.fluid.ModFluidTypes;
import net.owogirl300.dumbmod.fluid.ModFluids;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.owogirl300.dumbmod.block.ModBlocks;
import net.owogirl300.dumbmod.item.ModItems;
import net.owogirl300.dumbmod.world.feature.ModConfiguredFeatures;
import net.owogirl300.dumbmod.world.feature.ModPlacedFeatures;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DumbMod.MODID)
public class DumbMod{
    public static final String MODID = "dumbmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DumbMod()
    {           //very important amazing commentyt
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);

        ModPaintings.register(modEventBus);


        ModConfiguredFeatures.register(modEventBus);

        ModPlacedFeatures.register(modEventBus);

        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);


        modEventBus.addListener(this::commonSetup);

        ModConfiguredFeatures.register(modEventBus);


        MinecraftForge.EVENT_BUS.register(this);
    }
    private void commonSetup(final FMLCommonSetupEvent event){


    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_ACID.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_ACID.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GARLIC_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACKCURRANT_CROP.get(), RenderType.cutout());
        }
    }
}
