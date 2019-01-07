package com.metehankara.metehankara_termproject_487;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<Customers> data;

    public MyRecyclerViewAdapter(Context context, List<Customers> data) {
        this.context = context;
        this.data =(ArrayList<Customers>) data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recycler_customer_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //BIND DATA
        final Customers contact = data.get(position);
        holder.name.setText(contact.getName());
        holder.age.setText(contact.getAge());
        holder.pro.setText(contact.getProfession());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{


        TextView name,age,pro;

        MyViewHolder(View viewItem){
            super(viewItem);
            name = viewItem.findViewById(R.id.cardViewNameTxt);
            age = viewItem.findViewById(R.id.cardViewAgeTxt);
            pro = viewItem.findViewById(R.id.cardViewProfessionTxt);
        }
    }
}
