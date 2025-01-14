package com.mc1510ty.testfabricadditemmod1;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class Testfabricadditemmod1 implements ModInitializer {

    private void TutorialItems() {
    }

    public static final Item CUSTOM_ITEM = register("testitem1", Item::new, new Item.Settings());

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("testfabricadditemmod1", path));
        return Items.register(registryKey, factory, settings);
    }

    public static void initialize() {
    }

    @Override
    public void onInitialize() {
    }
}
