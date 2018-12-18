package fm.last.test.app.presenter;

import android.support.v4.util.Pair;

import java.lang.ref.WeakReference;

import fm.last.test.app.api.LastFmApiService;
import fm.last.test.app.common.BaseRx;
import fm.last.test.app.model.pojo.artist.Artist;
import fm.last.test.app.model.pojo.artist.ArtistResponse;
import fm.last.test.app.model.pojo.track.Track;
import fm.last.test.app.model.pojo.track.TrackResponse;
import fm.last.test.app.model.vo.SearchItem;
import fm.last.test.app.model.enums.SearchType;
import fm.last.test.app.model.pojo.album.Album;
import fm.last.test.app.model.pojo.album.AlbumResponse;
import fm.last.test.app.model.pojo.album.Results;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public class SearchPresenter extends BaseRx {

    private final WeakReference<ViewContract> viewReference;
    private final WeakReference<LastFmApiService> apiServiceReference;

    public SearchPresenter(ViewContract contract, LastFmApiService apiService) {
        this.viewReference = new WeakReference<>(contract);
        this.apiServiceReference = new WeakReference<>(apiService);
    }

    public void searchAlbum(String query, int pageNumber) {

        ViewContract viewContract = viewReference.get();

        if (viewContract != null) {
            viewContract.onLoading(SearchType.ALBUM);
        }

        Single<Pair<SearchItem[], Boolean>> searchAlbum = this.apiServiceReference.get().searchAlbum(query, pageNumber)
                .map(new Function<AlbumResponse, Pair<SearchItem[], Boolean>>() {

                    @Override
                    public Pair<SearchItem[], Boolean> apply(AlbumResponse albumResponse) throws Exception {

                        Results results = albumResponse.getResults();
                        Album[] albums = results.getAlbummatches().getAlbum();
                        SearchItem[] items = new SearchItem[albums.length];

                        for (int i = 0, length = albums.length; i < length; i++) {
                            Album album = albums[i];
                            items[i] = new SearchItem(album.getName(), album.getArtist(), album.getImage()[3].getText(), album.getUrl());
                        }
                        boolean canLoadMore = results.getStartIndex() < results.getTotalResults();

                        return new Pair<>(items, canLoadMore);
                    }
                });
        subscribe(searchAlbum, new DisposableSingleObserver<Pair<SearchItem[], Boolean>>() {
            @Override
            public void onSuccess(Pair<SearchItem[], Boolean> pair) {
                ViewContract viewContract = viewReference.get();
                if (viewContract != null) {
                    viewContract.onLoadItems(SearchType.ALBUM, pair.first, pair.second);
                }
            }

            @Override
            public void onError(Throwable e) {
                ViewContract viewContract = viewReference.get();
                if (viewContract != null) {
                    viewContract.onError(SearchType.ALBUM, e.getMessage());
                }
            }
        });
    }

    public void searchArtist(String query, int pageNumber) {

        ViewContract viewContract = viewReference.get();

        if (viewContract != null) {
            viewContract.onLoading(SearchType.ARTIST);
        }

        Single<Pair<SearchItem[], Boolean>> searchArtist = this.apiServiceReference.get().searchArtist(query, pageNumber)
                .map(new Function<ArtistResponse, Pair<SearchItem[], Boolean>>() {
                    @Override
                    public Pair<SearchItem[], Boolean> apply(ArtistResponse artistResponse) throws Exception {

                        fm.last.test.app.model.pojo.artist.Results results = artistResponse.getResults();

                        Artist[] artists = results.getArtistmatches().getArtist();
                        SearchItem[] items = new SearchItem[artists.length];

                        for (int i = 0, length = artists.length; i < length; i++) {
                            Artist artist = artists[i];
                            items[i] = new SearchItem(artist.getName(), "No-description", artist.getImage()[3].getText(), artist.getUrl());
                        }
                        boolean canLoadMore = results.getStartIndex() < results.getTotalResults();

                        return new Pair<>(items, canLoadMore);
                    }
                });

        subscribe(searchArtist, new DisposableSingleObserver<Pair<SearchItem[], Boolean>>() {
            @Override
            public void onSuccess(Pair<SearchItem[], Boolean> pair) {
                ViewContract viewContract = viewReference.get();
                if (viewContract != null) {
                    viewContract.onLoadItems(SearchType.ARTIST, pair.first, pair.second);
                }
            }

            @Override
            public void onError(Throwable e) {
                ViewContract viewContract = viewReference.get();
                if (viewContract != null) {
                    viewContract.onError(SearchType.ARTIST, e.getMessage());
                }
            }
        });
    }

    public void searchTrack(String query, int pageNumber) {

        ViewContract viewContract = viewReference.get();

        if (viewContract != null) {
            viewContract.onLoading(SearchType.TRACK);
        }

        Single<Pair<SearchItem[], Boolean>> searchTrack = this.apiServiceReference.get().searchTrack(query, pageNumber)
                .map(new Function<TrackResponse, Pair<SearchItem[], Boolean>>() {
                    @Override
                    public Pair<SearchItem[], Boolean> apply(TrackResponse trackResponse) throws Exception {

                        fm.last.test.app.model.pojo.track.Results results = trackResponse.getResults();
                        Track[] tracks = results.getTrackmatches().getTrack();
                        SearchItem[] items = new SearchItem[tracks.length];

                        for (int i = 0, length = tracks.length; i < length; i++) {
                            Track track = tracks[i];
                            items[i] = new SearchItem(track.getName(), track.getArtist(), track.getImage()[3].getText(), track.getUrl());

                        }
                        boolean canLoadMore = results.getStartIndex() < results.getTotalResults();

                        return new Pair<>(items, canLoadMore);
                    }
                });

        subscribe(searchTrack, new DisposableSingleObserver<Pair<SearchItem[], Boolean>>() {
            @Override
            public void onSuccess(Pair<SearchItem[], Boolean> pair) {
                ViewContract viewContract = viewReference.get();
                if (viewContract != null) {
                    viewContract.onLoadItems(SearchType.TRACK, pair.first, pair.second);
                }
            }

            @Override
            public void onError(Throwable e) {
                ViewContract viewContract = viewReference.get();
                if (viewContract != null) {
                    viewContract.onError(SearchType.TRACK, e.getMessage());
                }
            }
        });
    }

    public void onDestroy() {
        cleanup();
        this.viewReference.clear();
    }

    public interface ViewContract {

        void onError(SearchType type, String message);

        void onLoadItems(SearchType type, SearchItem[] response, boolean canLoadMore);

        void onLoading(SearchType type);
    }
}
