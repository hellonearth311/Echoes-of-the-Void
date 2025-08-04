package net.hellonearth311.echoesofthevoid.renderer.client;

import net.hellonearth311.echoesofthevoid.registries.entity.entity.CharredShadeEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.client.render.entity.state.SkeletonEntityRenderState;
import net.minecraft.util.Identifier;

// extend skeleton renderer
public class CharredShadeRenderer extends LivingEntityRenderer<CharredShadeEntity, SkeletonEntityRenderState, SkeletonEntityModel<SkeletonEntityRenderState>> {
    private static final Identifier TEXTURE = Identifier.of("echoesofthevoid", "textures/entity/charred_shade.png");

    public CharredShadeRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new SkeletonEntityModel<>(ctx.getPart(EntityModelLayers.SKELETON)), 0.6f);
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
