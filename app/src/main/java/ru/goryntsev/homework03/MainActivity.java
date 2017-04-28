package ru.goryntsev.homework03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements RandomView{

    @InjectPresenter
    RandomPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    long delay = Long.valueOf(((EditText)findViewById(R.id.delayEdit)).getText().toString());
                    presenter.start(delay);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Нужно ввести задержку", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.stop();
            }
        });
    }

    @Override
    public void newValue(int value) {
        TextView randomNumber = (TextView) findViewById(R.id.randomNumber);
        randomNumber.setText(String.valueOf(value));
    }
}
