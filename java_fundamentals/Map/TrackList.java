import java.util.HashMap;
import java.util.Set;

public class TrackList {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Changes", "I see no changes wake, up in the morning and I ask myself");
        trackList.put("Fly away", "I done fought through the battle, and I made it this far, I got a few more feet but its still the longest yard");
        trackList.put("Banana Pancakes", "Halaka ukulele mama made a baby");
        trackList.put("Better Together", "It's always better when we're together");
        // get the keys by using the keySet method

        Set<String> tracks = trackList.keySet();
        for(String track : tracks) {
            System.out.println(track + ": "+ trackList.get(track));
            // System.out.println(trackList.get(track));    
        }
        String Lyrics = trackList.get("Changes");
        System.out.println("Lyrics for selected song: " + Lyrics);
    }
}


