package com.jhy.moreapple.amazing_apple_salad;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class AmazingAppleSalad extends Item {
    private static final Food food = (new Food.Builder())
            .saturationMod(10)
            .nutrition(15)
            .effect(() -> new EffectInstance(Effects.DAMAGE_RESISTANCE, 30*20, 2), 1.0F)
            .effect(() -> new EffectInstance(Effects.MOVEMENT_SPEED, 20*20, 2), 1.0F)
            .effect(() -> new EffectInstance(Effects.NIGHT_VISION, 1200*20, 1), 1.0F)
            .effect(() -> new EffectInstance(Effects.ABSORPTION, 80*20, 2), 1.0F)
            .effect(() -> new EffectInstance(Effects.HEAL, 3*20, 5), 1.0F)
            .effect(() -> new EffectInstance(Effects.INVISIBILITY, 20*20, 1), 1.0F)
            .effect(() -> new EffectInstance(Effects.SATURATION, 20*20, 1), 1.0F)
            .effect(() -> new EffectInstance(Effects.DAMAGE_BOOST, 20*20, 1), 1.0F)
            .alwaysEat()
            .build();

    public AmazingAppleSalad() {
        super(new Properties().food(food).tab(ItemGroup.TAB_FOOD).rarity(Rarity.EPIC));
    }

}