package fm.last.test.app.model.pojo.album;

import java.util.Arrays;

import fm.last.test.app.model.pojo.common.Image;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public class Album {

    private String mbid;
    private String name;
    private String streamable;
    private Image[] image;
    private String artist;
    private String url;


    public String getMbid() {
        return mbid;
    }

    public String getName() {
        return name;
    }

    public String getStreamable() {
        return streamable;
    }

    public Image[] getImage() {
        return image;
    }

    public String getArtist() {
        return artist;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Album{" +
                "mbid='" + mbid + '\'' +
                ", name='" + name + '\'' +
                ", streamable='" + streamable + '\'' +
                ", image=" + Arrays.toString(image) +
                ", artist='" + artist + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
