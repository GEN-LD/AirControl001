package com.scut.toothpick.aircontrol001.other;

/**
 * Created by dgliang on 2018/5/11.
 */

public class SettingItem {
    private String settingName;

    public SettingItem(String name){
        settingName = name;
    }
    public String getName(){
        return settingName;
    }
}
