package fm.last.test.app.common;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public class VerticalListMarginDecorator extends RecyclerView.ItemDecoration {

    private final int mSize;

    public VerticalListMarginDecorator(int spaceSize) {
        mSize = spaceSize;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);

        if (position == 0) {
            outRect.top = mSize;
        } else {
            outRect.top = 0;
        }
        outRect.left = mSize;
        outRect.right = mSize;
        outRect.bottom = mSize;
    }
}
