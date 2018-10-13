package com.cjburkey.yaass.capability;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class NetworkProvider implements ICapabilitySerializable<NBTBase> {
    
    @CapabilityInject(NetworkBlock.INetworkBlock.class)
    public static final Capability<NetworkBlock.INetworkBlock> NETWORK_CAP = null;
    
    private NetworkBlock.INetworkBlock instance = NETWORK_CAP.getDefaultInstance();
    
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == NETWORK_CAP;
    }
    
    @Nullable
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return hasCapability(capability, facing) ? NETWORK_CAP.cast(this.instance) : null;
    }
    
    public NBTBase serializeNBT() {
        return new NBTTagCompound();
    }
    
    public void deserializeNBT(NBTBase nbt) {
    }
    
}
