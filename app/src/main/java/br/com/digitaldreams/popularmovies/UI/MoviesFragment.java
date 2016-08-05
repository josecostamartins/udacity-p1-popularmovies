package br.com.digitaldreams.popularmovies.UI;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.com.digitaldreams.popularmovies.R;
import br.com.digitaldreams.popularmovies.adapter.MovieRecyclerAdapter;
import br.com.digitaldreams.popularmovies.models.Movies;


public class MoviesFragment extends Fragment {

    private static final String LOG_TAG = MoviesFragment.class.getSimpleName();
    private GridLayoutManager movieGridLayout;
    private RecyclerView movieRecyclerView;
    private MovieRecyclerAdapter movieRecyclerAdapter;
    private View mView;


    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_movies, container, false);
//        FetchMovieRequest networking =
        ArrayList<Movies> movies = Movies.getMovieList();

        movieRecyclerView = (RecyclerView) mView.findViewById(R.id.movies_recycler_view);
        movieRecyclerView.setHasFixedSize(true);

        movieGridLayout = new GridLayoutManager(getActivity(), 3);

        movieRecyclerAdapter = new MovieRecyclerAdapter(movies, getContext());

        movieRecyclerView.setLayoutManager(movieGridLayout);
        movieRecyclerView.setAdapter(movieRecyclerAdapter);


         Log.d(LOG_TAG, movies.toString());
        return mView;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
}
