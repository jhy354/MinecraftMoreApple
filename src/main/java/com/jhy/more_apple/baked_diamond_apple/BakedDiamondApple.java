package com.jhy.more_apple.baked_diamond_apple;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BakedDiamondApple extends Item {
    private static final Food food = (new Food.Builder())
            .saturationMod(5)
            .nutrition(8)
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

    @Override
    public void appendHoverText(ItemStack p_77624_1_, @Nullable World p_77624_2_, List<ITextComponent> tooltip, ITooltipFlag p_77624_4_) {

        if (Screen.hasShiftDown()) {
            tooltip.add(new TranslationTextComponent("tooltip.more_apple.baked_diamond_apple_shift"));
        }
        else {
            tooltip.add(new TranslationTextComponent("tooltip.more_apple.baked_diamond_apple"));
        }

        super.appendHoverText(p_77624_1_, p_77624_2_, tooltip, p_77624_4_);
    }

    public BakedDiamondApple() {
        super(new Properties().food(food).tab(ItemGroup.TAB_FOOD).rarity(Rarity.RARE));
    }

}