package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {
    private EditText fullNameInput, emailInput, passwordInput;
    private Button signupButton;
    private TextView loginRedirectButton;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    // 🔥 Password regex pattern for strong password
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{6,}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();

        fullNameInput = findViewById(R.id.fullname);
        emailInput = findViewById(R.id.email);
        passwordInput = findViewById(R.id.password);
        signupButton = findViewById(R.id.signup_button);
        loginRedirectButton = findViewById(R.id.login_link);
        progressBar = findViewById(R.id.progressBar);

        signupButton.setOnClickListener(view -> registerUser());

        loginRedirectButton.setOnClickListener(view -> {
            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            finish();
        });
    }

    private void registerUser() {
        String fullName = fullNameInput.getText().toString().trim();
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        // 🔥 Validation for Full Name
        if (TextUtils.isEmpty(fullName)) {
            fullNameInput.setError("Full name is required!");
            return;
        }

        // 🔥 Validation for Email (checks if email is valid)
        if (TextUtils.isEmpty(email)) {
            emailInput.setError("Email is required!");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.setError("Enter a valid email address!");
            return;
        }

        // 🔥 Validation for Strong Password
        if (TextUtils.isEmpty(password)) {
            passwordInput.setError("Password is required!");
            return;
        }
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            passwordInput.setError("Password must have at least 6 characters, one uppercase, one lowercase, one digit, and one special character.");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    progressBar.setVisibility(View.GONE);
                    if (task.isSuccessful()) {
                        FirebaseUser user = auth.getCurrentUser();
                        if (user != null) {
                            // 🔥 Send verification email
                            user.sendEmailVerification()
                                    .addOnCompleteListener(verificationTask -> {
                                        if (verificationTask.isSuccessful()) {
                                            Toast.makeText(SignupActivity.this,
                                                    "Registration successful! Please check your email for verification.",
                                                    Toast.LENGTH_LONG).show();
                                            auth.signOut(); // Log out the user until email is verified
                                            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                                            finish();
                                        } else {
                                            Toast.makeText(SignupActivity.this,
                                                    "Failed to send verification email. Try again later.",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }
                    } else {
                        Toast.makeText(SignupActivity.this,
                                "Registration failed: " + task.getException().getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
