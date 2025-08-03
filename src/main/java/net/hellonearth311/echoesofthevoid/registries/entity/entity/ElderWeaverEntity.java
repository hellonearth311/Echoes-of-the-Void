package net.hellonearth311.echoesofthevoid.registries.entity.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.world.World;

public class ElderWeaverEntity extends SpiderEntity {

    public ElderWeaverEntity(EntityType<? extends ElderWeaverEntity> entityType, World world) {
        super(entityType, world);
        this.setCustomName(null);
        this.setCustomNameVisible(false);

    }

    @Override
    protected void initGoals() {
        super.initGoals();
    }


    public static DefaultAttributeContainer.Builder createAttributes() {
        return SpiderEntity.createSpiderAttributes()
            .add(EntityAttributes.MAX_HEALTH, 32.0)
            .add(EntityAttributes.ATTACK_DAMAGE, 4.0)
            .add(EntityAttributes.SAFE_FALL_DISTANCE, 20);
    }
}
