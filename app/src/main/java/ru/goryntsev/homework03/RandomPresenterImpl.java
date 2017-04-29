package ru.goryntsev.homework03;

import android.os.AsyncTask;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import static android.os.AsyncTask.Status.RUNNING;

/**
 * Created by ugoryntsev on 28.04.2017.
 */

@InjectViewState
public class RandomPresenterImpl extends MvpPresenter<RandomView> implements RandomPresenter {

    private AsyncRandomGenerator generator;

    @Override
    public void start(final long delay) {
        if (generator != null)
            generator.cancel(true);

        generator = new AsyncRandomGenerator(this);
        generator.execute(delay);
    }

    @Override
    public void stop() {
        if (generator != null && generator.getStatus().equals(RUNNING)) {
            generator.cancel(true);
            generator = null;
        }
    }

    @Override
    public void newValue(int value) {
        getViewState().newValue(value);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        generator.cancel(true);
    }
}
