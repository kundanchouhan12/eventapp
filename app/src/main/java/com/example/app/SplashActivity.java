package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_DELAY = 3000; // 🔥 3 Seconds Delay
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash); // ✅ Added to prevent blank screen

        auth = FirebaseAuth.getInstance();

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            FirebaseUser currentUser = auth.getCurrentUser();

            Intent intent;
            if (currentUser != null && (currentUser.isEmailVerified() || currentUser.getProviderData().size() > 1)) {
                // ✅ Email verified OR Google/Facebook login → Go to MainActivity
                intent = new Intent(SplashActivity.this, MainActivity.class);
            } else {
                // ❌ No user OR email not verified → Go to LoginActivity
                intent = new Intent(SplashActivity.this, LoginActivity.class);
            }

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // ✅ Close SplashActivity
        }, SPLASH_DELAY);
    }
}
