package net.hellonearth311.echoesofthevoid;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.hellonearth311.echoesofthevoid.registries.entity.ModEntities;
import net.hellonearth311.echoesofthevoid.renderer.client.*;

public class EchoesOfTheVoidClient implements ClientModInitializer {
	// guess i have to do this here??
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(ModEntities.VOID_WEAVER_ENTITY, VoidWeaverRenderer::new);
		EntityRendererRegistry.register(ModEntities.VOID_SHADE_ENTITY, VoidShadeRenderer::new);

		EntityRendererRegistry.register(ModEntities.CHARRED_WEAVER_ENTITY, CharredWeaverRenderer::new);
		EntityRendererRegistry.register(ModEntities.CHARRED_SHADE_ENTITY, CharredShadeRenderer::new);

		EntityRendererRegistry.register(ModEntities.ELDER_WEAVER_ENTITY, ElderWeaverRenderer::new);
		EntityRendererRegistry.register(ModEntities.ELDER_SHADE_ENTITY, ElderShadeRenderer::new);

	}
}