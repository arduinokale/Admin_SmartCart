package com.kale.adminsmartcart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.kale.adminsmartcart.Retrofit.ApiClient;
import com.kale.adminsmartcart.Retrofit.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultActivity extends AppCompatActivity {

    RecyclerView recyclerView2;
    ResultAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    TextView productquantity,productamount,productpaymentstatus;
    String a;
    List<ResultModel> resultModels;
    ApiInterface apiInterface;
    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        a = getIntent().getStringExtra("result");
        Log.d("responce_result",a);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        recyclerView2 = findViewById(R.id.recyclerView2);
        productquantity = findViewById(R.id.productquantity);
        productamount = findViewById(R.id.productamount);
        productpaymentstatus = findViewById(R.id.productpaymentstatus);

        productpaymentstatus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Call<List<ResultModel>> call = apiInterface.delete(a);
                call.enqueue(new Callback<List<ResultModel>>() {
                    @Override
                    public void onResponse(Call<List<ResultModel>> call, Response<List<ResultModel>> response) {
                       Log.d("result", String.valueOf(response.body()));
                       adapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onFailure(Call<List<ResultModel>> call, Throwable t) {

                    }
                });
                return true;
            }
        });

        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView2.setLayoutManager(layoutManager);

        Call<List<ResultModel>> call = apiInterface.showSelected(a);
        call.enqueue(new Callback<List<ResultModel>>() {
            @Override
            public void onResponse(Call<List<ResultModel>> call, Response<List<ResultModel>> response) {
                Log.d("responceok", String.valueOf(response.body()));

                resultModels = response.body();
                adapter = new ResultAdapter(getApplicationContext(),resultModels);
                recyclerView2.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                for (int j =0;j<response.body().size();j++)
                {
                    String total = response.body().get(j).getProduct_price();
                    sum +=Integer.valueOf(total);
                }
                productamount.setText("Total Amount \n "+"₹ "+String.valueOf(sum));
                productquantity.setText("Total Products \n " +response.body().size());
                productpaymentstatus.setText("Payment Status \n Done");
            }

            @Override
            public void onFailure(Call<List<ResultModel>> call, Throwable t) {
                Log.d("responceErrorRetrofit", String.valueOf(t));
            }
        });

    }
}