package fn10.musicexpansion;

import fn10.musicexpansion.datagen.providers.*;
import fn10.musicexpansion.providers.MusicExpandedModelProvider;
import fn10.musicexpansion.providers.MusicExpandedTranslationProviderEN;
import fn10.musicexpansion.reg.MusicExpandedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator.Pack;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class MusicExpandedDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(MusicExpandedRecipeProvider::new);
		pack.addProvider(MusicExpandedItemTagProvider::new);
		pack.addProvider(MusicExpandedModelProvider::new);
		pack.addProvider(MusicExpandedTranslationProviderEN::new);
		pack.addProvider(MusicExpandedBlockLootTableProvider::new);
		pack.addProvider(MusicExpandedBlockTagProvider::new);
		pack.addProvider(MusicExpandedWorldgenProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, MusicExpandedFeatures::configured);
		registryBuilder.add(Registries.PLACED_FEATURE, MusicExpandedFeatures::placed);
	}
}
