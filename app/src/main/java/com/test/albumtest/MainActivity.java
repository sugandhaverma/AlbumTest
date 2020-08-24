package com.test.albumtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int[] image = {R.drawable.image,
            R.drawable.ladygaga,
            R.drawable.madona,
            R.drawable.billy_ray,
            R.drawable.bruno_mars,
            R.drawable.chrish_brown,
            R.drawable.justin_biber,
            R.drawable.justin_timberlake,
            R.drawable.miley_cycrus,
            R.drawable.nick_jonas

    };

    private String[] name  ={
            "Taylor Swift",
            "Lady Gaga",
            "Madona",
            "Billy Ray",
            "Bruno Mars",
            "Chrish Brown",
            "Justin Bieber",
            "Justin Timberlake",
            "Miley Cyrus",
            "Nick Jonas"

    };

    private String[] songName = {
            "Love Story",
            "Rain On Me",
            "Into the Groove",
            "Words By Heart",
            "Just the way ",
            "Go Crazy",
            "I don't care when i'm",
            "Can't Stop the feeling",
            "When I look at you",
            "Find You"
    };

    private String[]price = {"$150","$120","$130","$120","$130","$90","$110","$150","$100","$130"};

    private List<ItemModel>itemModelList = new ArrayList<>();
    GridView gridView;
    CustomeAdapter customeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0;i< name.length;i++){

            ItemModel itemModel = new ItemModel(image[i],name[i],songName[i],price[i]);
            itemModelList.add(itemModel);
        }

          gridView = findViewById(R.id.gdView);
        customeAdapter = new CustomeAdapter(itemModelList,this);
        gridView.setAdapter(customeAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem = menu.findItem(R.id.search);

        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                Log.e("TAG","new text ==>"+newText);
                customeAdapter.getFilter().filter(newText);
                return true;
            }
        });
        return true;
    }
}
