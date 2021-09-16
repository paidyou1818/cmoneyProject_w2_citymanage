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
    private final int upgradeResetTime = 30
            ;
    public LumberCamp(){

        //建築編號
        this.setNumber(4);
        //建築名稱
        this.setName("伐木場");
        //建築等級
        this.setBuildingLevel(1);
        //建築生命值
        this.setLife(10);
        //建造所需資源
        this.setBuildResource(new Resource(15,0,0));
        //建築狀態
        this.setBuildCheck(Building.BuildCheck.BUILDABLE);
        //建造所需時間
        this.setBuildNeedTime(1);
        //建築建好時間
        this.setBuildTime(-1);
        //建造需要文明等級
        this.setNeedCivilLevel(1);
        //升級所需資源
        this.setUpgradeResource(new Resource(30,15,0));
        //升級狀態
        this.setUpgradeCheck(Building.UpgradeCheck.UPGRADEABLE);
        //升級所需時間
        this.setUpgradeNeedTime(30);
        //建築物功能開關
        this.setOnOff(false);
        //升級需要文明等級
        this.setUpNeedCivilLevel(2);
    }
    

}
