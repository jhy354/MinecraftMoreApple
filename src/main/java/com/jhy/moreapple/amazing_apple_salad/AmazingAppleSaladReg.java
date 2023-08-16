package com.jhy.moreapple.amazing_apple_salad;

import com.jhy.moreapple.Utils;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class AmazingAppleSaladReg {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);
    public static final RegistryObject<Item> amazing_apple_salad = ITEMS.register("amazing_apple_salad", AmazingAppleSalad::new);
}