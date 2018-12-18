package fm.last.test.app.model.pojo.artist;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public class ArtistResponse {

    private Results results;

    public Results getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "ArtistResponse{" +
                "results=" + results +
                '}';
    }
}
