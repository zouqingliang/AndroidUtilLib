package com.siberiadante.util;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.siberiadante.SiberiaDanteLib;
import com.siberiadante.exception.SiberiaDanteLibException;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by SiberiaDante on 2017/5/4.
 */

public class ToastUtil {
    private static Toast toast;
    private static List<Toast> toastList = new ArrayList<>();

    public ToastUtil() {
        new SiberiaDanteLibException();
    }

    /**
     * 吐司文本内容
     * 单例模式,吐司时间长
     *
     * @param content 吐司内容
     */
    public static void showSingletonLong(String content) {
        if (toast == null) {
            toast = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_LONG);
        }
        toast.setText(content);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * 吐司文本内容
     * 单例模式，吐司时间短
     *
     * @param content 吐司内容
     */
    public static void showSingletonShort(String content) {
        if (toast == null) {
            toast = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_SHORT);
        }
        toast.setText(content);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * 吐司文本内容
     * 非单例模式,吐司时间短
     *
     * @param content 吐司内容
     */
    public static void showTextShort(String content) {
        toast = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_LONG);
        toastList.add(toast);
        toast.setText(content);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * 吐司文本内容
     * 非单例模式,吐司时间短
     *
     * @param content 吐司内容
     */
    public static void showTextLong(String content) {
        toast = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_LONG);
        toastList.add(toast);
        toast.setText(content);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }

    /**
     * 吐司文本内容 自定义位置、时间
     * 单例模式
     *
     * @param content 吐司内容
     * @param duration 显示的时间
     * @param position 显示的位置
     */
    public static void showSingletonText(String content,int duration,int position ) {
        if (toast == null) {
            toast = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_LONG);
        }
        toast.setText(content);
        toast.setDuration(duration);
        toast.setGravity(position, 0, 0);
        toast.show();
    }

    /**
     * Toast 无背景透明的文本
     * @param content 内容
     * @param duration 时长
     * @param position 位置
     */
    public static void showSNBacText(String content, int duration, int position) {
        if (toast == null) {
            toast = new Toast(SiberiaDanteLib.getContext());
        }
        LinearLayout linearLayout = new LinearLayout(SiberiaDanteLib.getContext());//创建线性布局
        linearLayout.setOrientation(LinearLayout.VERTICAL);//设置布局垂直
        TextView textView = new TextView(SiberiaDanteLib.getContext());
        textView.setText(content);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        toast.setDuration(duration);
        toast.setGravity(position, 0, 0);
        toast.show();

    }


    /**
     * Toast图片
     * 单例模式，自定义时间
     *
     * @param resId    图片资源ID
     * @param duration Toast.LENGTH_LONG/Toast.LENGTH_LONG
     */
    public static void showSingletonImageCenter(int resId, int duration) {
        if (toast == null) {
            toast = new Toast(SiberiaDanteLib.getContext());
        }
        ImageView imageView = new ImageView(SiberiaDanteLib.getContext());
        imageView.setImageResource(resId);
        toast.setView(imageView);
        toast.setDuration(duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * Toast图片
     * 非单例模式，自定义时间
     *
     * @param resId    图片资源ID
     * @param duration Toast.LENGTH_LONG/Toast.LENGTH_LONG
     */
    public static void showImageCenter(int resId, int duration) {
        toast = new Toast(SiberiaDanteLib.getContext());
        toastList.add(toast);
        ImageView imageView = new ImageView(SiberiaDanteLib.getContext());//创建图片控件
        imageView.setImageResource(resId);//给控件设置图片
        toast.setView(imageView);//把图片绑定到Toast上
        toast.setDuration(duration);//Toast显示的时间;
        //设置图片显示的位置：三个参数
        //第一个：位置，可以用|添加并列位置，第二个：相对于X的偏移量，第三个：相对于Y轴的偏移量
        //注意一点：第二和第三个参数是相对于第一个参数设定的位置偏移的
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();//显示Toast
    }

    /**
     * Toast图片
     * 单例模式，自定义时间,自定义位置
     *
     * @param resId    图片资源ID
     * @param duration Toast.LENGTH_LONG/Toast.LENGTH_LONG
     * @param position Gravity.LEFT,Gravity.BOTTOM | Gravity.RIGHT...多个位置用竖线分割
     */
    public static void showSingletonImage(int resId, int duration, int position) {
        if (toast == null) {
            toast = new Toast(SiberiaDanteLib.getContext());
        }
        ImageView imageView = new ImageView(SiberiaDanteLib.getContext());//创建图片控件
        imageView.setImageResource(resId);
        toast.setView(imageView);
        toast.setDuration(duration);
        toast.setGravity(position, 0, 0);
        toast.show();
    }

    /**
     * Toast图片
     * 非单例模式，自定义时间,自定义位置
     *
     * @param resId    图片资源ID
     * @param duration Toast.LENGTH_LONG/Toast.LENGTH_LONG
     * @param position Gravity.LEFT,Gravity.BOTTOM | Gravity.RIGHT...多个位置用竖线分割
     */
    public static void showImage(int resId, int duration, int position) {
        toast = new Toast(SiberiaDanteLib.getContext());
        toastList.add(toast);
        ImageView imageView = new ImageView(SiberiaDanteLib.getContext());//创建图片控件
        imageView.setImageResource(resId);
        toast.setView(imageView);
        toast.setDuration(duration);
        toast.setGravity(position, 0, 0);
        toast.show();
    }

    /**
     * Toast图片
     * 非单例模式，自定义时间,自定义位置
     *
     * @param bitmap   图片资源ID
     * @param duration Toast.LENGTH_LONG/Toast.LENGTH_LONG
     * @param position Gravity.LEFT,Gravity.BOTTOM | Gravity.RIGHT...多个位置用竖线分割
     */
    public static void showImage(Bitmap bitmap, int duration, int position) {
        toast = Toast.makeText(SiberiaDanteLib.getContext(), "", duration);
        toastList.add(toast);
        ImageView imageView = new ImageView(SiberiaDanteLib.getContext());//创建图片控件
        imageView.setImageBitmap(bitmap);
        toast.setView(imageView);
        toast.setDuration(duration);
        toast.setGravity(position, 0, 0);
        toast.show();
    }

    /**
     * 自定义显示图文结合的Toast
     * 非单例
     *
     * @param resId    图片id
     * @param content  文本内容
     * @param duration toast时长
     * @param position toast位置
     */
    public static void showIT(int resId, String content, int duration, int position) {
        toast = new Toast(SiberiaDanteLib.getContext());
        toastList.add(toast);
        LinearLayout linearLayout = new LinearLayout(SiberiaDanteLib.getContext());//创建线性布局
        linearLayout.setOrientation(LinearLayout.VERTICAL);//设置布局垂直
        ImageView imageView = new ImageView(SiberiaDanteLib.getContext());//创建图片控件
        imageView.setImageResource(resId);//给控件设置图片
        TextView textView = new TextView(SiberiaDanteLib.getContext());//创建文本控件
        textView.setText(content);//设置文本内容
        linearLayout.addView(imageView);//添加图片控件到布局中
        linearLayout.addView(textView);//添加文本控件到布局中。注意添加顺序会影响图片在前还是为本在前
        toast.setView(linearLayout);//把布局绑定到Toast上
        toast.setDuration(duration);//Toast显示的时间;
        /**
         * position：显示位置
         * 第二个参数：相对X的偏移量
         * 第三个参数：相对Y的偏移量
         * 第二和第三个参数是相对于第一个参数设定的位置偏移的
         */
        toast.setGravity(position, 0, 0);
        toast.show();//显示Toast
    }

    /**
     * 自定义显示图文结合的Toast
     * 单例
     *
     * @param resId    图片id
     * @param content  文本内容
     * @param duration toast时长
     * @param position toast位置
     */
    public static void showITSingleton(int resId, String content, int duration, int position) {
        if (toast == null) {
            toast = new Toast(SiberiaDanteLib.getContext());
        }
        LinearLayout linearLayout = new LinearLayout(SiberiaDanteLib.getContext());//创建线性布局
        linearLayout.setOrientation(LinearLayout.VERTICAL);//设置布局垂直
        ImageView imageView = new ImageView(SiberiaDanteLib.getContext());//创建图片控件
        imageView.setImageResource(resId);//给控件设置图片
        TextView textView = new TextView(SiberiaDanteLib.getContext());//创建文本控件
        textView.setText(content);//设置文本内容
        linearLayout.addView(imageView);//添加图片控件到布局中
        linearLayout.addView(textView);//添加文本控件到布局中。注意添加顺序会影响图片在前还是为本在前
        toast.setView(linearLayout);//把布局绑定到Toast上
        toast.setDuration(duration);//Toast显示的时间;
        /**
         * position：显示位置
         * 第二个参数：相对X的偏移量
         * 第三个参数：相对Y的偏移量
         * 第二和第三个参数是相对于第一个参数设定的位置偏移的
         */
        toast.setGravity(position, 0, 0);
        toast.show();//显示Toast
    }


    /**
     * Toast 多行文本 非单例
     *
     * @param size     字体大小
     * @param contents list 形式的文本内容
     */
    public static void showLines(List<String> contents, int size) {
        toast = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_LONG);
        toastList.add(toast);
        LinearLayout linearLayoutTop = new LinearLayout(SiberiaDanteLib.getContext());//创建线性布局
        linearLayoutTop.setOrientation(LinearLayout.VERTICAL);//设置布局垂直
        for (int i = 0; i < contents.size(); i++) {
            TextView textView = new TextView(SiberiaDanteLib.getContext());
            textView.setText(contents.get(i));
            textView.setTextSize(size);
            linearLayoutTop.addView(textView);
        }
        toast.setView(linearLayoutTop);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }


    /**
     * Toast 多行文本 单例
     *
     * @param size     字体大小
     * @param contents list 形式的文本内容
     */
    public static void showSingletonLines(List<String> contents, int size) {
        if (toast == null) {
            toast = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_LONG);
        }
        toastList.add(toast);
        LinearLayout linearLayoutTop = new LinearLayout(SiberiaDanteLib.getContext());//创建线性布局
        linearLayoutTop.setOrientation(LinearLayout.VERTICAL);//设置布局垂直
        for (int i = 0; i < contents.size(); i++) {
            TextView textView = new TextView(SiberiaDanteLib.getContext());
            textView.setText(contents.get(i));
            textView.setTextSize(size);
            linearLayoutTop.addView(textView);
        }
        toast.setView(linearLayoutTop);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }

    /**
     * Toast 自定义布局 非单例
     *
     * @param view     布局
     * @param duration 时长
     * @param position 位置
     */
    public static void showLayout(View view, int duration, int position) {
        toast = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_LONG);
        toast.setDuration(duration);
        toast.setGravity(position, 0, 0);
        toast.setView(view);
        toast.show();

    }

    /**
     * Toast 自定义布局 单例
     *
     * @param view     布局
     * @param duration 时长
     * @param position 位置
     */
    public static void showSingletonLayout(View view, int duration, int position) {
        if (toast == null) {
            toast = Toast.makeText(SiberiaDanteLib.getContext(), "", Toast.LENGTH_LONG);
        }
        toast.setDuration(duration);
        toast.setGravity(position, 0, 0);
        toast.setView(view);
        toast.show();

    }
    /**
     * 异步线程下载图片并Toast
     * @param url
     */
    public static void showThread(String url) {
        final String mUrl=url;
        Observable.create(new ObservableOnSubscribe<Bitmap>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Bitmap> e) throws Exception {
                URL url = new URL(mUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(8000);
                connection.setReadTimeout(8000);
                InputStream inputStream = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                e.onNext(bitmap);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Bitmap>() {
                    @Override
                    public void accept(@NonNull Bitmap bitmap) throws Exception {
                        ToastUtil.showImage(bitmap, Toast.LENGTH_LONG, Gravity.CENTER);
                    }
                });
    }



    public static void cancel() {
        if (toast != null) {
            toast.cancel();
        }
    }

    public static void cancelAll() {
        for (int i = 0; i < toastList.size(); i++) {
            if (toastList.get(i) != null) {
                toastList.get(i).cancel();
            }
        }
    }

}
