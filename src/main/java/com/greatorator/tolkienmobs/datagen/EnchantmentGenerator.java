package com.greatorator.tolkienmobs.datagen;

import com.greatorator.tolkienmobs.enchantments.EnchantmentBalrogMark;
import com.greatorator.tolkienmobs.enchantments.EnchantmentElvenLongevity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.greatorator.tolkienmobs.TolkienMobs.MODID;

public class EnchantmentGenerator {
    private static final EquipmentSlotType[] ARMOR_SLOTS = new EquipmentSlotType[]{EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET};

    public static final DeferredRegister<Enchantment> ENCHANTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MODID);

    public static final RegistryObject<Enchantment> BALROG_MARK = ENCHANTS.register("balrogs_mark", () -> new EnchantmentBalrogMark(Enchantment.Rarity.RARE, EquipmentSlotType.FEET));
    public static final RegistryObject<Enchantment> ELVEN_LONGEVITY = ENCHANTS.register("elven_longevity", () -> new EnchantmentElvenLongevity(Enchantment.Rarity.RARE, EquipmentSlotType.CHEST));
//    public static final Enchantment SWEEPING = register("sweeping", new SweepingEnchantment(Enchantment.Rarity.RARE, EquipmentSlotType.MAINHAND));


    private static Enchantment register(String key, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, key, enchantment);
    }
}
