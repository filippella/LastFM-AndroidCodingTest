package fm.last.test.app.model.pojo.artist;

import java.util.Arrays;

import fm.last.test.app.model.pojo.common.Image;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public class Artist {

    private String listeners;
    private String mbid;
    private String name;
    private Image[] image;
    private String streamable;
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

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "listeners='" + listeners + '\'' +
                ", mbid='" + mbid + '\'' +
                ", name='" + name + '\'' +
                ", image=" + Arrays.toString(image) +
                ", streamable='" + streamable + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
