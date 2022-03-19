package com.example.gridviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gvProducts;
    ArrayList<product> productList;
    productAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();

        adapter = new productAdapter(this, R.layout.row_items, productList);
        gvProducts.setAdapter(adapter);

        gvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailsDonut.class);
                Bundle b = new Bundle();
                b.putString("name", productList.get(i).getDonutName());
                b.putString("des", productList.get(i).getDonutDes());
                b.putString("price", productList.get(i).getDonutPrice());
                b.putInt("img", productList.get(i).getDonutImg());
                intent.putExtras(b);

                startActivity(intent);
            }
        });
    }

    public void mapping() {
        gvProducts = (GridView) findViewById(R.id.gv_products);

        productList = new ArrayList<>();
        productList.add(new product("Tasty Donut", "Spicy tasty donut family", "$10.00", R.drawable.donut_yellow_1));
        productList.add(new product("Pink Donut", "Spicy tasty donut family", "$20.00", R.drawable.pink_donut_1));
        productList.add(new product("Floating Donut", "Spicy tasty donut family", "$30.00", R.drawable.green_donut_1));
        productList.add(new product("Tasty Donut", "Spicy tasty donut family", "$40.00", R.drawable.donut_red_1));
    }
}