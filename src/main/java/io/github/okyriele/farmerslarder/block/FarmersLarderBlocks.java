package io.github.okyriele.farmerslarder.block;

import java.util.function.Supplier;

import io.github.okyriele.farmerslarder.FarmersLarder;
import io.github.okyriele.farmerslarder.item.FarmersLarderItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FarmersLarderBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FarmersLarder.MODID);

    public static final DeferredBlock<Block> PUMPKIN_PIE = registerBlock("pumpkin_pie", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE)));
    public static final DeferredBlock<Block> CARROT_CAKE = registerBlock("carrot_cake", () -> new SliceableCakeBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY),FarmersLarderItems.CARROT_CAKE_SLICE)); //
    public static final DeferredBlock<Block> CHOCOLATE_CAKE = registerBlock("chocolate_cake", () -> new SliceableCakeBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY),FarmersLarderItems.CHOCOLATE_CAKE_SLICE)); //
    public static final DeferredBlock<Block> GLOWBERRY_CHEESECAKE = registerBlock("glowberry_cheesecake", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE)));
    public static final DeferredBlock<Block> SPICE_CAKE = registerBlock("spice_cake", () -> new SliceableCakeBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY),FarmersLarderItems.SPICE_CAKE_SLICE)); //
    public static final DeferredBlock<Block> WESTERN_BREAKFAST = registerBlock("western_breakfast", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE)));

    public static final DeferredBlock<Block> MAMMOTH_SUNFLOWER = registerBlock("mammoth_sunflower", () -> new MammothSunflowerCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SUNFLOWER)));

    private static <T extends Block> DeferredBlock<T> registerBlock (String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        String itemName = name + "_item";

        FarmersLarderItems.ITEMS.register(itemName, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> DeferredBlock<T> registerBlockWithoutItem (String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        return toReturn;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
