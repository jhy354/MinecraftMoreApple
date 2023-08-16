package com.jhy.more_apple.iron_apple;

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

public class IronApple extends Item {
    private static final Food food = (new Food.Builder())
            .saturationMod(2)
            .nutrition(2)
            .effect(() -> new EffectInstance(Effects.DAMAGE_RESISTANCE, 30*20, 1), 1.0F)
            .alwaysEat()
            .build();

    @Override
    public void appendHoverText(ItemStack p_77624_1_, @Nullable World p_77624_2_, List<ITextComponent> tooltip, ITooltipFlag p_77624_4_) {

        if (Screen.hasShiftDown()) {
            tooltip.add(new TranslationTextComponent("tooltip.more_apple.iron_apple_shift"));
        }
        else {
            tooltip.add(new TranslationTextComponent("tooltip.more_apple.iron_apple"));
        }

        super.appendHoverText(p_77624_1_, p_77624_2_, tooltip, p_77624_4_);
    }

    public IronApple() {
        super(new Properties().food(food).tab(ItemGroup.TAB_FOOD).rarity(Rarity.COMMON));
    }

}