package com.scut.toothpick.aircontrol001.Entity;

/**
 * Created by dgliang on 2018/5/15.
 */

public class Airconditioner {
    /*
    开关机状态  整数0-1
        -1无效 0关机 1开机
     */
    private int switchStatus;

    /*
    运行模式  整数0-4
        -1无效 0自动 1制热 2除湿 3制冷 4送风
     */
    private int runMode;

    /*
    风扇状态  整数0-4
        -1无效 0自动 1低速 2中速 3高速 4其他
     */
    private int fanStatus;

    //出风温度
    private float outletTem;

    //回风温度
    private float returnTem;

    //光感采样值
    private float ligthSen;

    /*
    人体红外感应 整数0-1
        -1无效 0无人 1有人
     */
    private int body;

    //电流
    private float eleCurrent;

    //电量
    private float electricity;

    /*
    品牌 整数0-N
        -1无效 0美的 1格力 2松下 3大金 4日立 5海尔
     */
    private int brands;

    /*
    空调类型 整数 0-N
        -1无效 0挂式 1柜式
     */
    private int type;

    /*
    通信状态 整数0-1
        -1无效 0通信无效，掉线 1通信有效，在线
     */
    private int communicationStatus;

    //构造函数
    public Airconditioner(int switchStatus,int runMode,int fanStatus,int outletTem,
                          int returnTem,int ligthSen,int body,int eleCurrent,
                          int electricity,int brands,int type,int communicationStatus){

    }

    //get函数
    public int getSwitchStatus(){
        return switchStatus;
    }
    public int getRunMode(){
        return runMode;
    }
    public int getBody() {
        return body;
    }
    public float getFanStatus() {
        return fanStatus;
    }
    public float getOutletTem() {
        return outletTem;
    }
    public float getReturnTem() {
        return returnTem;
    }
    public float getLigthSen() {
        return ligthSen;
    }
    public float getEleCurrent(){
        return eleCurrent;
    }
    public float getElectricity() {
        return electricity;
    }
    public int getBrands() {
        return brands;
    }
    public int getType() {
        return type;
    }
    public int getCommunicationStatus() {
        return communicationStatus;
    }

    //开关机操作
    void setSwitchStatus(){

    }

    /*
    设置运行模式 整数0-4
        0自动 1制热 2除湿 3制冷 4送风
     */
    void setRunMode(int runMode){

    }

    /*
    设定风扇转速 整数0-4
        0自动 1低速 2中速 3高速 4其他
     */
    void setFanStatus(int fanStatus) {

    }

    /*
    设定温度 浮点数
     */
    void setTemperature(float temperature){

    }
}
