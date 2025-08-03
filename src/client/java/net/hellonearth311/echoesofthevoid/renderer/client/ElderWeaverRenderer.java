package net.hellonearth311.echoesofthevoid.renderer.client;

import net.hellonearth311.echoesofthevoid.registries.entity.entity.ElderWeaverEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.SpiderEntityModel;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;

public class ElderWeaverRenderer extends LivingEntityRenderer<ElderWeaverEntity, LivingEntityRenderState, SpiderEntityModel> {
    private static final Identifier TEXTURE = Identifier.of("echoesofthevoid", "textures/entity/elder_weaver.png");

    public ElderWeaverRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new SpiderEntityModel(ctx.getPart(EntityModelLayers.SPIDER)), 0.7f);
    }

    @Override
    public Identifier getTexture(LivingEntityRenderState state) {
        return TEXTURE;
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

}
