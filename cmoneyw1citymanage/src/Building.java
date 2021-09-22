public class Building {

    private int number;
    private String name;
    private int buildingLevel;//建築物等級
    private int life;//當前生命值
    private Resource buildResource;
    private BuildCheck buildCheck;//enum
    private int buildNeedTime;//建造剩餘時間
    private int initialBuildTime;//起始建造時間
    private int buildTime;//建造完成時間
    private int needCivilLevel;//建造需要文明

    private int upNeedCivilLevel;//升級需要文明

    private Resource upgradeResource;
    private UpgradeCheck upgradeCheck;//enum
    private int upgradeNeedTime;//升級剩餘時間
    private int upgradeResetTime;//起始升級時間

    private boolean onOff;
    private Resource effectResource;

    public Building(){
        //建築等級
        setBuildingLevel(1);
        //建築建好時間
        setBuildTime(-1);
        //建築狀態
        setBuildCheck(Building.BuildCheck.BUILDABLE);
        //升級狀態
        setUpgradeCheck(UpgradeCheck.NOTUPGRADEABLE);
        //建築物功能開關
        setOnOff(false);
    }

    /**
     * 可否建造檢查
     */
    public enum BuildCheck {
        BUILDABLE("可以建造"),
        BUILDGOINGON("建造ing"),
        UNBUILDABLE("不可建造");
        public String label;
        private BuildCheck(String label){
            this.label = label;
        }
    }

    /**
     * 可否升級檢查
     */
    public enum UpgradeCheck {
        UPGRADEABLE("可以升級"),
        UPGRADING("升級ing"),
        NOTUPGRADEABLE("不可升級");
        public String label;
        private UpgradeCheck(String label){
            this.label = label;
        }
    }

    /**
     * 需要建築時間-1
     */
    public void reduceBuildNeedTime() {
        buildNeedTime--;
    }

    public void reduceUpgradeNeedTime() {
        upgradeNeedTime--;
    }


    /**
     * Getter & Setter
     * @return
     */
    public int getNumber() {
        return number;
    }
    //設定編號
    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }
    //設定名稱
    public void setName(String name) {
        this.name = name;
    }

    public int getBuildingLevel() {
        return buildingLevel;
    }
    //設定起始等級
    public void setBuildingLevel(int buildingLevel) {
        this.buildingLevel = buildingLevel;
    }

    public int getLife() {
        return life;
    }
    //設定當前生命值
    public void setLife(int life) {
        this.life = life;
    }

    public Resource getBuildResource() {
        return buildResource;
    }

    public void setBuildResource(Resource buildResource) {
        this.buildResource = buildResource;
    }

    public BuildCheck getBuildCheck() {
        return buildCheck;
    }

    public void setBuildCheck(BuildCheck buildCheck) {
        this.buildCheck = buildCheck;
    }

    public int getInitialBuildTime() {
        return initialBuildTime;
    }

    public void setInitialBuildTime(int initialBuildTime) {
        this.initialBuildTime = initialBuildTime;
    }

    public int getBuildNeedTime() {
        return buildNeedTime;
    }

    public void setBuildNeedTime(int buildNeedTime) {
        this.buildNeedTime = buildNeedTime;
    }

    public int getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(int buildTime) {
        this.buildTime = buildTime;
    }

    public int getNeedCivilLevel() {
        return needCivilLevel;
    }

    public void setNeedCivilLevel(int needCivilLevel) {
        this.needCivilLevel = needCivilLevel;
    }

    public Resource getUpgradeResource() {
        return upgradeResource;
    }

    public void setUpgradeResource(Resource upgradeResource) {
        this.upgradeResource = upgradeResource;
    }

    public UpgradeCheck getUpgradeCheck() {
        return upgradeCheck;
    }

    public void setUpgradeCheck(UpgradeCheck upgradeCheck) {
        this.upgradeCheck = upgradeCheck;
    }

    public int getUpNeedCivilLevel() {
        return upNeedCivilLevel;
    }

    public void setUpNeedCivilLevel(int upNeedCivilLevel) {
        this.upNeedCivilLevel = upNeedCivilLevel;
    }

    public int getUpgradeNeedTime() {
        return upgradeNeedTime;
    }

    public void setUpgradeNeedTime(int upgradeNeedTime) {
        this.upgradeNeedTime = upgradeNeedTime;
    }

    public int getUpgradeResetTime() {
        return upgradeResetTime;
    }

    public void setUpgradeResetTime(int upgradeResetTime) {
        this.upgradeResetTime = upgradeResetTime;
    }

    public boolean isOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }


    /**
     * 遊戲進行中的動作
     * 建造、升級
     */
    //升級完成
    //等級++、改成無法升級
    public void upgrade() {
        buildingLevel++;
        setUpgradeCheck(UpgradeCheck.NOTUPGRADEABLE);
    }
    //判斷是否滿等
    //未滿等則重置升級狀態及時間
    public void upgradeReset() {
        setUpgradeCheck(UpgradeCheck.UPGRADEABLE);
        setUpgradeNeedTime(upgradeResetTime);
    }

    //被摧毀後可重新建造
    public void buildReset() {
        setBuildNeedTime(initialBuildTime);
    }


    /**
     * 給固定消耗資源產生功能的建築物
     * 房屋、軍營、飛機工廠
     * @return
     */
    public Resource getEffectResource() {
        return effectResource;
    }

    public void setEffectResource(Resource effectResource) {
        this.effectResource = effectResource;
    }

    /**
     * 給有生產速率之建築物
     * 房屋、軍營、飛機工廠
     * 伐木場、煉鋼廠、瓦斯場
     * @return
     */
    public int getRate() {
        return 0;
    }


    /**
     * 印出各自的資訊
     * 建立空的方法
     */

    //印出各自的建造資訊
    public void printBuild() {

    }

    //印出各自的升級資訊
    public void printUpgrade() {

    }
}