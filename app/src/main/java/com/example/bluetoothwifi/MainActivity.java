package com.example.bluetoothwifi;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtBTStatus,txtWFStatus;
    Button btnBTOn,btnBTOff,btnWFOn,btnWFOff;
    BluetoothAdapter bluetoothadapter;
    WifiManager wifimanager;
    int i = 1;
    Intent bluetoothIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtBTStatus = findViewById(R.id.txtBTStatus);
        txtWFStatus = findViewById(R.id.txtWFStatus);
        btnBTOn = findViewById(R.id.btnBTOn);
        btnBTOff = findViewById(R.id.btnBTOff);
        btnWFOn = findViewById(R.id.btnWFOn);
        btnWFOff = findViewById(R.id.btnWFOff);
        bluetoothadapter = BluetoothAdapter.getDefaultAdapter();
        btnBTOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(bluetoothIntent, i);
                txtBTStatus.setText("Bluetooth ON");
            }});
        btnBTOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bluetoothadapter.disable();
                txtBTStatus.setText("Bluetooth OFF");
            }});
        btnWFOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wifimanager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifimanager.setWifiEnabled(true);
                txtWFStatus.setText("WiFi ON");
            }});
        btnWFOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wifimanager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifimanager.setWifiEnabled(false);
                txtWFStatus.setText("WiFi OFF");
            }
        });

    }
}