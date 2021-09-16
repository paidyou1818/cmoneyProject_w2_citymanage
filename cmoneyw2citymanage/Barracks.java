/*
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
        //建築滿血生命值
        setLifeFull(30);
        //建築當前生命值
        setLife(getLifeFull());
        //建造所需資源
        setBuildResource(new Resource(20,10,0));
        //建築狀態
        setBuildCheck(Building.BuildCheck.BUILDABLE);
        //建造所需時間
        setInitialBuildTime(2);
        //建築剩餘時間
        setBuildNeedTime(getInitialBuildTime());
        //建築建好時間
        setBuildTime(-1);
        //建造需要文明等級
        setNeedCivilLevel(1);
        //升級所需資源
        setUpgradeResource(new Resource(30,15,0));
        //升級狀態
        setUpgradeCheck(Building.UpgradeCheck.UPGRADEABLE);
        //升級所需時間
        this.setUpgradeResetTime(30);
        //升級剩餘時間
        this.setUpgradeNeedTime(getUpgradeResetTime());
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
}