package com.example.jonathanmaldonado.w2d1_ex01;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String MAIN_ACTIVITY_EXTRA="com.example.jonathanmaldonado.w2d1_ex01.MAIN_ACTIVITY_EXTRA";
    public static final String MAIN_ACTIVITY_EXTRA_IMAGE="com.example.jonathanmaldonado.w2d1_ex01.MAIN_ACTIVITY_EXTRA_IMAGE";
    public static final int REQUEST_CODE =2;
    static final int REQUEST_IMAGE_CAPTURE = 1;
  //  public static ImageView mImageView;
    EditText name;
    EditText lastName;
    EditText email;
    EditText username;
    ImageView mImageView;

    Bitmap imageBitmap;


    TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTV = (TextView) findViewById(R.id.tv_result);

        name = (EditText) findViewById(R.id.user_name);
        lastName = (EditText) findViewById(R.id.user_last_name);
        email = (EditText) findViewById(R.id.user_email);
        username = (EditText) findViewById(R.id.user_username);
    }

    public void startSecodnActivity(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivityForResult(intent, REQUEST_CODE);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE){
            String message = data.getStringExtra(SecondActivity.RESULT_EXTRA);
            resultTV.setText(message);
        }
        // Camera Image Retrive
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            mImageView= (ImageView) findViewById(R.id.imageView1);
            mImageView.setImageBitmap(imageBitmap);

            Toast.makeText(this, "Succes on image", Toast.LENGTH_SHORT).show();

        }
    }



    public void takePicture(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }

    }

    public void startSecondActivity(View view) {
        Toast.makeText(this, "Succes on image", Toast.LENGTH_SHORT).show();

        String nameValue= name.getText().toString();

        String lastNameValue=lastName.getText().toString();
        String emailValue = email.getText().toString();
        String usernameValue= username.getText().toString();


        User user = new User(nameValue, lastNameValue,emailValue,usernameValue);
        Intent intent = new Intent(MainActivity.this , SecondActivity.class);
        // intent.putExtra(MAIN_ACTIVITY_EXTRA, user);
        intent.putExtra(MAIN_ACTIVITY_EXTRA, user);
        intent.putExtra(MAIN_ACTIVITY_EXTRA_IMAGE, imageBitmap);
        startActivity(intent);


    }
}
