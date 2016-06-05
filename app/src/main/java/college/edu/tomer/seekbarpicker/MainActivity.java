package college.edu.tomer.seekbarpicker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, TextWatcher {
    SeekBar sbRed, sbGreen, sbBlue;
    EditText etRed, etGreen, etBlue;
    TextView tvTotal;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sbRed = (SeekBar) findViewById(R.id.sbRed);
        sbGreen = (SeekBar) findViewById(R.id.sbGreen);
        sbBlue = (SeekBar) findViewById(R.id.sbBlue);
        tvTotal = (TextView) findViewById(R.id.tvTotal);
        sbRed.setOnSeekBarChangeListener(this); //ALT + ENTER
        sbGreen.setOnSeekBarChangeListener(this);
        sbBlue.setOnSeekBarChangeListener(this);

        etBlue = (EditText) findViewById(R.id.etBlue);
        etRed = (EditText) findViewById(R.id.etRed);
        etGreen = (EditText) findViewById(R.id.etGreen);

        etRed.addTextChangedListener(this);
    }

    boolean fromCode = false;

    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int color = Color.rgb(sbRed.getProgress(), sbGreen.getProgress(), sbBlue.getProgress());
        String strColor = Integer.toHexString(color);

        tvTotal.setBackgroundColor(color);
        tvTotal.setText(String.format("#%s", strColor).toUpperCase());

        fromCode = true;
        etRed.setText(String.format("%d", sbRed.getProgress()));
        etGreen.setText(String.format("%d", sbGreen.getProgress()));
        etBlue.setText(String.format("%d", sbBlue.getProgress()));
        fromCode = false;
    }

    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!fromCode) {
            try {
                String etRedValue = etRed.getText().toString();
                int redProgress = Integer.valueOf(etRedValue);
                sbRed.setProgress(redProgress);
            } catch (Exception e) {
                etRed.setError("Numbers only");
            }

            try {
                String etGreenValue = etGreen.getText().toString();
                int greenProgress = Integer.valueOf(etGreenValue);
                sbGreen.setProgress(greenProgress);
            } catch (Exception e) {
                etGreen.setError("Numbers only");
            }

            try {
                String etBlueValue = etBlue.getText().toString();
                int blueProgress = Integer.valueOf(etBlueValue);
                sbBlue.setProgress(blueProgress);
            } catch (Exception e) {
                etBlue.setError("Numbers only");
            }
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
