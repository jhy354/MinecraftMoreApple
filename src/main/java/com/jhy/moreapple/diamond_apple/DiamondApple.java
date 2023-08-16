package com.jhy.moreapple.diamond_apple;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class DiamondApple extends Item {
    private static final Food food = (new Food.Builder())
            .saturationMod(5)
            .nutrition(10)
            .effect(() -> new EffectInstance(Effects.DAMAGE_RESISTANCE, 60*20, 1), 1.0F)
            .effect(() -> new EffectInstance(Effects.MOVEMENT_SPEED, 60*20, 1), 1.0F)
            .effect(() -> new EffectInstance(Effects.NIGHT_VISION, 900*20, 1), 1.0F)
            .effect(() -> new EffectInstance(Effects.ABSORPTION, 120*20, 1), 1.0F)
            .effect(() -> new EffectInstance(Effects.HEAL, 5*20, 3), 0.25F)
            .effect(() -> new EffectInstance(Effects.INVISIBILITY, 10*20, 1), 0.25F)
            .effect(() -> new EffectInstance(Effects.SATURATION, 30*20, 1), 0.25F)
            .effect(() -> new EffectInstance(Effects.SLOW_FALLING, 20*20, 1), 0.25F)
            .alwaysEat()
            .build();

    public DiamondApple() {
        super(new Properties().food(food).tab(ItemGroup.TAB_FOOD).rarity(Rarity.EPIC));
    }

}