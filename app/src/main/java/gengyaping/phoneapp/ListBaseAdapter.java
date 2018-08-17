package gengyaping.phoneapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ListBaseAdapter extends BaseAdapter {

    private Context context ;
    private List<AppInfo> list = new ArrayList<>();


    public ListBaseAdapter(Context context) {
        this.context=context;
    }
    public  void Addlist( List<AppInfo> list){
        this.list.addAll(list);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder myHolder ;
        if(convertView==null){
            myHolder = new MyHolder();
            convertView = View.inflate(context, R.layout.phone_list_item, null);
            myHolder.appicon = (ImageView) convertView.findViewById(R.id.appicon);
            myHolder.appname = (TextView) convertView.findViewById(R.id.appname);
            myHolder.appversion = (TextView) convertView.findViewById(R.id.appversion);
            convertView.setTag(myHolder);
        }else {
            myHolder = (MyHolder) convertView.getTag();
        }
        myHolder.appicon.setImageDrawable(list.get(position).appIcon);
        myHolder.appname.setText(list.get(position).appName);
        myHolder.appversion.setText(list.get(position).versionName);
        return convertView;
    }

    public class MyHolder{
        ImageView appicon;
        TextView appname;
        TextView appversion;
    }
}
