package com.example.inventory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    private static List<Shop> sShopList = new ArrayList<>();
    private  OnItemClickListener mListener;
    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_list_item,parent,false);

        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        Shop currentShop = sShopList.get(position);
        holder.nameView.setText(currentShop.getName());
        holder.quantityView.setText(currentShop.getQuantity());
        holder.priceView.setText(currentShop.getPrice());
    }

    @Override
    public int getItemCount() {
        return sShopList.size();
    }
    public void setData(List<Shop> shops)
    {
        sShopList = shops;
        notifyDataSetChanged();
    }

    public  class DataViewHolder extends RecyclerView.ViewHolder{

        public TextView nameView;
        public TextView quantityView;
        public TextView priceView;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.name);
            quantityView = itemView.findViewById(R.id.quantity);
            priceView = itemView.findViewById(R.id.price);

            //setting listener for itemview
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = getAdapterPosition();
                    if(true);
                    {
                        mListener.onItemClick(sShopList.get(index));
                    }
                }
            });







        }
    }

    public interface OnItemClickListener
    {
        void onItemClick(Shop shop);


    }


    public void OnItemClickListener(OnItemClickListener listener)
    {
        mListener = listener;
    }



    //to get the item position from the list in order to delete it
    public Shop getShopPosition(int position)
    {
        return sShopList.get(position);
    }
}
