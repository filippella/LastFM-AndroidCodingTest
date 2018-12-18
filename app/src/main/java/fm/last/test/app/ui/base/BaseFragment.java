package fm.last.test.app.ui.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public abstract class BaseFragment extends Fragment {

    private View mFragmentView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mFragmentView == null) {
            mFragmentView = inflater.inflate(getContentView(), container, false);
            bindView(mFragmentView);
        }
        return mFragmentView;
    }

    @CallSuper
    protected void bindView(View view) {}

    protected void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        if (mFragmentView != null) {
            ViewGroup parent = (ViewGroup) mFragmentView.getParent();
            parent.removeAllViews();
        }
        super.onDestroyView();
    }

    protected abstract int getContentView();
}
