package io.github.okyriele.farmerslarder.item;
import io.github.okyriele.farmerslarder.FarmersLarder;
import io.github.okyriele.farmerslarder.effect.FarmersLarderEffects;
import io.github.okyriele.farmerslarder.item.DrinkItem;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FarmersLarderDrinks {
	public static final int DRINK_DURATION = 600;    // 30 seconds

    // Drinks
    public static final FoodProperties CACTUS_JUICE_DRINK = new FoodProperties.Builder().nutrition(1).saturationModifier(1.0F).usingConvertsTo(Items.GLASS_BOTTLE).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, DRINK_DURATION, 0), 1.0F).build();
    public static final FoodProperties FRUIT_PUNCH_DRINK = new FoodProperties.Builder().nutrition(1).saturationModifier(1.0F).usingConvertsTo(Items.GLASS_BOTTLE).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 0.5F).build();
    public static final FoodProperties GLOWBERRY_JUICE_DRINK = new FoodProperties.Builder().nutrition(1).saturationModifier(1.0F).usingConvertsTo(Items.GLASS_BOTTLE).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, DRINK_DURATION, 0), 1.0F).build();
    public static final FoodProperties SWEET_BERRY_JUICE_DRINK = new FoodProperties.Builder().nutrition(1).saturationModifier(1.0F).usingConvertsTo(Items.GLASS_BOTTLE).alwaysEdible().effect(() -> new MobEffectInstance(FarmersLarderEffects.ICE_RESISTANCE, DRINK_DURATION, 0), 1.0F).build();

    // FIXME -- come back and figure out a way for these to not... be like this
    
}
