package fm.last.test.app.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import fm.last.test.app.R;
import fm.last.test.app.ui.base.BaseFragment;
import fm.last.test.app.common.OnScrollLoadMoreListener;
import fm.last.test.app.model.callback.OnSearchListener;
import fm.last.test.app.model.callback.OnSearchResultListener;
import fm.last.test.app.model.vo.SearchItem;
import fm.last.test.app.model.enums.SearchType;
import fm.last.test.app.common.VerticalListMarginDecorator;
import fm.last.test.app.utilities.KeyboardUtils;

/**
 * @author Filippo
 * @version 1.0.0
 * @since Sun, 16/12/2018 at 21:47.
 */
public class SearchFragment extends BaseFragment implements OnSearchResultListener {

    private final static String KEY_QUERY_HINT = "fm.last.test.app.ui.key.QUERY_HINT";
    private final static String KEY_SEARCH_ID = "fm.last.test.app.ui.key.SEARCH_ID";

    private SearchView mSearchView;
    private ProgressBar mProgressBar;
    private RecyclerView mSearchItems;
    private SearchListAdapter mAdapter;
    private int mId;
    private String mQuery;
    private int mPage;
    private boolean mShouldClear;

    public static SearchFragment newInstance(String queryHint, SearchType type) {

        Bundle args = new Bundle();
        args.putString(KEY_QUERY_HINT, queryHint);
        args.putInt(KEY_SEARCH_ID, type.getId());
        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_search;
    }

    @Override
    protected void bindView(View view) {
        super.bindView(view);

        Bundle arguments = getArguments();

        mSearchView = view.findViewById(R.id.searchView);
        mSearchView.setIconified(false);
        mSearchView.setIconifiedByDefault(false);

        if (arguments != null) {
            mSearchView.setQueryHint(arguments.getString(KEY_QUERY_HINT));
            mId = arguments.getInt(KEY_SEARCH_ID);
            KeyboardUtils.hideKeyboard(getContext(), mSearchView);
        }

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                doSearch();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        mProgressBar = view.findViewById(R.id.progressBar);

        Button searchButton = view.findViewById(R.id.button_search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSearch();
            }
        });

        mSearchItems = view.findViewById(R.id.recyclerView);
        mSearchItems.setHasFixedSize(true);
        mSearchItems.setLayoutManager(new LinearLayoutManager(getContext()));
        mSearchItems.addItemDecoration(new VerticalListMarginDecorator(getResources().getDimensionPixelSize(R.dimen.item_margin_gap_size)));
        mSearchItems.setAdapter(mAdapter = new SearchListAdapter(getLayoutInflater()));
    }

    private void doSearch() {
        mQuery = mSearchView.getQuery().toString();
        KeyboardUtils.hideKeyboard(getContext(), mSearchView);
        mShouldClear = true;
        loadItems(mPage = 1);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mSearchItems.addOnScrollListener(loadMoreListener);
    }

    private void loadItems(int page) {
        OnSearchListener listener = (OnSearchListener) getActivity();
        if (listener != null) {
            listener.onSearch(mQuery, page, SearchType.from(mId));
        }
    }

    @Override
    public void onLoading() {
        loadMoreListener.setLoading(true);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoadItems(SearchItem[] items, boolean canLoadMore) {
        if (mShouldClear) {
            mAdapter.clear();
            mShouldClear = false;
        }
        mAdapter.addItems(items);
        loadMoreListener.canLoadMore(canLoadMore);
        loadMoreListener.setLoading(false);
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(String message) {
        showToast(message);
        mProgressBar.setVisibility(View.GONE);
        loadMoreListener.canLoadMore(false);
        loadMoreListener.setLoading(false);
    }

    @Override
    public void onDestroy() {
        mSearchItems.removeOnScrollListener(loadMoreListener);
        super.onDestroy();
    }

    private final OnScrollLoadMoreListener loadMoreListener = new OnScrollLoadMoreListener() {

        @Override
        protected void onLoadMore(RecyclerView recyclerView, OnScrollLoadMoreListener listener) {
            listener.setLoading(true);
            loadItems(++mPage);
        }
    };
}
