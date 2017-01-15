package appewtc.masterung.myofficer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

public class ServiceActivity extends AppCompatActivity {

    //Explicit
    private ListView listView;
    private String[] nameStrings, userStrings, passwordStrings, imageStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        //Bind Widget
        listView = (ListView) findViewById(R.id.livOfficer);

        //Create ListView
        try {

            SynUser synUser = new SynUser(ServiceActivity.this);
            synUser.execute();
            String strJSON = synUser.get();

            JSONArray jsonArray = new JSONArray(strJSON);
            nameStrings = new String[jsonArray.length()];
            userStrings = new String[jsonArray.length()];
            passwordStrings = new String[jsonArray.length()];
            imageStrings = new String[jsonArray.length()];

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                nameStrings[i] = jsonObject.getString("Name");
                userStrings[i] = jsonObject.getString("User");
                passwordStrings[i] = jsonObject.getString("Password");
                imageStrings[i] = jsonObject.getString("Image");

            }   // for

            final MyAdapter myAdapter = new MyAdapter(ServiceActivity.this,
                    nameStrings, imageStrings);
            listView.setAdapter(myAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    MyAlert myAlert = new MyAlert(ServiceActivity.this);
                    myAlert.errorDialog(userStrings[i], passwordStrings[i]);
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }


    }   // Main Method

}   // Main Class
