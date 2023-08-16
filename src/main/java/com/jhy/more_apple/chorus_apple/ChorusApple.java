package com.jhy.more_apple.chorus_apple;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ChorusApple extends Item {
    private static final Food food = (new Food.Builder())
            .saturationMod(2)
            .nutrition(2)
            .alwaysEat()
            .build();

    @Override
    public void appendHoverText(ItemStack p_77624_1_, @Nullable World p_77624_2_, List<ITextComponent> tooltip, ITooltipFlag p_77624_4_) {

        if (Screen.hasShiftDown()) {
            tooltip.add(new TranslationTextComponent("tooltip.more_apple.chorus_apple_shift"));
        }
        else {
            tooltip.add(new TranslationTextComponent("tooltip.more_apple.chorus_apple"));
        }

        super.appendHoverText(p_77624_1_, p_77624_2_, tooltip, p_77624_4_);
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity player, Hand p_77659_3_) {
        if(!player.isLocalPlayer()) {
            Vector3d v = new Vector3d(player.getX() + random.nextDouble()*100, player.getY() + random.nextDouble()*100, player.getZ() + random.nextDouble()*100);
            player.moveTo(v);
        }

        player.inventory.removeItem(player.getItemInHand(Hand.MAIN_HAND));
        return super.use(p_77659_1_, player, p_77659_3_);
    }

    public ChorusApple() {
        super(
                new Properties()
                        .food(food)
                        .tab(ItemGroup.TAB_FOOD)
                        .rarity(Rarity.RARE)
                        .stacksTo(1)
        );
    }

}