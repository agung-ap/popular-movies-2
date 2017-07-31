package id.developer.agungaprian.popularmovie.rest;

import id.developer.agungaprian.popularmovie.models.MovieResponse;
import id.developer.agungaprian.popularmovie.models.RiviewResponse;
import id.developer.agungaprian.popularmovie.models.TrailerResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by agungaprian on 29/07/17.
 */

public interface ApiInterface {
    @GET("/3/movie/{sort}")
    Call<MovieResponse> loadMovies(@Path("sort") String sort, @Query("api_key") String api_key);

    @GET("/3/movie/{id}/videos")
    Call<TrailerResponse> loadTrailers(@Path("id") String id, @Query("api_key") String api_key);

    @GET("/3/movie/{id}/reviews")
    Call<RiviewResponse> loadReviews(@Path("id") String id, @Query("api_key") String api_key);
}
