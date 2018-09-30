package com.cjburkey.yaass.item;

import com.cjburkey.yaass.ModInfo;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Objects;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = ModInfo.MODID)
public final class ModItems {
    
    
    
    private static void registerItems() {
        
    }
    
    private ModItems() {
    }
    
    private static final Object2ObjectOpenHashMap<String, Item> items = new Object2ObjectOpenHashMap<>();
    
    public static Item registerItem(Item item, String name) {
        return items.put(name, item.setUnlocalizedName(name).setRegistryName(ModInfo.MODID, name));
    }
    
    @SubscribeEvent
    public static void initItems(RegistryEvent.Register<Item> e) {
        registerItems();
        
        for (Item item : items.values()) {
            e.getRegistry().register(item);
        }
    }
    
    @SubscribeEvent
    public static void initRender(ModelRegistryEvent e) {
        for (Item item : items.values()) {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
        }
    }
    
}
