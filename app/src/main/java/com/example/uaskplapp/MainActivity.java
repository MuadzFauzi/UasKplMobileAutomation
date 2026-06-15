package com.example.uaskplapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView tvErrorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvErrorMessage = findViewById(R.id.tvErrorMessage);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    tvErrorMessage.setText("Username dan Password wajib diisi!");
                    tvErrorMessage.setVisibility(View.VISIBLE);
                }
                else if (username.equals("admin") && password.equals("admin123")) {
                    tvErrorMessage.setVisibility(View.INVISIBLE);

                    Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                    intent.putExtra("USER_NAME", username);
                    startActivity(intent);
                    finish();
                }
                else {
                    tvErrorMessage.setText("Username atau Password salah!");
                    tvErrorMessage.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}