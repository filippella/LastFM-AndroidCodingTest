package fm.last.test.app.model.pojo.album;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public class AlbumResponse {

    private Results results;

    public Results getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "AlbumResponse{" +
                "results=" + results +
                '}';
    }
}
