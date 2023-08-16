package com.jhy.moreapple.iron_apple;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class IronApple extends Item {
    private static final Food food = (new Food.Builder())
            .saturationMod(6)
            .nutrition(12)
            .effect(() -> new EffectInstance(Effects.DAMAGE_RESISTANCE, 30*20, 1), 1.0F)
            .alwaysEat()
            .build();

    public IronApple() {
        super(new Properties().food(food).tab(ItemGroup.TAB_FOOD).rarity(Rarity.COMMON));
    }

}