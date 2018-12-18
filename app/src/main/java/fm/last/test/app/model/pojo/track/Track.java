package fm.last.test.app.model.pojo.track;

import java.util.Arrays;

import fm.last.test.app.model.pojo.common.Image;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public class Track {

    private String listeners;
    private String mbid;
    private String name;
    private Image[] image;
    private String streamable;
    private String artist;
    private String url;

    public String getListeners() {
        return listeners;
    }

    public String getMbid() {
        return mbid;
    }

    public String getName() {
        return name;
    }

    public Image[] getImage() {
        return image;
    }

    public String getStreamable() {
        return streamable;
    }

    public String getArtist() {
        return artist;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Track{" +
                "listeners='" + listeners + '\'' +
                ", mbid='" + mbid + '\'' +
                ", name='" + name + '\'' +
                ", image=" + Arrays.toString(image) +
                ", streamable='" + streamable + '\'' +
                ", artist='" + artist + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
