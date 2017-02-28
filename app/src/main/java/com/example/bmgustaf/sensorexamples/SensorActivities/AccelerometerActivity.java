package com.example.bmgustaf.sensorexamples.SensorActivities;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.example.bmgustaf.sensorexamples.R;

import java.util.ArrayList;
import java.util.Random;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    //Sensor Position
    private long lastUpdate = 0;
    private float last_x, last_y, last_z;
    private static final int SHAKE_THRESHOLD = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
    }


    @Override
    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(this);
    }


    @Override
    protected void onResume(){
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        Sensor activeSensor = sensorEvent.sensor;
        if(activeSensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            //Only do the update if enough time has passed
            long curTime = System.currentTimeMillis();

            if ((curTime - lastUpdate) > 100) {
                long diffTime = (curTime - lastUpdate);
                lastUpdate = curTime;


                float x = sensorEvent.values[0];
                float y = sensorEvent.values[1];
                float z = sensorEvent.values[2];

                float speed = Math.abs(x + y + z - last_x - last_y - last_z) / diffTime * 1000;


                if (speed > SHAKE_THRESHOLD) {
                    getRandomNumber();
                }

                last_x = x;
                last_y = y;
                last_z = z;

            }
        }
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


    private void getRandomNumber() {
        ArrayList numbersGenerated = new ArrayList();

        for (int i = 0; i < 6; i++) {
            Random randNumber = new Random();
            int iNumber = randNumber.nextInt(48) + 1;

            if(!numbersGenerated.contains(iNumber)) {
                numbersGenerated.add(iNumber);
            } else {
                i--;
            }
        }

        TextView text = (TextView)findViewById(R.id.number_1);
        text.setText(""+numbersGenerated.get(0));

        text = (TextView)findViewById(R.id.number_2);
        text.setText(""+numbersGenerated.get(1));

        text = (TextView)findViewById(R.id.number_3);
        text.setText(""+numbersGenerated.get(2));

        text = (TextView)findViewById(R.id.number_4);
        text.setText(""+numbersGenerated.get(3));

        text = (TextView)findViewById(R.id.number_5);
        text.setText(""+numbersGenerated.get(4));

        text = (TextView)findViewById(R.id.number_6);
        text.setText(""+numbersGenerated.get(5));

        FrameLayout ball1 = (FrameLayout) findViewById(R.id.ball_1);
        ball1.setVisibility(View.INVISIBLE);

        FrameLayout ball2 = (FrameLayout) findViewById(R.id.ball_2);
        ball2.setVisibility(View.INVISIBLE);

        FrameLayout ball3 = (FrameLayout) findViewById(R.id.ball_3);
        ball3.setVisibility(View.INVISIBLE);

        FrameLayout ball4 = (FrameLayout) findViewById(R.id.ball_4);
        ball4.setVisibility(View.INVISIBLE);

        FrameLayout ball5 = (FrameLayout) findViewById(R.id.ball_5);
        ball5.setVisibility(View.INVISIBLE);

        FrameLayout ball6 = (FrameLayout) findViewById(R.id.ball_6);
        ball6.setVisibility(View.INVISIBLE);

        Animation a = AnimationUtils.loadAnimation(this, R.anim.move_down_ball_first);
        ball6.setVisibility(View.VISIBLE);
        ball6.clearAnimation();
        ball6.startAnimation(a);

        ball5.setVisibility(View.VISIBLE);
        ball5.clearAnimation();
        ball5.startAnimation(a);

        ball4.setVisibility(View.VISIBLE);
        ball4.clearAnimation();
        ball4.startAnimation(a);

        ball3.setVisibility(View.VISIBLE);
        ball3.clearAnimation();
        ball3.startAnimation(a);

        ball2.setVisibility(View.VISIBLE);
        ball2.clearAnimation();
        ball2.startAnimation(a);

        ball1.setVisibility(View.VISIBLE);
        ball1.clearAnimation();
        ball1.startAnimation(a);
    }
}
