package fm.last.test.app.model.pojo.artist;

import com.google.gson.annotations.SerializedName;

import fm.last.test.app.model.pojo.common.Attr;
import fm.last.test.app.model.pojo.common.OpenSearchQuery;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public class Results {

    private Artistmatches artistmatches;
    @SerializedName("opensearch:Query") private OpenSearchQuery openSearchQuery;
    @SerializedName("opensearch:totalResults") private int totalResults;
    @SerializedName("opensearch:startIndex") private int startIndex;
    @SerializedName("opensearch:itemsPerPage") private int itemsPerPage;
    @SerializedName("@attr") private Attr attr;

    public Artistmatches getArtistmatches() {
        return artistmatches;
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
                "artistmatches=" + artistmatches +
                ", openSearchQuery=" + openSearchQuery +
                ", totalResults=" + totalResults +
                ", startIndex=" + startIndex +
                ", itemsPerPage=" + itemsPerPage +
                ", attr=" + attr +
                '}';
    }
}
