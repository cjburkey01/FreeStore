package com.cjburkey.yaass.proxy;

import com.cjburkey.yaass.capability.NetworkBlock;
import com.cjburkey.yaass.tile.TileEntityInterface;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    
    public void construct(FMLConstructionEvent e) {
    }
    
    public void preinit(FMLPreInitializationEvent e) {
        CapabilityManager.INSTANCE.register(NetworkBlock.INetworkBlock.class, new NetworkBlock.Storage(), NetworkBlock.NetworkedBlock::new);
    }
    
    public void init(FMLInitializationEvent e) {
        TileEntity.register("tile_interface", TileEntityInterface.class);
    }
    
    public void postinit(FMLPostInitializationEvent e) {
    }
    
}
