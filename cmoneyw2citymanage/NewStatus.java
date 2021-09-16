import java.util.ArrayList;

/**
 * 遊戲狀態列表(數值儲存於此，取用於此)
 */
public class NewStatus {
    private int time;
    private int civilLevel = 1;
    private Resource resource = new Resource();
    private Unit unit = new Unit();
    private ArrayList<Building> buildingList = new ArrayList<Building>();

    /**
     * 過一個小時
     */
    public void nextHour() {
        //增加木材
        resource.addWood(resource.getWoodPeople() * resource.getWoodRate());
        //增加瓦斯
        if (buildingList.get(6).isOnOff()) {
            resource.addGas(resource.getGasRate());
        }
        //增加鋼鐵
        resource.addSteel(resource.getSteelPeople() * resource.getSteelRate());
        //增加市民
        if (isEnough(new Resource(1, 0, 0)) && buildingList.get(0).isOnOff() &&
                buildingList.get(0).getBuildCheck() == 1 &&
                (time - buildingList.get(0).getBuildTime()) % 24 == 0) {
            unit.addVillager(unit.getVillagerGenRate());
            resource.addWood(-1);
        }
        //增加士兵
        if (isEnough(new Resource(2, 2, 0)) &&
                buildingList.get(2).isOnOff() &&
                buildingList.get(2).getBuildCheck() == 1 &&
                (time - buildingList.get(2).getBuildTime()) % 3 == 0) {
            unit.addArmy(unit.getArmyGenRate());
            resource.addWood(-2);
            resource.addSteel(-2);
        }
        //增加飛機
        if (isEnough(new Resource(0, 0, 5*buildingList.get())) &&
                buildingList.get(7).isOnOff() &&
                buildingList.get(7).getBuildCheck() == 1 &&
                (time - buildingList.get(7).getBuildTime()) % 3 == 0) {
            unit.addAircraft(unit.getAircraftGenRate());
            resource.addGas(-5);
        }
        //減少建築所需時間
        reduceBuildingNeedTime();
        //判定能不能升級


        time++;
    }

    /**
     * 減少建築所需時間
     */
    public void reduceBuildingNeedTime() {
        for (Building building : buildingList) {
            if (building.getBuildCheck() == 0) {
                building.reduceBuildNeedTime();
                if (building.getBuildNeedTime() == 0) {
                    building.setBuildCheck(1);
                    building.setOnOff(true);
                    building.setBuildTime(time);
                    unit.addVillager(1);
                }
            }
        }
    }

    /**
     * 減少升級所需時間
     */
    public void reduceUpgradeNeedTime() {
        for (Building building : buildingList) {
            if (building.getUpgradeCheck() == 0) {
                building.reduceUpgradeNeedTime();//減少時間
                if (building.getUpgradeNeedTime() == 0) {
                    building.setUpgradeCheck(-1);//升級後動作
                }
            }
        }
    }

    /**
     *
     * @param //建築物編號
     * @return//是否可以建造(變成建造中)
     */
    public boolean build(int opt) {
        boolean isBuildable = false;
        if (civilLevel >= buildingList.get(opt - 1).getNeedCivilLevel() &&
                isEnough(buildingList.get(opt - 1).getBuildResource()) &&
                buildingList.get(opt - 1).getBuildCheck() == -1 &&
                unit.getVillagerCount() > 0) {
            unit.addVillager(-1);
            resource.reduceResource(buildingList.get(opt - 1).getBuildResource());
            buildingList.get(opt - 1).setBuildCheck(0);
            isBuildable = true;
        }
        return isBuildable;
    }

    public boolean upgrade(int opt) {
        boolean isUpgradable = false;
        if (opt == 2 && civilLevel == 3) {
            System.out.println("文明等級已達上限，研究所無法升級");
        } else if (civilLevel >= buildingList.get(opt - 1).getUpNeedCivilLevel()) {
            System.out.println("文明等級不足");
        } else if (civilLevel >= buildingList.get(opt - 1).getUpNeedCivilLevel() &&
                isEnough(buildingList.get(opt - 1).getUpgradeResource()) &&
                buildingList.get(opt - 1).getUpgradeCheck() == -1) {
            resource.reduceResource(buildingList.get(opt - 1).getUpgradeResource());
            buildingList.get(opt - 1).setUpgradeCheck(0);
            isUpgradable = true;
        }
        return isUpgradable;
    }

    public boolean isEnough(Resource r) {
        if (resource.getWood() < r.getWood() || resource.getSteel() < r.getSteel() || resource.getGas() < r.getGas()) {
            return false;
        }
        return true;
    }

    public void upgradeBuild(int opt) {
        switch (opt) {
            case 1:
                unit.setVillagerGenRate(unit.getVillagerGenRate() + 2);
                buildingList.get(opt - 1).setUpgradeCheck(-1);
                buildingList.get(opt - 1).setUpgradeNeedTime(30);
                break;
            case 2:
                civilLevel++;
                buildingList.get(opt - 1).setUpgradeCheck(-1);
                buildingList.get(opt - 1).setUpgradeNeedTime(24);
                if (civilLevel >= 2) {
                    buildingList.get(opt - 1).setUpgradeResource(new Resource(60, 30, 10));
                }
                break;
            case 3:
                unit.setArmyGenRate(unit.getArmyGenRate() + 2);
                buildingList.get(opt - 1).setUpgradeCheck(-1);
                buildingList.get(opt - 1).setUpgradeNeedTime(30);
                break;
            case 4:
                resource.setWoodRate(resource.getWoodRate() + 2);
                buildingList.get(opt - 1).setUpgradeCheck(-1);
                buildingList.get(opt - 1).setUpgradeNeedTime(30);
                break;
            case 5:
                resource.setSteelRate(resource.getSteelPeople() + 1);
                buildingList.get(opt - 1).setUpgradeCheck(-1);
                buildingList.get(opt - 1).setUpgradeNeedTime(30);
                break;
            case 6:
                unit.setArmyLife(unit.getArmyLife() + 3);
                buildingList.get(opt - 1).setUpgradeCheck(-1);
                buildingList.get(opt - 1).setUpgradeNeedTime(48);
                break;
            case 7:
                resource.setGasRate(resource.getGasRate() + 1);
                buildingList.get(opt - 1).setUpgradeCheck(-1);
                buildingList.get(opt - 1).setUpgradeNeedTime(30);
                break;
            case 8:
                //消耗資源要增加
                buildingList.get(opt - 1).setUpgradeCheck(-1);
                buildingList.get(opt - 1).setUpgradeNeedTime(48);
                break;


        }
    }

}
