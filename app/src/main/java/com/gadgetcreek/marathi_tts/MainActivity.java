package com.gadgetcreek.marathi_tts;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button click;
    EditText tv;
    TextToSpeech tts;
    String nameString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = (Button) findViewById(R.id.click);
        tv = (EditText) findViewById(R.id.tv);
        tts=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    if (tts.isLanguageAvailable(Locale.US) == TextToSpeech.LANG_AVAILABLE)
                        tts.setLanguage(Locale.US);
                } else if (status == TextToSpeech.ERROR) {
                    Toast.makeText(getApplicationContext(), "Sorry! Text To Speech failed...",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void click(View v){
        Intent i = new Intent(MainActivity.this,SmsActivity.class);
        startActivity(i);
    }
    public void sp(View v){
        String toSpeak = tv.getText().toString();
        tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }

}
