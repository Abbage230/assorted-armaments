package team.leomc.assortedarmaments.integration;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import team.leomc.assortedarmaments.registry.AADataComponents;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public record MaterialsComponent(List<AAMaterial> materials) implements DataComponentType<MaterialsComponent> {
	public static final Codec<MaterialsComponent> CODEC = AAMaterial.CODEC.listOf().xmap(MaterialsComponent::new, MaterialsComponent::materials);
	public static final StreamCodec<ByteBuf, MaterialsComponent> STREAM_CODEC = AAMaterial.STREAM_CODEC.apply(ByteBufCodecs.list()).map(MaterialsComponent::new, MaterialsComponent::materials);

	public MaterialsComponent(AAMaterial... materials) {
		this(Arrays.stream(materials).toList());
	}

	@Override
	public @Nullable Codec<MaterialsComponent> codec() {
		return CODEC;
	}

	@Override
	public StreamCodec<ByteBuf, MaterialsComponent> streamCodec() {
		return STREAM_CODEC;
	}

	public static void applyMaterials(ItemStack itemStack, Consumer<AAMaterial> consumer) {
		MaterialsComponent component = itemStack.get(AADataComponents.MATERIAL);
		if (component != null) {
			for (AAMaterial material : component.materials) {
				consumer.accept(material);
			}
		}
	}
}
