package com.example.jialebao02.jialebao_ms_informalversion.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 陶聪 on 2016-08-22.
 */
public class ToastUtil {
    private static Toast toast=null;

    public  static  void show(Context context,String msg){
        if(toast!=null){
            toast.setText(msg);
        }else {
            toast=Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        }
        toast.show();
    }


}
