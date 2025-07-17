package com.anhnth.mobileprg.ui.accessory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.anhnth.mobileprg.R;
import com.anhnth.mobileprg.models.responses.AllAccessoryResponse;

import java.util.List;

public class AccessoriesAdapter extends RecyclerView.Adapter<AccessoriesAdapter.ViewHolder> {
    private final List<AllAccessoryResponse> accessories;
    private final Context context;
    public AccessoriesAdapter(Context context, List<AllAccessoryResponse> accessories) {
        this.context = context;
        this.accessories = accessories;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_accessory, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AllAccessoryResponse accessory = accessories.get(position);
        holder.name.setText(accessory.getName());
        holder.price.setText(String.format("%,.0f VNĐ", accessory.getPrice()));

        List<String> photos = accessory.getPhoto();
        if (photos != null && !photos.isEmpty()) {
            Picasso.get()
                    .load(photos.get(0))
                    .placeholder(R.drawable.placeholder_image)
                    .error(R.drawable.error_image)
                    .into(holder.image);
        } else {
            holder.image.setImageResource(R.drawable.error_image);
        }

        holder.detailButton.setOnClickListener(v -> {
            // TODO: Implement detail activity navigation
        });
    }

    @Override
    public int getItemCount() {
        return accessories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, price;
        Button detailButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_image);
            name = itemView.findViewById(R.id.item_name);
            price = itemView.findViewById(R.id.item_price);
            detailButton = itemView.findViewById(R.id.item_detail);
        }
    }
}
