package com.cjburkey.yaass.tile;

import com.cjburkey.yaass.capability.NetworkProvider;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;

public class TileEntityInterface extends TileEntity implements ITickable {
    
    private final Object2ObjectOpenHashMap<BlockPos, InterfacedInv> neighborInventories = new Object2ObjectOpenHashMap<>();
    private final ObjectOpenHashSet<BlockPos> updated = new ObjectOpenHashSet<>();
    
    private final NetworkProvider np = new NetworkProvider();
    
    public void onNeighborUpdate() {
        for (EnumFacing dir : EnumFacing.values()) {
            checkNeighbor(dir);
        }
    }
    
    public void update() {
        updated.clear();
    }
    
    public InterfacedInv getInventory(EnumFacing dir) {
        BlockPos pos = getPos().offset(dir);
        if (neighborInventories.containsKey(pos)) {
            return neighborInventories.get(pos);
        }
        return null;
    }
    
    private void checkNeighbor(EnumFacing dir) {
        BlockPos pos = getPos().offset(dir);
        if (updated.contains(pos)) {
            return;
        }
        updated.add(pos);
        EnumFacing facing = dir.getOpposite();
        TileEntity te = world.getTileEntity(pos);
        if (te != null && te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, facing)) {
            neighborInventories.put(pos, new InterfacedInv(pos, te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, facing)));
        }
    }
    
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return np.hasCapability(capability, facing);
    }
    
    @Nullable
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return np.getCapability(capability, facing);
    }
    
}
