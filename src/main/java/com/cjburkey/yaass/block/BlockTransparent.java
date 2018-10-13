package com.cjburkey.yaass.block;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockTransparent extends BlockBreakable {
    
    public BlockTransparent(Material blockMaterialIn, MapColor blockMapColorIn) {
        super(blockMaterialIn, true, blockMapColorIn);
    }
    
    public BlockTransparent(Material materialIn) {
        super(materialIn, true);
    }
    
    public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    public boolean isFullCube(IBlockState state) {
        return false;
    }
    
}
