package fm.last.test.app.model.enums;

import fm.last.test.app.R;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public enum SearchType {

    ALBUM(R.id.navigation_album),
    ARTIST(R.id.navigation_artist),
    TRACK(R.id.navigation_track);

    private final int mId;

    SearchType(int id) {
        mId = id;
    }

    public int getId() {
        return mId;
    }

    public static SearchType from(int id) {
        SearchType type = SearchType.ALBUM;
        SearchType[] values = values();
        for (SearchType value : values) {
            if(value.mId == id) {
                type = value;
                break;
            }
        }
        return type;
    }
}
