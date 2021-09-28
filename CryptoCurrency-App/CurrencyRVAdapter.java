package com.example.cryptotrackerapplication;

import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CurrencyRVAdapter extends RecyclerView.Adapter<CurrencyRVAdapter.ViewHolder> {
    private ArrayList<CurrencyRVModal> currencyRVModalArrayList;
    private Context context;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public CurrencyRVAdapter(ArrayList<CurrencyRVModal> currencyRVModalArrayList, Context context) {
        this.currencyRVModalArrayList = currencyRVModalArrayList;
        this.context = context;
    }
    public void filterList(ArrayList<CurrencyRVModal> filteredList){
        currencyRVModalArrayList = filteredList;
        notifyDataSetChanged();

    }
    @NonNull
    @Override
    public CurrencyRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.currency_rv_item,parent,false);
        return new CurrencyRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyRVAdapter.ViewHolder holder, int position) {
    CurrencyRVModal currencyRVModal = currencyRVModalArrayList.get(position);
    holder.currencynameTV.setText(currencyRVModal.getName());
    holder.symbolTV.setText(currencyRVModal.getSymbol());
    holder.rateTV.setText("$ " + df2.format(currencyRVModal.getPrice()));
    }

    @Override
    public int getItemCount() {
        return currencyRVModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView currencynameTV,symbolTV,rateTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            currencynameTV = itemView.findViewById(R.id.idTvCurrencyName);
            symbolTV = itemView.findViewById(R.id.idTVSymbol);
            rateTV = itemView.findViewById(R.id.idTVCurrencyRate);
        }
    }
}
