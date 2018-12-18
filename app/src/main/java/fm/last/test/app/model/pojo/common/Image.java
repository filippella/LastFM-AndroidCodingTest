package fm.last.test.app.model.pojo.common;

import com.google.gson.annotations.SerializedName;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public class Image {

    @SerializedName("#text") private String text;
    private String size;

    public String getText() {
        return text;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Image{" +
                "text='" + text + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
