public class University extends Building {
    private int civilLevel;

    public University() {

        //建築編號
        this.setNumber(2);
        //建築名稱
        this.setName("研究所");
        //建築生命值
        setLife(30);
        //建造所需資源
        this.setBuildResource(new Resource(10, 5, 0));
        //建造所需時間
        this.setInitialBuildTime(3);
        //建築剩餘時間
        setBuildNeedTime(getInitialBuildTime());
        //建造需要文明等級
        this.setNeedCivilLevel(1);
        //升級所需資源
        this.setUpgradeResource(new Resource(50, 20, 0));
        //升級剩餘時間
        this.setUpgradeNeedTime(24);
        //升級所需時間
        this.setUpgradeResetTime(24);
        //升級需要文明等級
        this.setUpNeedCivilLevel(1);
        //起始文明等級
        this.civilLevel = 1;
    }

    public int getCivilLevel() {
        return civilLevel;
    }

    @Override
    public void upgrade() {
        setUpgradeResource(new Resource(60, 30, 10));
        civilLevel++;
    }

    /**
     * 印出建造資訊
     *
     * @return 印出建造資訊
     */
    @Override
    public void printBuild() {
        System.out.println(getNumber() + "." + getName() +
                "　:(建造成本:木材" + getBuildResource().getWood() +
                " 鋼鐵" + getBuildResource().getSteel() +
                " 所需文明等級: " + getNeedCivilLevel() +
                " )\t功能：可以進行科技研究，提升文明等級");
    }

    //印出升級資訊
    @Override
    public void printUpgrade() {
        System.out.println(getNumber() + "." + getName() +
                "　:(升級成本:木材" + getUpgradeResource().getWood() +
                " 鋼鐵" + getUpgradeResource().getSteel() +
                " 所需文明等級: " + getUpNeedCivilLevel() +
                " )\t升級功能:文明等級上升1級");
    }
}