package appewtc.masterung.myofficer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private Button signInButton, signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        signInButton = (Button) findViewById(R.id.button);
        signUpButton = (Button) findViewById(R.id.button2);

        //Button Controller
        signInButton.setOnClickListener(MainActivity.this);
        signUpButton.setOnClickListener(MainActivity.this);


    }   // Main Method


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button:   // for SignIn

                break;
            case R.id.button2:  // for SignUp
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
                break;
        }

    }
}   // Main Class
