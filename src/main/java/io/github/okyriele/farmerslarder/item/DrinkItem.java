package io.github.okyriele.farmerslarder.item;

import io.github.okyriele.farmerslarder.FarmersLarder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.FoodProperties.PossibleEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

import java.util.Iterator;
import java.util.List;

public class DrinkItem extends Item {

   private final boolean hasFoodEffectTooltip;
	private final boolean hasCustomTooltip;

   public DrinkItem(Properties properties) {
      super(properties.craftRemainder(Items.GLASS_BOTTLE).stacksTo(16));
		this.hasFoodEffectTooltip = false;
		this.hasCustomTooltip = false;
   }

   public DrinkItem(Properties properties, boolean hasFoodEffectTooltip) {
		super(properties.craftRemainder(Items.GLASS_BOTTLE).stacksTo(16));
		this.hasFoodEffectTooltip = hasFoodEffectTooltip;
		this.hasCustomTooltip = false;
	}

	public DrinkItem(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
		super(properties.craftRemainder(Items.GLASS_BOTTLE).stacksTo(16));
		this.hasFoodEffectTooltip = hasFoodEffectTooltip;
		this.hasCustomTooltip = hasCustomTooltip;
	}

   @Override
	public UseAnim getUseAnimation(ItemStack stack) {
      return UseAnim.DRINK;
   }

   @Override
	public int getUseDuration(ItemStack stack, LivingEntity entity) {
		return 32;
	}


	/**
	 * FIXME - figure out how to make this item "edible" without having nutrition or saturation, and leave its container/craft remainder
	 */
   @Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack heldStack = player.getItemInHand(hand);

		//Item container = heldStack.getItem().getCraftingRemainingItem();
		if (heldStack.getFoodProperties(player) != null) {
			if (player.canEat(heldStack.getFoodProperties(player).canAlwaysEat())) {
				player.startUsingItem(hand);
				return InteractionResultHolder.consume(heldStack);
			} else {
				return InteractionResultHolder.fail(heldStack);
			}
		}
		return ItemUtils.startUsingInstantly(level, player, hand);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
		if (!level.isClientSide) {
			this.affectConsumer(stack, level, consumer);
		}

		FoodProperties foodproperties = stack.getFoodProperties(consumer);
		return foodproperties != null ? consumer.eat(level, stack, foodproperties) : stack;
	}

	/**
	 * Override this to apply changes to the consumer (e.g. curing effects).
	 */
	public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {

	}

   
	/**
     * Make it refer to a getTranslation method that fetches ("tooltip." + BuiltInRegistries.ITEM.getKey(this).getPath()) and make sure to put stuff in the translation file
     */
   @Override
   public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (this.hasFoodEffectTooltip) {
			List<PossibleEffect> listofEffects = this.getFoodProperties(stack, null).effects();
			Iterator<PossibleEffect> itr = listofEffects.iterator();
			while (itr.hasNext()) {
				MobEffectInstance effect = itr.next().effect();
				MutableComponent mutableComponent = Component.translatable(effect.getDescriptionId());
				if (effect.getAmplifier() > 0) {
					mutableComponent = Component.translatable("potion.withAmplifier", new Object[]{mutableComponent, Component.translatable("potion.potency." + effect.getAmplifier())});
				}
				if (!effect.endsWithin(20)) {
					mutableComponent = Component.translatable("potion.withDuration", new Object[]{mutableComponent, MobEffectUtil.formatDuration(effect, effect.getDuration(), 1)});
				}
				tooltipComponents.add(mutableComponent.withStyle(effect.getEffect().value().getCategory().getTooltipFormatting()));
			}
		}
        if (this.hasCustomTooltip) {
				MutableComponent customTooltip = getTranslation(BuiltInRegistries.ITEM.getKey(this).getPath()+".tooltip");
				tooltipComponents.add(customTooltip.withStyle(ChatFormatting.BLUE));
		}
   }

    /**
     * Gets the tooltip out of the language file
     */
   public static MutableComponent getTranslation(String key, Object... args) {
		return Component.translatable(FarmersLarder.MODID + "." + key, args);
	}

   
    
}
