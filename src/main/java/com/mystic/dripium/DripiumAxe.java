package com.mystic.dripium;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;

public class DripiumAxe extends AxeItem {
    public DripiumAxe(Tier tier) {
        super(tier, Float.MAX_VALUE, Float.MAX_VALUE, new Properties()
                .stacksTo(1)
                .fireResistant()
                .defaultDurability(tier.getUses()));
    }
}