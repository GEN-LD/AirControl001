package com.scut.toothpick.aircontrol001.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.scut.toothpick.aircontrol001.R;
import com.scut.toothpick.aircontrol001.Adapter.SettingAdapter;
import com.scut.toothpick.aircontrol001.other.SettingItem;

import java.util.ArrayList;
import java.util.List;

public class SettingActivity extends AppCompatActivity {

    private List<SettingItem> settingItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initSetting();
        SettingAdapter settingAdapter = new SettingAdapter(SettingActivity.this,R.layout.setting_item,settingItems);
        ListView settingList = (ListView)findViewById(R.id.setting_list);
        settingList.setAdapter(settingAdapter);
        settingList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SettingItem settingItem = settingItems.get(i);
                Toast.makeText(SettingActivity.this,"点击了"+settingItem.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initSetting(){
        SettingItem use = new SettingItem("使用说明");
        settingItems.add(use);
        SettingItem extension = new SettingItem("拓展功能");
        settingItems.add(extension);
        SettingItem habit = new SettingItem("用户习惯");
        settingItems.add(habit);
        SettingItem about = new SettingItem("关于");
        settingItems.add(about);
    }
}
