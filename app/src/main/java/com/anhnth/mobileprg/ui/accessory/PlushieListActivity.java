package com.anhnth.mobileprg.ui.accessory;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.widget.Toast;

import com.anhnth.mobileprg.DatabaseHelper;
import com.anhnth.mobileprg.R;
import com.anhnth.mobileprg.models.responses.AllAccessoryResponse;
import com.anhnth.mobileprg.repositories.AccessoriesRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlushieListActivity extends AppCompatActivity {
    private ListView lvPlushies;
    private AccessoriesRepository accessoriesRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plushie_list);

        lvPlushies = findViewById(R.id.lvPlushies);
        accessoriesRepository = new AccessoriesRepository(this);

        accessoriesRepository.getAllAccessories().enqueue(new Callback<List<AllAccessoryResponse>>() {
            @Override
            public void onResponse(Call<List<AllAccessoryResponse>> call, Response<List<AllAccessoryResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<AllAccessoryResponse> accessoryList = response.body();
                    AccessoriesAdapter adapter = new AccessoriesAdapter(PlushieListActivity.this, accessoryList);
                    lvPlushies.setAdapter(adapter);
                } else {
                    Toast.makeText(PlushieListActivity.this, "Failed to load accessories", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<AllAccessoryResponse>> call, Throwable t) {
                Toast.makeText(PlushieListActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}