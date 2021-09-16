/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kisso
 */
public class LumberCamp extends Building{
    private final int upgradeResetTime = 30;
    private int woodRate ;

    public LumberCamp(){

        //建築編號
        this.setNumber(4);
        //建築名稱
        this.setName("伐木場");
        //建築等級
        this.setBuildingLevel(1);
        //建築滿血生命值
        setLifeFull(10);
        //建築當前生命值
        setLife(getLifeFull());
        //建造所需資源
        this.setBuildResource(new Resource(15,0,0));
        //建築狀態
        this.setBuildCheck(Building.BuildCheck.BUILDABLE);
        //建造所需時間
        setInitialBuildTime(1);
        //建築剩餘時間
        setBuildNeedTime(getInitialBuildTime());
        //建築建好時間
        this.setBuildTime(-1);
        //建造需要文明等級
        this.setNeedCivilLevel(1);
        //升級所需資源
        this.setUpgradeResource(new Resource(30,15,0));
        //升級狀態
        this.setUpgradeCheck(Building.UpgradeCheck.UPGRADEABLE);
        //升級所需時間
        this.setUpgradeResetTime(30);
        //升級剩餘時間
        this.setUpgradeNeedTime(getUpgradeResetTime());
        //建築物功能開關
        this.setOnOff(false);
        //升級需要文明等級
        this.setUpNeedCivilLevel(2);
    }

    public int getWoodRate() {

        woodRate = this.getBuildingLevel()+1;
        if(this.getBuildCheck().equals(Building.BuildCheck.UNBUILDABLE)){
            woodRate ++;
        }
        return woodRate;
    }

}