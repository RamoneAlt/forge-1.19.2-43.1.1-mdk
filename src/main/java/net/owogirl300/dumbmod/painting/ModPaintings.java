package net.owogirl300.dumbmod.painting;

import net.owogirl300.dumbmod.DumbMod;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS,DumbMod.MODID);

    public static final RegistryObject<PaintingVariant> AMOGUS = PAINTING_VARIANTS.register("amogus",
            () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> COCK = PAINTING_VARIANTS.register("cock",
            () -> new PaintingVariant(16, 32));
    public static void register(IEventBus eventBus) {
        PAINTING_VARIANTS.register(eventBus);
    }
}