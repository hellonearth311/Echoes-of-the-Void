package net.hellonearth311.echoesofthevoid.registries.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.hellonearth311.echoesofthevoid.EchoesOfTheVoid;
import net.hellonearth311.echoesofthevoid.registries.entity.entity.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntities {
    // void
    public static final EntityType<VoidWeaverEntity> VOID_WEAVER_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(EchoesOfTheVoid.MOD_ID, "void_weaver"),
            EntityType.Builder.create(VoidWeaverEntity::new, SpawnGroup.CREATURE) // set spawn group to creature so it can spawn in daylight
                .dimensions(1.4f, 0.9f)
                .maxTrackingRange(8)
                .trackingTickInterval(3)
                .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(EchoesOfTheVoid.MOD_ID, "void_weaver")))
    );

    public static final EntityType<VoidShadeEntity> VOID_SHADE_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(EchoesOfTheVoid.MOD_ID, "void_shade"),
            EntityType.Builder.create(VoidShadeEntity::new, SpawnGroup.CREATURE) // set spawn group to creature so it can spawn in daylight
                    .dimensions(0.6f, 1.99f)
                    .maxTrackingRange(8)
                    .trackingTickInterval(3)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(EchoesOfTheVoid.MOD_ID, "void_shade")))
    );

    // charred
    public static final EntityType<CharredWeaverEntity> CHARRED_WEAVER_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(EchoesOfTheVoid.MOD_ID, "charred_weaver"),
            EntityType.Builder.create(CharredWeaverEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1.4f, 0.9f)
                    .maxTrackingRange(8)
                    .trackingTickInterval(3)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(EchoesOfTheVoid.MOD_ID, "charred_weaver")))
    );

    public static final EntityType<CharredShadeEntity> CHARRED_SHADE_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(EchoesOfTheVoid.MOD_ID, "charred_shade"),
            EntityType.Builder.create(CharredShadeEntity::new, SpawnGroup.CREATURE) // set spawn group to creature so it can spawn in daylight
                    .dimensions(0.6f, 1.99f)
                    .maxTrackingRange(8)
                    .trackingTickInterval(3)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(EchoesOfTheVoid.MOD_ID, "charred_shade")))
    );

    // elder
    public static final EntityType<ElderWeaverEntity> ELDER_WEAVER_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(EchoesOfTheVoid.MOD_ID, "elder_weaver"),
            EntityType.Builder.create(ElderWeaverEntity::new, SpawnGroup.CREATURE)
                    .dimensions(2.8f, 1.8f)
                    .maxTrackingRange(8)
                    .trackingTickInterval(3)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(EchoesOfTheVoid.MOD_ID, "elder_weaver")))
    );


    public static final EntityType<ElderShadeEntity> ELDER_SHADE_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(EchoesOfTheVoid.MOD_ID, "elder_shade"),
            EntityType.Builder.create(ElderShadeEntity::new, SpawnGroup.CREATURE) // set spawn group to creature so it can spawn in daylight
                    .dimensions(0.9f, 2.985f)
                    .maxTrackingRange(8)
                    .trackingTickInterval(3)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(EchoesOfTheVoid.MOD_ID, "elder_shade")))
    );


    public static void initializeModEntities() {
        EchoesOfTheVoid.LOGGER.info("Registering entities for Echoes of the Void");

        // add attributes
        FabricDefaultAttributeRegistry.register(VOID_WEAVER_ENTITY, VoidWeaverEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(VOID_SHADE_ENTITY, VoidShadeEntity.createAttributes());

        FabricDefaultAttributeRegistry.register(CHARRED_WEAVER_ENTITY, CharredWeaverEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(CHARRED_SHADE_ENTITY, CharredShadeEntity.createAttributes());


        FabricDefaultAttributeRegistry.register(ELDER_WEAVER_ENTITY, ElderWeaverEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ELDER_SHADE_ENTITY, ElderShadeEntity.createAttributes());
    }
}
