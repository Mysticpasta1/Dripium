package com.mystic.dripium;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class DripiumSword extends SwordItem {
    public DripiumSword(Tier tier) {
        super(tier, Integer.MAX_VALUE, Float.MAX_VALUE, new Properties()
                .stacksTo(1)
                .fireResistant()
                .defaultDurability(tier.getUses()));
    }
}