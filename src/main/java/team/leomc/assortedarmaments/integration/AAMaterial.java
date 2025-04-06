package team.leomc.assortedarmaments.integration;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
import net.neoforged.neoforge.event.entity.EntityInvulnerabilityCheckEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import team.leomc.assortedarmaments.registry.AAMaterials;

public abstract class AAMaterial {
	public static final Codec<AAMaterial> CODEC = ResourceLocation.CODEC.xmap(AAMaterials.MATERIALS::get, AAMaterial::getId);
	public static final StreamCodec<ByteBuf, AAMaterial> STREAM_CODEC = ResourceLocation.STREAM_CODEC.map(AAMaterials.MATERIALS::get, AAMaterial::getId);
	protected final ResourceLocation id;

	public AAMaterial(ResourceLocation id) {
		this.id = id;
	}

	public ResourceLocation getId() {
		return id;
	}

	public void onItemAttributeModifier(ItemAttributeModifierEvent event) {}

	public void onIncomingDamage(LivingIncomingDamageEvent event) {}

	public void onMobEffectApplicable(MobEffectEvent.Applicable event) {}

	public void onEntityInvulnerabilityCheck(EntityInvulnerabilityCheckEvent event) {}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj instanceof AAMaterial material) {
			return material.id.equals(id);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
