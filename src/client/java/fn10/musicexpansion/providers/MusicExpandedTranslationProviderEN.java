package fn10.musicexpansion.providers;

import java.util.concurrent.CompletableFuture;

import fn10.musicexpansion.reg.MusicExpandedBlocks;
import fn10.musicexpansion.reg.MusicExpandedItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup.Provider;

public class MusicExpandedTranslationProviderEN extends FabricLanguageProvider {

    public MusicExpandedTranslationProviderEN(FabricDataOutput dataOutput,
            CompletableFuture<Provider> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(Provider registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(MusicExpandedItems.GLASS_DUST, "Glass Dust");
        translationBuilder.add(MusicExpandedItems.CD, "Compact-Disc");

        translationBuilder.add(MusicExpandedBlocks.DISC_BURNER_BLOCK, "Disc Burner");
        translationBuilder.add(MusicExpandedBlocks.STEREO_BLOCK, "Stereo");
        translationBuilder.add(MusicExpandedBlocks.DISC_MONOLITH_BLOCK, "Monolith");

        translationBuilder.add("menu.container.disc_burner", "Disc Burner");
        translationBuilder.add("menu.container.stereo", "Stereo");

        translationBuilder.add("itemGroup.compactdiscs", "Compact Discs");
        
        translationBuilder.add("text.cd.tooltip.nosongs", "No Songs");
        translationBuilder.add("text.cd.tooltip.writable", "CD-RW");
        translationBuilder.add("text.cd.tooltip.notwritable", "CD-R");

        translationBuilder.add("subtitle.compactdiscs.block.discburner", "Disc Burner Starts...");

        translationBuilder.add("song.compactdiscs.c418.13", "C418 - 13");
        translationBuilder.add("song.compactdiscs.c418.cat", "C418 - cat");
        translationBuilder.add("song.compactdiscs.c418.blocks", "C418 - blocks");
        translationBuilder.add("song.compactdiscs.c418.chirp", "C418 - chirp");
        translationBuilder.add("song.compactdiscs.c418.far", "C418 - far");
        translationBuilder.add("song.compactdiscs.c418.mall", "C418 - mall");
        translationBuilder.add("song.compactdiscs.c418.mellohi", "C418 - mellohi");
        translationBuilder.add("song.compactdiscs.c418.stal", "C418 - stal");
        translationBuilder.add("song.compactdiscs.c418.strad", "C418 - strad");
        translationBuilder.add("song.compactdiscs.c418.ward", "C418 - ward");
        translationBuilder.add("song.compactdiscs.c418.11", "C418 - 11");
        translationBuilder.add("song.compactdiscs.c418.wait", "C418 - wait");

        translationBuilder.add("song.compactdiscs.c418.pigstep", "Lena Raine - Pigstep");
        translationBuilder.add("song.compactdiscs.c418.otherside", "Lena Raine - otherside");
        translationBuilder.add("song.compactdiscs.c418.creator", "Lena Raine - Creator");
        translationBuilder.add("song.compactdiscs.c418.creatoralt", "Lena Raine - Creator (Music Box)");

        translationBuilder.add("song.compactdiscs.c418.5", "Samuel Åberg - 5");

        translationBuilder.add("song.compactdiscs.c418.relic", "Aaron Cherof - Relic");
        translationBuilder.add("song.compactdiscs.c418.precipice", "Aaron Cherof - Precipice");

        translationBuilder.add("song.compactdiscs.c418.tears", "Amos Roddy - Tears");

        translationBuilder.add("song.compactdiscs.c418.lavachic", "Hyper Potions - Lava Chicken");
    }

}
