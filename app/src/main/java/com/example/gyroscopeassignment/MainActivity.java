// Group members: Riley Sheehy & Landon Jones

package com.example.gyroscopeassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager sensorManager_;
    private Sensor sensor_;
    private Sensor gyrosensor_;
    private Button startButton;
    private EditText orientationText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.button);
        orientationText = (EditText) findViewById(R.id.orientation);

        sensorManager_ = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor_ = sensorManager_.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyrosensor_ = sensorManager_.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sensorManager_.registerListener(MainActivity.this, sensor_, SensorManager.SENSOR_DELAY_NORMAL);
                sensorManager_.registerListener(MainActivity.this, gyrosensor_, SensorManager.SENSOR_DELAY_NORMAL);
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            Float x = event.values[0];
            Float y = event.values[1];
            Float z = event.values[2];
            Double angle = Math.atan2(y, x);

        }
        else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE)
        {
            Float x = event.values[0];
            Float y = event.values[1];
            Float z = event.values[2];


        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}