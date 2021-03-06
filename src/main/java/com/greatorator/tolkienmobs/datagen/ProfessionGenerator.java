package com.greatorator.tolkienmobs.datagen;

import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableSet;
import com.greatorator.tolkienmobs.TTMContent;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.greatorator.tolkienmobs.TolkienMobs.MODID;

public class ProfessionGenerator {
   private static final Supplier<Set<PointOfInterestType>> WORKSTATIONS = Suppliers.memoize(() -> {
      return Registry.VILLAGER_PROFESSION.stream().map(VillagerProfession::getPointOfInterest).collect(Collectors.toSet());
   });

   public static final Predicate<PointOfInterestType> ANY_VILLAGER_WORKSTATION = (type) -> {
      return WORKSTATIONS.get().contains(type);
   };

   public static final DeferredRegister<VillagerProfession> PROFESSION = DeferredRegister.create(ForgeRegistries.PROFESSIONS, MODID);
   public static final DeferredRegister<PointOfInterestType> POIT = DeferredRegister.create(ForgeRegistries.POI_TYPES, MODID);

   //#################################################################
   // POIT
   //#################################################################
   //Points of Interest Types
   public static final RegistryObject<PointOfInterestType> SLACKER = POIT.register("unemployed", ()-> new PointOfInterestType("unemployed", ImmutableSet.of(), 1,ANY_VILLAGER_WORKSTATION, 1));
   public static final RegistryObject<PointOfInterestType> COIN_TRADER = POIT.register("coin_trader", ()-> new PointOfInterestType("coin_trader", PointOfInterestType.getAllStates(TTMContent.MITHRIL_BARS.get()), 1, 1));
   public static final RegistryObject<PointOfInterestType> GROCERY_STORE = POIT.register("grocery_store", ()-> new PointOfInterestType("grocery_store", PointOfInterestType.getAllStates(TTMContent.DOOR_MITHRIL.get()), 1, 1));
   public static final RegistryObject<PointOfInterestType> PET_MERCHANT = POIT.register("pet_merchant", ()-> new PointOfInterestType("pet_merchant", PointOfInterestType.getAllStates(TTMContent.MORGULIRON_BARS.get()), 1, 1));
   public static final RegistryObject<PointOfInterestType> JUNK_TRADER = POIT.register("junk_trader", ()-> new PointOfInterestType("junk_trader", PointOfInterestType.getAllStates(TTMContent.DOOR_MORGULIRON.get()), 1, 1));

   //#################################################################
   // Profession Registry
   //#################################################################
   // Profession
   public static final RegistryObject<VillagerProfession> UNEMPLOYED_PROFESSION = PROFESSION.register("unemployed", () -> new VillagerProfession("unemployed", SLACKER.get(), ImmutableSet.of(), ImmutableSet.of(), (SoundEvent)null));
   public static final RegistryObject<VillagerProfession> COIN_TRADER_PROFESSION = PROFESSION.register("coin_trader", () -> new VillagerProfession("coin_trader", COIN_TRADER.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_CARTOGRAPHER));
   public static final RegistryObject<VillagerProfession> GROCERY_STORE_PROFESSION = PROFESSION.register("grocery_store", () -> new VillagerProfession("grocery_store", GROCERY_STORE.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_BUTCHER));
   public static final RegistryObject<VillagerProfession> PET_MERCHANT_PROFESSION = PROFESSION.register("pet_merchant", () -> new VillagerProfession("pet_merchant", PET_MERCHANT.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN));
   public static final RegistryObject<VillagerProfession> JUNK_TRADER_PROFESSION = PROFESSION.register("junk_trader", () -> new VillagerProfession("junk_trader", JUNK_TRADER.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_CLERIC));

}
