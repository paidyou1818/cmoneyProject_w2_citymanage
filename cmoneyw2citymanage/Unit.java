

public class Unit {

    private int villagerLife = 1;//村民數值//放建築
    private int villagerCount = 20;//村民人數
    private int villagerGenRate = 1;//生產村民速率//放建築裡

    private int armyLife = 2; //士兵數值
    private int armyCount = 10; //士兵人數
    private int armyGenRate = 1; //生產士兵速率

    private int aircraftLife = 2; //飛機數值
    private int aircraftCount = 0; //飛機數量
    private int aircraftGenRate = 0; //飛機數值
    //寫建構子


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

    public void addVillager(int value) {
        villagerCount += value;
    }

    public void addArmy(int value) {
        armyCount += value;
    }

    public void addAircraft(int value) {
        aircraftCount += value;
    }
}
