package net.hellonearth311.echoesofthevoid.renderer.client;

import net.hellonearth311.echoesofthevoid.registries.entity.entity.ElderWeaverEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.SpiderEntityModel;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

// extend spider renderer
public class ElderWeaverRenderer extends LivingEntityRenderer<ElderWeaverEntity, LivingEntityRenderState, SpiderEntityModel> {
    private static final Identifier TEXTURE = Identifier.of("echoesofthevoid", "textures/entity/elder_weaver.png");
    private static final float SCALE = 2.0f;

    public ElderWeaverRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new SpiderEntityModel(ctx.getPart(EntityModelLayers.SPIDER)), 1.4f * SCALE); // Scale shadow size too
    }

    @Override
    protected void scale(LivingEntityRenderState state, MatrixStack matrices) {
        matrices.scale(SCALE, SCALE, SCALE); // big boi size
        super.scale(state, matrices);
    }

    // override spider texture with mine
    @Override
    public Identifier getTexture(LivingEntityRenderState state) {
        return TEXTURE;
    }

    // idk what this is but i have to do it lol
    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

}
