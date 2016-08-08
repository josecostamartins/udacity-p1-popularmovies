package br.com.digitaldreams.popularmovies.UI;

import android.graphics.Movie;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.digitaldreams.popularmovies.R;
import br.com.digitaldreams.popularmovies.models.Movies;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);


        if (savedInstanceState == null){
            Movies movie = getIntent().getParcelableExtra("movie");

            MovieDetailFragment movieDetailFragment = MovieDetailFragment.newInstance(movie);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.movie_details_fragment, movieDetailFragment)
                    .commit();
        }
    }
}
