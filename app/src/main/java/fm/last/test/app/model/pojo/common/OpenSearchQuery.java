package fm.last.test.app.model.pojo.common;

import com.google.gson.annotations.SerializedName;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public class OpenSearchQuery {

    private String searchTerms;
    private String role;
    @SerializedName("#text") private String text;
    private String startPage;

    public String getSearchTerms() {
        return searchTerms;
    }

    public String getRole() {
        return role;
    }

    public String getText() {
        return text;
    }

    public String getStartPage() {
        return startPage;
    }

    @Override
    public String toString() {
        return "OpenSearchQuery{" +
                "searchTerms='" + searchTerms + '\'' +
                ", role='" + role + '\'' +
                ", text='" + text + '\'' +
                ", startPage='" + startPage + '\'' +
                '}';
    }
}
