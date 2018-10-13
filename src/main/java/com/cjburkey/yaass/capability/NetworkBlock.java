package com.cjburkey.yaass.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public final class NetworkBlock {
    
    private NetworkBlock() {
    }
    
    public static final class Storage implements Capability.IStorage<INetworkBlock> {
        public NBTBase writeNBT(Capability<INetworkBlock> capability, INetworkBlock instance, EnumFacing side) {
            return null;
        }
        public void readNBT(Capability<INetworkBlock> capability, INetworkBlock instance, EnumFacing side, NBTBase nbt) {
        }
    }
    
    public interface INetworkBlock {
    }
    
    public static final class NetworkedBlock implements INetworkBlock {
    }
    
}
