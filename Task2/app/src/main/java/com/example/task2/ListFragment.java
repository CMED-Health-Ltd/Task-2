package com.example.task2;

import android.content.Context;
import android.net.DnsResolver;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListFragment extends Fragment {


    private Context context;
    private RecyclerView recyclerView;
    private final String BASE_URL = "http://hp-api.herokuapp.com/";
    private Adapter adapter;
    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api serviceAPI = retrofit.create(Api.class);
        serviceAPI.getDetail().enqueue(new Callback<List<Detail>>() {
            @Override
            public void onResponse(Call<List<Detail>> call, Response<List<Detail>> response) {
                if (response.isSuccessful()) {
                    List<Detail> List = response.body();
                    //adapter = new Adapter(context, List < response > List);
                    adapter = new Adapter(context,List );
                    LinearLayoutManager llm = new LinearLayoutManager(context);
                    recyclerView.setLayoutManager(llm);
                    recyclerView.setAdapter(adapter);

                }

            }

                    @Override
                    public void onFailure(Call<List<Detail>> call, Throwable t) {
                        Log.e("response", t.getLocalizedMessage());
                    }
                });
    }
}


