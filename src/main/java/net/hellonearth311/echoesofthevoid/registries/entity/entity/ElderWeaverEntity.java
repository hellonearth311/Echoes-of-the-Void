package net.hellonearth311.echoesofthevoid.registries.entity.entity;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;

public class ElderWeaverEntity extends SpiderEntity {

    // HELP THE NAME STILL SHOWS
    public ElderWeaverEntity(EntityType<? extends ElderWeaverEntity> entityType, World world) {
        super(entityType, world);
        this.setCustomName(null);
        this.setCustomNameVisible(false);
    }

    // goals? what goals?
    @Override
    protected void initGoals() {
        super.initGoals();
    }

    @Override
    public void tick() {
        super.tick();
        // explosion
        if (!this.getWorld().isClient && this.getTarget() != null && this.random.nextInt(300) == 0) {
            // make it invincible while the TNT explodes
            this.setInvulnerable(!this.isInvulnerable());
            TntEntity tnt = new TntEntity(this.getWorld(), this.getX(), this.getY() + 1.0, this.getZ(), this);
            tnt.setFuse(1);

            this.getWorld().spawnEntity(tnt);
        }

        // dirt particles
        if (this.getWorld().isClient) {
            this.getWorld().addParticleClient(new BlockStateParticleEffect(ParticleTypes.BLOCK, Blocks.DIRT.getDefaultState()),
                    this.getX() + (this.random.nextDouble() - 0.5) * 0.5,
                    this.getY() + 0.5,
                    this.getZ() + (this.random.nextDouble() - 0.5) * 0.5,
                    0.0, 0.02, 0.0);
        }
    }

    @Override
    public boolean shouldRenderName() {
        return false;
    }

    // strong boi
    public static DefaultAttributeContainer.Builder createAttributes() {
        return SpiderEntity.createSpiderAttributes()
            .add(EntityAttributes.MAX_HEALTH, 64.0)
            .add(EntityAttributes.ATTACK_DAMAGE, 8.0);
    }
}
