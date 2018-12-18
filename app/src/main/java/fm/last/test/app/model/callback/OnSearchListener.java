package fm.last.test.app.model.callback;

import fm.last.test.app.model.enums.SearchType;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public interface OnSearchListener {

    void onSearch(String queryName, int pageNumber, SearchType type);
}
