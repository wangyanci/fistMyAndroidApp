  
package com.example.swipmemulistview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes.Name;

import com.example.fisthomework3.R;

import android.R.integer;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SlideAdapter extends BaseAdapter implements View.OnClickListener{
  private List<Map<String,Object>>   dataList;
  private Context context;
  private LayoutInflater inflater;
  public SlideAdapter(Context context, List<Map<String,Object>>  dataList ) {
    this.context = context;
    this.dataList = dataList;
    this.inflater=LayoutInflater.from(context);
  }
  @Override
  public int getCount() {
    return dataList.size();
  }
  @Override
  public Object getItem(int position) {
    return getItem(position);
  }
  @Override
  public long getItemId(int position) {
    return position;
  }
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder=null;
    if (convertView==null){
      View content=inflater.inflate(R.layout.adapter_item_content,null);
      View menu=inflater.inflate(R.layout.adapter_item_menu,null);
      holder=new ViewHolder(content,menu);
      SlideItem slideItem=new SlideItem(context);
      slideItem.setContentView(content,menu);
      convertView=slideItem;
      convertView.setTag(holder);
    }else {
      holder= (ViewHolder) convertView.getTag();
    }
    
    
    holder.itemNrTx.setImageResource(Integer.parseInt(dataList.get(position).get("pc").toString()));
    holder.itemNrName.setText((String)dataList.get(position).get("name"));
    holder.itemNrQianming.setText(dataList.get(position).get("qianming").toString());
    
    
    
    holder.itemTvDelete.setOnClickListener(this);
    holder.itemTvNoRead.setOnClickListener(this);
    holder.itemTvToTop.setOnClickListener(this);
    return convertView;
  }
  class ViewHolder{
	  ImageView itemNrTx; 
	  TextView itemNrName;
	  TextView itemNrQianming;
	  
    TextView itemTvToTop;
    TextView itemTvNoRead;
    TextView itemTvDelete;
    public ViewHolder(View center,View menu) {
    	 this.itemNrTx = (ImageView) center.findViewById(R.id.tx);
    	 this.itemNrName = (TextView) center.findViewById(R.id.name);
    	 this.itemNrQianming = (TextView) center.findViewById(R.id.qianming);
    	 
      this.itemTvToTop = (TextView) menu.findViewById(R.id.item_no_read);
      this.itemTvNoRead = (TextView) menu.findViewById(R.id.item_to_top);
      this.itemTvDelete = (TextView) menu.findViewById(R.id.item_delete);
    }
  }
  @Override
  public void onClick(View v) {
    switch (v.getId()){
      case R.id.item_no_read:
    	  
        Toast.makeText(context,"±êÎªÎ´¶Á",Toast.LENGTH_SHORT).show();
        break;
      case R.id.item_to_top:
        Toast.makeText(context,"ÖÃ¶¥ÁË°¾",Toast.LENGTH_SHORT).show();
        break;
      case R.id.item_delete:
        Toast.makeText(context,"É¾³ýÀ²",Toast.LENGTH_SHORT).show();
        break;
    }
  }
}
 