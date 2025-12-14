package io.github.okyriele.farmerslarder.item;

import io.github.okyriele.farmerslarder.FarmersLarder;
import io.github.okyriele.farmerslarder.item.affectingitems.CakeBlockaIceCreamItem;
import io.github.okyriele.farmerslarder.item.affectingitems.ChocolateIceCreamItem;
import io.github.okyriele.farmerslarder.item.affectingitems.PumpkinJuiceItem;
import io.github.okyriele.farmerslarder.item.affectingitems.SweetBerryIceCreamItem;
import io.github.okyriele.farmerslarder.item.affectingitems.SyrupBottleItem;
import io.github.okyriele.farmerslarder.item.affectingitems.TrifectaSundaeItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FarmersLarderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FarmersLarder.MODID);

    public static final DeferredItem<Item> BAGEL = ITEMS.register("bagel", () -> new FoodItem(new Item.Properties().food(FarmersLarderFoods.BAGEL_FOOD)));
    public static final DeferredItem<Item> BAMBOO_SHOOTS = ITEMS.register("bamboo_shoots", () -> new FoodItem(new Item.Properties().food(FarmersLarderFoods.BAMBOO_SHOOTS_FOOD)));
    public static final DeferredItem<Item> BRAISED_BAMBOO_SHOOTS = ITEMS.register("braised_bamboo_shoots", () -> new FoodItem(new Item.Properties().craftRemainder(Items.BOWL).food(FarmersLarderFoods.BRAISED_BAMBOO_SHOOTS_FOOD)));
    public static final DeferredItem<Item> BREAKFAST_SANDWICH = ITEMS.register("breakfast_sandwich", () -> new FoodItem(new Item.Properties().food(FarmersLarderFoods.BREAKFAST_SANDWICH_FOOD)));
    public static final DeferredItem<Item> CACTUS_JUICE = ITEMS.register("cactus_juice", () -> new DrinkItem(new Item.Properties().food(FarmersLarderDrinks.CACTUS_JUICE_DRINK), true));
    public static final DeferredItem<Item> CAKE_BLOCKA_ICECREAM = ITEMS.register("cake_blocka_icecream", () -> new CakeBlockaIceCreamItem(new Item.Properties().craftRemainder(Items.BOWL).food(FarmersLarderFoods.CAKE_BLOCKA_ICECREAM_FOOD), true, true));
    public static final DeferredItem<Item> CARROT_CAKE_SLICE = ITEMS.register("carrot_cake_slice", () -> new FoodItem(new Item.Properties().food(FarmersLarderFoods.CARROT_CAKE_SLICE_FOOD)));
    public static final DeferredItem<Item> CHOCOLATE_CAKE_SLICE = ITEMS.register("chocolate_cake_slice", () -> new FoodItem(new Item.Properties().food(FarmersLarderFoods.CHOCOLATE_CAKE_SLICE_FOOD)));
    public static final DeferredItem<Item> CHOCOLATE_ICECREAM = ITEMS.register("chocolate_icecream", () -> new ChocolateIceCreamItem(new Item.Properties().craftRemainder(Items.BOWL).food(FarmersLarderFoods.CHOCOLATE_ICECREAM_FOOD), true, true));
    public static final DeferredItem<Item> COOKING_OIL = ITEMS.register("cooking_oil", () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
    public static final DeferredItem<Item> DONUT = ITEMS.register("donut", () -> new FoodItem(new Item.Properties().food(FarmersLarderFoods.DONUT_FOOD)));
    public static final DeferredItem<Item> DRIED_BERRIES = ITEMS.register("dried_berries", () -> new FoodItem(new Item.Properties().food(FarmersLarderFoods.DRIED_BERRIES_FOOD)));
    public static final DeferredItem<Item> FISH_AND_CHIPS = ITEMS.register("fish_and_chips", () -> new FoodItem(new Item.Properties().craftRemainder(Items.BOWL).food(FarmersLarderFoods.FISH_AND_CHIPS_FOOD)));
    public static final DeferredItem<Item> FRIED_CHICKEN = ITEMS.register("fried_chicken", () -> new FoodItem(new Item.Properties().food(FarmersLarderFoods.FRIED_CHICKEN_FOOD)));
    public static final DeferredItem<Item> FRIED_CHICKEN_BUCKET = ITEMS.register("fried_chicken_bucket", () -> new FoodItem(new Item.Properties().craftRemainder(Items.BUCKET).food(FarmersLarderFoods.FRIED_CHICKEN_BUCKET_FOOD).stacksTo(1)));
    public static final DeferredItem<Item> FRIED_TOMATOES = ITEMS.register("fried_tomatoes", () -> new FoodItem(new Item.Properties().craftRemainder(Items.BOWL).food(FarmersLarderFoods.FRIED_TOMATOES_FOOD)));
    public static final DeferredItem<Item> FRUIT_PUNCH = ITEMS.register("fruit_punch", () -> new DrinkItem(new Item.Properties().food(FarmersLarderDrinks.FRUIT_PUNCH_DRINK), true));
    public static final DeferredItem<Item> GARDEN_VEGGIE_SOUP = ITEMS.register("garden_veggie_soup", () -> new FoodItem(new Item.Properties().craftRemainder(Items.BOWL).food(FarmersLarderFoods.GARDEN_VEGGIE_SOUP_FOOD)));
    public static final DeferredItem<Item> GLOWBERRY_CHEESECAKE_SLICE = ITEMS.register("glowberry_cheesecake_slice", () -> new FoodItem(new Item.Properties().food(FarmersLarderFoods.GLOWBERRY_CHEESECAKE_SLICE_FOOD)));
    public static final DeferredItem<Item> GLOWBERRY_JUICE = ITEMS.register("glowberry_juice", () -> new DrinkItem(new Item.Properties().food(FarmersLarderDrinks.GLOWBERRY_JUICE_DRINK), true));
    public static final DeferredItem<Item> GRANOLA_BAR = ITEMS.register("granola_bar", () -> new FoodItem(new Item.Properties().food(FarmersLarderFoods.GRANOLA_BAR_FOOD)));
    public static final DeferredItem<Item> HARDBOILED_EGG = ITEMS.register("hardboiled_egg", () -> new FoodItem(new Item.Properties().food(FarmersLarderFoods.HARDBOILED_EGG_FOOD)));
    public static final DeferredItem<Item> HOME_FRIES = ITEMS.register("home_fries", () -> new FoodItem(new Item.Properties().craftRemainder(Items.PAPER).food(FarmersLarderFoods.HOME_FRIES_FOOD)));
    public static final DeferredItem<Item> JERKY = ITEMS.register("jerky", () -> new FoodItem(new Item.Properties().food(FarmersLarderFoods.JERKY_FOOD)));
    public static final DeferredItem<Item> PUMPKIN_BREAD = ITEMS.register("pumpkin_bread", () -> new FoodItem(new Item.Properties().food(FarmersLarderFoods.PUMPKIN_BREAD_FOOD)));
    public static final DeferredItem<Item> PUMPKIN_CURRY = ITEMS.register("pumpkin_curry", () -> new FoodItem(new Item.Properties().craftRemainder(Items.BOWL).food(FarmersLarderFoods.PUMPKIN_CURRY_FOOD)));
    public static final DeferredItem<Item> PUMPKIN_JUICE = ITEMS.register("pumpkin_juice", () -> new PumpkinJuiceItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).food(FarmersLarderFoods.PUMPKIN_JUICE_FOOD).stacksTo(16), false, true));
    public static final DeferredItem<Item> PUMPKIN_PIE_SLICE = ITEMS.register("pumpkin_pie_slice", () -> new FoodItem(new Item.Properties().food(FarmersLarderFoods.PUMPKIN_PIE_SLICE_FOOD)));
    public static final DeferredItem<Item> ROASTED_PUMPKIN_SEEDS = ITEMS.register("roasted_pumpkin_seeds", () -> new FoodItem(new Item.Properties().food(FarmersLarderFoods.ROASTED_PUMPKIN_SEEDS_FOOD)));
    public static final DeferredItem<Item> ROASTED_SUNFLOWER_SEEDS = ITEMS.register("roasted_sunflower_seeds", () -> new FoodItem(new Item.Properties().food(FarmersLarderFoods.ROASTED_SUNFLOWER_SEEDS_FOOD)));
    public static final DeferredItem<Item> SAUTEED_FIDDLEHEADS = ITEMS.register("sauteed_fiddleheads", () -> new FoodItem(new Item.Properties().craftRemainder(Items.BOWL).food(FarmersLarderFoods.SAUTEED_FIDDLEHEADS_FOOD)));
    public static final DeferredItem<Item> SPICE_CAKE_SLICE = ITEMS.register("spice_cake_slice", () -> new FoodItem(new Item.Properties().food(FarmersLarderFoods.SPICE_CAKE_SLICE_FOOD)));
    public static final DeferredItem<Item> SUNFLOWER_SEEDS = ITEMS.register("sunflower_seeds", () -> new FoodItem(new Item.Properties().food(FarmersLarderFoods.SUNFLOWER_SEEDS_FOOD)));
    public static final DeferredItem<Item> SWEET_BERRY_ICECREAM = ITEMS.register("sweet_berry_icecream", () -> new SweetBerryIceCreamItem(new Item.Properties().craftRemainder(Items.BOWL).food(FarmersLarderFoods.SWEET_BERRY_ICECREAM_FOOD), true, true));
    public static final DeferredItem<Item> SWEET_BERRY_JUICE = ITEMS.register("sweet_berry_juice", () -> new DrinkItem(new Item.Properties().food(FarmersLarderDrinks.SWEET_BERRY_JUICE_DRINK), true));
    public static final DeferredItem<Item> SYRUP_BOTTLE = ITEMS.register("syrup_bottle", () -> new SyrupBottleItem(new Item.Properties().food(FarmersLarderFoods.SYRUP_BOTTLE_FOOD).stacksTo(16)));
    public static final DeferredItem<Item> TRAILMIX = ITEMS.register("trailmix", () -> new FoodItem(new Item.Properties().food(FarmersLarderFoods.TRAILMIX_FOOD)));
    public static final DeferredItem<Item> TRIFECTA_SUNDAE = ITEMS.register("trifecta_sundae", () -> new TrifectaSundaeItem(new Item.Properties().craftRemainder(Items.BOWL).food(FarmersLarderFoods.TRIFECTA_SUNDAE_FOOD).stacksTo(3), true, true));
    public static final DeferredItem<Item> WESTERN_BREAKFAST_PLATE = ITEMS.register("western_breakfast_plate", () -> new FoodItem(new Item.Properties().craftRemainder(Items.BOWL).food(FarmersLarderFoods.WESTERN_BREAKFAST_PLATE_FOOD), true));
    public static final DeferredItem<Item> WILD_GREENS_SALAD = ITEMS.register("wild_greens_salad", () -> new FoodItem(new Item.Properties().craftRemainder(Items.BOWL).food(FarmersLarderFoods.WILD_GREENS_SALAD_FOOD)));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
