package cmoneyweek1citymanage;

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
        //建築滿血生命值
        setLifeFull(10);
        //建築當前生命值
        setLife(getLifeFull());
        //建造所需資源
        this.setBuildResource(new Resource(15,5,0));
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
        this.setUpgradeResource(new Resource(15,5,0));
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

    @Override
    public int getRate() {

        steelRate = this.getBuildingLevel()+1;
        if(this.getBuildCheck().equals(Building.BuildCheck.UNBUILDABLE)){
            steelRate ++;
        }
        return steelRate;
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
                            " )\t功能：採集鋼鐵效率增加 >> 市民每小時鋼鐵採集效率增為2單位鋼鐵");
    }

    //印出升級資訊
    @Override
    public void printUpgrade() {
        System.out.println(getNumber() + "." + getName() +
                            "　:(升級成本:木材" + getUpgradeResource().getWood() +
                            " 鋼鐵" + getUpgradeResource().getSteel() +
                            " 所需文明等級: " + getUpNeedCivilLevel() +
                            " )\t升級功能:採集鋼鐵效率增加 >> 市民每小時鋼鐵採集效率增為" + (getRate() + 1) +"單位鋼鐵");
    }
    
    

}
