package br.com.digitaldreams.popularmovies.models;

import android.graphics.Movie;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import br.com.digitaldreams.popularmovies.Networking.FetchMovieRequest;

/**
 * Created by josecostamartins on 7/24/16.
 */
public class Movies {
    private static final String key = "7671bc75195b14bf9991ba9f478c75fe";
    private static final String baseURL = "https://api.themoviedb.org/3/movie";

    private static int currentPage; //request
    private static int total_results; //request
    private static int total_pages; //request

    private Boolean adult;
    private String backdropPath; //image
    private ArrayList<Integer> genreIds;
    private Integer id;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private Date releaseDate;
    private String title;
    private String posterPath;
    private Double populatity;
    private Boolean video;
    private Double voteAverage;
    private Integer voteCount;

    private static final String[] imageSizes = {"w92", "w154", "w185", "w342", "w500", "w780", "original"};

    public static String getKey() {
        return key;
    }

    public static ArrayList<Movies> getMovieList() {
        FetchMovieRequest movieRequest = new FetchMovieRequest(baseURL, key, null);
        String answer = null;
        try {
            answer = movieRequest.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return parseMovieList(answer);
    }

    private static ArrayList<Movies> parseMovieList(String json){
        if (json == null){
            return null;
        }
        try {
            JSONObject data = new JSONObject(json);
            currentPage = data.optInt("page");
            JSONArray results = data.getJSONArray("results");

            ArrayList<Movies> moviesList = new ArrayList<>();
            for (int i = 0; i < results.length(); i++){
                JSONObject current = results.getJSONObject(i);
                Movies movies = new Movies();
                movies.setAdult(current.optBoolean("adult", false));
                movies.setOverview(current.optString("overview", ""));
                movies.setPosterPath(current.optString("poster_path", ""));
                movies.setOriginalTitle(current.optString("original_title", ""));
                movies.setOriginalLanguage(current.optString("original_language", ""));
                movies.setTitle(current.optString("title", ""));
                movies.setBackdropPath(current.optString("backdrop_path", ""));
                movies.setPopulatity(current.optDouble("popularity", 0.0));
                movies.setVoteCount(current.optInt("vote_count", 0));
                movies.setVoteAverage(current.optDouble("vote_average", 0.0));
                movies.setVideo(current.optBoolean("video", false));
//                movies.setReleaseDate();
//                movies.setGenreIds();
                moviesList.add(movies);
            }

            return moviesList;


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @return the movie image URL with size w185
     */
    public String getMovieImageURL() {
        return getMovieImageURL(2);
    }


    /**
     * size has the following configuration:
     * 0: "w92",
     * 1: "w154",
     * 2: "w185",
     * 3: "w342",
     * 4: "w500",
     * 5: "w780",
     * 6: "original".
     * @param size
     * @return the movie image URL with the specified size
     */
    public String getMovieImageURL(Integer size) {
        String finalUrl;
        if (size == null){
            throw new NullPointerException("Please inform image size");
        }

        finalUrl = "http://image.tmdb.org/t/p/" + imageSizes[size] + "/" + this.posterPath;

        return finalUrl;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Double getPopulatity() {
        return populatity;
    }

    public void setPopulatity(Double populatity) {
        this.populatity = populatity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(ArrayList<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }
}