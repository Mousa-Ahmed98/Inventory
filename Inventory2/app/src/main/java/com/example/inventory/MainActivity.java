package com.example.inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText passwordEntered;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        passwordEntered = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passwordEntered.getText().toString().equals("admin"))
                {
                    Intent intent  = new Intent(MainActivity.this,DataActivity.class);
                    startActivity(intent);
                    MainActivity.this.finish();
                }
                else
                {
                    passwordEntered.setText("");
                    Toast.makeText(MainActivity.this,R.string.Invalid_password ,Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}