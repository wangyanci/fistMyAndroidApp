package com.example.chat;

import com.example.fisthomework3.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class PingfenActivity extends Activity {
	
	public int picture;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pingfen);
		
		
		
		
Intent intent=getIntent();
		
		 picture=intent.getIntExtra("picture", R.drawable.bc);
		ImageView imageView=(ImageView) findViewById(R.id.iv4);
		imageView.setImageResource(picture);
		
		
		
		
		Button button=(Button) findViewById(R.id.bt);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText editText=(EditText) findViewById(R.id.ed9);
				String pingfen=editText.getText().toString();
				Intent date=new Intent();
				date .putExtra("pingfen", pingfen);

				if(picture==R.drawable.p1){
				setResult(777, date);
				finish();
				}
					

				else if(picture==R.drawable.p2){
				setResult(888, date);
				finish();
				}

				else if(picture==R.drawable.p3){
				setResult(999, date);
				finish();
				}
				
			}
		});
		
		
	
		}
		




}