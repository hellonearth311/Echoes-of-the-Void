package net.hellonearth311.echoesofthevoid.registries;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hellonearth311.echoesofthevoid.EchoesOfTheVoid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
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
    public static final Item NETHER_ECHO_LOCATOR = register("nether_echo_locator", Item::new, new Item.Settings().maxCount(1));
    public static final Item OVERWORLD_ECHO_LOCATOR = register("overworld_echo_locator", Item::new, new Item.Settings().maxCount(1));


    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY =
            RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(EchoesOfTheVoid.MOD_ID, "item_group"));

    // register item group
    public static final ItemGroup CUSTOM_ITEM_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            CUSTOM_ITEM_GROUP_KEY,
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.END_ECHO_LOCATOR))
                    .displayName(Text.translatable("itemGroup.echoes_of_the_void.item_group"))
                    .build()
    );


    public static void initialize() {
        EchoesOfTheVoid.LOGGER.info("Registering items and item groups for Echoes of the Void");

        // register items to the group
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(END_ECHO_LOCATOR);
            itemGroup.add(NETHER_ECHO_LOCATOR);
            itemGroup.add(OVERWORLD_ECHO_LOCATOR);
        });

    }
}
