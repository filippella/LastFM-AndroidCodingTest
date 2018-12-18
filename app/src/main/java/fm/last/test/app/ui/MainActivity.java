package fm.last.test.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import java.util.LinkedHashMap;
import java.util.Map;

import fm.last.test.app.R;
import fm.last.test.app.api.LastFmApiService;
import fm.last.test.app.ui.base.BaseActivity;
import fm.last.test.app.model.callback.OnSearchListener;
import fm.last.test.app.model.callback.OnSearchResultListener;
import fm.last.test.app.model.vo.SearchItem;
import fm.last.test.app.model.enums.SearchType;
import fm.last.test.app.presenter.SearchPresenter;
import fm.last.test.app.utilities.KeyboardUtils;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public class MainActivity extends BaseActivity implements OnSearchListener, SearchPresenter.ViewContract {

    private final Map<Integer, Fragment> mFragmentMap = new LinkedHashMap<>();

    private BottomNavigationView mNavigationView;
    private SearchPresenter searchPresenter;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onActivityCreated(Intent intent, Bundle savedInstanceState) {
        super.onActivityCreated(intent, savedInstanceState);

        mNavigationView = findViewById(R.id.bottom_navs);
        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                Fragment fragment = mFragmentMap.get(itemId);
                if (fragment == null) {
                    switch (itemId) {
                        case R.id.navigation_artist:
                            fragment = SearchFragment.newInstance(getString(R.string.text_hint_artist_search), SearchType.ARTIST);
                            break;
                        default:
                            fragment = SearchFragment.newInstance(getString(R.string.text_hint_track_search), SearchType.TRACK);
                            break;
                    }
                    mFragmentMap.put(itemId, fragment);
                }
                replaceFragment(fragment);
                return true;
            }
        });

        Fragment albumFragment = SearchFragment.newInstance(getString(R.string.text_hint_album_search), SearchType.ALBUM);
        mFragmentMap.put(R.id.navigation_album, albumFragment);
        replaceFragment(albumFragment);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LastFmApiService.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.searchPresenter = new SearchPresenter(this, retrofit.create(LastFmApiService.class));
    }

    private void replaceFragment(Fragment fragment) {
        KeyboardUtils.hideKeyboard(getApplicationContext(), mNavigationView);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment, fragment.getTag())
                .commit();
    }

    @Override
    public void onSearch(String queryName, int pageNumber, SearchType type) {
        switch (type) {
            case ALBUM:
                searchPresenter.searchAlbum(queryName, pageNumber);
                break;
            case ARTIST:
                searchPresenter.searchArtist(queryName, pageNumber);
                break;
            case TRACK:
                searchPresenter.searchTrack(queryName, pageNumber);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        this.searchPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onError(SearchType type, String message) {
        OnSearchResultListener listener = (OnSearchResultListener) mFragmentMap.get(type.getId());
        if (listener != null) {
            listener.onError(message);
        }
    }

    @Override
    public void onLoadItems(SearchType type, SearchItem[] response, boolean canLoadMore) {
        OnSearchResultListener listener = (OnSearchResultListener) mFragmentMap.get(type.getId());
        if (listener != null) {
            listener.onLoadItems(response, canLoadMore);
        }
    }

    @Override
    public void onLoading(SearchType type) {
        OnSearchResultListener listener = (OnSearchResultListener) mFragmentMap.get(type.getId());
        if (listener != null) {
            listener.onLoading();
        }
    }
}
