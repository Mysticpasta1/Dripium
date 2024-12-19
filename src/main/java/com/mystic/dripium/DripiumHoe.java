package com.mystic.dripium;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;

public class DripiumHoe extends HoeItem {
    public DripiumHoe(Tier tier) {
        super(tier, Integer.MAX_VALUE, Float.MAX_VALUE, new Properties()
                .stacksTo(1)
                .fireResistant()
                .defaultDurability(tier.getUses()));
    }
}