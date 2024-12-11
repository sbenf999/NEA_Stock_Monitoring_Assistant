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

import java.sql.*;

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

        String connectionString = "jdbc:mysql://localhost:3306/nea";
        String username = "root";
        String password = "BeltMadness3";
        //establish a connection to a MySQL database using the JDBC driver

        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "String URL= \"jdbc:mysql://192.168.0.142:3306/nea\";\n",
                    "root", "BeltMadness3");

            // mydb is database
            // mydbuser is name of database
            // mydbuser is password of database

            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "select * from Persons");
            int code;
            String title;
            while (resultSet.next()) {
                code = resultSet.getInt("PersonID");
                title = resultSet.getString("title").trim();
                System.out.println("Code : " + code);
            }
            System.out.println("HI!");
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }


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