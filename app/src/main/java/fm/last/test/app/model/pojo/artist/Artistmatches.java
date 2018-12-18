package fm.last.test.app.model.pojo.artist;

import java.util.Arrays;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public class Artistmatches {

    private Artist[] artist;

    public Artist[] getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "Artistmatches{" +
                "artist=" + Arrays.toString(artist) +
                '}';
    }
}
