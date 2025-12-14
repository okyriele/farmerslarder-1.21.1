package io.github.okyriele.farmerslarder.block;

import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import io.github.okyriele.farmerslarder.FarmersLarder;
import io.github.okyriele.farmerslarder.item.FarmersLarderItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BambooStalkBlock;
import net.minecraft.world.level.block.BeetrootBlock;
import net.minecraft.world.level.block.Blocks;

public class MammothSunflowerCropBlock extends CropBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF;

    public MammothSunflowerCropBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(HALF, DoubleBlockHalf.LOWER));
        //TODO Auto-generated constructor stub
    }

    @Override
    protected ItemLike getBaseSeedId() {
      return FarmersLarderItems.SUNFLOWER_SEEDS;
   }

    static {
      HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    }
    
}
