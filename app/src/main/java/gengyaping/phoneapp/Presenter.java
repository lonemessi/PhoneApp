package gengyaping.phoneapp;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/8/16.
 */

public class Presenter {
    ArrayList<AppInfo> appList = new ArrayList<AppInfo>();
    private List<PackageInfo> packages;

    public Presenter() {
        getApp();
    }

    public void getApp() {
        packages = AppApplication.provideContext().getPackageManager().getInstalledPackages(0);

        for (int i = 0; i < packages.size(); i++) {
            PackageInfo packageInfo = packages.get(i);
            if ((ApplicationInfo.FLAG_SYSTEM & packageInfo.applicationInfo.flags) != 0) {
                continue;
            }
            AppInfo tmpInfo = new AppInfo();
            tmpInfo.appName = packageInfo.applicationInfo.loadLabel(AppApplication.provideContext().getPackageManager()).toString();
            tmpInfo.packageName = packageInfo.packageName;
            tmpInfo.versionName = packageInfo.versionName;
            tmpInfo.versionCode = packageInfo.versionCode;
            tmpInfo.appIcon = packageInfo.applicationInfo.loadIcon(AppApplication.provideContext().getPackageManager());
            appList.add(tmpInfo);
        }
    }

}
