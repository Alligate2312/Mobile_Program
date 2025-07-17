package com.anhnth.mobileprg.apis;

import com.anhnth.mobileprg.models.responses.AllAccessoryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AccessoriesApiService {
    @GET("/accessories/allAccessories")
    Call<List<AllAccessoryResponse>> getAllAccessories();
}
