package io.github.okyriele.farmerslarder.item.affectingitems;

import io.github.okyriele.farmerslarder.FarmersLarder;
import io.github.okyriele.farmerslarder.item.FoodItem;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.FoodProperties.PossibleEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.EffectCures;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.sounds.SoundEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CakeBlockaIceCreamItem extends FoodItem {

    private final boolean hasFoodEffectTooltip;
	private final boolean hasCustomTooltip;

    public CakeBlockaIceCreamItem(Item.Properties properties) {
		super(properties);
		this.hasFoodEffectTooltip = false;
		this.hasCustomTooltip = false;
	}

    public CakeBlockaIceCreamItem(Item.Properties properties, boolean hasFoodEffectTooltip) {
		super(properties);
		this.hasFoodEffectTooltip = hasFoodEffectTooltip;
		this.hasCustomTooltip = false;
	}

	public CakeBlockaIceCreamItem(Item.Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
		super(properties);
		this.hasFoodEffectTooltip = hasFoodEffectTooltip;
		this.hasCustomTooltip = hasCustomTooltip;
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
	 * Removes weakness
	 */
	@Override
	public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
		Iterator<MobEffectInstance> itr = consumer.getActiveEffects().iterator();
		ArrayList<Holder<MobEffect>> compatibleEffects = new ArrayList<>();

		while (itr.hasNext()) {
			MobEffectInstance effect = itr.next();
			if ((effect.getEffect()).equals(MobEffects.WEAKNESS)) {
				compatibleEffects.add(effect.getEffect());
			}
		}

		Iterator<Holder<MobEffect>> itrRemove = compatibleEffects.iterator();
		
		while (itrRemove.hasNext()) {
			MobEffectInstance selectedEffect = consumer.getEffect(itrRemove.next());
			if (selectedEffect != null && !net.neoforged.neoforge.event.EventHooks.onEffectRemoved(consumer, selectedEffect, EffectCures.MILK)) {
				consumer.removeEffect(selectedEffect.getEffect());
			}
		}

	}
	
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
					mutableComponent = Component.translatable("potion.withDuration", new Object[]{mutableComponent, MobEffectUtil.formatDuration(effect, 1.0F, context.tickRate())});
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
     * Aesthetic flavor
     */
	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
      return UseAnim.DRINK;
   }

   @Override
   public SoundEvent getDrinkingSound() {
      return SoundEvents.AXE_STRIP;
	}

   @Override
   public SoundEvent getEatingSound() {
      return SoundEvents.AXE_STRIP;
	}
    
}
