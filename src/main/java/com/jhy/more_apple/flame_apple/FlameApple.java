package com.jhy.more_apple.flame_apple;

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

public class FlameApple extends Item {
    private static final Food food = (new Food.Builder())
            .saturationMod(8)
            .nutrition(8)
            .effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 3600*20, 1), 1.0F)
            .effect(() -> new EffectInstance(Effects.GLOWING, 3600*20, 1), 1.0F)
            .effect(() -> new EffectInstance(Effects.CONFUSION, 60*20, 1), 0.5F)
            .effect(() -> new EffectInstance(Effects.BLINDNESS, 60*20, 1), 0.5F)
            .alwaysEat()
            .build();

    @Override
    public void appendHoverText(ItemStack p_77624_1_, @Nullable World p_77624_2_, List<ITextComponent> tooltip, ITooltipFlag p_77624_4_) {

        if (Screen.hasShiftDown()) {
            tooltip.add(new TranslationTextComponent("tooltip.more_apple.flame_apple_shift"));
        }
        else {
            tooltip.add(new TranslationTextComponent("tooltip.more_apple.flame_apple"));
        }

        super.appendHoverText(p_77624_1_, p_77624_2_, tooltip, p_77624_4_);
    }

    public FlameApple() {
        super(new Properties().food(food).tab(ItemGroup.TAB_FOOD).rarity(Rarity.EPIC));
    }

}