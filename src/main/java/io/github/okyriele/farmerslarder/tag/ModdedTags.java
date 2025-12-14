package io.github.okyriele.farmerslarder.tag;

import io.github.okyriele.farmerslarder.FarmersLarder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModdedTags {
    
    public static final TagKey<Item> KNIVES = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "tools/knives"));

    
}
