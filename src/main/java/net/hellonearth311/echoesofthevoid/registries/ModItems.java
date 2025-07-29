package net.hellonearth311.echoesofthevoid.registries;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hellonearth311.echoesofthevoid.EchoesOfTheVoid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create item
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(EchoesOfTheVoid.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }
    // register echo locator(s)
    public static final Item END_ECHO_LOCATOR = register("end_echo_locator", Item::new, new Item.Settings().maxCount(1));

    public static void initialize() {
        EchoesOfTheVoid.LOGGER.info("Registering items for Echoes of the Void");

        // add to an item group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> itemGroup.add(END_ECHO_LOCATOR));

    }
}
