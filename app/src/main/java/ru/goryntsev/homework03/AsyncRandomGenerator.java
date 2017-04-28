package ru.goryntsev.homework03;

import android.os.AsyncTask;

/**
 * Created by ugoryntsev on 28.04.2017.
 */

public class AsyncRandomGenerator extends AsyncTask<Long, Integer, Integer> {
    private int currentValue;
    private final RandomPresenter presenter;

    public AsyncRandomGenerator(RandomPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected Integer doInBackground(Long... params) {
        while (!isCancelled()) {
            currentValue = (int) (Math.random() * 65_535);
            publishProgress(currentValue);

            try {
                Thread.sleep(params[0]);
            } catch (InterruptedException e) {
                //do nothing
            }
        }
        return currentValue;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        presenter.newValue(values[0]);
    }
}
