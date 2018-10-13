package com.cjburkey.yaass.block;

import com.cjburkey.yaass.capability.NetworkBlock;
import com.cjburkey.yaass.capability.NetworkProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockCable extends BlockTransparent implements NetworkBlock.INetworkBlock {
    
    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool WEST = PropertyBool.create("west");
    public static final PropertyBool UP = PropertyBool.create("up");
    public static final PropertyBool DOWN = PropertyBool.create("down");
    
    public BlockCable() {
        super(Material.IRON);
        
        setCreativeTab(CreativeTabs.REDSTONE);
        setHarvestLevel("pickaxe", 0);
        setHardness(0.25f);
        setSoundType(SoundType.METAL);
    }
    
    public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
        return state.withProperty(NORTH, checkBlock(world, pos, EnumFacing.NORTH))
                    .withProperty(SOUTH, checkBlock(world, pos, EnumFacing.SOUTH))
                    .withProperty(EAST, checkBlock(world, pos, EnumFacing.EAST))
                    .withProperty(WEST, checkBlock(world, pos, EnumFacing.WEST))
                    .withProperty(UP, checkBlock(world, pos, EnumFacing.UP))
                    .withProperty(DOWN, checkBlock(world, pos, EnumFacing.DOWN));
    }
    
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, NORTH, SOUTH, EAST, WEST, UP, DOWN);
    }
    
    private boolean checkBlock(IBlockAccess world, BlockPos pos, EnumFacing direction) {
        pos = pos.offset(direction);
        IBlockState at = world.getBlockState(pos);
        if (NetworkBlock.INetworkBlock.class.isAssignableFrom(at.getBlock().getClass())) {
            return true;
        }
        TileEntity te = world.getTileEntity(pos);
        return te != null && te.hasCapability(NetworkProvider.NETWORK_CAP, direction.getOpposite());
    }
    
    public int getMetaFromState(IBlockState state) {
        return 0;
    }
    
}
