package cmoneyweek1citymanage;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kisso
 */
public class Barracks extends Building{
    private int armyGenRate; //生產士兵速率
            
    public Barracks(){
        //建築編號
        setNumber(3);
        //建築名稱
        setName("軍營");
        //建築等級
        setBuildingLevel(1);
        //建築生命值
        setLife(30);
        //建造所需資源
        setBuildResource(new Resource(20,10,0));
        //建築狀態
        setBuildCheck(Building.BuildCheck.BUILDABLE);
        //建造所需時間
        setBuildNeedTime(2);
        //建築建好時間
        setBuildTime(-1);
        //建造需要文明等級
        setNeedCivilLevel(1);
        //升級所需資源
        setUpgradeResource(new Resource(30,15,0));
        //升級狀態
        setUpgradeCheck(Building.UpgradeCheck.UPGRADEABLE);
        //升級剩餘時間
        this.setUpgradeNeedTime(30);
        //升級所需時間
        this.setUpgradeResetTime(30);
        //建築物功能開關
        setOnOff(false);
        //自動生產消耗資源
        setEffectResource(new Resource(2,2,0));
        //升級需要文明等級
        setUpNeedCivilLevel(2);
        
    }

    public int getArmyGenRate() {
        armyGenRate = getBuildingLevel()*2-1;
        return armyGenRate;
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
                            " )\t功能：每3小時消耗" + getEffectResource().getWood() + "木材" +
                            " " + getEffectResource().getSteel() + "鋼鐵" +
                            "，產生" + getBuildingLevel() + "個士兵");
    }

    //印出升級資訊
    @Override
    public void printUpgrade() {
        System.out.println(getNumber() + "." + getName() +
                            "　:(升級成本:木材" + getUpgradeResource().getWood() +
                            " 鋼鐵" + getUpgradeResource().getSteel() +
                            " 所需文明等級: " + getUpNeedCivilLevel() +
                            " )\t升級功能:每3小時消耗" + getEffectResource().getWood() + "木材" +
                            " " + getEffectResource().getSteel() + "鋼鐵" +
                            "，產生" + (this.getBuildingLevel() + 1) + "個士兵");
    }
}
