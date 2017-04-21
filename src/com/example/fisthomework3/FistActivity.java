package com.example.fisthomework3;

import java.io.File;
import java.io.FileOutputStream;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FistActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fist);
	
		
	}



public void storge(View v){
	
	 Toast.makeText(this,"保存成功！",0).show();
	
	
}



public void zhuce(View v){
	
	EditText ed1=(EditText) findViewById(R.id.ed1);
	EditText ed2=(EditText) findViewById(R.id.ed2);
	EditText ed3=(EditText) findViewById(R.id.ed3);
	EditText ed4=(EditText) findViewById(R.id.et4);
	
	String name=ed1.getText().toString();
    String paw=ed2.getText().toString();
	String date=ed3.getText().toString();
	String paw2=ed4.getText().toString();
	

	if(TextUtils.isEmpty(name)||TextUtils.isEmpty(paw))
	{
		Toast.makeText(this, "信息填写不完整，请继续填写！", 1).show();
		
	}
	else if(!paw.equals(paw2)){
		Toast.makeText(this, "两次密码不一致，请重新填写！", 1).show();
	}
	
	else{
		
		File file=new File(getFilesDir(),"Date.txt");
		
		try{
		
			FileOutputStream fileOutputStream=new FileOutputStream(file);
		    fileOutputStream.write((name+"&&"+paw).getBytes());
		    fileOutputStream.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	Toast.makeText(this, "注册成功 正在返回登陆！", 0).show();
	

	
	Intent intent=new Intent();
	intent.setClass(this, MainActivity.class);
	this.startActivity(intent);
	}
}
}
