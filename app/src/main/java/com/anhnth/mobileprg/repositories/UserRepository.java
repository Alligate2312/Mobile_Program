package com.anhnth.mobileprg.repositories;

import retrofit2.Call;

import com.anhnth.mobileprg.apis.ApiClient;
import com.anhnth.mobileprg.apis.UserService;
import com.anhnth.mobileprg.models.requests.RegisterRequest;
import com.anhnth.mobileprg.models.responses.RegisterResponse;

public class UserRepository {
    private final UserService userService;

    public UserRepository() {
        userService = ApiClient.getRetrofit().create(UserService.class);
    }

    public Call<RegisterResponse> registerUser(RegisterRequest req) {
        return userService.registerUser(req);
    }

//    public Call<LoginResponse> loginUser(LoginRequest req) {
//        return userService.loginUser(req);
//    }
}
