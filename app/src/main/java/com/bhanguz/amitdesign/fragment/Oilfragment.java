package com.bhanguz.amitdesign.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bhanguz.amitdesign.ApiConstant;
import com.bhanguz.amitdesign.R;
import com.bhanguz.amitdesign.adapter.Adapter;
import com.bhanguz.amitdesign.model.MyModelClass;
import com.bhanguz.amitdesign.util.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Oilfragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private Adapter adapter;
    //private RecyclerView.LayoutManager layoutManager;
    private LinearLayoutManager layoutManager;
    private List<MyModelClass.Data> list;
    MyModelClass.Data data;

    public Oilfragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_oilfragment, container, false);
        recyclerView =  view.findViewById(R.id.recyclerview);
        // layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        getData();
           return view;
    }

    public void getData(){

        RetrofitClient.getInstance().services.getlist(ApiConstant.token).enqueue(new Callback<MyModelClass>() {
            @Override
            public void onResponse(Call<MyModelClass> call, Response<MyModelClass> response) {
                list=new ArrayList<>();

                if (response.isSuccessful()){
                             MyModelClass modelClass=response.body();
                             data=modelClass.getData();
                             list.add(data);

                    adapter = new Adapter(getActivity(),list);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<MyModelClass> call, Throwable t) {

            }
        });

    }
}