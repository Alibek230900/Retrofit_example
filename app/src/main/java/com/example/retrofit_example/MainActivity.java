package com.example.retrofit_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofit_example.Adapter.SourceAdapter;
import com.example.retrofit_example.Models.Source;
import com.example.retrofit_example.Models.Website;
import com.example.retrofit_example.Retrofit.ApiClient;
import com.example.retrofit_example.Retrofit.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerViewMainActivity)
    RecyclerView recyclerView;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefreshLayout;

    ApiInterface apiInterface;
    List<Source> listSources;
    SourceAdapter adapter;
    AlertDialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        loadWebsiteSources();


    }

    private void loadWebsiteSources() {

        dialog.show();

        apiInterface.getSources().enqueue(new Callback<Website>() {
            @Override
            public void onResponse(Call<Website> call, Response<Website> response) {
                dialog.dismiss();

                Website website=response.body();
                if (website!=null && response.body().getSource().size()>0){

                    listSources.clear();
                    listSources.addAll(website.getSource());

                }
                else {
                    Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_LONG).show();
                }
                adapter.notifyDataSetChanged();
            }


            @Override
            public void onFailure(Call<Website> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this,"Error",+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }


    private void init(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        listSources=new ArrayList<>();

        dialog=new SpotsDialog(this);

        adapter=new SourceAdapter(this,listSources);
        recyclerView.setAdapter(adapter);
    }
}