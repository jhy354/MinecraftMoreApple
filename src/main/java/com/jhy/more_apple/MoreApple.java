package com.jhy.more_apple;

import com.jhy.more_apple.amazing_apple_salad.AmazingAppleSaladReg;
import com.jhy.more_apple.baked_diamond_apple.BakedDiamondAppleReg;
import com.jhy.more_apple.chorus_apple.ChorusAppleReg;
import com.jhy.more_apple.diamond_apple.DiamondAppleReg;
import com.jhy.more_apple.flame_apple.FlameAppleReg;
import com.jhy.more_apple.iron_apple.IronAppleReg;
import com.jhy.more_apple.strange_villager_apple.StrangeVillagerAppleReg;
import com.jhy.more_apple.villager_apple.VillagerAppleReg;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Utils.MOD_ID)
public class MoreApple
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public MoreApple() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // More Apples
        // Diamond
        DiamondAppleReg.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BakedDiamondAppleReg.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Iron
        IronAppleReg.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Chorus
        ChorusAppleReg.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Entity Apple
        VillagerAppleReg.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        StrangeVillagerAppleReg.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        // Etc
        AmazingAppleSaladReg.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FlameAppleReg.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some pre-init code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
