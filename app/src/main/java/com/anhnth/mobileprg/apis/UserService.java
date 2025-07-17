package com.anhnth.mobileprg.apis;



import com.anhnth.mobileprg.models.requests.LoginRequest;
import com.anhnth.mobileprg.models.requests.RegisterRequest;
import com.anhnth.mobileprg.models.responses.LoginResponse;
import com.anhnth.mobileprg.models.responses.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("/user/register")
    Call<RegisterResponse> registerUser(@Body RegisterRequest request);

    @POST("/user/login")
    Call<LoginResponse> loginUser(@Body LoginRequest request);
}
