package com.bhanguz.amitdesign.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bhanguz.amitdesign.ApiConstant;
import com.bhanguz.amitdesign.R;
import com.bhanguz.amitdesign.model.Data;
import com.bhanguz.amitdesign.model.MyModelClass;
import com.bhanguz.amitdesign.util.RetrofitClient;
import com.bhanguz.amitdesign.util.RetrofitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Newsfragment extends Fragment {
    RetrofitInterface api;
    TextView spottype;
    TextView priceformat;
    TextView currency;
    TextView code;
    TextView date,price;
    String t1;

    public Newsfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_newsfragment, container, false);
        spottype = view.findViewById(R.id.txt1);
        priceformat = view.findViewById(R.id.money);
        currency = view.findViewById(R.id.opentxt);
        code = view.findViewById(R.id.closetxt);
        date = view.findViewById(R.id.anothertxt);
        price=view.findViewById(R.id.growthtxt);
        hitApi();
        return view;
    }

    private void hitApi() {
        RetrofitClient.getInstance().services.getlist(ApiConstant.token).enqueue(new Callback<MyModelClass>() {
            @Override
            public void onResponse(Call<MyModelClass> call, Response<MyModelClass> response) {
                if (response.isSuccessful()) {

                    if (response.body() != null) {
                        MyModelClass modelClass = response.body();
                        spottype.setText(modelClass.getData().getType());
                        priceformat.setText(modelClass.getData().getFormatted());
                        code.setText(modelClass.getData().getCode());
                        currency.setText(modelClass.getData().getCurrency());
                        date.setText(modelClass.getData().getCreatedAt());
                        price.setText(modelClass.getData().getPrice().toString());



                    }
                }

            }

            @Override
            public void onFailure(Call<MyModelClass> call, Throwable t) {
                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });



      //  api = RetrofitClient.getRetrofit().create(RetrofitInterface.class);


//        Call<MyModelClass> call = api.getlist(ApiConstant.token);
//
//        call.enqueue(new Callback<MyModelClass>() {
//            @Override
//            public void onResponse(Call<MyModelClass> call, Response<MyModelClass> response) {
//
//                if (response.isSuccessful()) {
//
//                    if (response.body() != null) {
//                        MyModelClass modelClass = response.body();
//                        spottype.setText(modelClass.getData().getCode());
//                        //  priceformat.setText.response.body().getPrice();
//                        currency.setText(modelClass.getData().getCurrency());
//                        //code.setText(response.body().getCode());
//                        //date.setText((CharSequence) response.body().getCreated_at());
////                        list = response.body().getData().getData();
////                        adapter = new ProductAdapter(activity, list);
////                        recyclerView.setAdapter(adapter);
//
//                    }
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<MyModelClass> call, Throwable t) {
//
//                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });


    }
}