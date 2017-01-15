package appewtc.masterung.myofficer;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by masterUNG on 1/15/2017 AD.
 */

public class SynUser extends AsyncTask<Void, Void, String>{

    //Explicit
    private Context context;
    private static final String urlJSON = "http://swiftcodingthai.com/14jan/get_user_master.php";

    public SynUser(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... voids) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlJSON).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}   // Main Class
