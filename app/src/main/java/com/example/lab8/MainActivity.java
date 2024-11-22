package com.example.lab8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start MyService when the button is clicked
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent);

                // Show a Toast message to confirm
                Toast.makeText(MainActivity.this, "啟動Service", Toast.LENGTH_SHORT).show();

                // Close the current activity
                finish();
            }
        });
    }
}
