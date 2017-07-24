package com.example.jonathanmaldonado.w2d1_ex01;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String RESULT_EXTRA="com.example.jonathanmaldonado.w2d1_ex01.RESULT_EXTRA";

    EditText messageET;

    TextView name;
    TextView lastName;
    TextView email;
    TextView username;
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        if(intent != null){

            User user = intent.getParcelableExtra(MainActivity.MAIN_ACTIVITY_EXTRA);

            Bundle extras = intent.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get(MainActivity.MAIN_ACTIVITY_EXTRA_IMAGE);
            mImageView= (ImageView) findViewById(R.id.imageView2);
            mImageView.setImageBitmap(imageBitmap);



            name = (TextView) findViewById(R.id.tv_user_name);
            lastName = (TextView) findViewById(R.id.tv_user_lastName);
            email = (TextView) findViewById(R.id.tv_user_email);
            username = (TextView) findViewById(R.id.tv_user_username);


            name.setText(user.getName());
            lastName.setText(user.getLastName());
            email.setText(user.getEmail());
            username.setText(user.getUsername());

            //Toast.makeText(this, tv_Name.toString(), Toast.LENGTH_SHORT).show();

        }

    }

    public void sendResult(View view) {
        String message = messageET.getText().toString();
        Intent data = new Intent();
        data.putExtra(RESULT_EXTRA, message);
        setResult(MainActivity.REQUEST_CODE, data);
        finish();
    }
}
