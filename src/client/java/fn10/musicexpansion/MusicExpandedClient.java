package fn10.musicexpansion;

import java.util.HashMap;
import java.util.Optional;

import fn10.musicexpansion.items.CompactDiscItem;
import fn10.musicexpansion.music.network.CDTrackPlayPayloadS2C;
import fn10.musicexpansion.music.network.payload.CDTrackStopPayloadS2C;
import fn10.musicexpansion.reg.MusicExpandedBlocks;
import fn10.musicexpansion.reg.MusicExpandedItems;
import fn10.musicexpansion.reg.MusicExpandedMenus;
import fn10.musicexpansion.screens.DiscBurnerScreenConstructor;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;

public class MusicExpandedClient implements ClientModInitializer {

	public static HashMap<Integer, SoundInstance> TRACK_INSTANCES = new HashMap<>();

	@Override
	public void onInitializeClient() {
		ClientPlayNetworking.registerGlobalReceiver(CDTrackPlayPayloadS2C.ID, (payload, contxt) -> {
			Minecraft client = contxt.client();
			Optional<SoundEvent> optionalEvent = payload.event().unwrap().right();
			SoundEvent event = optionalEvent.orElseThrow();
			SoundInstance instance = SimpleSoundInstance.forJukeboxSong(event, payload.pos().getCenter());
			client.getSoundManager().play(instance);

			client.gui.setNowPlaying(Component.translatable(payload.translationKey()));

			TRACK_INSTANCES.put(payload.id(), instance);
		});
		ClientPlayNetworking.registerGlobalReceiver(CDTrackStopPayloadS2C.ID, (payload, contxt) -> {
			Minecraft client = contxt.client();
			SoundInstance sInstance = TRACK_INSTANCES.get(payload.id());
			if (sInstance == null)
				return;
			client.getSoundManager().stop(sInstance);
			TRACK_INSTANCES.remove(payload.id());
		});

		ItemTooltipCallback.EVENT.register((stack, context, tooltipType, lines) -> {
			if (stack.is(MusicExpandedItems.CD)) {
				lines.addAll(CompactDiscItem.getTooltip(context, stack, tooltipType));
			}
		});
		MenuScreens.register(MusicExpandedMenus.DISC_BURNER_MENU, new DiscBurnerScreenConstructor());

		ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos,i) -> blockAndTintGetter.getBlockTint(blockPos, BiomeColors.FOLIAGE_COLOR_RESOLVER), MusicExpandedBlocks.DISC_MONOLITH_BLOCK);

		BlockRenderLayerMap.putBlock(MusicExpandedBlocks.DISC_BURNER_BLOCK, ChunkSectionLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(MusicExpandedBlocks.STEREO_BLOCK, ChunkSectionLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(MusicExpandedBlocks.DISC_MONOLITH_BLOCK, ChunkSectionLayer.CUTOUT);
	}
}