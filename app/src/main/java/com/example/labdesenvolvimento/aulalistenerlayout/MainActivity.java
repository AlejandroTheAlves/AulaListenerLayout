package com.example.labdesenvolvimento.aulalistenerlayout;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText editValor;
    private SeekBar seekValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = (EditText) findViewById(R.id.editValor);
        seekValor = (SeekBar) findViewById(R.id.seekValor);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().isEmpty()) {
                    Integer valorString = Integer.parseInt(s.toString());
                    seekValor.setProgress(valorString);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        editValor.addTextChangedListener(textWatcher);

        SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Integer valor = seekBar.getProgress();
                editValor.setText(valor.toString());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        seekValor.setOnSeekBarChangeListener(listener);
    }
}
