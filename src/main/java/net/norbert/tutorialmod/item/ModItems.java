package net.norbert.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.norbert.tutorialmod.TutorialMod;

public class ModItems {
    public static final Item MOGUS_ORE = registerItem("mogus_ore",new Item(new FabricItemSettings()));
    public static final Item IMPOSTER_SWORD =registerItem("imposter_sword",new Item(new FabricItemSettings()));
    public static final Item MOGUS_INGOT =registerItem("mogus_ingot",new Item(new FabricItemSettings()));

    private static void addItemsToIngridientItemGroup(FabricItemGroupEntries entries){
        entries.add(MOGUS_ORE);
        entries.add(IMPOSTER_SWORD);
        entries.add(MOGUS_INGOT);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID,name),item);
    }

    public static void registerModItems(){
        TutorialMod.LOGGER.info("Registering Mod items for "+TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToIngridientItemGroup);
    }
}
