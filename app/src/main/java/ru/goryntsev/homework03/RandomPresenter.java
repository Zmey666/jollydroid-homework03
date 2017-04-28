package ru.goryntsev.homework03;

/**
 * Created by ugoryntsev on 28.04.2017.
 */

public interface RandomPresenter {
    void start(long delay);
    void stop();
    void newValue(int value);
}
