package com.scut.toothpick.aircontrol001.other;

/**
 * Created by dgliang on 2018/5/11.
 */

public class modeControl {
    private String modeName;

    private int startHour;
    private int startMin;
    private int endHour;
    private int endMin;

    public modeControl(String mName,int sHour,int sMin,int eHour,int eMin) {
        modeName = mName;
        startHour = sHour;
        startMin = sMin;
        endHour = eHour;
        endMin = eMin;
    }
    public String getModeName() {
        return modeName;
    }

    public String getStartTime() {
        return getMoreZero(startHour)+":"+getMoreZero(startMin);
    }
    public String getEndTime() {
        return getMoreZero(endHour)+":"+getMoreZero(endMin);
    }

    public String getAllShow() {
        return getMoreZero(startHour)+":"+getMoreZero(startMin)+" ~ "+getMoreZero(endHour)+":"+getMoreZero(endMin);
    }
    //时、分都用两位显示，不足两位补零
    public String getMoreZero(int num) {
        String vtr = String.valueOf(num);
        if(vtr.length() == 1) {
            return "0"+vtr;
        } else {
            return vtr;
        }
    }
}
