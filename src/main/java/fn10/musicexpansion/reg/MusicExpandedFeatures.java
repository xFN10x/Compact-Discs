package fn10.musicexpansion.reg;

import fn10.musicexpansion.MusicExpanded;
import fn10.musicexpansion.generation.features.MonolithFeature;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.heightproviders.TrapezoidHeight;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class MusicExpandedFeatures {

    public static ResourceKey<ConfiguredFeature<?, ?>> regConfig(String id) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE,
                Identifier.fromNamespaceAndPath(MusicExpanded.MOD_ID, id));
    }

    public static ResourceKey<PlacedFeature> regPlacement(String id) {
        return ResourceKey.create(
                Registries.PLACED_FEATURE,
                Identifier.fromNamespaceAndPath(MusicExpanded.MOD_ID, id)
        );
    }

    //taken from the feature class
    public static <C extends FeatureConfiguration, F extends Feature<C>> F regFeature(String string, F feature) {
        return Registry.register(BuiltInRegistries.FEATURE, string, feature);
    }

    public static final List<PlacementModifier> MONOLITH_FEATURE_PLACED_MODFIIERS = List.of(
            CountPlacement.of(1),
            BiomeFilter.biome(),
            RarityFilter.onAverageOnceEvery(4),
            InSquarePlacement.spread(),
            HeightRangePlacement.of(
                    TrapezoidHeight.of(
                            VerticalAnchor.absolute(5),
                            VerticalAnchor.absolute(50))));

    public static final ResourceKey<PlacedFeature> MONOLITH_FEATURE_PLACED = regPlacement("monolith_cave_placed");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MONOLITH_FEATURE_CONFIGURED = regConfig("monolith_cave");
    public static final MonolithFeature MONOLITH_FEATURE = regFeature("monolith", new MonolithFeature());

    public static void configured(BootstrapContext<ConfiguredFeature<?, ?>> bootstrapContext) {
        bootstrapContext.register(MONOLITH_FEATURE_CONFIGURED,
                new ConfiguredFeature<>(
                        MONOLITH_FEATURE, NoneFeatureConfiguration.INSTANCE
                ));
    }

    public static void placed(BootstrapContext<PlacedFeature> bootstrapContext) {
        bootstrapContext.register(MONOLITH_FEATURE_PLACED,
                new PlacedFeature(
                        bootstrapContext.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(MONOLITH_FEATURE_CONFIGURED),
                        MONOLITH_FEATURE_PLACED_MODFIIERS
                ));
    }

    public static void init() {
    }
}
