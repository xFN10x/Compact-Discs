package fn10.musicexpansion.reg;

import com.google.common.base.Function;

import fn10.musicexpansion.MusicExpanded;
import fn10.musicexpansion.items.CompactDiscItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class MusicExpandedItems {
    public static <GenericItem extends Item> GenericItem register(String name,
            Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM,
                Identifier.fromNamespaceAndPath(MusicExpanded.MOD_ID, name));

        GenericItem item = itemFactory.apply(settings.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static final Item GLASS_DUST = register("glass_dust", Item::new, new Item.Properties().fireResistant());
    public static final Item REDSTONE_LAZER = register("redstone_lazer", Item::new, new Item.Properties());
    public static final Item DIAMOND_LAZER = register("diamond_lazer", Item::new, new Item.Properties());

    public static final Item CD = register("compact_disc", CompactDiscItem::new, new Item.Properties().stacksTo(1));

    public static void init() {

    }
}
