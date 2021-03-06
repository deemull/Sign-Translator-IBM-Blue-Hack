package bluehackatlanta.ibm_bluehackatlanta_signtranslate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class WelcomeActivity extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.relativelayout);
        relativeLayout.setOnTouchListener(this);
    }


    //Switches to the Main Menu when any part of the screen is touched.
    public boolean onTouch(View view, MotionEvent event) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        return true;
    }
}
