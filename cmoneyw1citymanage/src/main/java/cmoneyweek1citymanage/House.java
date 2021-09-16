package cmoneyweek1citymanage;/*
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
        this.setNumber(1);
        //建築名稱
        this.setName("房屋");
        //建築等級
        this.setBuildingLevel(1);
        //建築生命值
        this.setLife(10);
        //建造所需資源
        this.setBuildResource(new Resource(10,0,0));
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
        //升級剩餘時間
        this.setUpgradeNeedTime(30);
        //升級所需時間
        this.setUpgradeResetTime(30);
        //建築物功能開關
        this.setOnOff(false);
        //自動生產消耗資源
        this.setEffectResource(new Resource(1,0,0));
        //升級需要文明等級
        this.setUpNeedCivilLevel(2);
    }

    public int getVillagerGenRate() {
        villagerGenRate = this.getBuildingLevel()*2-1;
        return villagerGenRate;
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
                            " )\t功能：每24小時消耗" + getEffectResource().getWood() + "木材" +
                            "，產生" + this.getBuildingLevel() + "個市民");
    }

    //印出升級資訊
    @Override
    public void printUpgrade() {
        System.out.println(getNumber() + "." + getName() +
                            "　:(升級成本:木材" + getUpgradeResource().getWood() +
                            " 鋼鐵" + getUpgradeResource().getSteel() +
                            " 所需文明等級: " + getUpNeedCivilLevel() +
                            " )\t升級功能:每24小時消耗" + getEffectResource().getWood() + "木材" +
                            "，產生" + (this.getBuildingLevel() + 1) + "個市民");
    }

}
