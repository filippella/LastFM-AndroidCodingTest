package fm.last.test.app.api;

import fm.last.test.app.model.pojo.album.AlbumResponse;
import fm.last.test.app.model.pojo.artist.ArtistResponse;
import fm.last.test.app.model.pojo.track.TrackResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public interface LastFmApiService {

    String API_KEY = "990de67c6ab19c2d4bacb2222fe8bc3c";;
    String BASE_URL = "http://ws.audioscrobbler.com";

    @GET("/2.0/?method=album.search&api_key=" + API_KEY + "&format=json")
    Single<AlbumResponse> searchAlbum(@Query("album") String album, @Query("page") int page);

    @GET("/2.0/?method=artist.search&api_key=" + API_KEY + "&format=json")
    Single<ArtistResponse> searchArtist(@Query("artist") String artist, @Query("page") int page);

    @GET("/2.0/?method=track.search&api_key=" + API_KEY + "&format=json")
    Single<TrackResponse> searchTrack(@Query("track") String track, @Query("page") int page);
}
