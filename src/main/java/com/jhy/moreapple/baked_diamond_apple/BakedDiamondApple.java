package com.jhy.moreapple.baked_diamond_apple;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class BakedDiamondApple extends Item {
    private static final Food food = (new Food.Builder())
            .saturationMod(7)
            .nutrition(13)
            .effect(() -> new EffectInstance(Effects.DAMAGE_RESISTANCE, 60*20, 1), 0.60F)
            .effect(() -> new EffectInstance(Effects.MOVEMENT_SPEED, 60*20, 1), 0.60F)
            .effect(() -> new EffectInstance(Effects.NIGHT_VISION, 900*20, 1), 0.60F)
            .effect(() -> new EffectInstance(Effects.ABSORPTION, 120*20, 1), 0.60F)
            .effect(() -> new EffectInstance(Effects.HEAL, 5*20, 3), 0.60F)
            .effect(() -> new EffectInstance(Effects.INVISIBILITY, 10*20, 1), 0.60F)
            .effect(() -> new EffectInstance(Effects.SATURATION, 30*20, 1), 0.60F)
            .effect(() -> new EffectInstance(Effects.SLOW_FALLING, 20*20, 1), 0.60F)
            .alwaysEat()
            .build();

    public BakedDiamondApple() {
        super(new Properties().food(food).tab(ItemGroup.TAB_FOOD).rarity(Rarity.EPIC));
    }

}