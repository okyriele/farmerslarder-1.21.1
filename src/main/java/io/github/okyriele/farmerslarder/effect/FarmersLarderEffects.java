package io.github.okyriele.farmerslarder.effect;

import io.github.okyriele.farmerslarder.FarmersLarder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
//import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FarmersLarderEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, FarmersLarder.MODID);

    public static final Holder<MobEffect> ICE_RESISTANCE = MOB_EFFECTS.register("ice_resistance", () -> new IceResistanceEffect(MobEffectCategory.BENEFICIAL, 11337213));
    public static final Holder<MobEffect> SUGAR_RUSH = MOB_EFFECTS.register("sugar_rush", () -> new SugarRushEffect(MobEffectCategory.BENEFICIAL, 16755438).addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(FarmersLarder.MODID, "sugar_rush"), 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL).addAttributeModifier(Attributes.JUMP_STRENGTH, ResourceLocation.fromNamespaceAndPath(FarmersLarder.MODID, "sugar_rush"), 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
