package net.norbert.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.norbert.tutorialmod.TutorialMod;

public class ModItemGroups {

    public static final ItemGroup AMOGUS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TutorialMod.MOD_ID,"amongus"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.amongus")).icon(() -> new ItemStack(ModItems.IMPOSTER_SWORD))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModItems.IMPOSTER_SWORD);
                        entries.add(ModItems.MOGUS_ORE);

                    })).build());
    public static void registerItemGroups(){
        TutorialMod.LOGGER.info("Registering Item Groups for "+TutorialMod.MOD_ID);
    }

}
