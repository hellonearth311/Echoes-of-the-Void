package net.hellonearth311.echoesofthevoid.renderer.client;

import net.hellonearth311.echoesofthevoid.registries.entity.entity.CharredWeaverEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.SpiderEntityModel;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.util.Identifier;

// extend spider renderer
public class CharredWeaverRenderer extends LivingEntityRenderer<CharredWeaverEntity, LivingEntityRenderState, SpiderEntityModel> {
    private static final Identifier TEXTURE = Identifier.of("echoesofthevoid", "textures/entity/charred_weaver.png");

    public CharredWeaverRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new SpiderEntityModel(ctx.getPart(EntityModelLayers.SPIDER)), 0.7f);
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
