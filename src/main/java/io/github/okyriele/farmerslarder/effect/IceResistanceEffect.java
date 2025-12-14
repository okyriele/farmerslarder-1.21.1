package io.github.okyriele.farmerslarder.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class IceResistanceEffect extends MobEffect {

    public IceResistanceEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity == null)
			return false;
		if (livingEntity.getTicksFrozen() > 20) {
			livingEntity.setTicksFrozen(20);
		}
        return super.applyEffectTick(livingEntity, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
    
}
