package bluehackatlanta.ibm_bluehackatlanta_signtranslate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ibm.watson.developer_cloud.android.library.camera.CameraHelper;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    //Opens the Sign to Text screen.
    public void openSigntoText(View view){
        Intent intent = new Intent(this, SignToText.class);
        startActivity(intent);
    }

    //Opens the Text to Sign screen.
    public void openTextoSign(View view){
        Intent i = new Intent(this, TextToSign.class);
        startActivity(i);
    }
}
