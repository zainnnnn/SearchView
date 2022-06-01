package com.example.searchbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.Toolbar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcv;
    SearchView searchView;
    List<ProductTypeModel> productTypeModels = new ArrayList<>();
    ProductTypeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //   searchView = findViewById(R.id.searchView);
        rcv = findViewById(R.id.rcv);

        productTypeModels.add(new ProductTypeModel("Movies", ""));
        productTypeModels.add(new ProductTypeModel("PC games", ""));
        productTypeModels.add(new ProductTypeModel("Sports", ""));
        productTypeModels.add(new ProductTypeModel("TV Channel", ""));

        show();

    }

    public void show() {
        adapter = new ProductTypeAdapter(MainActivity.this, productTypeModels);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setAdapter(adapter);
        rcv.setHasFixedSize(true);

        adapter.setOnItemClickListener(new ProductTypeAdapter.OnItemClickListener() {
            @Override
            public void OnItem(int position) {
                Toast.makeText(MainActivity.this, "  hy ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.example_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.search_menu);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}
