package com.cjburkey.yaass.block;

import com.cjburkey.yaass.tile.TileEntityInterface;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockInterface extends Block implements ITileEntityProvider {
    
    public BlockInterface() {
        super(Material.IRON);
        
        setCreativeTab(CreativeTabs.REDSTONE);
        setHarvestLevel("pickaxe", 0);
        setHardness(0.5f);
        setSoundType(SoundType.METAL);
    }
    
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        TileEntityInterface te = getTe(world, pos);
        te.onNeighborUpdate();
    }
    
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos from) {
        updateTileEntity(world, pos);
    }
    
    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor) {
        updateTileEntity(world, pos);
    }
    
    private void updateTileEntity(IBlockAccess world, BlockPos pos) {
        TileEntityInterface te = getTe(world, pos);
        if (te != null) {
            te.onNeighborUpdate();
        }
    }
    
    private TileEntityInterface getTe(IBlockAccess world, BlockPos pos) {
        TileEntity te = world.getTileEntity(pos);
        if (te != null) {
            return (TileEntityInterface) te;
        }
        return null;
    }
    
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityInterface();
    }
    
}
