package net.hellonearth311.echoesofthevoid.registries.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.hellonearth311.echoesofthevoid.EchoesOfTheVoid;
import net.hellonearth311.echoesofthevoid.registries.entity.entity.ElderWeaverEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<ElderWeaverEntity> ELDER_WEAVER_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(EchoesOfTheVoid.MOD_ID, "elder_weaver"),
            EntityType.Builder.create(ElderWeaverEntity::new, SpawnGroup.MONSTER)
                .dimensions(1.4f, 0.9f) // width, height (spider dimensions)
                .maxTrackingRange(8)
                .trackingTickInterval(3)
                .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(EchoesOfTheVoid.MOD_ID, "elder_weaver")))
    );

    public static void initializeModEntities() {
        EchoesOfTheVoid.LOGGER.info("Registering entities for Echoes of the Void");

        // add attributes
        FabricDefaultAttributeRegistry.register(ELDER_WEAVER_ENTITY, ElderWeaverEntity.createAttributes());
    }
}
