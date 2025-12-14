package io.github.okyriele.farmerslarder.item.affectingitems;

import io.github.okyriele.farmerslarder.item.FoodItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;

public class SyrupBottleItem extends FoodItem {

    public SyrupBottleItem(Item.Properties properties) {
		super(properties);
	}

    @Override
    public SoundEvent getDrinkingSound() {
      return SoundEvents.HONEY_DRINK;
	}

   @Override
   public SoundEvent getEatingSound() {
      return SoundEvents.HONEY_DRINK;
	}
    
}
