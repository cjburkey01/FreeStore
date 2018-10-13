package com.cjburkey.yaass;

import com.cjburkey.yaass.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModInfo.MODID, name = ModInfo.NAME, version = ModInfo.VERSION, acceptedMinecraftVersions = "[" + ModInfo.MC_VERSION + "]")
public final class YAASS {
    
    private static final String proxyS = "com.cjburkey.yaass.proxy.";
    
    public static final Logger logger = LogManager.getLogger(ModInfo.MODID);
    
    @Mod.Instance(owner = ModInfo.MODID)
    public static YAASS instance;
    
    @SidedProxy(clientSide = proxyS + "ClientProxy", serverSide = proxyS + "ServerProxy")
    public static CommonProxy proxy;
    
    @Mod.EventHandler
    public void construct(FMLConstructionEvent e) {
        proxy.construct(e);
    }
    
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent e) {
        proxy.preinit(e);
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }
    
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent e) {
        proxy.postinit(e);
    }
    
}
