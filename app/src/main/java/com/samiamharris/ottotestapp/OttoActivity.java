package com.samiamharris.ottotestapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.otto.Subscribe;


public class OttoActivity extends Activity {

    private TextView textView;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otto);

        //Register self with the only bus that we're using
        //Moved register/unregister to onResume/Pause
        //BusProvider.getInstance().register(this);

        textView = (TextView) findViewById(R.id.text_view);
        editText = (EditText) findViewById(R.id.edit_text);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals("")) {
                    textView.setText("");
                    Toast.makeText(getApplicationContext(),
                            "Please Enter Text!", Toast.LENGTH_SHORT).show();
                } else {
                    //Send Otto event which will reverse the String parameter
                    BusProvider.getInstance().post(new ButtonEvent(editText.getText().toString()));
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);

    }

    @Subscribe
    public void answerButtonClick(ButtonEvent event) {
        textView.setText(event.message);

        //Also could just pass the String along and then
        //reverse it right here
        //new StringBuilder(event.message)
        //  .reverse().toString());
    }

}
