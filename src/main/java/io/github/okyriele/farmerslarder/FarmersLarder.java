package io.github.okyriele.farmerslarder;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import io.github.okyriele.farmerslarder.block.FarmersLarderBlocks;
import io.github.okyriele.farmerslarder.effect.FarmersLarderEffects;
import io.github.okyriele.farmerslarder.item.FarmersLarderDrinks;
import io.github.okyriele.farmerslarder.item.FarmersLarderItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(FarmersLarder.MODID)
public class FarmersLarder {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "farmerslarder";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();


    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public FarmersLarder(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (FarmersLarder) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the Deferred Register to the mod event bus so items get registered
        FarmersLarderItems.register(modEventBus);
        FarmersLarderBlocks.register(modEventBus);
        FarmersLarderEffects.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM Farmer's Larder");
    }

    // Add the mod items to the correct creative tabs
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(FarmersLarderItems.SYRUP_BOTTLE);
            event.accept(FarmersLarderItems.BAMBOO_SHOOTS);
            event.accept(FarmersLarderItems.ROASTED_PUMPKIN_SEEDS);
            event.accept(FarmersLarderItems.ROASTED_SUNFLOWER_SEEDS);
            event.accept(FarmersLarderItems.DRIED_BERRIES);
            event.accept(FarmersLarderItems.TRAILMIX);
            event.accept(FarmersLarderItems.GRANOLA_BAR);
            event.accept(FarmersLarderItems.JERKY);
            event.accept(FarmersLarderItems.HARDBOILED_EGG);
            event.accept(FarmersLarderItems.BAGEL);
            event.accept(FarmersLarderItems.DONUT);
            event.accept(FarmersLarderItems.PUMPKIN_BREAD);
            event.accept(FarmersLarderItems.WILD_GREENS_SALAD);
            event.accept(FarmersLarderItems.GARDEN_VEGGIE_SOUP);
            event.accept(FarmersLarderItems.PUMPKIN_CURRY);
            event.accept(FarmersLarderItems.SAUTEED_FIDDLEHEADS);
            event.accept(FarmersLarderItems.BREAKFAST_SANDWICH);
            event.accept(FarmersLarderItems.COOKING_OIL);
            event.accept(FarmersLarderItems.HOME_FRIES);
            event.accept(FarmersLarderItems.FRIED_TOMATOES);
            event.accept(FarmersLarderItems.FISH_AND_CHIPS);
            event.accept(FarmersLarderItems.BRAISED_BAMBOO_SHOOTS);
            event.accept(FarmersLarderItems.FRIED_CHICKEN);
            event.accept(FarmersLarderItems.FRIED_CHICKEN_BUCKET);
            event.accept(FarmersLarderBlocks.WESTERN_BREAKFAST);
            event.accept(FarmersLarderItems.WESTERN_BREAKFAST_PLATE);
            event.accept(FarmersLarderBlocks.CARROT_CAKE);
            event.accept(FarmersLarderItems.CARROT_CAKE_SLICE);
            event.accept(FarmersLarderBlocks.CHOCOLATE_CAKE);
            event.accept(FarmersLarderItems.CHOCOLATE_CAKE_SLICE);
            event.accept(FarmersLarderBlocks.SPICE_CAKE);
            event.accept(FarmersLarderItems.SPICE_CAKE_SLICE);
            event.accept(FarmersLarderBlocks.GLOWBERRY_CHEESECAKE);
            event.accept(FarmersLarderItems.GLOWBERRY_CHEESECAKE_SLICE);
            event.accept(FarmersLarderBlocks.PUMPKIN_PIE);
            event.accept(FarmersLarderItems.PUMPKIN_PIE_SLICE);
            event.accept(FarmersLarderItems.CAKE_BLOCKA_ICECREAM);
            event.accept(FarmersLarderItems.CHOCOLATE_ICECREAM);
            event.accept(FarmersLarderItems.SWEET_BERRY_ICECREAM);
            event.accept(FarmersLarderItems.TRIFECTA_SUNDAE);
            event.accept(FarmersLarderItems.FRUIT_PUNCH);
            event.accept(FarmersLarderItems.CACTUS_JUICE);
            event.accept(FarmersLarderItems.SWEET_BERRY_JUICE);
            event.accept(FarmersLarderItems.GLOWBERRY_JUICE);
            event.accept(FarmersLarderItems.PUMPKIN_JUICE);
        }
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(FarmersLarderBlocks.MAMMOTH_SUNFLOWER);
            event.accept(FarmersLarderItems.SUNFLOWER_SEEDS);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
