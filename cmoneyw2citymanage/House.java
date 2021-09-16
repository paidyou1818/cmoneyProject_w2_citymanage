/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kisso
 */
public class House extends Building{
    /**
     * 升級所需時間
     * 村民生命值
     * 村民生產速度
     */
    private int villagerGenRate;
    private int villagerLife;


    public House(){
        //建築編號
        setNumber(1);
        //建築名稱
        setName("房屋");
        //建築等級
        setBuildingLevel(1);
        //建築滿血生命值
        setLifeFull(10);
        //建築當前生命值
        setLife(getLifeFull());
        //建造所需資源
        setBuildResource(new Resource(10,0,0));
        //建築狀態
        setBuildCheck(Building.BuildCheck.BUILDABLE);
        //建造所需時間
        setInitialBuildTime(1);
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
        setUpgradeResetTime(30);
        //升級剩餘時間
        setUpgradeNeedTime(getUpgradeResetTime());
        //建築物功能開關
        setOnOff(false);
        //自動生產消耗資源
        setEffectResource(new Resource(1,0,0));
        //升級需要文明等級
        setUpNeedCivilLevel(2);
        
        this.villagerLife = 1;
    }

    public int getVillagerGenRate() {
        villagerGenRate = this.getBuildingLevel()*2-1;
        return villagerGenRate;
    }
    
    

}
