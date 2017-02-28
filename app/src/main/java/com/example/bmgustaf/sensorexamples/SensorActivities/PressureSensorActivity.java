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

public class PressureSensorActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor pS;

    private TextView pressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure_sensor);


        // Look for barometer sensor
        mSensorManager = (SensorManager) getSystemService(Service.SENSOR_SERVICE);
        pS = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        mSensorManager.registerListener(this, pS, SensorManager.SENSOR_DELAY_UI);

        pressView = (TextView) findViewById(R.id.pressTxt);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] values = sensorEvent.values;
        pressView.setText("" + values[0]);
    }

}
