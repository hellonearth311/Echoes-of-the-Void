package net.hellonearth311.echoesofthevoid.registries;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hellonearth311.echoesofthevoid.EchoesOfTheVoid;
import net.hellonearth311.echoesofthevoid.registries.custom.EndEchoLocator;
import net.hellonearth311.echoesofthevoid.registries.custom.NetherEchoLocator;
import net.hellonearth311.echoesofthevoid.registries.custom.OverworldEchoLocator;
import net.hellonearth311.echoesofthevoid.registries.entity.ModEntities;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import java.util.function.Function;

public class ModItems {
    public static <T extends Item> T register(String name, Function<Item.Settings, T> itemFactory, Item.Settings settings) {
        // Create item
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(EchoesOfTheVoid.MOD_ID, name));
        T item = itemFactory.apply(settings.registryKey(itemKey));

        // Register
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }
    // register echo locator(s) and their shards

    // end
    public static final Item END_ECHO_LOCATOR = register(
            "end_echo_locator",
            EndEchoLocator::new,
            new Item.Settings().maxDamage(200).rarity(Rarity.RARE).fireproof()
    );
    public static final Item END_ECHO_LOCATOR_SHARD = register(
            "end_echo_locator_shard",
            Item::new,
            new Item.Settings().fireproof().rarity(Rarity.UNCOMMON)
    );

    // nether
    public static final Item NETHER_ECHO_LOCATOR = register(
            "nether_echo_locator",
            NetherEchoLocator::new,
            new Item.Settings().maxDamage(200).rarity(Rarity.RARE).fireproof()
    );
    public static final Item NETHER_ECHO_LOCATOR_SHARD = register(
            "nether_echo_locator_shard",
            Item::new,
            new Item.Settings().fireproof().rarity(Rarity.UNCOMMON)
    );

    // overworld
    public static final Item OVERWORLD_ECHO_LOCATOR = register(
            "overworld_echo_locator",
            OverworldEchoLocator::new,
            new Item.Settings().maxDamage(200).rarity(Rarity.RARE).fireproof()
    );
    public static final Item OVERWORLD_ECHO_LOCATOR_SHARD = register(
            "overworld_echo_locator_shard",
            Item::new,
            new Item.Settings().fireproof().rarity(Rarity.UNCOMMON)
    );


    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY =
            RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(EchoesOfTheVoid.MOD_ID, "item_group"));

    // spawn eggs
    public static final SpawnEggItem VOID_WEAVER_SPAWN_EGG = register("void_weaver_spawn_egg",
            settings -> new SpawnEggItem(ModEntities.VOID_WEAVER_ENTITY, settings),
            new Item.Settings()
    );

    public static final SpawnEggItem CHARRED_WEAVER_SPAWN_EGG = register("charred_weaver_spawn_egg",
            settings -> new SpawnEggItem(ModEntities.CHARRED_WEAVER_ENTITY, settings),
            new Item.Settings()
    );

    public static final SpawnEggItem ELDER_WEAVER_SPAWN_EGG = register("elder_weaver_spawn_egg",
            settings -> new SpawnEggItem(ModEntities.ELDER_WEAVER_ENTITY, settings),
            new Item.Settings()
    );

    // register item groups
    public static final ItemGroup CUSTOM_ITEM_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            CUSTOM_ITEM_GROUP_KEY,
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.END_ECHO_LOCATOR))
                    .displayName(Text.translatable("itemGroup.echoes_of_the_void.item_group"))
                    .build()
    );


    public static void initializeModItems() {
        EchoesOfTheVoid.LOGGER.info("Registering items and item groups for Echoes of the Void");

        // register items to the group
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(END_ECHO_LOCATOR);
            itemGroup.add(NETHER_ECHO_LOCATOR);
            itemGroup.add(OVERWORLD_ECHO_LOCATOR);
            itemGroup.add(END_ECHO_LOCATOR_SHARD);
            itemGroup.add(NETHER_ECHO_LOCATOR_SHARD);
            itemGroup.add(OVERWORLD_ECHO_LOCATOR_SHARD);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(itemGroup -> {
            itemGroup.add(VOID_WEAVER_SPAWN_EGG);
            itemGroup.add(CHARRED_WEAVER_SPAWN_EGG);
            itemGroup.add(ELDER_WEAVER_SPAWN_EGG);
        });

    }
}
