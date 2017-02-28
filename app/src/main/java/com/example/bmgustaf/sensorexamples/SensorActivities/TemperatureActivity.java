package com.example.bmgustaf.sensorexamples.SensorActivities;

import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.bmgustaf.sensorexamples.R;

public class TemperatureActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mTempSensor;

    private TextView tempView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        mSensorManager = (SensorManager) getSystemService(Service.SENSOR_SERVICE);
        mTempSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        mSensorManager.registerListener(this, mTempSensor, SensorManager.SENSOR_DELAY_UI);

        tempView = (TextView) findViewById(R.id.lxTxt);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] values = sensorEvent.values;
        tempView.setText("" + values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
