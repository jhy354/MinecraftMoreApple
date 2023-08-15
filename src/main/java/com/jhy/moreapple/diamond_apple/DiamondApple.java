package com.jhy.moreapple.diamond_apple;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class DiamondApple extends Item {
    public DiamondApple() {
        //super(new Properties().group(ItemGroup.MATERIALS));
        super(new Properties().tab(ItemGroup.TAB_FOOD));
    }

}