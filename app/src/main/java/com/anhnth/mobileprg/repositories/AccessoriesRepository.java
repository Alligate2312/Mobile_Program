package com.anhnth.mobileprg.repositories;

import android.content.Context;

import com.anhnth.mobileprg.apis.AccessoriesApiService;
import com.anhnth.mobileprg.apis.ApiClient;
import com.anhnth.mobileprg.models.responses.AllAccessoryResponse;

import java.util.List;

import retrofit2.Call;


public class AccessoriesRepository {
    private final AccessoriesApiService accessoryService;

    public AccessoriesRepository(Context context) {
        this.accessoryService = ApiClient.getRetrofit(context).create(AccessoriesApiService.class);
    }

    public Call<List<AllAccessoryResponse>> getAllAccessories() {
        return accessoryService.getAllAccessories();
    }
}
