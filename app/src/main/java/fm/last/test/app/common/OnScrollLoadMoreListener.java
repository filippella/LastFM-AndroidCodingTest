package fm.last.test.app.common;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public abstract class OnScrollLoadMoreListener extends RecyclerView.OnScrollListener {

    private boolean mLoading = false;
    private boolean mCanLoadMore = true;
    private static final int VISIBLE_ITEM_THRESHOLD = 10;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (mLinearLayoutManager == null) {
            mLinearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        }
        int totalItemCount = mLinearLayoutManager.getItemCount();
        int lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
        if (mCanLoadMore && !mLoading && totalItemCount <= (lastVisibleItem + VISIBLE_ITEM_THRESHOLD)) {
            onLoadMore(recyclerView, this);
            mLoading = true;
        }
    }
    public void setLoading(boolean loading) {
        mLoading = loading;
    }
    public void canLoadMore(boolean canLoadMore) {
        mCanLoadMore = canLoadMore;
    }
    protected abstract void onLoadMore(RecyclerView recyclerView, OnScrollLoadMoreListener listener);
}
