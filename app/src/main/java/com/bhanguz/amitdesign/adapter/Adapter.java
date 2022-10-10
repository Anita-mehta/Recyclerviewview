package com.bhanguz.amitdesign.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bhanguz.amitdesign.R;
import com.bhanguz.amitdesign.model.MyModelClass;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<MyModelClass.Data> list=new ArrayList<>();
    private Context context;


    public Adapter(Context context,List<MyModelClass.Data> list) {

        this.context=context;
        this.list=list;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View v = inflater.inflate(R.layout.mainscreenlayout, parent, false);
//        ViewHolder viewHolder = new ViewHolder(v);
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.mainscreenlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.spottype.setText(list.get(position).getType());
        holder.priceformat.setText(list.get(position).getFormatted());
         holder.code.setText(list.get(position).getCode());
         holder.currency.setText(list.get(position).getCurrency());
         holder.date.setText(list.get(position).getCreatedAt());
         holder.price.setText(list.get(position).getPrice().toString());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView spottype;
        TextView priceformat;
        TextView currency;
        TextView code;
        TextView date,price;

        String t1;
        public ViewHolder(View v) {
            super(v);

            spottype=v.findViewById(R.id.txt1);
            priceformat=v.findViewById(R.id.money);
            code=v.findViewById(R.id.opentxt);
            currency=v.findViewById(R.id.closetxt);
            date=v.findViewById(R.id.anothertxt);
            price=v.findViewById(R.id.growthtxt);


        }
    }
}