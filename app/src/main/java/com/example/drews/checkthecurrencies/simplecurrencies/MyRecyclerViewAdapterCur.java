package com.example.drews.checkthecurrencies.simplecurrencies;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.drews.checkthecurrencies.MyRecyclerViewAdapter;
import com.example.drews.checkthecurrencies.R;

import java.util.List;

/**
 * Created by Drews on 30.11.2017.
 */

public class MyRecyclerViewAdapterCur extends RecyclerView.Adapter<MyRecyclerViewAdapterCur.MyViewHolderCur> {

    private MyRecyclerViewAdapter.OnItemClickListener itemClickListener;

    List<Money> moneyList;

    public MyRecyclerViewAdapterCur(List<Money> moneyList) {
        this.moneyList = moneyList;
    }

    @Override
    public MyViewHolderCur onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_info1, parent, false);
        return new MyViewHolderCur(inflate);
    }

    @Override
    public void onBindViewHolder(MyViewHolderCur holder, int position) {

        Rates rates = moneyList.get(position);


        holder.tvName1.setText(rates.getName());
        holder.tvPriceUsd1.setText((int) rates.getPriceUsd());


    }

    @Override
    public int getItemCount() {
        return moneyList.size();
    }

    public void setItemClickListener(@Nullable MyRecyclerViewAdapter.OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    class MyViewHolderCur extends RecyclerView.ViewHolder implements View.OnClickListener {

        private View cardView1;
        TextView tvName1, tvPriceUsd1;

        public MyViewHolderCur(View itemView) {
            super(itemView);


            tvName1 = itemView.findViewById(R.id.tv_name1);
            tvPriceUsd1 = itemView.findViewById(R.id.tv_price_usd1);
            cardView1 = itemView.findViewById(R.id.cardView1);

            cardView1.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null) {
                itemClickListener.onItemClicked((View) v.getParent(), getAdapterPosition());
            }
        }
    }


    interface OnItemClickListener {
        void onItemClicked(View view, int position);
    }

}