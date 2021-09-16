import java.util.ArrayList;

/**
 * 遊戲狀態列表(數值儲存於此，取用於此)
 */
public class NewStatus {
    private int time;
    private Resource resource = new Resource();
    private Unit unit = new Unit();
    private Zombie zombie = new Zombie();
    private ArrayList<Building> buildingList = new ArrayList<Building>();

    public NewStatus() {
        buildingList.add(new House());
        buildingList.add(new University());
        buildingList.add(new Barracks());
        buildingList.add(new LumberCamp());
        buildingList.add(new MiningCamp());
        buildingList.add(new Blacksmith());
        buildingList.add(new GasCamp());
        buildingList.add(new AirFactory());
    }

    /**
     * 過一個小時
     */
    public void nextHour() {
        //加一小
        time++;
        //增加木材
        resource.addWood(resource.getWoodPeople() * (buildingList.get(3)).getRate());
        //增加瓦斯
        if (buildingList.get(6).isOnOff() && buildingList.get(6).getBuildTime() > 0) {
            resource.addGas(buildingList.get(6).getRate());
        }
        //增加鋼鐵
        resource.addSteel(resource.getSteelPeople() * buildingList.get(4).getRate());
        //增加市民
        if (isEnough(buildingList.get(0).getEffectResource()) &&
                buildingList.get(0).isOnOff() &&
                buildingList.get(0).getBuildCheck() == Building.BuildCheck.UNBUILDABLE &&
                (time - buildingList.get(0).getBuildTime()) % 24 == 0) {
            unit.addVillager(unit.getVillagerGenRate());
            resource.reduceResource(buildingList.get(0).getEffectResource());
            buildingList.get(0).setBuildTime(time);
        }
        //增加士兵
        if (isEnough(buildingList.get(2).getEffectResource()) &&
                buildingList.get(2).isOnOff() &&
                buildingList.get(2).getBuildCheck() == Building.BuildCheck.UNBUILDABLE &&
                (time - buildingList.get(2).getBuildTime()) % 3 == 0) {
            unit.addArmy(unit.getArmyGenRate());
            resource.reduceResource(buildingList.get(2).getEffectResource());
            buildingList.get(2).setBuildTime(time);

        }
        //增加飛機
        if (isEnough(new Resource(0, 0, 5 * buildingList.get(7).getBuildingLevel())) &&
                buildingList.get(7).isOnOff() &&
                buildingList.get(7).getBuildCheck() == Building.BuildCheck.UNBUILDABLE &&
                (time - buildingList.get(7).getBuildTime()) % 3 == 0) {
            unit.addAircraft(unit.getAircraftGenRate());
            resource.reduceResource(buildingList.get(7).getEffectResource());
            buildingList.get(7).setBuildTime(time);
        }
        //減少建築所需時間
        reduceBuildingNeedTime();
        //減少建築所需升級時間
        reduceUpgradeNeedTime();

        //判定能不能升級
    }

    /**
     * 經過指定小時
     *
     * @param hr//指定小時
     */
    public void nextHours(int hr) {
        for (int i = 0; i < hr; i++) {
            nextHour();
        }
    }

    /**
     * 減少建築所需時間
     */
    public void reduceBuildingNeedTime() {
        for (Building building : buildingList) {
            if (building.getBuildCheck() == Building.BuildCheck.BUILDGOINGON) {
                building.reduceBuildNeedTime();
                if (building.getBuildNeedTime() == 0) {
                    building.setBuildCheck(Building.BuildCheck.UNBUILDABLE);
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
        for (int i = 0; i < buildingList.size(); i++) {
            Building building = buildingList.get(i);
            if (building.getUpgradeCheck() == Building.UpgradeCheck.UPGRADING) {
                building.reduceUpgradeNeedTime();
                if (building.getUpgradeNeedTime() == 0) {
                    building.setUpgradeCheck(Building.UpgradeCheck.UPGRADEABLE);
                    building.upgrade();
                }
            }
        }
    }

    /**
     * (主動)分配人力
     *
     * @param woodPeople
     * @param steelPeople
     * @return
     */
    public boolean distribute(int woodPeople, int steelPeople) {
        villagerReset();
        boolean isEnoughVillager = false;
        if (unit.getVillagerCount() >= woodPeople + steelPeople) {
            resource.addWoodPeople(woodPeople);
            resource.setSteelPeople(steelPeople);
            unit.addVillager((woodPeople + steelPeople) * -1);
            isEnoughVillager = true;
        }
        return isEnoughVillager;
    }

    /**
     * 召集市民回歸
     */
    public void villagerReset() {
        unit.addVillager(resource.getWoodPeople() + resource.getSteelPeople());
        resource.setSteelPeople(0);
        resource.setWoodPeople(0);
    }

    /**
     * (主動)選擇建造
     *
     * @param //建築物編號
     * @return//是否可以建造(並變成建造中)
     */
    public boolean build(int opt) {
        int civilLevel = ((University)(buildingList.get(1))).getCivilLevel();
        boolean isBuildable = false;
        if (civilLevel >= buildingList.get(opt - 1).getNeedCivilLevel()
                && isEnough(buildingList.get(opt - 1).getBuildResource())
                && buildingList.get(opt - 1).getBuildCheck() == Building.BuildCheck.BUILDABLE
                && unit.getVillagerCount() > 0) {
            unit.addVillager(-1);
            resource.reduceResource(buildingList.get(opt - 1).getBuildResource());
            buildingList.get(opt - 1).setBuildCheck(Building.BuildCheck.BUILDGOINGON);
            isBuildable = true;
        }
        return isBuildable;
    }

    /**
     * (主動)選擇升級
     *
     * @param //建築物編號
     * @return //是否可以升級(變成升級中)
     */
    public boolean upgrade(int opt) {
        boolean isUpgradable = false;
        if (opt == 2 && buildingList.get(1).) {
            System.out.println("文明等級已達上限，研究所無法升級");
        } else if (civilLevel >= buildingList.get(opt - 1).getUpNeedCivilLevel()) {
            System.out.println("文明等級不足");
        } else if (civilLevel >= buildingList.get(opt - 1).getUpNeedCivilLevel() &&
                isEnough(buildingList.get(opt - 1).getUpgradeResource()) &&
                buildingList.get(opt - 1).getUpgradeCheck() == Building.UpgradeCheck.UPGRADEABLE) {
            resource.reduceResource(buildingList.get(opt - 1).getUpgradeResource());
            buildingList.get(opt - 1).setUpgradeCheck(Building.UpgradeCheck.UPGRADING);
            isUpgradable = true;
        }
        return isUpgradable;
    }

    /**
     * @param r 資源
     * @return 是否夠資源
     */
    public boolean isEnough(Resource r) {
        if (resource.getWood() < r.getWood() || resource.getSteel() < r.getSteel() || resource.getGas() < r.getGas()) {
            return false;
        }
        return true;
    }
}
