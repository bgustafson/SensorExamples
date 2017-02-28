package com.example.bmgustaf.sensorexamples;

import android.content.Intent;
import android.hardware.Sensor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.bmgustaf.sensorexamples.SensorActivities.*;


public class SensorSelector extends AppCompatActivity {

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_selector);

        final SensorListAdapter mSensorListAdapter = new SensorListAdapter(this);

        listView = (ListView) findViewById(R.id.sensor_list);
        listView.setAdapter(mSensorListAdapter);
        //TODO: Need to create an activity for each sensor in the list and then run it

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //https://developer.android.com/guide/topics/sensors/sensors_overview.html
                Sensor sensor = mSensorListAdapter.getItem(position);
                Intent intent = null;

                switch(sensor.getType()) {
                    case Sensor.TYPE_ACCELEROMETER:
                        intent = new Intent(getBaseContext(), AccelerometerActivity.class);
                        intent.putExtra("SENSOR_TYPE", sensor.getType());
                        startActivity(intent);
                        break;
                    case Sensor.TYPE_AMBIENT_TEMPERATURE:
                        intent = new Intent(getBaseContext(), TemperatureActivity.class);
                        intent.putExtra("SENSOR_TYPE", sensor.getType());
                        startActivity(intent);
                        break;
                    case Sensor.TYPE_GRAVITY:


                        break;
                    case Sensor.TYPE_GYROSCOPE:


                        break;
                    case Sensor.TYPE_LIGHT:
                        intent = new Intent(getBaseContext(), LightSensorActivity.class);
                        intent.putExtra("SENSOR_TYPE", sensor.getType());
                        startActivity(intent);
                        break;
                    case Sensor.TYPE_LINEAR_ACCELERATION:


                        break;
                    case Sensor.TYPE_MAGNETIC_FIELD:


                        break;
                    case Sensor.TYPE_ORIENTATION:


                        break;
                    case Sensor.TYPE_PRESSURE:
                        intent = new Intent(getBaseContext(), PressureSensorActivity.class);
                        intent.putExtra("SENSOR_TYPE", sensor.getType());
                        startActivity(intent);
                        break;
                    case Sensor.TYPE_PROXIMITY:
                        intent = new Intent(getBaseContext(), ProximitySensorActivity.class);
                        intent.putExtra("SENSOR_TYPE", sensor.getType());
                        startActivity(intent);
                        break;
                    case Sensor.TYPE_RELATIVE_HUMIDITY:
                        intent = new Intent(getBaseContext(), HumiditySensorActivity.class);
                        intent.putExtra("SENSOR_TYPE", sensor.getType());
                        startActivity(intent);
                        break;
                    case Sensor.TYPE_ROTATION_VECTOR:


                        break;
                    case Sensor.TYPE_TEMPERATURE:
                        intent = new Intent(getBaseContext(), TemperatureActivity.class);
                        intent.putExtra("SENSOR_TYPE", sensor.getType());
                        startActivity(intent);
                        break;
                }

                Toast.makeText(view.getContext(), sensor.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
