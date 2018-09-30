package com.cjburkey.yaass.block;

import com.cjburkey.yaass.ModInfo;
import com.cjburkey.yaass.item.ModItems;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Objects;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = ModInfo.MODID)
public final class ModBlocks {
    
    
    
    private static void registerBlocks() {
        
    }
    
    private ModBlocks() {
    }
    
    private static final Object2ObjectOpenHashMap<String, Block> blocks = new Object2ObjectOpenHashMap<>();
    
    public static Block registerBlock(Block block, String name) {
        return blocks.put(name, block.setUnlocalizedName(name).setRegistryName(ModInfo.MODID, name));
    }
    
    @SubscribeEvent
    public static void initBlocks(RegistryEvent.Register<Block> e) {
        registerBlocks();
        
        for (Block block : blocks.values()) {
            e.getRegistry().register(block);
            ModItems.registerItem(new ItemBlock(block), Objects.requireNonNull(block.getRegistryName()).getResourcePath());
        }
    }
    
}
