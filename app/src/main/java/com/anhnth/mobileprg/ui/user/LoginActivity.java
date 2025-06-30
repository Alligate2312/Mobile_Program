package com.anhnth.mobileprg.ui.user;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.anhnth.mobileprg.R;
import com.anhnth.mobileprg.repositories.UserRepository;

public class LoginActivity extends AppCompatActivity {
//    EditText emailInput, passwordInput;
//    Button loginButton;
//    UserRepository userRepository;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        emailInput = findViewById(R.id.email_input);
//        passwordInput = findViewById(R.id.password_input);
//        loginButton = findViewById(R.id.login_button);
//        userRepository = new UserRepository();
//
//        loginButton.setOnClickListener(view -> {
//            String email = emailInput.getText().toString();
//            String password = passwordInput.getText().toString();
//
//            LoginRequest request = new LoginRequest(email, password);
//
//            userRepository.loginUser(request).enqueue(new Callback<LoginResponse>() {
//                @Override
//                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                    if (response.isSuccessful()) {
//                        Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                        intent.putExtra("userId", response.body().id);
//                        startActivity(intent);
//                        finish();
//                    } else {
//                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<LoginResponse> call, Throwable t) {
//                    Log.e("LoginError", t.getMessage());
//                    Toast.makeText(LoginActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            });
//        });
//    }
//}
}
