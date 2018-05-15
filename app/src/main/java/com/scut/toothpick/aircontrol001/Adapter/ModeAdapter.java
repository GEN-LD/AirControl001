package com.scut.toothpick.aircontrol001.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.scut.toothpick.aircontrol001.R;
import com.scut.toothpick.aircontrol001.other.modeControl;

import java.util.List;

/**
 * Created by dgliang on 2018/5/11.
 */
//情景模式适配器
public class ModeAdapter extends ArrayAdapter<modeControl>{
    private int modeId;

    public ModeAdapter(Context context,int modeResourceId,List<modeControl> objects){
        super(context,modeResourceId,objects);
        modeId = modeResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        modeControl mControl = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(modeId,parent,false);
        TextView textView1 = (TextView)view.findViewById(R.id.mode_name);
        TextView textView2 = (TextView)view.findViewById(R.id.mode_time);
        textView1.setText(mControl.getModeName());
        textView2.setText(mControl.getAllShow());
        return view;
    }
}
