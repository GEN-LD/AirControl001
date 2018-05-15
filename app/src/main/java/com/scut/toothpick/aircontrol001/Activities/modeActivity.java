package com.scut.toothpick.aircontrol001.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.scut.toothpick.aircontrol001.R;
import com.scut.toothpick.aircontrol001.Adapter.ModeAdapter;
import com.scut.toothpick.aircontrol001.other.modeControl;

import java.util.ArrayList;
import java.util.List;

public class modeActivity extends AppCompatActivity {

    private List<modeControl> modeControlList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);
        initMode();
        ModeAdapter modeAdapter = new ModeAdapter(modeActivity.this,R.layout.mode_item,modeControlList);
        ListView listView = (ListView)findViewById(R.id.modeList);
        listView.setAdapter(modeAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                modeControl selectMode = modeControlList.get(i);
                Toast.makeText(modeActivity.this,"点击了 "+selectMode.getModeName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initMode() {
        modeControl noon = new modeControl("午休",11,0,13,20);
        modeControlList.add(noon);
        modeControl sleep = new modeControl("睡觉",21,15,7,20);
        modeControlList.add(sleep);
        modeControl outside = new modeControl("外出",15,45,18,35);
        modeControlList.add(outside);
    }
}
