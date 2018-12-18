package fm.last.test.app.common;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Filippo
 * @version 1.0.0
 * @since 16/12/2018
 */
public class BaseRx {

    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    protected <O> void subscribe(Single<O> single, DisposableSingleObserver<O> observer) {
        mCompositeDisposable.add(single.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer));
    }

    protected void cleanup() {
        mCompositeDisposable.clear();
    }
}
