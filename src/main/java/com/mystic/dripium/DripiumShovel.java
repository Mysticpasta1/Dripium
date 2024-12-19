package com.mystic.dripium;

import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

public class DripiumShovel extends ShovelItem {
    public DripiumShovel(Tier tier) {
        super(tier, Integer.MAX_VALUE, Float.MAX_VALUE, new Properties()
                .stacksTo(1)
                .fireResistant()
                .defaultDurability(tier.getUses()));
    }
}