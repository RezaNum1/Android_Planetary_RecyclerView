package com.example.planetary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCategory;
    private ArrayList<Planet> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(PlanetData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListPlanetAdapter listPlanetAdapter = new ListPlanetAdapter(list);
        rvCategory.setAdapter(listPlanetAdapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int selectedMode) {
        switch (selectedMode){
            case R.id.action_list:
                showRecyclerList();
                break;
            case R.id.action_grid:
                showRecycleGrid();
                break;
            case R.id.action_cardview:
                break;
        }
    }

    private void showRecycleGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this,2));
        GridPlanetAdapter gridPlanetAdapter = new GridPlanetAdapter(list);
        rvCategory.setAdapter(gridPlanetAdapter);
    }
}
