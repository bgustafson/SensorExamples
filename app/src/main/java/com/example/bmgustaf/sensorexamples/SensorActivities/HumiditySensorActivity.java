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

public class HumiditySensorActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mHumiditySensor;

    private TextView humidityView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humidity_sensor);

        mSensorManager = (SensorManager) getSystemService(Service.SENSOR_SERVICE);
        mHumiditySensor = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        mSensorManager.registerListener(this, mHumiditySensor, SensorManager.SENSOR_DELAY_UI);

        humidityView = (TextView) findViewById(R.id.humidityTxt);
    }


    @Override
    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(this);
    }


    @Override
    protected void onResume(){
        super.onResume();
        mSensorManager.registerListener(this, mHumiditySensor, SensorManager.SENSOR_DELAY_NORMAL);
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] values = sensorEvent.values;
        humidityView.setText("" + values[0]);
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

}
