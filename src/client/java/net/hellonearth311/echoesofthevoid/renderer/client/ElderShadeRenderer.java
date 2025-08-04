package net.hellonearth311.echoesofthevoid.renderer.client;

import net.hellonearth311.echoesofthevoid.registries.entity.entity.ElderShadeEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.client.render.entity.state.SkeletonEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

// extend skeleton renderer
public class ElderShadeRenderer extends LivingEntityRenderer<ElderShadeEntity, SkeletonEntityRenderState, SkeletonEntityModel<SkeletonEntityRenderState>> {
    private static final Identifier TEXTURE = Identifier.of("echoesofthevoid", "textures/entity/elder_shade.png");
    private static final float SCALE = 1.5f;

    public ElderShadeRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new SkeletonEntityModel<>(ctx.getPart(EntityModelLayers.SKELETON)), 0.6f * SCALE);
    }

    @Override
    protected void scale(SkeletonEntityRenderState state, MatrixStack matrices) {
        matrices.scale(SCALE, SCALE, SCALE); // big boi size
        super.scale(state, matrices);
    }

    // override spider texture with mine
    @Override
    public Identifier getTexture(SkeletonEntityRenderState state) {
        return TEXTURE;
    }

    // idk what this is but i have to do it lol
    @Override
    public SkeletonEntityRenderState createRenderState() {
        return new SkeletonEntityRenderState();
    }

}
