package io.github.okyriele.farmerslarder.item;

import io.github.okyriele.farmerslarder.FarmersLarder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.FoodProperties.PossibleEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;

import java.util.Iterator;
import java.util.List;

public class FoodItem extends Item {

    private final boolean hasFoodEffectTooltip;
	private final boolean hasCustomTooltip;

    public FoodItem(Item.Properties properties) {
		super(properties);
		this.hasFoodEffectTooltip = false;
		this.hasCustomTooltip = false;
	}

    public FoodItem(Properties properties, boolean hasFoodEffectTooltip) {
		super(properties);
		this.hasFoodEffectTooltip = hasFoodEffectTooltip;
		this.hasCustomTooltip = false;
	}

	public FoodItem(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
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
	 * Override this to apply changes to the consumer (e.g. curing effects).
	 */
	public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {

	}

    /**
     * Adding the Food Effect tooltip and any custom tooltips found in the translation file
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
