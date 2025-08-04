package net.hellonearth311.echoesofthevoid.registries.entity.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class CharredWeaverEntity extends SpiderEntity {

    // HELP THE NAME STILL SHOWS
    public CharredWeaverEntity(EntityType<? extends CharredWeaverEntity> entityType, World world) {
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
    public boolean isFireImmune() {
        return true;
    }

    @Override
    public boolean shouldRenderName() {
        return false;
    }

    @Override
    public void tick() {
        super.tick();
        // fire
        if (!this.getWorld().isClient && this.getTarget() != null && this.random.nextInt(50) == 0) {
            this.setInvulnerable(!this.isInvulnerable());
            LivingEntity target = this.getTarget();

            Vec3d direction = target.getPos().subtract(this.getPos()).normalize();

            FireballEntity fireball = new FireballEntity(this.getWorld(), this, direction, 2);
            fireball.setPosition(this.getX(), this.getY() + 1.0, this.getZ());

            this.getWorld().spawnEntity(fireball);
        }

        // flame particles
        if (this.getWorld().isClient) {
            this.getWorld().addParticleClient(ParticleTypes.FLAME,
                    this.getX() + (this.random.nextDouble() - 0.5) * 0.5,
                    this.getY() + 0.5,
                    this.getZ() + (this.random.nextDouble() - 0.5) * 0.5,
                    0.0, 0.02, 0.0);
        }
    }

    // strong boi
    public static DefaultAttributeContainer.Builder createAttributes() {
        return SpiderEntity.createSpiderAttributes()
            .add(EntityAttributes.MAX_HEALTH, 32.0)
            .add(EntityAttributes.ATTACK_DAMAGE, 8.0);
    }
}
