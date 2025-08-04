package net.hellonearth311.echoesofthevoid.registries.entity.entity;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class CharredShadeEntity extends SkeletonEntity {

    public CharredShadeEntity(EntityType<? extends CharredShadeEntity> entityType, World world) {
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

    @Override
    public boolean isFireImmune() { return true; }

    // strong boi
    public static DefaultAttributeContainer.Builder createAttributes() {
        return SkeletonEntity.createAbstractSkeletonAttributes()
            .add(EntityAttributes.MAX_HEALTH, 40.0)
            .add(EntityAttributes.ATTACK_DAMAGE, 10.0);
    }
}
