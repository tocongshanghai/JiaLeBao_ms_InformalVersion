package com.example.jialebao02.jialebao_ms_informalversion.util;

import android.app.Activity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 陶聪 on 2016-08-22.
 */
public class CloseActivityUtil {
    private List<Activity> activityList=null;
    private static  CloseActivityUtil instance;

    private  CloseActivityUtil() {
       activityList=new LinkedList<Activity>();
    }

    public static  CloseActivityUtil getInstance(){
        if(null==instance){
            instance=new CloseActivityUtil();
        }
        return instance;
    }


    public  void addActivity(Activity activity){
        if(activityList!=null&&activityList.size()>0){
           if(!activityList.contains(activity)){
               activityList.add(activity);
           }

        }else{
            activityList.add(activity);
        }
    }

    public  void exit(){
        if(null!=activityList&&activityList.size()>0){
            for(Activity activity:activityList){
                activity.finish();
            }
        }
        if(null!=activityList){
            activityList.clear();
        }
    }
}
