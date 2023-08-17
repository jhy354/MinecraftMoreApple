package com.jhy.more_apple.villager_apple;

import com.jhy.more_apple.Utils;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VillagerAppleReg {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);
    public static final RegistryObject<Item> villager_apple = ITEMS.register("villager_apple", VillagerApple::new);
}