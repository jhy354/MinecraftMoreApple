package com.jhy.moreapple.baked_diamond_apple;

import com.jhy.moreapple.Utils;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BakedDiamondAppleReg {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);
    public static final RegistryObject<Item> baked_diamond_apple = ITEMS.register("baked_diamond_apple", BakedDiamondApple::new);
}