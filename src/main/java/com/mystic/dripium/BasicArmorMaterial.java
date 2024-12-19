package com.mystic.dripium;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public class BasicArmorMaterial {
    public static final net.minecraft.world.item.ArmorMaterial ARMOR_DRIPIUM = new ArmorMaterial( "dripium", new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE} , Integer.MAX_VALUE, SoundEvents.ARMOR_EQUIP_IRON, Double.MAX_VALUE, Float.MAX_VALUE, () -> Ingredient.of(Dripium.DRIPIUM_BLOCK.get()));
    private static class ArmorMaterial implements net.minecraft.world.item.ArmorMaterial{

        private static final int[] Max_Damage_Array = new int[] {13,15,16,11};
        private final String name;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final float knockbackResistance;
        private final Lazy<Ingredient> repairMaterial;

        public ArmorMaterial(String name, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, double toughness, float knockbackResistance, Supplier<Ingredient> supplier) {
            this.name = name;
            this.damageReductionAmountArray = damageReductionAmountArray;
            this.enchantability = enchantability;
            this.soundEvent = soundEvent;
            this.toughness = (float)toughness;
            this.knockbackResistance = knockbackResistance;
            this.repairMaterial = new Lazy<>(supplier);
        }

        @Override
        public int getDurabilityForType(ArmorItem.Type pType) {
            return Max_Damage_Array[pType.getSlot().getIndex()];
        }

        @Override
        public int getDefenseForType(ArmorItem.Type pType) {
            return damageReductionAmountArray[pType.getSlot().getIndex()];
        }

        @Override
        public int getEnchantmentValue() {
            return enchantability;
        }

        @Override
        public SoundEvent getEquipSound() {
            return soundEvent;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return repairMaterial.get();
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return name;
        }

        @Override
        public float getToughness() {
            return toughness;
        }

        @Override
        public float getKnockbackResistance() {
            return this.knockbackResistance;
        }
    }
}
