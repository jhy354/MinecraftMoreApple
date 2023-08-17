package com.jhy.more_apple.strange_villager_apple;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class StrangeVillagerApple extends Item {
    private static final Food food = (new Food.Builder())
            .saturationMod(2)
            .nutrition(2)
            .alwaysEat()
            .build();

    @Override
    public void appendHoverText(ItemStack p_77624_1_, @Nullable World p_77624_2_, List<ITextComponent> tooltip, ITooltipFlag p_77624_4_) {

        if (Screen.hasShiftDown()) {
            tooltip.add(new TranslationTextComponent("tooltip.more_apple.strange_villager_apple_shift"));
        }
        else {
            tooltip.add(new TranslationTextComponent("tooltip.more_apple.strange_villager_apple"));
        }

        super.appendHoverText(p_77624_1_, p_77624_2_, tooltip, p_77624_4_);
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity player, Hand p_77659_3_) {
        if(!player.isLocalPlayer()) {
            player.inventory.removeItem(player.getItemInHand(Hand.MAIN_HAND));
            World world = player.getCommandSenderWorld();
            IronGolemEntity[] iron_golems = new IronGolemEntity[5];
            for (int i=0; i<5; i++) {
                iron_golems[i] = new IronGolemEntity(EntityType.IRON_GOLEM, world);
                iron_golems[i].moveTo(player.position());
                iron_golems[i].setPersistentAngerTarget(player.getUUID());
                world.addFreshEntity(iron_golems[i]);
            }
        }

        return super.use(p_77659_1_, player, p_77659_3_);
    }

    public StrangeVillagerApple() {
        super(new Properties()
                .food(food)
                .tab(ItemGroup.TAB_FOOD)
                .rarity(Rarity.RARE)
                .stacksTo(1)
        );
    }

}