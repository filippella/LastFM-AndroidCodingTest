package fm.last.test.app.presenter;

import com.google.gson.Gson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.concurrent.Callable;

import fm.last.test.app.TestMockDataProvider;
import fm.last.test.app.api.LastFmApiService;
import fm.last.test.app.model.enums.SearchType;
import fm.last.test.app.model.pojo.album.AlbumResponse;
import fm.last.test.app.model.pojo.artist.ArtistResponse;
import fm.last.test.app.model.pojo.track.TrackResponse;
import fm.last.test.app.model.vo.SearchItem;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
@RunWith(MockitoJUnitRunner.class)
public class SearchPresenterTest {

    private static final String TEST_NAME = "name";
    private static final int TEST_PAGE_NUMBER = 1;
    private static final String TEST_ERROR = "test-error";

    private final Gson gson = new Gson();

    @Mock private SearchPresenter.ViewContract view;
    @Mock private LastFmApiService apiService;
    @Mock private SingleObserver<AlbumResponse> albumObserver;
    @Mock private SingleObserver<ArtistResponse> artistObserver;
    @Mock private SingleObserver<TrackResponse> trackObserver;

    private SearchPresenter presenter;

    @Before
    public void setUp() throws Exception {

        RxAndroidPlugins.reset();
        RxAndroidPlugins.setMainThreadSchedulerHandler(new Function<Scheduler, Scheduler>() {
            @Override
            public Scheduler apply(Scheduler scheduler) throws Exception {
                return Schedulers.trampoline();
            }
        });
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(new Function<Callable<Scheduler>, Scheduler>() {
            @Override
            public Scheduler apply(Callable<Scheduler> schedulerCallable) throws Exception {
                return Schedulers.trampoline();
            }
        });

        //Set Schedulers to trampoline
        RxJavaPlugins.reset();
        RxJavaPlugins.setComputationSchedulerHandler(new Function<Scheduler, Scheduler>() {
            @Override
            public Scheduler apply(Scheduler scheduler) throws Exception {
                return Schedulers.trampoline();
            }
        });
        RxJavaPlugins.setIoSchedulerHandler(new Function<Scheduler, Scheduler>() {
            @Override
            public Scheduler apply(Scheduler scheduler) throws Exception {
                return Schedulers.trampoline();
            }
        });
        RxJavaPlugins.setNewThreadSchedulerHandler(new Function<Scheduler, Scheduler>() {
            @Override
            public Scheduler apply(Scheduler scheduler) throws Exception {
                return Schedulers.trampoline();
            }
        });
        this.presenter = new SearchPresenter(view, apiService);
    }

    @Test
    public void searchAlbum_onSuccess() throws Exception {

        AlbumResponse response = gson.fromJson(TestMockDataProvider.getMockAlbumResponse(), AlbumResponse.class);

        Single<AlbumResponse> single = Single.just(response);
        single.subscribe(albumObserver);
        when(this.apiService.searchAlbum(TEST_NAME, TEST_PAGE_NUMBER)).thenReturn(single);

        this.presenter.searchAlbum(TEST_NAME, TEST_PAGE_NUMBER);

        verify(this.view, times(1)).onLoading(SearchType.ALBUM);
        verify(this.view, times(1)).onLoadItems(eq(SearchType.ALBUM), any(SearchItem[].class), eq(true));
    }

    @Test
    public void searchAlbum_onError() throws Exception {
        Single<AlbumResponse> single = Single.error(new Throwable(TEST_ERROR));
        single.subscribe(albumObserver);
        when(this.apiService.searchAlbum(TEST_NAME, TEST_PAGE_NUMBER)).thenReturn(single);

        this.presenter.searchAlbum(TEST_NAME, TEST_PAGE_NUMBER);

        verify(this.view, times(1)).onLoading(SearchType.ALBUM);
        verify(this.view, times(1)).onError(eq(SearchType.ALBUM), eq(TEST_ERROR));
    }

    @Test
    public void searchArtist_onSuccess() throws Exception {
        ArtistResponse response = gson.fromJson(TestMockDataProvider.getMockArtistResponse(), ArtistResponse.class);

        Single<ArtistResponse> single = Single.just(response);
        single.subscribe(artistObserver);
        when(this.apiService.searchArtist(TEST_NAME, TEST_PAGE_NUMBER)).thenReturn(single);

        this.presenter.searchArtist(TEST_NAME, TEST_PAGE_NUMBER);

        verify(this.view, times(1)).onLoading(SearchType.ARTIST);
        verify(this.view, times(1)).onLoadItems(eq(SearchType.ARTIST), any(SearchItem[].class), eq(true));
    }

    @Test
    public void searchArtist_onError() throws Exception {
        Single<ArtistResponse> single = Single.error(new Throwable(TEST_ERROR));
        single.subscribe(artistObserver);
        when(this.apiService.searchArtist(TEST_NAME, TEST_PAGE_NUMBER)).thenReturn(single);

        this.presenter.searchArtist(TEST_NAME, TEST_PAGE_NUMBER);

        verify(this.view, times(1)).onLoading(SearchType.ARTIST);
        verify(this.view, times(1)).onError(eq(SearchType.ARTIST), eq(TEST_ERROR));
    }

    @Test
    public void searchTrack_onSuccess() throws Exception {
        TrackResponse response = gson.fromJson(TestMockDataProvider.getMockTrackResponse(), TrackResponse.class);

        Single<TrackResponse> single = Single.just(response);
        single.subscribe(trackObserver);
        when(this.apiService.searchTrack(TEST_NAME, TEST_PAGE_NUMBER)).thenReturn(single);

        this.presenter.searchTrack(TEST_NAME, TEST_PAGE_NUMBER);

        verify(this.view, times(1)).onLoading(SearchType.TRACK);
        verify(this.view, times(1)).onLoadItems(eq(SearchType.TRACK), any(SearchItem[].class), eq(true));
    }

    @Test
    public void searchTrack_onError() throws Exception {
        Single<TrackResponse> single = Single.error(new Throwable(TEST_ERROR));
        single.subscribe(trackObserver);
        when(this.apiService.searchTrack(TEST_NAME, TEST_PAGE_NUMBER)).thenReturn(single);

        this.presenter.searchTrack(TEST_NAME, TEST_PAGE_NUMBER);

        verify(this.view, times(1)).onLoading(SearchType.TRACK);
        verify(this.view, times(1)).onError(eq(SearchType.TRACK), eq(TEST_ERROR));
    }

    @After
    public void tearDown() throws Exception {
        this.presenter.onDestroy();
        this.presenter = null;
        RxAndroidPlugins.reset();
        RxJavaPlugins.reset();
    }
}