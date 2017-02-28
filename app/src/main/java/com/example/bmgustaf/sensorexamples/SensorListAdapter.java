package com.example.bmgustaf.sensorexamples;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bmgustaf on 2/27/17.
 */
public class SensorListAdapter extends BaseAdapter {

    private SensorManager mSensorManager;
    private List<Sensor> mSensorList;
    private LayoutInflater inflater = null;


    public SensorListAdapter(Context context) {
        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        mSensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return mSensorList.size();
    }


    @Override
    public Sensor getItem(int i) {
        return mSensorList.get(i);
    }


    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Sensor sensor = mSensorList.get(i);
        view = inflater.inflate(R.layout.list_layout_item, null);
        TextView tv = (TextView) view.findViewById(R.id.sensor_name);
        tv.setText(sensor.getName());
        return view;
    }
}
