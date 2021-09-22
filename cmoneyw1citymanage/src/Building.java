public class Building {

    private int number;
    private String name;
    private int buildingLevel;
    private int life;
    private int lifeFull;
    private int initialLife;
    private Resource buildResource;
    private BuildCheck buildCheck;//enum
    private int buildNeedTime;
    private int buildTime;
    private int initialBuildTime;
    private int needCivilLevel;
    private int upNeedCivilLevel;

    private Resource upgradeResource;
    private UpgradeCheck upgradeCheck;//enum
    private int upgradeNeedTime;
    private int upgradeResetTime;

    private boolean onOff;
    private Resource effectResource;

    /**
     * 可否建造檢查
     */
    public enum BuildCheck {
        BUILDABLE("尚未建造"),
        BUILDGOINGON("正在建造"),
        UNBUILDABLE("已建完畢");
        private String buildChecking;

        private BuildCheck(String buildChecking) {
            this.buildChecking = buildChecking;
        }

        public String getBuildChecking() {
            return buildChecking;
        }
    }

    /**
     * 可否升級檢查
     */
    public enum UpgradeCheck {
        UPGRADEABLE("可升級"),
        UPGRADING("升級中"),
        NOTUPGRADEABLE("不可升級");
        private String updateChecking;

        private UpgradeCheck(String updateChecking) {
            this.updateChecking = updateChecking;
        }

        public String getBuildChecking() {
            return updateChecking;
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


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBuildingLevel() {
        return buildingLevel;
    }

    public void setBuildingLevel(int buildingLevel) {
        this.buildingLevel = buildingLevel;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLifeFull() {
        return lifeFull;
    }

    public void setLifeFull(int lifeFull) {
        this.lifeFull = lifeFull;
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

    public UpgradeCheck getUpgradeCheck() {
        return upgradeCheck;
    }

    public void setUpgradeCheck(UpgradeCheck upgradeCheck) {
        this.upgradeCheck = upgradeCheck;
    }

    public void setUpgradeResource(Resource upgradeResource) {
        this.upgradeResource = upgradeResource;
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

    //可重複升級
    public void upgradeReset() {
        setUpgradeNeedTime(upgradeResetTime);
    }

    //被摧毀後可重新建造
    public void buildReset() {
        setBuildNeedTime(initialBuildTime);
    }

    public void initialLife() {
        setLife(initialLife);
    }

    public Resource getEffectResource() {
        return effectResource;
    }

    public void setEffectResource(Resource effectResource) {
        this.effectResource = effectResource;
    }

    public int getRate() {
        return 0;
    }

    public void upgrade() {
        buildingLevel++;
        upgradeReset();
        setUpgradeCheck(UpgradeCheck.UPGRADEABLE);
    }

    public int getInitialLife() {
        return initialLife;
    }

    //印出建造資訊
    public void printBuild() {

    }

    //印出升級資訊
    public void printUpgrade() {

    }
}