package com.example.rudresh.tester;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rudresh on 03-08-2018.
 */

public class Test_basic_apps_uninstallable {
    static String[] uninstallable_ba=new String[8];
    static int i=0;
    static List<ApplicationInfo> basic_packages=new ArrayList<>();

    static void test_basic_apps_uninstallable(Activity a,String package_names[], List<ApplicationInfo> all_packages, Button indicator_basic_apps_uninstallable){
    int count_non_uninstallable_ba=0;

        for(int i=0;i<8;i++) {
            for (ApplicationInfo packageInfo : all_packages) {

                if (package_names[i].equals(packageInfo.packageName)) {
                    basic_packages.add(packageInfo);
                }
            }
        }

        for(ApplicationInfo pinfo : basic_packages){

            if((ApplicationInfo.FLAG_SYSTEM & pinfo.flags)!=0 & (ApplicationInfo.FLAG_UPDATED_SYSTEM_APP & pinfo.FLAG_UPDATED_SYSTEM_APP)!=0){
                count_non_uninstallable_ba++;
            }
            else{
                uninstallable_ba[i]=pinfo.packageName;
                i++;
            }
        }

        if(count_non_uninstallable_ba==8){
            indicator_basic_apps_uninstallable.setBackgroundResource(R.drawable.test_ok);
        }
        else{
            indicator_basic_apps_uninstallable.setBackgroundResource(R.drawable.test_fail);
        }
    }
}
