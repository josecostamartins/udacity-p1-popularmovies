package br.com.digitaldreams.popularmovies.Interface;

/**
 * Created by josecostamartins on 7/25/16.
 */
public interface NetworkingTask {

    public void onFinished(String json);
    public void onProgress(Double percentage);

}
