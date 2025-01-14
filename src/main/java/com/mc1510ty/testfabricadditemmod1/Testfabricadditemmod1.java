package com.mc1510ty.testfabricadditemmod1;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class Testfabricadditemmod1 implements ModInitializer {

    public static final Item CUSTOM_ITEM = register("testitem1", Item::new, new Item.Settings());

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("testfabricadditemmod1", path));
        return Items.register(registryKey, factory, settings);

    }

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.add(Testfabricadditemmod1.CUSTOM_ITEM);
        });
    }
}

