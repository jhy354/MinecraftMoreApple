package com.jhy.more_apple.amazing_apple_salad;

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

public class AmazingAppleSalad extends Item {
    private static final Food food = (new Food.Builder())
            .saturationMod(10)
            .nutrition(10)
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

    @Override
    public void appendHoverText(ItemStack p_77624_1_, @Nullable World p_77624_2_, List<ITextComponent> tooltip, ITooltipFlag p_77624_4_) {

        if (Screen.hasShiftDown()) {
            tooltip.add(new TranslationTextComponent("tooltip.more_apple.amazing_apple_salad_shift"));
        }
        else {
            tooltip.add(new TranslationTextComponent("tooltip.more_apple.amazing_apple_salad"));
        }

        super.appendHoverText(p_77624_1_, p_77624_2_, tooltip, p_77624_4_);
    }

    public AmazingAppleSalad() {
        super(new Properties().food(food).tab(ItemGroup.TAB_FOOD).rarity(Rarity.EPIC));
    }

}