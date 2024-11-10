package com.example.nea_stockmonitoringassistant;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    EditText mEditUsername;
    EditText mEditPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //login function for button
    public void login(View view) {
        mButton = findViewById(R.id.loginButton);
        mEditUsername = findViewById(R.id.usernameInput);
        mEditPassword = findViewById(R.id.passwordInput);

        String inputtedUsername = mEditUsername.getText().toString();
        String inputtedPassword = String.valueOf(mEditPassword.getText());

        if (inputtedUsername.equals("admin") & inputtedPassword.equals("1234")) {
            Log.v("EditText", mEditUsername.getText().toString());
            Log.v("EditText", mEditPassword.getText().toString());

            Intent intent = new Intent(MainActivity.this, HomeScreen.class);
            startActivity(intent);

        } else {
            System.out.println("Incorrect username or password");

            CharSequence text = "Incorrect username or password";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(getApplicationContext(), text, duration);
            toast.show();
        }

    }

    //forgot password function for button
    public void forgotPassword(View view) {

    }
}