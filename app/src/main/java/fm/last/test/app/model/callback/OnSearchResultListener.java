package fm.last.test.app.model.callback;

import fm.last.test.app.model.vo.SearchItem;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public interface OnSearchResultListener {

    void onLoading();

    void onLoadItems(SearchItem[] items, boolean canLoadMore);

    void onError(String message);
}
