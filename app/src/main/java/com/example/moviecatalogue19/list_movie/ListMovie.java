package com.example.moviecatalogue19.list_movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.moviecatalogue19.R;
import com.example.moviecatalogue19.detail_movie.DetailMovie;

import java.util.ArrayList;

public class ListMovie extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListMovieAdapter mAdapter;

    private ArrayList<MovieModel> modelList = new ArrayList<>();
    public static final String SELECTED_MOVIE = "selected_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);
        findViews();
        setAdapter();
    }

    private void findViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }

    private void setAdapter() {
        modelList.add(new MovieModel(getResources().getString(R.string.tittle_avengerinfinity), getString(R.string.overview_avangerinfinyty), R.drawable.poster_avengerinfinity));
        modelList.add(new MovieModel(getResources().getString(R.string.tittle_birdbox), getString(R.string.overview_birdbox), R.drawable.poster_birdbox));
        modelList.add(new MovieModel(getResources().getString(R.string.tittle_dragonball), getString(R.string.overview_dragonball), R.drawable.poster_dragonball));
        modelList.add(new MovieModel(getResources().getString(R.string.tittle_a_star), getString(R.string.overview_a_star), R.drawable.poster_a_star));
        modelList.add(new MovieModel(getResources().getString(R.string.tittle_bohemian), getString(R.string.overview_bohemian), R.drawable.poster_bohemian));
        modelList.add(new MovieModel(getResources().getString(R.string.tittle_creed), getString(R.string.overview_creed), R.drawable.poster_creed));
        modelList.add(new MovieModel(getResources().getString(R.string.tittle_hunterkiller), getString(R.string.overview_huterkiller), R.drawable.poster_hunterkiller));
        modelList.add(new MovieModel(getResources().getString(R.string.tittle_aquaman), getString(R.string.overview_aquaman), R.drawable.poster_aquaman));
        modelList.add(new MovieModel(getResources().getString(R.string.tittle_deadpool), getString(R.string.overview_deadpool), R.drawable.poster_deadpool));
        modelList.add(new MovieModel(getResources().getString(R.string.tittle_dragom), getString(R.string.overview_dragon), R.drawable.poster_dragon));
        modelList.add(new MovieModel(getResources().getString(R.string.tittle_bumblebee), getString(R.string.overview_bohemian), R.drawable.poster_bumblebee));
        modelList.add(new MovieModel(getResources().getString(R.string.tittle_glass), getString(R.string.overview_glass), R.drawable.poster_glass));

        mAdapter = new ListMovieAdapter(ListMovie.this, modelList);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setmItemClickListener(new ListMovieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, MovieModel model) {
                Intent goToDetailMovie = new Intent(ListMovie.this, DetailMovie.class);
                goToDetailMovie.putExtra(ListMovie.SELECTED_MOVIE, model);
                startActivity(goToDetailMovie);
            }
        });
    }
}