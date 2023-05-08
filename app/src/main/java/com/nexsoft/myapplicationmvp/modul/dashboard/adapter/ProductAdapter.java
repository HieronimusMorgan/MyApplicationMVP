package com.nexsoft.myapplicationmvp.modul.dashboard.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nexsoft.myapplicationmvp.R;
import com.nexsoft.myapplicationmvp.core.model.ProductModel;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<ProductModel> productModels;

    public ProductAdapter(List<ProductModel> productModels) {
        this.productModels = productModels;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_product, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        ProductModel productModel = productModels.get(position);
        holder.tvProductCode.setText(productModel.getProductCode());
        holder.tvProductName.setText(productModel.getProductName());
    }

    @Override
    public int getItemCount() {
        return productModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvProductCode;
        private final TextView tvProductName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductCode = itemView.findViewById(R.id.tv_product_code);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
        }
    }
}
