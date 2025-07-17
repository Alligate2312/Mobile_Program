package com.anhnth.mobileprg.repositories;

import android.content.Context;

import retrofit2.Call;

import com.anhnth.mobileprg.apis.ApiClient;
import com.anhnth.mobileprg.apis.UserService;
import com.anhnth.mobileprg.models.requests.LoginRequest;
import com.anhnth.mobileprg.models.requests.RegisterRequest;
import com.anhnth.mobileprg.models.responses.LoginResponse;
import com.anhnth.mobileprg.models.responses.RegisterResponse;
import com.anhnth.mobileprg.ui.user.RegisterActivity;

public class UserRepository {
    private final UserService userService;

    public UserRepository(Context context) {
        this.userService = ApiClient.getRetrofit(context).create(UserService.class);
    }

    public Call<RegisterResponse> registerUser(RegisterRequest request) {
        return userService.registerUser(request);
    }

    public Call<LoginResponse> loginUser(LoginRequest req) {
        return userService.loginUser(req);
    }
}
