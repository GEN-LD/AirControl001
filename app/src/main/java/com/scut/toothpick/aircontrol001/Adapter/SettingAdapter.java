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
import com.scut.toothpick.aircontrol001.other.SettingItem;

import java.util.List;

/**
 * Created by dgliang on 2018/5/11.
 */

public class SettingAdapter extends ArrayAdapter<SettingItem> {

    private int resourceId;

    public SettingAdapter(Context context, int textViewResourceId, List<SettingItem> objects) {
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        SettingItem settingItem = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView settingText = (TextView)view.findViewById(R.id.setting_item_name);
        settingText.setText(settingItem.getName());
        return view;
    }
}
