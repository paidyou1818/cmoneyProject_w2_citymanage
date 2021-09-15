package cmoneyweek1citymanage;

/**
 * 我軍單位
 */
public class Unit {
    private int villagerLife = 1;//起始村民數值
    private int villagerCount = 20;//起始村民人數
    private int villagerGenRate = 0;//起始生產村民速率

    private int armyLife = 2; //起始士兵數值
    private int armyCount = 10; //起始士兵人數
    private int armyGenRate = 0; //起始生產士兵速率

    private int aircraftLife = 2; //起始飛機數值
    private int aircraftCount = 0; //起始飛機數值
    private int aircraftGenRate = 0; //起始飛機數值

    public int getVillagerLife() {
        return villagerLife;
    }

    public void setVillagerLife(int villagerLife) {
        this.villagerLife = villagerLife;
    }

    public int getVillagerCount() {
        return villagerCount;
    }

    public void setVillagerCount(int villagerCount) {
        this.villagerCount = villagerCount;
    }

    public int getVillagerGenRate() {
        return villagerGenRate;
    }

    public void setVillagerGenRate(int villagerGenRate) {
        this.villagerGenRate = villagerGenRate;
    }

    public int getArmyLife() {
        return armyLife;
    }

    public void setArmyLife(int armyLife) {
        this.armyLife = armyLife;
    }

    public int getArmyCount() {
        return armyCount;
    }

    public void setArmyCount(int armyCount) {
        this.armyCount = armyCount;
    }

    public int getArmyGenRate() {
        return armyGenRate;
    }

    public void setArmyGenRate(int armyGenRate) {
        this.armyGenRate = armyGenRate;
    }

    public int getAircraftLife() {
        return aircraftLife;
    }

    public void setAircraftLife(int aircraftLife) {
        this.aircraftLife = aircraftLife;
    }

    public int getAircraftCount() {
        return aircraftCount;
    }

    public void setAircraftCount(int aircraftCount) {
        this.aircraftCount = aircraftCount;
    }

    public int getAircraftGenRate() {
        return aircraftGenRate;
    }

    public void setAircraftGenRate(int aircraftGenRate) {
        this.aircraftGenRate = aircraftGenRate;
    }
}
