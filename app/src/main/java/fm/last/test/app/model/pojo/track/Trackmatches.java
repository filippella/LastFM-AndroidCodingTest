package fm.last.test.app.model.pojo.track;

import java.util.Arrays;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public class Trackmatches {

    private Track[] track;

    public Track[] getTrack() {
        return track;
    }

    @Override
    public String toString() {
        return "Trackmatches{" +
                "track=" + Arrays.toString(track) +
                '}';
    }
}
