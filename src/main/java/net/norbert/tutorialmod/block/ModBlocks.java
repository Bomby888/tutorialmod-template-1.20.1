package net.norbert.tutorialmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.norbert.tutorialmod.TutorialMod;

public class ModBlocks {

    public static final Block MOGUS_BLOCK = registerBlock("mogus_block"
            ,new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.HONEY)));
    //FabricBlockSettings.create()
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID,name),block);
    }
    private  static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID,name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        TutorialMod.LOGGER.info("Registering ModBlocks"+TutorialMod.MOD_ID);
    }
}
