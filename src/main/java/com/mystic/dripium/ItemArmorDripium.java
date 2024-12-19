package com.mystic.dripium;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ItemArmorDripium extends ArmorItem {

    public static ArmorMaterial armorMaterial;

    public ItemArmorDripium(ArmorMaterial material, Type slot, Properties settings) {
        super(material, slot, settings);
        armorMaterial = material;
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, Level world, @NotNull Entity entity, int slot, boolean selected) {
        if (!world.isClientSide()) {
            if (entity instanceof Player player) {
                if (hasFullArmorArmorOn(player)) {
                    evaluateArmorEffects(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(Player player) {
        if (hasCorrectArmorOn(material, player)) {
            if (player instanceof ServerPlayer serverPlayer) {
                serverPlayer.setGameMode(GameType.CREATIVE);
            }
        }
    }

    public static boolean hasAnyArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() || !breastplate.isEmpty()
                || !leggings.isEmpty() || !boots.isEmpty();
    }

    public static boolean hasAnyCorrectArmorOn(ArmorMaterial material, Player player) {
        ItemStack boots = player.getInventory().getArmor(0) != ItemStack.EMPTY ? player.getInventory().getArmor(0) : ItemStack.EMPTY;
        ItemStack leggings = player.getInventory().getArmor(1) != ItemStack.EMPTY  ? player.getInventory().getArmor(1) : ItemStack.EMPTY;
        ItemStack breastplate = player.getInventory().getArmor(2) != ItemStack.EMPTY  ? player.getInventory().getArmor(2) : ItemStack.EMPTY;
        ItemStack helmet = player.getInventory().getArmor(3) != ItemStack.EMPTY  ? player.getInventory().getArmor(3) : ItemStack.EMPTY;

        return helmet.is(Dripium.DRIPIUM_HELMET.get()) || breastplate.is(Dripium.DRIPIUM_CHESTPLATE.get()) ||
                leggings.is(Dripium.DRIPIUM_LEGGINGS.get()) || boots.is(Dripium.DRIPIUM_BOOTS.get());
    }

    private boolean hasFullArmorArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private static boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
        for (ItemStack armor : player.getInventory().armor) {
            if (armor.getItem() instanceof ArmorItem armorItem) {
                if (armorItem.getMaterial() != material) {
                    return false;
                }
            } else {
                return false;
            }
        }

        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return helmet.is(Dripium.DRIPIUM_HELMET.get()) && breastplate.is(Dripium.DRIPIUM_CHESTPLATE.get()) &&
                leggings.is(Dripium.DRIPIUM_LEGGINGS.get()) && boots.is(Dripium.DRIPIUM_BOOTS.get());
    }
}