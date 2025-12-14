package io.github.okyriele.farmerslarder.block;

import java.util.function.Supplier;

import io.github.okyriele.farmerslarder.FarmersLarder;
import io.github.okyriele.farmerslarder.tag.ModdedTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;


public class SliceableCakeBlock extends CakeBlock {

    public final Supplier<Item> cakeSlice;

    public SliceableCakeBlock(BlockBehaviour.Properties properties, Supplier<Item> cakeSlice) {
      super(properties);
      this.cakeSlice = cakeSlice;
    }

    public ItemStack getSlice() {
		return new ItemStack(this.cakeSlice.get());
    } 

    /*@Override
	public ItemInteractionResult useItemOn(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (heldStack.is(ModdedTags.KNIVES)) {
			return cutSlice(level, pos, state, player);
		}

		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}

    protected ItemInteractionResult cutSlice(Level level, BlockPos pos, BlockState state, Player player) {
		/*int bites = state.getValue(BITES);
		if (bites < 6) {
			level.setBlock(pos, state.setValue(BITES, bites + 1),6);
		} else {
			level.removeBlock(pos, false);
		}
        player.getInventory().add(this.getSlice());
        //level.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
		return ItemInteractionResult.SUCCESS;
	}
*/

    
}
