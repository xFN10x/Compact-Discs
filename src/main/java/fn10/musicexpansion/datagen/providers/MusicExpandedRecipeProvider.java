package fn10.musicexpansion.datagen.providers;

import java.util.concurrent.CompletableFuture;

import fn10.musicexpansion.reg.MusicExpandedBlocks;
import fn10.musicexpansion.reg.MusicExpandedItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.jspecify.annotations.NonNull;

public class MusicExpandedRecipeProvider extends FabricRecipeProvider {

    public MusicExpandedRecipeProvider(FabricDataOutput output, CompletableFuture<Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public @NonNull String getName() {
        return getClass().getSimpleName();
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(@NonNull Provider registryLookup, @NonNull RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {

            @Override
            public void buildRecipes() {
                shaped(RecipeCategory.MISC, MusicExpandedItems.GLASS_DUST)
                        .pattern("AA")
                        .pattern("AA")
                        .define('A', MusicExpandedItemTagProvider.GLASS)
                        .unlockedBy(getHasName(Items.GLASS), has(MusicExpandedItemTagProvider.GLASS))
                        .unlockedBy(getHasName(MusicExpandedItems.GLASS_DUST), has(MusicExpandedItems.GLASS_DUST))
                        .save(exporter);

                shaped(RecipeCategory.MISC, MusicExpandedItems.REDSTONE_LAZER)
                        .pattern("GRG")
                        .pattern("ARA")
                        .pattern("AAA")
                        .define('A', Blocks.SMOOTH_STONE)
                        .define('R', Items.REDSTONE)
                        .define('G', MusicExpandedItems.GLASS_DUST)
                        .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                        .unlockedBy(getHasName(MusicExpandedItems.GLASS_DUST), has(MusicExpandedItems.GLASS_DUST))
                        .unlockedBy(getHasName(MusicExpandedItems.REDSTONE_LAZER), has(MusicExpandedItems.REDSTONE_LAZER))
                        .save(exporter);

                shaped(RecipeCategory.MISC, MusicExpandedItems.DIAMOND_LAZER)
                        .pattern("GRG")
                        .pattern("ARA")
                        .pattern("AAA")
                        .define('A', Blocks.SMOOTH_STONE)
                        .define('R', Items.DIAMOND)
                        .define('G', MusicExpandedItems.GLASS_DUST)
                        .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                        .unlockedBy(getHasName(MusicExpandedItems.GLASS_DUST), has(MusicExpandedItems.GLASS_DUST))
                        .unlockedBy(getHasName(MusicExpandedItems.DIAMOND_LAZER), has(MusicExpandedItems.DIAMOND_LAZER))
                        .save(exporter);

                shaped(RecipeCategory.MISC, MusicExpandedItems.CD)
                        .pattern("GG")
                        .pattern("II")
                        .pattern("GG")
                        .define('I', Items.IRON_NUGGET)
                        .define('G', MusicExpandedItems.GLASS_DUST)
                        .unlockedBy(getHasName(MusicExpandedItems.GLASS_DUST), has(MusicExpandedItems.GLASS_DUST))
                        .unlockedBy(getHasName(MusicExpandedItems.CD), has(MusicExpandedItems.CD))
                        .save(exporter);

                shaped(RecipeCategory.MISC, MusicExpandedBlocks.DISC_BURNER_BLOCK)
                        .pattern("RGR")
                        .pattern("SIS")
                        .pattern("SSS")
                        .define('I', MusicExpandedItems.REDSTONE_LAZER)
                        .define('R', Items.REDSTONE)
                        .define('S', Blocks.SMOOTH_STONE)
                        .define('G', MusicExpandedItems.GLASS_DUST)
                        .unlockedBy(getHasName(MusicExpandedItems.GLASS_DUST), has(MusicExpandedItems.GLASS_DUST))
                        .unlockedBy(getHasName(MusicExpandedItems.REDSTONE_LAZER), has(MusicExpandedItems.REDSTONE_LAZER))
                        .unlockedBy(getHasName(MusicExpandedBlocks.DISC_BURNER_BLOCK), has(MusicExpandedBlocks.DISC_BURNER_BLOCK))
                        .save(exporter);

                shaped(RecipeCategory.MISC, MusicExpandedBlocks.DISC_MONOLITH_BLOCK)
                        .pattern("SSS")
                        .pattern("VIC")
                        .pattern("SRS")
                        .define('I', MusicExpandedItems.REDSTONE_LAZER)
                        .define('R', Items.REDSTONE)
                        .define('C', Items.COPPER_INGOT)
                        .define('S', Blocks.COBBLESTONE)
                        .define('V', Blocks.VINE)
                        .unlockedBy(getHasName(Blocks.MOSSY_COBBLESTONE), has(Blocks.MOSSY_COBBLESTONE))
                        .unlockedBy(getHasName(Blocks.VINE), has(Blocks.VINE))
                        .unlockedBy(getHasName(MusicExpandedBlocks.DISC_MONOLITH_BLOCK), has(MusicExpandedBlocks.DISC_MONOLITH_BLOCK))
                        .unlockedBy(getHasName(MusicExpandedItems.REDSTONE_LAZER), has(MusicExpandedItems.REDSTONE_LAZER))
                        .save(exporter, "disc_mono_vines");

                shaped(RecipeCategory.MISC, MusicExpandedBlocks.DISC_MONOLITH_BLOCK)
                        .pattern("SSS")
                        .pattern("SIC")
                        .pattern("SRS")
                        .define('I', MusicExpandedItems.REDSTONE_LAZER)
                        .define('R', Items.REDSTONE)
                        .define('C', Items.COPPER_INGOT)
                        .define('S', Blocks.MOSSY_COBBLESTONE)
                        .unlockedBy(getHasName(Blocks.MOSSY_COBBLESTONE), has(Blocks.MOSSY_COBBLESTONE))
                        .unlockedBy(getHasName(Blocks.VINE), has(Blocks.VINE))
                        .unlockedBy(getHasName(MusicExpandedBlocks.DISC_MONOLITH_BLOCK), has(MusicExpandedBlocks.DISC_MONOLITH_BLOCK))
                        .unlockedBy(getHasName(MusicExpandedItems.REDSTONE_LAZER), has(MusicExpandedItems.REDSTONE_LAZER))
                        .save(exporter);

                shaped(RecipeCategory.MISC, MusicExpandedBlocks.STEREO_BLOCK)
                        .pattern("SGS")
                        .pattern("DID")
                        .pattern("RRR")
                        .define('I', MusicExpandedItems.DIAMOND_LAZER)
                        .define('R', Items.REDSTONE)
                        .define('G', Blocks.GLASS)
                        .define('D', Items.DIAMOND)
                        .define('S', Blocks.SMOOTH_STONE)
                        .unlockedBy(getHasName(Blocks.MOSSY_COBBLESTONE), has(Blocks.MOSSY_COBBLESTONE))
                        .unlockedBy(getHasName(Blocks.VINE), has(Blocks.VINE))
                        .unlockedBy(getHasName(MusicExpandedBlocks.STEREO_BLOCK), has(MusicExpandedBlocks.STEREO_BLOCK))
                        .unlockedBy(getHasName(MusicExpandedItems.REDSTONE_LAZER), has(MusicExpandedItems.REDSTONE_LAZER))
                        .save(exporter);
            }

        };
    }

}
