package net.norbert.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.norbert.tutorialmod.item.ModItemGroups;
import net.norbert.tutorialmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);





	@Override
	public void onInitialize() {
		//bbob
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
	}
}