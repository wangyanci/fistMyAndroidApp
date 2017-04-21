package com.example.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.fisthomework3.R;
import com.example.swipmemulistview.SlideAdapter;
import com.example.swipmemulistview.SlideListView;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class ChatActivity extends TabActivity{
	
	@SuppressWarnings("deprecation")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
	
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		
		TabHost tabHost=getTabHost();
		
		
		TabSpec tab1=tabHost.newTabSpec("tab1").setIndicator("聊天").setContent(R.id.tab01);
		tabHost.addTab(tab1);
		
		TabSpec tab2=tabHost.newTabSpec("tab2").setIndicator("联系人").setContent(R.id.tab03);
		tabHost.addTab(tab2);
		
		TabSpec tab3=tabHost.newTabSpec("tab3").setIndicator("空间").setContent(R.id.tab03);
		tabHost.addTab(tab3);
		
		
		
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
