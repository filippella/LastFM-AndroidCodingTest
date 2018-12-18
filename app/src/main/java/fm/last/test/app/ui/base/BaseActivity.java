package fm.last.test.app.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        onActivityCreated(getIntent(), savedInstanceState);
    }

    @CallSuper protected void onActivityCreated(Intent intent, Bundle savedInstanceState) {}

    protected abstract int getContentView();
}
