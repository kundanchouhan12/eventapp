package com.example.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText email;
    private Button resetButton;
    private ProgressBar progressBar;  // Corrected variable name

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        // Initialize views
        email = findViewById(R.id.email);
        resetButton = findViewById(R.id.reset_button);
        progressBar = findViewById(R.id.progress_bar);  // Fixed: now matches XML ID

        resetButton.setOnClickListener(v -> {
            String emailInput = email.getText().toString().trim();

            if (emailInput.isEmpty()) {
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
                return;
            }

            // Show progress bar while processing
            progressBar.setVisibility(View.VISIBLE);
            resetButton.setEnabled(false);

            // Simulating a password reset process
            new android.os.Handler().postDelayed(() -> {
                progressBar.setVisibility(View.GONE);
                resetButton.setEnabled(true);
                Toast.makeText(this, "Reset link sent to " + emailInput, Toast.LENGTH_SHORT).show();
            }, 2000);  // Simulated delay (2 seconds)
        });
    }
}
