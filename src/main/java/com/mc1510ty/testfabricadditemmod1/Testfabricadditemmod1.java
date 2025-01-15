package com.mc1510ty.testfabricadditemmod1;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class Testfabricadditemmod1 implements ModInitializer {

    public static final Item TestItem_1 = register("testitem1", Item::new, new Item.Settings());

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("testfabricadditemmod1", path));
        return Items.register(registryKey, factory, settings);

    }

    public static final Block TestBlock_1 = register("testblock1", Block::new, Block.Settings.create().strength(4.0f).requiresTool());

    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of("testfabricadditemmod1", path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        return block;
    }

    public final class testfabricadditemmod1_test_group_1 {
        public static final ItemGroup TEST_GROUP_1 = FabricItemGroup.builder()
                .icon(() -> new ItemStack(Testfabricadditemmod1.TestItem_1))
                .displayName(Text.translatable("itemGroup.testfabricadditemmod1.test_group_1"))
                .entries((context, entries) -> {
                    entries.add(Testfabricadditemmod1.TestItem_1);
                    entries.add(Testfabricadditemmod1.TestBlock_1);
                })
                .build();

        public static void initialize() {
            // Since 1.21:
            Registry.register(Registries.ITEM_GROUP, Identifier.of("testfabricadditemmod1", "test_group_1"), TEST_GROUP_1);

        }
    }

    @Override
    public void onInitialize() {
        testfabricadditemmod1_test_group_1.initialize();
    //    ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
    //        content.add(Testfabricadditemmod1.CUSTOM_ITEM);
    //    });
    }

}

