
public class Building {
    private int number;
    private String name;
    private int buildingLevel;
    private int life;
    private Resource buildResource;
    private BuildCheck buildCheck;

    private Resource effectResource;
    private int buildNeedTime;
    private int buildTime;
    private int needCivilLevel;

    private int upNeedCivilLevel;

    private Resource upgradeResource;
    private UpgradeCheck upgradeCheck;
    private int upgradeNeedTime;
    private boolean onOff;
  



    /**
     * 可否升級檢查
     */
    public enum UpgradeCheck {
        UPGRADEABLE,
        UPGRADING,
        NOTUPGRADEABLE;
    }

    /**
     * 可否建造檢查
     */
    public enum BuildCheck {
        BUILDABLE,
        BUILDGOINGON,
        UNBUILDABLE;
    }

    public Building(int number, String name, int buildingLevel, int life, Resource buildResource, int buildNeedTime, int buildTime, int needCivilLevel, Resource upgradeResource, int upgradeNeedTime, boolean onOff, int upNeedCivilLevel) {
        this.number = number;
        this.name = name;
        this.buildingLevel = buildingLevel;
        this.life = life;
        this.buildResource = buildResource;
        this.buildCheck = BuildCheck.BUILDABLE;
        this.buildNeedTime = buildNeedTime;
        this.buildTime = buildTime;
        this.needCivilLevel = needCivilLevel;
        this.upgradeResource = upgradeResource;
        this.upgradeCheck = UpgradeCheck.UPGRADEABLE;
        this.upgradeNeedTime = upgradeNeedTime;
        this.onOff = onOff;
        this.upNeedCivilLevel = upNeedCivilLevel;
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

    public Resource getBuildResource() {
        return buildResource;
    }

    public void setBuildResource(Resource buildResource) {
        this.buildResource = buildResource;
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

    public int getUpgradeNeedTime() {
        return upgradeNeedTime;
    }

    public void setUpgradeNeedTime(int upgradeNeedTime) {
        this.upgradeNeedTime = upgradeNeedTime;
    }

    public boolean isOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }

    public Resource getEffectResource() {
        return effectResource;
    }

    public void setEffectResource(Resource effectResource) {
        this.effectResource = effectResource;
    }

    public BuildCheck getBuildCheck() {
        return buildCheck;
    }

    public void setBuildCheck(BuildCheck buildCheck) {
        this.buildCheck = buildCheck;
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
}

    
    

    
    
  
    
    
