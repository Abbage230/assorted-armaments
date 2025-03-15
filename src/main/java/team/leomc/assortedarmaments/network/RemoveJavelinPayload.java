package team.leomc.assortedarmaments.network;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import team.leomc.assortedarmaments.AssortedArmaments;
import team.leomc.assortedarmaments.entity.ThrownJavelin;

public record RemoveJavelinPayload(int victimId) implements CustomPacketPayload {
	public static final Type<RemoveJavelinPayload> TYPE = new Type<>(AssortedArmaments.id("remove_javelin"));
	public static final Codec<RemoveJavelinPayload> CODEC = Codec.INT.xmap(RemoveJavelinPayload::new, RemoveJavelinPayload::victimId);
	public static final StreamCodec<ByteBuf, RemoveJavelinPayload> STREAM_CODEC = ByteBufCodecs.fromCodec(CODEC);

	public static void handle(RemoveJavelinPayload payload, IPayloadContext context) {
		Player player = context.player();
		Entity entity = player.level().getEntity(payload.victimId());
		if (entity != null) {
			for (ThrownJavelin javelin : player.level().getEntitiesOfClass(ThrownJavelin.class, entity.getBoundingBox().inflate(1))) {
				javelin.removeFromTarget(player);
			}
		}
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}
