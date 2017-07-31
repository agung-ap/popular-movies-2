package id.developer.agungaprian.popularmovie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import id.developer.agungaprian.popularmovie.BuildConfig;
import id.developer.agungaprian.popularmovie.R;
import id.developer.agungaprian.popularmovie.models.Movie;

/**
 * Created by agungaprian on 29/07/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    private List<Movie> data;
    private int rowLayout;
    private Context context;



    public MovieAdapter(List<Movie> movies, Context applicationContext) {
        data = movies;
        context = applicationContext;
    }


    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.grid_image, parent, false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        //image url
        String imageUrl = BuildConfig.IMAGE_URL+"/w342"+
                data.get(position).getPoster_path() +
                "?api_key?="+BuildConfig.API_KEY;

        //load image to image view
        Picasso.with(context)
                .load(imageUrl)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addAll(List<Movie> list){
        for (int i = 0; i < list.size(); i++){
            data.add(list.get(i));
        }
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public MovieViewHolder(View view){
            super(view);
            imageView = (ImageView) view.findViewById(R.id.list_image);
        }
    }

}
