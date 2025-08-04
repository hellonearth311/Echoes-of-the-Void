package net.hellonearth311.echoesofthevoid.registries.entity.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class VoidWeaverEntity extends SpiderEntity {

    // HELP THE NAME STILL SHOWS
    public VoidWeaverEntity(EntityType<? extends VoidWeaverEntity> entityType, World world) {
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

        // tp to player lol
        PlayerEntity nearestPlayer = this.getWorld().getClosestPlayer(this, 32.0);

        if (!this.getWorld().isClient && nearestPlayer != null && nearestPlayer == this.getTarget()) {
            double distanceToPlayer = this.distanceTo(nearestPlayer);

            if (distanceToPlayer > 10 && this.random.nextFloat() < 0.3f) {
                Vec3d playerPos = nearestPlayer.getPos();

                double angle = this.random.nextDouble() * 2 * Math.PI;
                double distance = 5 + this.random.nextDouble() * 5;

                double x = playerPos.x + Math.cos(angle) * distance;
                double y = playerPos.y + this.random.nextInt(3) - 1;
                double z = playerPos.z + Math.sin(angle) * distance;

                teleport(x, y, z, true);
            }
            // or randomly tp
            else if (this.random.nextFloat() < 0.005f) {
                double x = this.getX() + (this.random.nextDouble() - 0.5) * 16;
                double y = this.getY() + this.random.nextInt(6) - 3;
                double z = this.getZ() + (this.random.nextDouble() - 0.5) * 16;
                teleport(x, y, z, true);
            }
        }
        // or randomly tp
        else if (!this.getWorld().isClient && this.random.nextFloat() < 0.01f) {
            double x = this.getX() + (this.random.nextDouble() - 0.5) * 16;
            double y = this.getY() + this.random.nextInt(6) - 3;
            double z = this.getZ() + (this.random.nextDouble() - 0.5) * 16;
            teleport(x, y, z, true);
        }

        // particles
        if (this.getWorld().isClient) {
            for (int i = 0; i < 2; i++) {
                double offsetX = (this.random.nextDouble() - 0.5) * 0.5;
                double offsetZ = (this.random.nextDouble() - 0.5) * 0.5;
                this.getWorld().addParticleClient(ParticleTypes.DRAGON_BREATH,
                        this.getX() + offsetX,
                        this.getY() + 0.5,
                        this.getZ() + offsetZ,
                        0.0, 0.02, 0.0);
            }
        }    }

    // strong boi
    public static DefaultAttributeContainer.Builder createAttributes() {
        return SpiderEntity.createSpiderAttributes()
            .add(EntityAttributes.MAX_HEALTH, 32.0)
            .add(EntityAttributes.ATTACK_DAMAGE, 8.0)
            .add(EntityAttributes.SAFE_FALL_DISTANCE, 20);
    }
}
