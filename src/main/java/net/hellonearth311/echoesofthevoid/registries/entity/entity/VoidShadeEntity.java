package net.hellonearth311.echoesofthevoid.registries.entity.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class VoidShadeEntity extends SkeletonEntity {

    public VoidShadeEntity(EntityType<? extends VoidShadeEntity> entityType, World world) {
        super(entityType, world);

        // try to get rid of name
        this.setCustomName(null);
        this.setCustomNameVisible(false);

        // put diamond sword in hand
        final ItemStack DIAMOND_SWORD_ITEM_STACK = new ItemStack(Items.DIAMOND_SWORD);
        this.equipStack(net.minecraft.entity.EquipmentSlot.MAINHAND, DIAMOND_SWORD_ITEM_STACK);
        this.setEquipmentDropChance(net.minecraft.entity.EquipmentSlot.MAINHAND, 0.0f);
    }

    // goals? what goals?
    @Override
    protected void initGoals() {
        // prevent bow shooting
        this.goalSelector.add(1, new net.minecraft.entity.ai.goal.SwimGoal(this));
        this.goalSelector.add(2, new net.minecraft.entity.ai.goal.MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.add(5, new net.minecraft.entity.ai.goal.WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(6, new net.minecraft.entity.ai.goal.LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(6, new net.minecraft.entity.ai.goal.LookAroundGoal(this));

        this.targetSelector.add(1, new net.minecraft.entity.ai.goal.RevengeGoal(this));
        this.targetSelector.add(2, new net.minecraft.entity.ai.goal.ActiveTargetGoal<>(this, PlayerEntity.class, true));
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
                        this.getY() + 1.0,
                        this.getZ() + offsetZ,
                        0.0, 0.02, 0.0);
            }
        }

        // stop burning
        if (this.getWorld().isDay() && this.getWorld().isSkyVisible(this.getBlockPos())) {
            if (this.isOnFire()) {
                this.extinguish();
            }
        }
    }

    @Override
    public boolean shouldRenderName() {
        return false;
    }

    // strong boi
    public static DefaultAttributeContainer.Builder createAttributes() {
        return SkeletonEntity.createAbstractSkeletonAttributes()
            .add(EntityAttributes.MAX_HEALTH, 40.0)
            .add(EntityAttributes.ATTACK_DAMAGE, 10.0)
            .add(EntityAttributes.SAFE_FALL_DISTANCE, 999.0);
    }
}
