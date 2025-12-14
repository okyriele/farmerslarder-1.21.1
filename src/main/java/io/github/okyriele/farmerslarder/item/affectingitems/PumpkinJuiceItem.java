package io.github.okyriele.farmerslarder.item.affectingitems;

import java.util.Iterator;
import java.util.List;

import io.github.okyriele.farmerslarder.item.FoodItem;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.FoodProperties.PossibleEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class PumpkinJuiceItem extends FoodItem {
    
    private final boolean hasFoodEffectTooltip;
	private final boolean hasCustomTooltip;

	public PumpkinJuiceItem(Item.Properties properties) {
		super(properties);
		this.hasFoodEffectTooltip = false;
		this.hasCustomTooltip = true;
	}

	public PumpkinJuiceItem(Item.Properties properties, boolean hasFoodEffectTooltip) {
		super(properties);
		this.hasFoodEffectTooltip = hasFoodEffectTooltip;
		this.hasCustomTooltip = true;
	}

	public PumpkinJuiceItem(Item.Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
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
	 * Add 30 seconds to the beneficial effect with the lowest remaining duration.
	 */
    @Override
	public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
		Iterator<MobEffectInstance> itr = consumer.getActiveEffects().iterator();
		MobEffectInstance boostedEffect = null;
		int lowestDuration = 6000;
		int newDuration = 600;

		while (itr.hasNext()) {
			MobEffectInstance effect = itr.next();
			if (effect.getEffect().value().getCategory() == MobEffectCategory.BENEFICIAL) {
				int duration = effect.getDuration();
				if (duration < lowestDuration) {
					boostedEffect = effect;
					lowestDuration = duration;
				}
			}
		}
		newDuration = 600 + lowestDuration;
		if (newDuration > 6000) {
			newDuration = 6000;
		}

		if (boostedEffect != null){
			consumer.addEffect(new MobEffectInstance(boostedEffect.getEffect(), newDuration, boostedEffect.getAmplifier()));	
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

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
      return UseAnim.DRINK;
   }
}
