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

public class LightSensorActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mLightSensor;

    private TextView lightView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor);

        mSensorManager = (SensorManager) getSystemService(Service.SENSOR_SERVICE);
        mLightSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mSensorManager.registerListener(this, mLightSensor, SensorManager.SENSOR_DELAY_UI);

        lightView = (TextView) findViewById(R.id.lxTxt);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] values = sensorEvent.values;
        lightView.setText("" + values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
