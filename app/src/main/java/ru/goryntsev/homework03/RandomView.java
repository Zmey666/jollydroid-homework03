package ru.goryntsev.homework03;

import com.arellomobile.mvp.MvpView;

/**
 * Created by ugoryntsev on 28.04.2017.
 */

public interface RandomView extends MvpView{
    void newValue(int value);
}
