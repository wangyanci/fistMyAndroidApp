package com.example.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.fisthomework3.R;

import com.example.swipmemulistview.SlideAdapter;
import com.example.swipmemulistview.SlideListView;

import android.app.Activity;
import android.app.TabActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;


public class ExpandableList extends  TabActivity{
	
	@SuppressWarnings("deprecation")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
	
final TabHost tabHost=getTabHost();
		
		
		TabSpec tab1=tabHost.newTabSpec("tab1").setIndicator("聊天").setContent(R.id.lv);
		tabHost.addTab(tab1);
		
		TabSpec tab2=tabHost.newTabSpec("tab2").setIndicator("联系人").setContent(R.id.expandableListview);
		tabHost.addTab(tab2);
		
		TabSpec tab3=tabHost.newTabSpec("tab3").setIndicator("空间").setContent(R.id.tab03);
		tabHost.addTab(tab3);
		
		
		
		SlideListView slideListView = (SlideListView) findViewById(R.id.lv);
		SlideAdapter adapter=new SlideAdapter(this,getDate());
		slideListView .setAdapter(adapter);
		
		
		
	

		
		
		final ExpandableListAdapter madapter = new BaseExpandableListAdapter() {  
            //设置组视图的图片  
//            int[] logos = new int[] { R.drawable.wei, R.drawable.shu,R.drawable.wu};  
            //设置组视图的显示文字  
            private String[] generalsTypes = new String[] { "魏", "蜀", "吴" };  
            //子视图显示文字  
            private String[][] generals = new String[][] {  
                    { "夏侯惇", "甄姬", "许褚", "郭嘉", "司马懿", "杨修" },  
                    { "马超", "张飞", "刘备", "诸葛亮", "黄月英", "赵云" },  
                    { "吕蒙", "陆逊", "孙权", "周瑜", "孙尚香" }
            };
		
		
                    TextView getTextView() {  
                        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(  
                                ViewGroup.LayoutParams.FILL_PARENT, 64);  
                        TextView textView = new TextView(  
                                ExpandableList.this);  
                        textView.setLayoutParams(lp);  
                        textView.setGravity(Gravity.CENTER_VERTICAL);  
                        textView.setPadding(36, 0, 0, 0);  
                        textView.setTextSize(20);  
                        textView.setTextColor(Color.BLACK);  
                        return textView;  
                    }  
          
                      
                    //重写ExpandableListAdapter中的各个方法  
                    @Override  
                    public int getGroupCount() {  
                        // TODO Auto-generated method stub  
                        return generalsTypes.length;  
                    }  
          
                    @Override  
                    public Object getGroup(int groupPosition) {  
                        // TODO Auto-generated method stub  
                        return generalsTypes[groupPosition];  
                    }  
          
                    @Override  
                    public long getGroupId(int groupPosition) {  
                        // TODO Auto-generated method stub  
                        return groupPosition;  
                    }  
          
                    @Override  
                    public int getChildrenCount(int groupPosition) {  
                        // TODO Auto-generated method stub  
                        return generals[groupPosition].length;  
                    }  
          
                    @Override  
                    public Object getChild(int groupPosition, int childPosition) {  
                        // TODO Auto-generated method stub  
                        return generals[groupPosition][childPosition];  
                    }  
          
                    @Override  
                    public long getChildId(int groupPosition, int childPosition) {  
                        // TODO Auto-generated method stub  
                        return childPosition;  
                    }  
          
                    @Override  
                    public boolean hasStableIds() {  
                        // TODO Auto-generated method stub  
                        return true;  
                    }  
          
                    @Override  
                    public View getGroupView(int groupPosition, boolean isExpanded,  
                            View convertView, ViewGroup parent) {  
                        // TODO Auto-generated method stub  
                        LinearLayout ll = new LinearLayout(  
                                ExpandableList.this);  
                        ll.setOrientation(0);  
//                        ImageView logo = new ImageView(ExpandableList.this);  
//                        logo.setImageResource(logos[groupPosition]);  
//                        logo.setPadding(50, 0, 0, 0);  
//                        ll.addView(logo);  
                        TextView textView = getTextView();  
                        textView.setTextColor(Color.BLACK);  
                        textView.setText(getGroup(groupPosition).toString());  
                        ll.addView(textView);  
          
                        return ll;  
                    }  
          
                    @Override  
                    public View getChildView(int groupPosition, int childPosition,  
                            boolean isLastChild, View convertView, ViewGroup parent) {  
                        // TODO Auto-generated method stub  
                        LinearLayout ll = new LinearLayout(  
                                ExpandableList.this);  
                        ll.setOrientation(0);  
//                        ImageView generallogo = new ImageView(  
//                                ExpandableList.this);  
//                        generallogo  
//                                .setImageResource(generallogos[groupPosition][childPosition]);  
//                        ll.addView(generallogo);  
                        TextView textView = getTextView();  
                        textView.setText(getChild(groupPosition, childPosition)  
                                .toString());  
                        ll.addView(textView);  
                        return ll;  
                    }  
          
                    @Override  
                    public boolean isChildSelectable(int groupPosition,  
                            int childPosition) {  
                        // TODO Auto-generated method stub  
                        return true;  
                    }  
          
                };  
          
                ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandableListview );  
                expandableListView.setAdapter(madapter);  
                  
                  
                //设置item点击的监听器  
                expandableListView.setOnChildClickListener(new OnChildClickListener() {  
          
                    @Override  
                    public boolean onChildClick(ExpandableListView parent, View v,  
                            int groupPosition, int childPosition, long id) {  
          
                        Toast.makeText(  
                                ExpandableList.this,  
                                "你点击了" + madapter.getChild(groupPosition, childPosition),  
                                Toast.LENGTH_SHORT).show();  
          
                        return false;  
                    }  
                });  
          
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
