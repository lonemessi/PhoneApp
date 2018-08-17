package gengyaping.phoneapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView mlistView;
    private Presenter presenter;
    private ListBaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initPresenter();
        initList();

    }

    private void initList() {
        adapter = new ListBaseAdapter(this);
        mlistView.setAdapter(adapter);
        adapter.Addlist(presenter.appList);

    }

    private void initPresenter() {
        presenter = new Presenter();
    }

    private void initView() {
        mlistView = (ListView) findViewById(R.id.lv);
    }



    public class AppReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_PACKAGE_ADDED)) {
                String packageName = intent.getDataString();
                AppInfo appInfo = new AppInfo();
                appInfo.appName = packageName;
                presenter.appList.add(appInfo);
                adapter.notifyDataSetChanged();
            }

            if (intent.getAction().equals(Intent.ACTION_PACKAGE_REMOVED)) {
                String packageName = intent.getDataString();
                for (int i =0;i<=presenter.appList.size();i++){
                    if (presenter.appList.get(i).packageName==packageName){
                        presenter.appList.remove(i);
                        adapter.notifyDataSetChanged();
                    }
                }

            }

        }
    }

}
