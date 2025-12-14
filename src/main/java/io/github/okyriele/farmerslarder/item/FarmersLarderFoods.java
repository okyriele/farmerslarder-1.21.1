package io.github.okyriele.farmerslarder.item;

import io.github.okyriele.farmerslarder.effect.FarmersLarderEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
//import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Items;

public class FarmersLarderFoods {
	public static final int BRIEF_DURATION = 200;    // 5 seconds
    // Borrowed from vectorwing's FoodValues
	public static final int DRINK_DURATION = 600;    // 30 seconds
	public static final int SHORT_DURATION = 1200;    // 1 minute
	public static final int MEDIUM_DURATION = 3600;    // 3 minutes
	public static final int LONG_DURATION = 6000;    // 5 minutes

    public static final FoodProperties BAGEL_FOOD = new FoodProperties.Builder().nutrition(5).saturationModifier(0.6F).build();
	public static final FoodProperties BAMBOO_SHOOTS_FOOD = new FoodProperties.Builder().nutrition(1).saturationModifier(0.6F).build();
    public static final FoodProperties BRAISED_BAMBOO_SHOOTS_FOOD = new FoodProperties.Builder().nutrition(10).saturationModifier(0.7F).usingConvertsTo(Items.BOWL).build();
    public static final FoodProperties BREAKFAST_SANDWICH_FOOD = new FoodProperties.Builder().nutrition(9).saturationModifier(0.7F).build();    
    public static final FoodProperties CAKE_BLOCKA_ICECREAM_FOOD = new FoodProperties.Builder().nutrition(4).saturationModifier(0.2F).usingConvertsTo(Items.BOWL).effect(() -> new MobEffectInstance(FarmersLarderEffects.SUGAR_RUSH, SHORT_DURATION, 3), 1.0F).alwaysEdible().build();
    public static final FoodProperties CARROT_CAKE_SLICE_FOOD = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3F).effect(() -> new MobEffectInstance(FarmersLarderEffects.SUGAR_RUSH, BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties CHOCOLATE_CAKE_SLICE_FOOD = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3F).effect(() -> new MobEffectInstance(FarmersLarderEffects.SUGAR_RUSH, BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties CHOCOLATE_ICECREAM_FOOD = new FoodProperties.Builder().nutrition(3).saturationModifier(0.2F).usingConvertsTo(Items.BOWL).effect(() -> new MobEffectInstance(FarmersLarderEffects.SUGAR_RUSH, SHORT_DURATION, 2), 1.0F).alwaysEdible().build();
    public static final FoodProperties DONUT_FOOD = new FoodProperties.Builder().nutrition(3).saturationModifier(0.15F).effect(() -> new MobEffectInstance(FarmersLarderEffects.SUGAR_RUSH, DRINK_DURATION, 0), 1.0F).alwaysEdible().build();
    public static final FoodProperties DRIED_BERRIES_FOOD = new FoodProperties.Builder().nutrition(2).saturationModifier(0.5F).alwaysEdible().fast().build();
    public static final FoodProperties FISH_AND_CHIPS_FOOD = new FoodProperties.Builder().nutrition(8).saturationModifier(0.6F).usingConvertsTo(Items.BOWL).build();
    public static final FoodProperties FRIED_CHICKEN_FOOD = new FoodProperties.Builder().nutrition(5).saturationModifier(0.45F).build();
    public static final FoodProperties FRIED_CHICKEN_BUCKET_FOOD = new FoodProperties.Builder().nutrition(15).saturationModifier(0.45F).usingConvertsTo(Items.BUCKET).build();
    public static final FoodProperties FRIED_TOMATOES_FOOD = new FoodProperties.Builder().nutrition(5).saturationModifier(0.6F).usingConvertsTo(Items.BOWL).build();
    public static final FoodProperties GARDEN_VEGGIE_SOUP_FOOD = new FoodProperties.Builder().nutrition(8).saturationModifier(0.6F).usingConvertsTo(Items.BOWL).build();
    public static final FoodProperties GLOWBERRY_CHEESECAKE_SLICE_FOOD = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3F).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, SHORT_DURATION, 0), 1.0F).build();
    public static final FoodProperties GRANOLA_BAR_FOOD = new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).alwaysEdible().fast().build();
    public static final FoodProperties HARDBOILED_EGG_FOOD = new FoodProperties.Builder().nutrition(4).saturationModifier(0.4F).build();
    public static final FoodProperties HOME_FRIES_FOOD = new FoodProperties.Builder().nutrition(6).saturationModifier(0.5F).usingConvertsTo(Items.PAPER).build();
    public static final FoodProperties JERKY_FOOD = new FoodProperties.Builder().nutrition(3).saturationModifier(0.7F).alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties PUMPKIN_BREAD_FOOD = new FoodProperties.Builder().nutrition(6).saturationModifier(0.6F).build();
    public static final FoodProperties PUMPKIN_CURRY_FOOD = new FoodProperties.Builder().nutrition(8).saturationModifier(0.6F).usingConvertsTo(Items.BOWL).build();
    public static final FoodProperties PUMPKIN_JUICE_FOOD = new FoodProperties.Builder().nutrition(5).saturationModifier(0.6F).usingConvertsTo(Items.GLASS_BOTTLE).alwaysEdible().build();
    public static final FoodProperties PUMPKIN_PIE_SLICE_FOOD = new FoodProperties.Builder().nutrition(4).saturationModifier(0.6F).build();
    public static final FoodProperties ROASTED_PUMPKIN_SEEDS_FOOD = new FoodProperties.Builder().nutrition(1).saturationModifier(0.3F).alwaysEdible().fast().build();
    public static final FoodProperties ROASTED_SUNFLOWER_SEEDS_FOOD = new FoodProperties.Builder().nutrition(1).saturationModifier(0.3F).alwaysEdible().fast().build();
    public static final FoodProperties SAUTEED_FIDDLEHEADS_FOOD = new FoodProperties.Builder().nutrition(7).saturationModifier(0.7F).usingConvertsTo(Items.BOWL).build();
    public static final FoodProperties SPICE_CAKE_SLICE_FOOD = new FoodProperties.Builder().nutrition(3).saturationModifier(0.2F).effect(() -> new MobEffectInstance(FarmersLarderEffects.ICE_RESISTANCE, SHORT_DURATION, 0), 1.0F).effect(() -> new MobEffectInstance(FarmersLarderEffects.SUGAR_RUSH, BRIEF_DURATION, 0), 1.0F).build();
    public static final FoodProperties SUNFLOWER_SEEDS_FOOD = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1F).alwaysEdible().fast().build();
    public static final FoodProperties SWEET_BERRY_ICECREAM_FOOD = new FoodProperties.Builder().nutrition(3).saturationModifier(0.2F).usingConvertsTo(Items.BOWL).effect(() -> new MobEffectInstance(FarmersLarderEffects.SUGAR_RUSH, SHORT_DURATION, 1), 1.0F).alwaysEdible().build();
    public static final FoodProperties SYRUP_BOTTLE_FOOD = new FoodProperties.Builder().nutrition(6).saturationModifier(0.1F).usingConvertsTo(Items.GLASS_BOTTLE).build();
    public static final FoodProperties TRAILMIX_FOOD = new FoodProperties.Builder().nutrition(4).saturationModifier(0.4F).alwaysEdible().fast().build();
    public static final FoodProperties TRIFECTA_SUNDAE_FOOD = new FoodProperties.Builder().nutrition(7).saturationModifier(0.1F).usingConvertsTo(Items.BOWL).effect(() -> new MobEffectInstance(FarmersLarderEffects.SUGAR_RUSH, MEDIUM_DURATION, 8), 1.0F).alwaysEdible().build(); 
    public static final FoodProperties WESTERN_BREAKFAST_PLATE_FOOD = new FoodProperties.Builder().nutrition(10).saturationModifier(0.85F).usingConvertsTo(Items.BOWL).effect(() -> new MobEffectInstance(MobEffects.SATURATION, MEDIUM_DURATION, 0), 1.0F).build();
    public static final FoodProperties WILD_GREENS_SALAD_FOOD = new FoodProperties.Builder().nutrition(6).saturationModifier(0.7F).usingConvertsTo(Items.BOWL).build();
    
}

