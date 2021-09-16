
public class Building {
    private int number;
    private String name;
    private int buildingLevel;
    private int life;
    private Resource buildResource;
    private int buildCheck;
    private int buildNeedTime;
    private int buildTime;
    private int needCivilLevel;

    private int upNeedCivilLevel;

    private Resource upgradeResource;
    private int upgradeCheck;
    private int upgradeNeedTime;

    private boolean onOff;
  



    public Building(int number, String name, int buildingLevel, int life, Resource buildResource, int buildCheck, int buildNeedTime, int buildTime, int needCivilLevel, Resource upgradeResource, int upgradeCheck, int upgradeNeedTime, boolean onOff, int upNeedCivilLevel) {
        this.number = number;
        this.name = name;
        this.buildingLevel = buildingLevel;
        this.life = life;
        this.buildResource = buildResource;
        this.buildCheck = buildCheck;
        this.buildNeedTime = buildNeedTime;
        this.buildTime = buildTime;
        this.upNeedCivilLevel = upNeedCivilLevel
        this.upgradeResource = upgradeResource;
        this.upgradeCheck = upgradeCheck;
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

    public int getBuildCheck() {
        return buildCheck;
    }

    public void setBuildCheck(int buildCheck) {
        this.buildCheck = buildCheck;
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

    public int getUpgradeCheck() {
        return upgradeCheck;
    }

    public void setUpgradeCheck(int upgradeCheck) {
        this.upgradeCheck = upgradeCheck;
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

    public int getUpNeedCivilLevel() {
        return upNeedCivilLevel;
    }

    public void setUpNeedCivilLevel(int upNeedCivilLevel) {
        this.upNeedCivilLevel = upNeedCivilLevel;
    }
}

    
    

    
    
  
    
    
