package com.example.thebox;

import androidx.appcompat.app.AppCompatActivity;
import com.example.thebox.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button customerButton, cloudKitchenButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customerButton = findViewById(R.id.button_customer);
        cloudKitchenButton = findViewById(R.id.button_cloudKitchen);
        customerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CustomerMain.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}