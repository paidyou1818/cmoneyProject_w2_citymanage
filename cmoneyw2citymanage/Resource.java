

public class Resource {
    public int wood;
    public int steel;
    public int gas;
    public int woodPeople;
    public int steelPeople;
    public int gasPeople;
    public int woodRate = 3;
    public int steelRate = 1;
    public int gasRate = 0;
    
    public Resource(){
        
    }

    public Resource(int wood, int steel, int gas) {
        this.wood = wood;
        this.steel = steel;
        this.gas = gas;
    }
    
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
