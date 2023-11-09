package com.example.sensorproximidad;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
//se configura la interfaz de usuarios cargando el diseño definido en el activity_main.xml

    LinearLayout ln;

    SensorManager sm;

    Sensor sensor;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Se inicializan las variables
        ln = findViewById(R.id.activity_main);//un objeto Linearlayout que representa el diseno principal de la actividad
        tv = findViewById(R.id.tv);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);// un objeto SensorManager que se utiliza para gestionar los sensores del dispositivo
        sensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);//Se obtiene el sensor de proximidad con Sensor, Type_Proximity del dispositivo
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);


    }

    @Override
    //Se actualiza el TextView o tv con el valor actual del sensor de proximidad
    public void onSensorChanged(SensorEvent event) {
        //El valor del sensor se encuentra en event.values[0]
        String text = String.valueOf(event.values[0]);
        tv.setText(text);//Luego se convierte el valor en una cadena y se muestra en el textview
        float valor = Float.parseFloat(text);//Se analiza el valor del sensor de proximidad
        if (valor == 0) {//Si el valor es igual a 0 el objeto esta cerda del sensor
            ln.setBackgroundColor(Color.GREEN);//El fondo de pantalla se cambiara a verde
        } else {
            ln.setBackgroundColor(Color.RED);//de Lo contrario se cambiara a rojo
        }
    }

            @Override
            //no realiza ninguna accion en este caso
            public void onAccuracyChanged(Sensor sensor,int i){


            }

        }