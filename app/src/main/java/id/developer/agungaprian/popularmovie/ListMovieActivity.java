package id.developer.agungaprian.popularmovie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import id.developer.agungaprian.popularmovie.adapter.MovieAdapter;
import id.developer.agungaprian.popularmovie.models.Movie;
import id.developer.agungaprian.popularmovie.models.MovieResponse;
import id.developer.agungaprian.popularmovie.rest.ApiClient;
import id.developer.agungaprian.popularmovie.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMovieActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private MovieAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2,
                LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);


        ApiInterface apiInterface =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MovieResponse> call = apiInterface.loadMovies("top_rated",BuildConfig.API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> movies = response.body().getResults();
                Log.d(TAG, "number of movie received :" +movies.size());

                adapter = new MovieAdapter(movies, getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });
    }
}