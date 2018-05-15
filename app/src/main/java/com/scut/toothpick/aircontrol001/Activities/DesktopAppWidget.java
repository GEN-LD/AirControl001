package com.scut.toothpick.aircontrol001.Activities;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

import com.scut.toothpick.aircontrol001.R;

/**
 * Implementation of App Widget functionality.
 */
public class DesktopAppWidget extends AppWidgetProvider {

    static String onon = "widget.button.on";
    static String offoff = "widget.button.off";
    static int tenp = 25;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

//        CharSequence widgetText = "25";
//        CharSequence widgetText0 = "26℃";
        // Construct the RemoteViews object
        Intent intentx = new Intent(context, MyService.class);
        context.startService(intentx);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.desktop_app_widget);
//        views.setTextViewText(R.id.appwidget_text, widgetText);

        Intent intent = new Intent(context,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,0);
        views.setOnClickPendingIntent(R.id.widget_more,pendingIntent);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Intent intentx = new Intent(context, MyService.class);
        context.startService(intentx);
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.desktop_app_widget);
            Intent intent = new Intent(context,DesktopAppWidget.class);

            PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,0);
            views.setOnClickPendingIntent(R.id.widget_more,pendingIntent);
            Intent intent1 =new Intent();

            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
    //MyService服务程序
    public static class MyService extends Service {

        public void onStart(Intent intent, int startId){
            ComponentName thisWidget = new ComponentName(this, MainActivity.class);
            AppWidgetManager manager = AppWidgetManager.getInstance(this);

            RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.activity_main);
            // 点击按钮时
            if (intent.getAction() != null){
                if (intent.getAction().equals(onon)){
                    tenp++;
                }
            }
            remoteViews.setTextViewText(R.id.appwidget_text, String.valueOf(tenp));
            // 定义一个Intent来发送按钮Action
            Intent prevInten = new Intent();
            prevInten.setAction(onon);
            // 用Intent实例化一个PendingIntent
            PendingIntent Pprevintent=PendingIntent.getService(this, 0,
                    prevInten, 0);
            // 给RemoteView上的Button设置按钮事件
            remoteViews.setOnClickPendingIntent(R.id.jia, Pprevintent);
            manager.updateAppWidget(thisWidget, remoteViews);
        }

        @Override
        public IBinder onBind(Intent arg0) {
            // TODO Auto-generated method stub
            return null;
        }

    }
}

