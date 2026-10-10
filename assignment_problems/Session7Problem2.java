import java.util.Arrays;

public class Session7Problem2 {
    static class Playlist {
        private final String[] songs;
        private int songCount;

        Playlist(int capacity) {
            if (capacity < 0) {
                throw new IllegalArgumentException("Capacity cannot be negative");
            }
            songs = new String[capacity];
        }

        boolean addSong(String title) {
            if (title == null || songCount == songs.length) {
                return false;
            }
            songs[songCount++] = title;
            return true;
        }

        String[] getSongs() {
            return Arrays.copyOf(songs, songCount);
        }

        int getSongCount() {
            return songCount;
        }
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist(10);
        playlist.addSong("Song A");
        playlist.addSong("Song B");
        String[] copy = playlist.getSongs();
        copy[0] = "Hacked";
        System.out.println(Arrays.toString(playlist.getSongs()));
        System.out.println(playlist.getSongCount());
    }
}