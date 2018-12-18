package fm.last.test.app.model.pojo.common;

import com.google.gson.annotations.SerializedName;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public class Attr {

    @SerializedName("for") private String attrFor;

    public String getAttrFor() {
        return attrFor;
    }

    @Override
    public String toString() {
        return "Attr{" +
                "attrFor='" + attrFor + '\'' +
                '}';
    }
}
