package com.mystic.dripium;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@Mod(Dripium.MODID)
public class Dripium {
    public static final String MODID = "dripium";
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    //BLOCKS
    public static final RegistryObject<Block> DRIPIUM_BLOCK = block("dripium_block", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(5000f)), Rarity.EPIC);
    public static final RegistryObject<Block> RAW_DRIPIUM_BLOCK = block("raw_dripium_block", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(3000f)), Rarity.EPIC);

    public static RegistryObject<Block> block(String name, Supplier<Block> block, Rarity rarity) {
        var reg = BLOCKS.register(name, block);
        ITEMS.register(name, () -> new BlockItem(reg.get(), new Item.Properties().fireResistant().rarity(rarity)));
        return reg;
    }

    //ITEMS
    public static final RegistryObject<Item> DRIPIUM_HELMET = ITEMS.register("dripium_helmet", () -> new ItemArmorDripium(BasicArmorMaterial.ARMOR_DRIPIUM, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> DRIPIUM_CHESTPLATE = ITEMS.register("dripium_chestplate", () -> new ItemArmorDripium(BasicArmorMaterial.ARMOR_DRIPIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> DRIPIUM_LEGGINGS = ITEMS.register("dripium_leggings", () -> new ItemArmorDripium(BasicArmorMaterial.ARMOR_DRIPIUM, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> DRIPIUM_BOOTS = ITEMS.register("dripium_boots", () -> new ItemArmorDripium(BasicArmorMaterial.ARMOR_DRIPIUM, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> DRIPIUM_AXE = ITEMS.register("dripium_axe", () -> new DripiumAxe(ToolInit.DRIPIUM));
    public static final RegistryObject<Item> DRIPIUM_PICKAXE = ITEMS.register("dripium_pickaxe", () -> new DripiumPickaxe(ToolInit.DRIPIUM));
    public static final RegistryObject<Item> DRIPIUM_SHOVEL = ITEMS.register("dripium_shovel", () -> new DripiumShovel(ToolInit.DRIPIUM));
    public static final RegistryObject<Item> DRIPIUM_HOE = ITEMS.register("dripium_hoe", () -> new DripiumHoe(ToolInit.DRIPIUM));
    public static final RegistryObject<Item> DRIPIUM_SWORD = ITEMS.register("dripium_sword", () -> new DripiumSword(ToolInit.DRIPIUM));

    public static final RegistryObject<Item> DRIPIUM_INGOT = ITEMS.register("dripium_ingot", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> RAW_DRIPIUM = ITEMS.register("raw_dripium", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> DRIPIUM_NUGGET = ITEMS.register("dripium_nugget", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> DRIPIUM_ROD = ITEMS.register("dripium_rod", () -> new Item(new Item.Properties().fireResistant()));

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> DRIPIUM_TAB = CREATIVE_MODE_TABS.register("dripium_tab",
            () -> CreativeModeTab.builder().icon(() ->
                    DRIPIUM_INGOT.get().getDefaultInstance()).displayItems((parameters, output) -> {
                output.accept(DRIPIUM_BLOCK.get());
                output.accept(RAW_DRIPIUM_BLOCK.get());
                output.accept(RAW_DRIPIUM.get());
                output.accept(DRIPIUM_NUGGET.get());
                output.accept(DRIPIUM_ROD.get());
                output.accept(DRIPIUM_INGOT.get());
                output.accept(DRIPIUM_HELMET.get());
                output.accept(DRIPIUM_CHESTPLATE.get());
                output.accept(DRIPIUM_LEGGINGS.get());
                output.accept(DRIPIUM_BOOTS.get());
                output.accept(DRIPIUM_AXE.get());
                output.accept(DRIPIUM_PICKAXE.get());
                output.accept(DRIPIUM_SHOVEL.get());
                output.accept(DRIPIUM_HOE.get());
                output.accept(DRIPIUM_SWORD.get());
            }).build());

    public Dripium() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
