package cmoneyweek1citymanage;

/**
 * 建造一個起始資源類別
 */
public class Resource {
    public int wood; //木材量
    public int steel; //鋼鐵量
    public int gas; //瓦斯量
    public int woodPeople;//採集木材人數
    public int steelPeople;//採集鋼鐵人數
    public int gasPeople;//採集瓦斯人數
    public int woodRate = 3;//採集木材效率
    public int steelRate = 1;//採集鋼鐵效率
    public int gasRate = 0;//採集瓦斯效率

    public int getWood() {
        return wood;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public int getSteel() {
        return steel;
    }

    public void setSteel(int steel) {
        this.steel = steel;
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public int getWoodPeople() {
        return woodPeople;
    }

    public void setWoodPeople(int woodPeople) {
        this.woodPeople = woodPeople;
    }

    public int getSteelPeople() {
        return steelPeople;
    }

    public void setSteelPeople(int steelPeople) {
        this.steelPeople = steelPeople;
    }

    public int getGasPeople() {
        return gasPeople;
    }

    public void setGasPeople(int gasPeople) {
        this.gasPeople = gasPeople;
    }

    public int getWoodRate() {
        return woodRate;
    }

    public void setWoodRate(int woodRate) {
        this.woodRate = woodRate;
    }

    public int getSteelRate() {
        return steelRate;
    }

    public void setSteelRate(int steelRate) {
        this.steelRate = steelRate;
    }

    public int getGasRate() {
        return gasRate;
    }

    public void setGasRate(int gasRate) {
        this.gasRate = gasRate;
    }

    public void addGas() {
        gas += gasRate;
    }

    public void addWood() {
        wood += woodRate;
    }

    public void addSteel() {
        steel += steelRate;
    }
}
