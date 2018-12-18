package fm.last.test.app.model.vo;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public class SearchItem {

    private final String name;
    private final String description;
    private final String imageURL;
    private final String url;

    public SearchItem(String name, String description, String imageURL, String url) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "SearchItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
