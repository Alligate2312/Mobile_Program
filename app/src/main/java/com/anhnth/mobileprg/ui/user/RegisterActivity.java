package com.anhnth.mobileprg.ui.user;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.anhnth.mobileprg.R;
import com.anhnth.mobileprg.models.requests.RegisterRequest;
import com.anhnth.mobileprg.models.responses.RegisterResponse;
import com.anhnth.mobileprg.repositories.UserRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    EditText nameInput, emailInput, passwordInput, confirmPasswordInput, dobInput;
    Button registerButton;
    UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameInput = findViewById(R.id.name_input);
        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        confirmPasswordInput = findViewById(R.id.confirm_password_input);
        dobInput = findViewById(R.id.dob_input);
        registerButton = findViewById(R.id.register_button);
        userRepository = new UserRepository();

        registerButton.setOnClickListener(view -> {
            String name = nameInput.getText().toString();
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();
            String confirmedPassword = confirmPasswordInput.getText().toString();
            String dob = dobInput.getText().toString();

            RegisterRequest request = new RegisterRequest(name, email, password, confirmedPassword, dob);

            userRepository.registerUser(request).enqueue(new Callback<RegisterResponse>() {
                @Override
                public void onResponse(Call<RegisterResponse> call,
                                       Response<RegisterResponse> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "Register Success",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Register Failed", Toast.LENGTH_SHORT)
                                .show();
                    }
                }

                @Override
                public void onFailure(Call<RegisterResponse> call, Throwable t) {
                    Log.e("RegisterError", t.getMessage());
                    Toast.makeText(RegisterActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
