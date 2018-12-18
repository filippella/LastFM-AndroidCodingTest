package fm.last.test.app.model.pojo.track;

import com.google.gson.annotations.SerializedName;

import fm.last.test.app.model.pojo.common.Attr;
import fm.last.test.app.model.pojo.common.OpenSearchQuery;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public class Results {

    private Trackmatches trackmatches;
    @SerializedName("opensearch:Query") private OpenSearchQuery openSearchQuery;
    @SerializedName("opensearch:totalResults") private int totalResults;
    @SerializedName("opensearch:startIndex") private int startIndex;
    @SerializedName("opensearch:itemsPerPage") private int itemsPerPage;
    @SerializedName("@attr") private Attr attr;

    public Trackmatches getTrackmatches() {
        return trackmatches;
    }

    public OpenSearchQuery getOpenSearchQuery() {
        return openSearchQuery;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public Attr getAttr() {
        return attr;
    }

    @Override
    public String toString() {
        return "Results{" +
                "trackmatches=" + trackmatches +
                ", openSearchQuery=" + openSearchQuery +
                ", totalResults=" + totalResults +
                ", startIndex=" + startIndex +
                ", itemsPerPage=" + itemsPerPage +
                ", attr=" + attr +
                '}';
    }
}
