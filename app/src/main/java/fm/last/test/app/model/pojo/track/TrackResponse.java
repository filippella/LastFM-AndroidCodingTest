package fm.last.test.app.model.pojo.track;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public class TrackResponse {

    private Results results;

    public Results getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "TrackResponse{" +
                "results=" + results +
                '}';
    }
}
