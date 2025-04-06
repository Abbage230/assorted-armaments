package team.leomc.assortedarmaments.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
import net.neoforged.neoforge.event.entity.EntityInvulnerabilityCheckEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import team.leomc.assortedarmaments.AssortedArmaments;
import team.leomc.assortedarmaments.integration.AAMaterial;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class AAMaterials {
	public static final Map<ResourceLocation, AAMaterial> MATERIALS = new HashMap<>();

	public static final AAMaterial LIGHT_DANCE = register("light_dance", id -> new AAMaterial(id) {
		@Override
		public void onItemAttributeModifier(ItemAttributeModifierEvent event) {
			event.addModifier(Attributes.ATTACK_SPEED, new AttributeModifier(id, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL), EquipmentSlotGroup.MAINHAND);
		}
	});
	public static final AAMaterial BANE_UNDEAD = register("bane_undead", id -> new AAMaterial(id) {
		@Override
		public void onIncomingDamage(LivingIncomingDamageEvent event) {
			if (event.getEntity().getType().is(EntityTypeTags.UNDEAD)) {
				event.setAmount(event.getAmount() * 1.25F);
			}
		}
	});
	public static final AAMaterial POISON_IMMUNE = register("poison_immune", id -> new AAMaterial(id) {
		@Override
		public void onMobEffectApplicable(MobEffectEvent.Applicable event) {
			if (event.getEffectInstance().is(MobEffects.POISON)) {
				event.setResult(MobEffectEvent.Applicable.Result.DO_NOT_APPLY);
			}
		}
	});

	public static final AAMaterial HEAT = register("heat", id -> new AAMaterial(id) {
		@Override
		public void onIncomingDamage(LivingIncomingDamageEvent event) {
			if (event.getEntity().getRemainingFireTicks() < 100) {
				event.getEntity().setRemainingFireTicks(100);
			}
		}
	});
	public static final AAMaterial FIRE_IMMUNE = register("fire_immune", id -> new AAMaterial(id) {
		@Override
		public void onEntityInvulnerabilityCheck(EntityInvulnerabilityCheckEvent event) {
			if (!event.isInvulnerable()) {
				event.setInvulnerable(event.getSource().is(DamageTypeTags.IS_FIRE));
			}
		}
	});

	public static final AAMaterial CHILL = register("chill", id -> new AAMaterial(id) {
		@Override
		public void onIncomingDamage(LivingIncomingDamageEvent event) {
			MobEffectInstance effect = event.getEntity().getEffect(MobEffects.MOVEMENT_SLOWDOWN);
			if (effect == null) {
				event.getEntity().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40));
			} else {
				if (effect.getAmplifier() >= 3) {
					event.getEntity().addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 20, 1));
				}
				event.getEntity().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, effect.getAmplifier() + 1));
			}
		}
	});
	public static final AAMaterial COLD_IMMUNE = register("cold_immune", id -> new AAMaterial(id) {
		@Override
		public void onMobEffectApplicable(MobEffectEvent.Applicable event) {
			if (event.getEffectInstance().is(MobEffects.MOVEMENT_SLOWDOWN) || event.getEffectInstance().is(MobEffects.DIG_SLOWDOWN)) {
				event.setResult(MobEffectEvent.Applicable.Result.DO_NOT_APPLY);
			}
		}
	});

	private static AAMaterial register(String path, Function<ResourceLocation, AAMaterial> function) {
		ResourceLocation id = AssortedArmaments.id(path);
		AAMaterial material = function.apply(id);
		MATERIALS.put(id, material);
		return material;
	}

	public static void init() {}
}
