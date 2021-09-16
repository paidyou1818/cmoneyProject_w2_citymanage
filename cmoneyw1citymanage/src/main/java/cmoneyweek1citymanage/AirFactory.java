package cmoneyweek1citymanage;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kisso
 */
public class AirFactory extends Building{
    private int aircraftGenRate;//飛機生產速度


    public AirFactory(){
        //設定參數，無法升級，相關選項未設定(檢查是否會報錯)
        //建築編號
        this.setNumber(8);
        //建築名稱
        this.setName("飛機工廠");
        //建築等級
        this.setBuildingLevel(1);
        //建築生命值
        this.setLife(50);
        //建造所需資源
        this.setBuildResource(new Resource(15,5,5));
        //建築狀態
        this.setBuildCheck(Building.BuildCheck.BUILDABLE);
        //建造所需時間
        this.setBuildNeedTime(2);
        //建築建好時間
        this.setBuildTime(-1);
        //建造需要文明等級
        this.setNeedCivilLevel(2);
        //升級狀態(不可升級)
        this.setUpgradeCheck(Building.UpgradeCheck.NOTUPGRADEABLE);
        //建築物功能開關
        this.setOnOff(false);
        //自動生產消耗資源
        this.setEffectResource(new Resource(0,0,5));
        //升級需要文明等級
        this.setUpNeedCivilLevel(3);
        
    }
    public int getAircraftGenRate() {
        //飛機生產速度=房屋等級*1
        aircraftGenRate = this.getBuildingLevel();
        return aircraftGenRate;
    }

    /**
     * 印出建造資訊
     * @return 印出建造資訊
     */
    @Override
    public void printBuild() {
        System.out.println(getNumber() + "." + getName() +
                            "　:(建造成本:木材" + getBuildResource().getWood() +
                            " 鋼鐵" + getBuildResource().getSteel() +
                            " 所需文明等級: " + getNeedCivilLevel() +
                            " )\t功能：每3小時消耗" + getEffectResource().getGas() + "瓦斯" +
                            "，產生" + this.getBuildingLevel() + "台戰鬥機");
    }

    //印出升級資訊
    @Override
    public void printUpgrade() {
        System.out.println(getNumber() + "." + getName() +
                "　:(升級成本:木材" + getUpgradeResource().getWood() +
                " 鋼鐵" + getUpgradeResource().getSteel() +
                " 所需文明等級: " + getUpNeedCivilLevel() +
                " )\t升級功能:每3小時消耗" + getEffectResource().getGas() + "瓦斯" +
                "，產生" + (this.getBuildingLevel() + 1) + "台戰鬥機");
    }
}
