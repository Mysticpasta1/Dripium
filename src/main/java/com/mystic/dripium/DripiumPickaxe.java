package com.mystic.dripium;

import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class DripiumPickaxe extends PickaxeItem {
    public DripiumPickaxe(Tier tier) {
        super(tier, Integer.MAX_VALUE, Float.MAX_VALUE, new Properties()
                .stacksTo(1)
                .fireResistant()
                .defaultDurability(tier.getUses()));
    }
}