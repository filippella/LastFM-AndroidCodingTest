package fm.last.test.app.model.pojo.album;

import java.util.Arrays;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public class AlbumMatches {

    private Album[] album;

    public Album[] getAlbum() {
        return album;
    }

    @Override
    public String toString() {
        return "AlbumMatches{" +
                "album=" + Arrays.toString(album) +
                '}';
    }
}
