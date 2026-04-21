package fn10.musicexpansion.music;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CDTracks {

    // get these from the wiki
//    protected static final Map<String, Integer> TRACK_LENGTHS = extendedMap(String.class, Integer.class,
//            "13", getTicksFromMinsAndSeconds(2, 56),
//            "cat", getTicksFromMinsAndSeconds(3, 6),
//            "blocks", getTicksFromMinsAndSeconds(5,45),
//            "chirp", getTicksFromMinsAndSeconds(5,45),
//            "far", getTicksFromMinsAndSeconds(5,45),
//            "mall", getTicksFromMinsAndSeconds(5,45),
//            "mellohi", getTicksFromMinsAndSeconds(5,45),
//            "stal", getTicksFromMinsAndSeconds(5,45),
//            "strad", getTicksFromMinsAndSeconds(5,45),
//            "ward", getTicksFromMinsAndSeconds(5,45),
//            "11", getTicksFromMinsAndSeconds(1, 11),
//            "wait", getTicksFromMinsAndSeconds(5,45),
//
//            "pigstep", getTicksFromMinsAndSeconds(5,45),
//            "otherside", getTicksFromMinsAndSeconds(5,45),
//            "creator", getTicksFromMinsAndSeconds(5,45),
//            "creatoralt", getTicksFromMinsAndSeconds(5,45),
//
//            "5", getTicksFromMinsAndSeconds(5,45),
//
//            "relic", getTicksFromMinsAndSeconds(5,45),
//            "precipice", getTicksFromMinsAndSeconds(5,45),
//            "tears", getTicksFromMinsAndSeconds(5,45),
//            "lavachic", getTicksFromMinsAndSeconds(5,45)
//    );
//
//    public static final CDTrack C418_CAT = new CDTrack(lengthOf("cat"), SoundEvents.MUSIC_DISC_CAT.value(),
//            "song.compactdiscs.c418.cat");
//    public static final CDTrack C418_13 = new CDTrack(lengthOf("13"), SoundEvents.MUSIC_DISC_13.value(),
//            "song.compactdiscs.c418.13");
//    public static final CDTrack C418_11 = new CDTrack(
//            lengthOf("11"),
//            SoundEvents.MUSIC_DISC_11.value(),
//            "song.compactdiscs.c418.11");
//
//    private static final Map<String, CDTrack> TRACK_IDS = Map.of(
//            "cat", C418_CAT,
//            "13", C418_13,
//            "11", C418_11);
    public static final Map<String, CDTrack> tracks = extendedMap(String.class, CDTrack.class,
            "13", new CDTrack(
                    getTicksFromMinsAndSeconds(2, 58),
                    SoundEvents.MUSIC_DISC_13.value(),
                    "song.compactdiscs.c418.13"),
            "cat", new CDTrack(
                    getTicksFromMinsAndSeconds(3, 6),
                    SoundEvents.MUSIC_DISC_CAT.value(),
                    "song.compactdiscs.c418.cat"),
            "blocks",new CDTrack(
                    getTicksFromMinsAndSeconds(5, 45),
                    SoundEvents.MUSIC_DISC_BLOCKS.value(),
                    "song.compactdiscs.c418.blocks"),
            "chirp", new CDTrack(
                    getTicksFromMinsAndSeconds(3, 5),
                    SoundEvents.MUSIC_DISC_CHIRP.value(),
                    "song.compactdiscs.c418.chirp"),

            "far", new CDTrack(
                    getTicksFromMinsAndSeconds(2, 54),
                    SoundEvents.MUSIC_DISC_FAR.value(),
                    "song.compactdiscs.c418.far"),
            "mall", new CDTrack(
                    getTicksFromMinsAndSeconds(3, 17),
                    SoundEvents.MUSIC_DISC_MALL.value(),
                    "song.compactdiscs.c418.mall"),
            "mellohi", new CDTrack(
                    getTicksFromMinsAndSeconds(1, 36),
                    SoundEvents.MUSIC_DISC_MELLOHI.value(),
                    "song.compactdiscs.c418.mellohi"),
            "stal", new CDTrack(
                    getTicksFromMinsAndSeconds(2, 30),
                    SoundEvents.MUSIC_DISC_STAL.value(),
                    "song.compactdiscs.c418.stal"),
            "strad", new CDTrack(
                    getTicksFromMinsAndSeconds(3, 8),
                    SoundEvents.MUSIC_DISC_STRAD.value(),
                    "song.compactdiscs.c418.strad"),
            "ward", new CDTrack(
                    getTicksFromMinsAndSeconds(4, 11),
                    SoundEvents.MUSIC_DISC_WARD.value(),
                    "song.compactdiscs.c418.ward"),
            "11", new CDTrack(
                    getTicksFromMinsAndSeconds(1, 11),
                    SoundEvents.MUSIC_DISC_11.value(),
                    "song.compactdiscs.c418.11"),
            "wait", new CDTrack(
                    getTicksFromMinsAndSeconds(3, 57),
                    SoundEvents.MUSIC_DISC_WAIT.value(),
                    "song.compactdiscs.c418.wait"),

            "pigstep", new CDTrack(
                    getTicksFromMinsAndSeconds(2, 28),
                    SoundEvents.MUSIC_DISC_PIGSTEP.value(),
                    "song.compactdiscs.c418.pigstep"),
            "otherside", new CDTrack(
                    getTicksFromMinsAndSeconds(3, 15),
                    SoundEvents.MUSIC_DISC_OTHERSIDE.value(),
                    "song.compactdiscs.c418.otherside"),
            "creator", new CDTrack(
                    getTicksFromMinsAndSeconds(2, 56),
                    SoundEvents.MUSIC_DISC_CREATOR.value(),
                    "song.compactdiscs.c418.creator"),
            "creatoralt", new CDTrack(
                    getTicksFromMinsAndSeconds(1, 13),
                    SoundEvents.MUSIC_DISC_CREATOR_MUSIC_BOX.value(),
                    "song.compactdiscs.c418.creatoralt"),

            "5", new CDTrack(
                    getTicksFromMinsAndSeconds(2, 58),
                    SoundEvents.MUSIC_DISC_5.value(),
                    "song.compactdiscs.c418.5"),

            "relic", new CDTrack(
                    getTicksFromMinsAndSeconds(3, 39),
                    SoundEvents.MUSIC_DISC_RELIC.value(),
                    "song.compactdiscs.c418.relic"),
            "precipice", new CDTrack(
                    getTicksFromMinsAndSeconds(4, 59),
                    SoundEvents.MUSIC_DISC_PRECIPICE.value(),
                    "song.compactdiscs.c418.precipice"),
            "tears", new CDTrack(
                    getTicksFromMinsAndSeconds(2, 5),
                    SoundEvents.MUSIC_DISC_TEARS.value(),
                    "song.compactdiscs.c418.tears"),
            "lavachic", new CDTrack(
                    getTicksFromMinsAndSeconds(2, 15),
                    SoundEvents.MUSIC_DISC_LAVA_CHICKEN.value(),
                    "song.compactdiscs.c418.lavachic")
    );

    protected static final HashMap<Integer, CDTrack> ACTIVE_CD_TRACKS = new HashMap<>();

    public static CDTrack getCDTrackFromPlayingID(Integer id) {
        return ACTIVE_CD_TRACKS.get(id);
    }

    public static Integer getTicksFromSeconds(Integer seconds) {
        return seconds * 20;
    }

    public static Integer lengthOf(String id) {
        return tracks.get(id).getLength();
    }

    public static Integer getTicksFromMinsAndSeconds(Integer minutes, Integer seconds) {
        return getTicksFromSeconds(seconds) + getTicksFromSeconds(minutes * 60);
    }

    public static Integer createNewCDTrackId() {
        Integer canadite = RandomSource.create().nextInt(0, Integer.MAX_VALUE);
        if (ACTIVE_CD_TRACKS.containsKey(canadite))
            return createNewCDTrackId();
        else
            return canadite;
    }

    public static CDTrack getTrackFromId(String id) {
        return tracks.get(id);
    }

    public static String getIdFromTrack(CDTrack track) {
        for (Entry<String, CDTrack> set : tracks.entrySet()) {
            if (set.getValue().equals(track)) {
                return set.getKey();
            }
        }
        return null;
    }

    public static <K, V> Map<K, V> extendedMap(Class<K> keyClass, Class<V> valueClass, Object... values) {
        if (values.length % 2 != 0) throw new IllegalArgumentException("Values are odd. (" + values.length + ")");
        HashMap<K, V> map = new HashMap<>();
        for (int i = 0; i < values.length; i += 2) {
            K k = (K) values[i];
            V v = (V) values[i + 1];
            map.put(k,v);
        }
        return map;
    }

}
