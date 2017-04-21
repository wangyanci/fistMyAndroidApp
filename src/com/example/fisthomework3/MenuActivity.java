package com.example.fisthomework3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;


import com.example.swipmemulistview.SlideAdapter;
import com.example.swipmemulistview.SlideListView;

import android.R.anim;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


/*
 * ArrayAdapter实现单个文本域listview、
 */


/*public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
	
		
		ListView lv=(ListView) findViewById(R.id.lv);
		lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getDate()));
		
	}

	private List<String>  getDate() {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>() ;
		
		for(int i=0;i<50;i++){
			list.add("测试数据"+i);
		}
		
		
		
		return list;
		
	}}*/






/*public class MyAdapter extends BaseAdapter{

	
	
	public MyAdapter() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		return null;
	}
	
}*/




/*
 * SimpleAdapter实现listview
 */


/*public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		;
		
		ListView lv=(ListView) findViewById(R.id.lv);
		lv.setAdapter(new SimpleAdapter(this,getDate(),R.layout.items,new String[]{"name","paw","pc"},new int[]{R.id.name,R.id.paw,R.id.pc}));
		
	}

	private List<Map<String,Object>>  getDate() {
		// TODO Auto-generated method stub
			List<Map<String,Object>> list= new ArrayList<Map<String,Object>> () ;
			Map<String,Object> map;
			
		
		for(int i=0;i<50;i++){
		 map=new HashMap<String, Object>();
		 map.put("name","职员"+i);
		 map.put("paw","今天天气真好"+i);
		 map.put("pc",R.drawable.p1);
		 list.add(map);
		 
		}
		
		
		
		return list;
		
	}}*/


public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
	SlideListView slideListView = (SlideListView) findViewById(R.id.lv);
	SlideAdapter adapter=new SlideAdapter(this,getDate());
	slideListView .setAdapter(adapter);
	
	}

	private List<Map<String,Object>>  getDate() {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list= new ArrayList<Map<String,Object>> () ;
		Map<String,Object> map;
		
		for(int i=0;i<50;i++){
			 map=new HashMap<String, Object>();
			 map.put("name","杭州电子科技大学路人"+i);
			 map.put("qianming","今天天气真好"+i);
			 
			 switch(i%6){
			 case 0:
				 map.put("pc",R.drawable.p1);
				 break;
			 case 1:
				 map.put("pc",R.drawable.p2);
				 break;
			 case 2:
				 map.put("pc",R.drawable.p3);
				 break;
			 case 3:
				 map.put("pc",R.drawable.p4);
				 break;
			 case 4:
				 map.put("pc",R.drawable.p5);
				 break;
			 case 5:
				 map.put("pc",R.drawable.p6);
				 break;
			 }
			 list.add(map);
			}
		return list;
	}
}
	
