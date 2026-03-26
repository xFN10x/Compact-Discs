package fn10.musicexpansion;

import java.util.ArrayList;
import java.util.List;

import com.mojang.brigadier.context.CommandContext;

import fn10.musicexpansion.music.CDTrack;
import fn10.musicexpansion.music.CDTracks;
import fn10.musicexpansion.reg.MusicExpandedItemComponents;
import fn10.musicexpansion.reg.MusicExpandedItems;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

import static fn10.musicexpansion.items.CompactDiscItem.makeDiscStackWithTracks;

public class MusicExpandedCommands {

    public static int giveExampleDiscs(CommandContext<CommandSourceStack> context) {
        try {
            Inventory inventory = context.getSource().getPlayer().getInventory();

            CDTrack song1 = CDTracks.C418_11;
            CDTrack song2 = CDTracks.C418_13;
            CDTrack song3 = CDTracks.C418_CAT;
            //CDTrack song4 = new CDSong("dog");

            ItemStack exampleDisc1 = makeDiscStackWithTracks(song1);
            ItemStack exampleDisc2 = makeDiscStackWithTracks(song2);
            ItemStack exampleDisc3 = makeDiscStackWithTracks(song3);
            exampleDisc3.set(MusicExpandedItemComponents.CD_WRITEABLE, true);

            inventory.add(exampleDisc1);
            inventory.add(exampleDisc2);
            inventory.add(exampleDisc3);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
