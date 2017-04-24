package com.example.fisthomework3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.chat.ExpandableList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;
import come.example.fireedittext.FireworkView;


@SuppressLint("CutPasteId")
public class MainActivity extends Activity implements OnClickListener {
	
    private ImageView select;
    private PopupWindow pw;
    private int width, i;
    private LinearLayout parent, option;
    private EditText et_user, et_pwd;
    private ListView listView;
    private Button login;
    private CheckBox checkBox;
    private SharedPreferences sPreferences;
    private Map<String, String> map;

    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  
        
        
 
  
        init();
    }
 
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
        case R.id.select:
            //Ϊʲôx������ƫ�Ʋ��ˣ�������ȡ��ʱ�Ϳ��ԣ����˿��Խ�������
            pw.showAsDropDown(parent, 15, -4);
            break;
        case R.id.login:
            login();
            break;
        }
    }
 
    @SuppressWarnings({ "deprecation", "unchecked" })
	private void init() {
 
         
        et_user = (EditText) findViewById(R.id.et_user);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        parent = (LinearLayout) findViewById(R.id.llayout);
 
        select = (ImageView) findViewById(R.id.select);
        login = (Button) findViewById(R.id.login);
        checkBox = (CheckBox) findViewById(R.id.checkBox1);
 
       
        FireworkView mFireworkView=(FireworkView) findViewById(R.id.fire_work);
        mFireworkView.bindEditText( et_user);
         
        select.setOnClickListener(this);
        login.setOnClickListener(this);
         
        //��ȡ�Ѿ���ס���û���������
        sPreferences = getSharedPreferences("session", MODE_PRIVATE);
        map = (Map<String, String>) sPreferences.getAll();
        List<String> list = new ArrayList<String>();
 
        for (int i = 0; i < (map.size()/2); i++) {
            String name = sPreferences.getString("name" + i, "");
            list.add(name);
        }
         
 
        // ��4��������ָ�����ĸ�listview�е�textview
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.items, R.id.item, list);
        option = (LinearLayout) getLayoutInflater().inflate(R.layout.option,
                null);
        // Ҫ�����linearLayout������listView......
        listView = (ListView) option.findViewById(R.id.op);
        listView.setAdapter(adapter);
 
         
 
        //��ȡ��Ļ�Ŀ�Ȳ�����popupwindow�Ŀ��Ϊwidth,�������Ǹ��ݲ��ֿؼ���ռ��Ȩ��
        WindowManager wManager = (WindowManager) getSystemService(this.WINDOW_SERVICE);
        width = wManager.getDefaultDisplay().getWidth()*9/10;
 
         
        //ʵ����һ��popupwindow����
        pw = new PopupWindow(option, width, LayoutParams.WRAP_CONTENT, true);
        ColorDrawable dw = new ColorDrawable(00000);
        pw.setBackgroundDrawable(dw);
        pw.setOutsideTouchable(true);
 
        listView.setOnItemClickListener(new OnItemClickListener() {
 
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                    int position, long id) {
 
                // ��ȡѡ�������ݼ���sharePreferences�л�ȡ��Ӧ������
                String username = adapterView.getItemAtPosition(position)
                        .toString();
                String pwd = sPreferences.getString("pwd" + position, "");
 
                et_user.setText(username);
                et_pwd.setText(pwd);
 
                // ѡ���popupwindow�Զ���ʧ
                pw.dismiss();
            }
 
        });
    }
 
    private void login() {
 
        // ���ǵڶ��δ����ʱ����map��size����i,���ǲ���,��iֻҪʵ��i++
        if (i == 0) {
            i = map.size()/2;
        }
 
        // ���й�ѡ��ס���򱣴�
        if (checkBox.isChecked()) {
            String name = et_user.getText().toString().trim();
            String pwd = et_pwd.getText().toString().trim();
            if (!"".equals(name) && !"".equals(pwd)) {
 
                sPreferences.edit().putString("name" + i, name)
                        .putString("pwd" + i, pwd).commit();
                i++;
                 
                Toast.makeText(this,"�û����������Ѿ���ס���´ν������ʱ����Ч��",0).show();
 
            }
        }
 
        Intent intent=new Intent();
		intent.setClass(this, ExpandableList.class);
		startActivity(intent);
    }
    
    
    
    
    public void zhuce(View v) {
		Intent intent=new Intent();
		intent.setClass(this, FistActivity.class);
		startActivity(intent);
	}
}

























/*import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.security.PublicKey;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		Button bt_zc=(Button) findViewById(R.id.button1);
		Button bt_sj=(Button) findViewById(R.id.button2);
		
		readCache();
		
		bt_zc.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, FistActivity.class);
				MainActivity.this.startActivity(intent);
			
			}
		
		});
		
		
		bt_sj.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, SecondActivity.class);
				MainActivity.this.startActivity(intent);
			}
		}
		
				
				);
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	public void readCache(){
		
		
		
		File file=new File(getCacheDir(),"denglu.txt");
		if(file.exists()){
		try{
		
		FileInputStream fileIntputStream=new FileInputStream(file);
		  BufferedReader bReader=new BufferedReader(new InputStreamReader(fileIntputStream));
		  
		    
		    String text=bReader.readLine();
		    String str[]=text.split("&&");
		    
		    EditText name1=(EditText) findViewById(R.id.name);
			EditText paw1=(EditText) findViewById(R.id.paw);
			
			name1.setText(str[0]);
			paw1.setText(str[1]);
			CheckBox cb=(CheckBox) findViewById(R.id.cb);
			cb.setActivated(true);
			
			
		   
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}
		
	}
	
	
	
	public void logi(View v){
		
		
	EditText name1=(EditText) findViewById(R.id.name);
	EditText paw1=(EditText) findViewById(R.id.paw);
	CheckBox cb=(CheckBox) findViewById(R.id.cb);
	
	String name=name1.getText().toString();
	String paw=paw1.getText().toString();
	
	
	
	
	File file=new File(getFilesDir(),"Date.txt");
	
	if (TextUtils.isEmpty(name)||TextUtils.isEmpty(paw)) {
		Toast.makeText(this, "�û��������벻��Ϊ��", 0).show();
	}
	else if(file.exists()){
	try{
	
	FileInputStream fileIntputStream=new FileInputStream(file);
	  BufferedReader bReader=new BufferedReader(new InputStreamReader(fileIntputStream));
	  
	    
	    String text=bReader.readLine();
	    String str[]=text.split("&&");
	
		
		
		if (name.equals(str[0])&&paw.equals(str[1])) {
			Toast.makeText(this, "��½�ɹ�", 0).show();
			//�����ס����
			if (cb.isChecked()) {
				
			
			File file2=new File(getCacheDir(),"denglu.txt");
			
			try{
			
				FileOutputStream fileOutputStream=new FileOutputStream(file2);
			    fileOutputStream.write((name+"&&"+paw).getBytes());
			    fileOutputStream.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}}
			
			Intent intent=new Intent();
			intent.setClass(this, MenuActivity.class);
			startActivity(intent);
			
		}
		else{
			Toast.makeText(this, "�˻������������", 0).show();
		}
		
	   
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
		
		
	}
	else{
		Toast.makeText(this, "�˻������ڣ���ע��", 0).show();
	}
	
	}
}
	*/
	
	
	
	
	
	
	
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


