package cmoneyweek1citymanage;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kisso
 */
public class MiningCamp extends Building{
    private final int upgradeResetTime = 30;
    private int steelRate ;
    
    public MiningCamp(){
        //建築物狀態
        //建築編號
        this.setNumber(5);
        //建築名稱
        this.setName("煉鋼廠");
        //建築等級
        this.setBuildingLevel(1);
        //建築生命值
        this.setLife(10);
        //建造所需資源
        this.setBuildResource(new Resource(15,5,0));
        //建築狀態
        this.setBuildCheck(Building.BuildCheck.BUILDABLE);
        //建造所需時間
        this.setBuildNeedTime(1);
        //建築建好時間
        this.setBuildTime(-1);
        //建造需要文明等級
        this.setNeedCivilLevel(1);
        //升級所需資源
        this.setUpgradeResource(new Resource(15,5,0));
        //升級狀態
        this.setUpgradeCheck(Building.UpgradeCheck.UPGRADEABLE);
        //升級剩餘時間
        this.setUpgradeNeedTime(30);
        //升級所需時間
        this.setUpgradeResetTime(30);
        //建築物功能開關
        this.setOnOff(false);
        //升級需要文明等級
        this.setUpNeedCivilLevel(2);
        
    }

    public int getSteelRate() {
        
        steelRate = this.getBuildingLevel()+1;
        if(this.getBuildCheck().equals(Building.BuildCheck.UNBUILDABLE)){
            steelRate ++;
        }
        return steelRate;
    }

    
    
    

}
