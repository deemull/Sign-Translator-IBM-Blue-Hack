package bluehackatlanta.ibm_bluehackatlanta_signtranslate;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ibm.watson.developer_cloud.android.library.camera.CameraHelper;

public class SignToText extends AppCompatActivity {
    CameraHelper cameraHelper = new CameraHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_to_text);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CameraHelper.REQUEST_IMAGE_CAPTURE){
            System.out.println(cameraHelper.getFile(resultCode));
        }
    }

    //Translates an image of 'y' in ASL and returns the text 'y'.
    public void translate(){
        cameraHelper.dispatchTakePictureIntent();
    }
}
