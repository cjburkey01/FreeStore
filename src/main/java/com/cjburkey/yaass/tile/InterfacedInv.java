package com.cjburkey.yaass.tile;

import java.util.Objects;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.items.IItemHandler;

public final class InterfacedInv {
    
    public final BlockPos pos;
    public final IItemHandler items;
    
    public InterfacedInv(BlockPos pos, IItemHandler items) {
        this.pos = pos.toImmutable();
        this.items = items;
    }
    
    public int getItemSlots() {
        return this.items.getSlots();
    }
    
    public ItemStack[] getItems() {
        ItemStack[] out = new ItemStack[getItemSlots()];
        for (int i = 0; i < out.length; i ++) {
            out[i] = items.getStackInSlot(i);
        }
        return out;
    }
    
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InterfacedInv that = (InterfacedInv) o;
        return Objects.equals(pos, that.pos);
    }
    
    public int hashCode() {
        return Objects.hash(pos);
    }
    
}
