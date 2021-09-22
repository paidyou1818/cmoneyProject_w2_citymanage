public class AirFactory extends Building {
    private int aircraftGenRate;//飛機生產速度


    public AirFactory(){
        //設定參數，無法升級，相關選項未設定(檢查是否會報錯)
        //建築編號
        this.setNumber(8);
        //建築名稱
        this.setName("飛機工廠");
        //建築生命值
        setLife(50);
        //建造所需資源
        this.setBuildResource(new Resource(15,5,5));
        //建造所需時間
        setInitialBuildTime(2);
        //建築剩餘時間
        setBuildNeedTime(getInitialBuildTime());
        //建造需要文明等級
        this.setNeedCivilLevel(2);
        //升級所需資源 第二組自訂
        setUpgradeResource(new Resource(20,20,20));
        //升級所需時間 第二組自訂
        setUpgradeResetTime(30);
        //升級剩餘時間 第二組自訂
        setUpgradeNeedTime(getUpgradeResetTime());
        //自動生產消耗資源
        this.setEffectResource(new Resource(0,0,5));
        //升級需要文明等級 第二組自訂
        this.setUpNeedCivilLevel(3);

    }
    public int getRate() {
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
    public void printUpgrade() {
        System.out.println("無法升級，不准再選");
    }
}