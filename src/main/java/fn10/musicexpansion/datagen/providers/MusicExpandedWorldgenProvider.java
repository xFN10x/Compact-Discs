package fn10.musicexpansion.datagen.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;

import java.util.concurrent.CompletableFuture;

public class MusicExpandedWorldgenProvider extends FabricDynamicRegistryProvider {
    public MusicExpandedWorldgenProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider provider, Entries entries) {
        entries.addAll(provider.lookupOrThrow(Registries.CONFIGURED_FEATURE));
        entries.addAll(provider.lookupOrThrow(Registries.PLACED_FEATURE));
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
