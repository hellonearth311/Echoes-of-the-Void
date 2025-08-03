package net.hellonearth311.echoesofthevoid;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.hellonearth311.echoesofthevoid.registries.entity.ModEntities;
import net.hellonearth311.echoesofthevoid.renderer.client.ElderWeaverRenderer;

public class EchoesOfTheVoidClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(ModEntities.ELDER_WEAVER_ENTITY, ElderWeaverRenderer::new);
	}
}