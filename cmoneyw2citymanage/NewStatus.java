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
        //加一小
        time++;
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
                buildingList.get(0).getBuildCheck() == Building.BuildCheck.UNBUILDABLE &&
                (time - buildingList.get(0).getBuildTime()) % 24 == 0) {
            unit.addVillager(unit.getVillagerGenRate());
            resource.addWood(-1);
        }
        //增加士兵
        if (isEnough(new Resource(2, 2, 0)) &&
                buildingList.get(2).isOnOff() &&
                buildingList.get(2).getBuildCheck() == Building.BuildCheck.UNBUILDABLE &&
                (time - buildingList.get(2).getBuildTime()) % 3 == 0) {
            unit.addArmy(unit.getArmyGenRate());
            resource.addWood(-2);
            resource.addSteel(-2);
        }
        //增加飛機
        if (isEnough(new Resource(0, 0, 5 * buildingList.get(7).getBuildingLevel())) &&
                buildingList.get(7).isOnOff() &&
                buildingList.get(7).getBuildCheck() == Building.BuildCheck.UNBUILDABLE &&
                (time - buildingList.get(7).getBuildTime()) % 3 == 0) {
            unit.addAircraft(unit.getAircraftGenRate());
            resource.addGas(-5);
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
                    upgradeBuild(i + 1); //升級完成後效果產生
                }
            }
        }
    }

    /**
     * //選擇建造
     *
     * @param //建築物編號
     * @return//是否可以建造(並變成建造中)
     */
    public boolean build(int opt) {
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
     * //選擇升級
     *
     * @param //建築物編號
     * @return //是否可以升級(變成升級中)
     */
    public boolean upgrade(int opt) {
        boolean isUpgradable = false;
        if (opt == 2 && civilLevel == 3) {
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
     * @param //資源
     * @return //是否夠資源
     */
    public boolean isEnough(Resource r) {
        if (resource.getWood() < r.getWood() || resource.getSteel() < r.getSteel() || resource.getGas() < r.getGas()) {
            return false;
        }
        return true;
    }

    /**
     * 建築物升級完成時發動效果
     *
     * @param opt //建築物編號
     */
    public void upgradeBuild(int opt) {
        switch (opt) {
            case 1:
                unit.setVillagerGenRate(unit.getVillagerGenRate() + 2);
                buildingList.get(opt - 1).setUpgradeCheck(Building.UpgradeCheck.UPGRADEABLE);
                buildingList.get(opt - 1).setUpgradeNeedTime(30);
                break;
            case 2:
                civilLevel++;
                buildingList.get(opt - 1).setUpgradeCheck(Building.UpgradeCheck.UPGRADEABLE);
                buildingList.get(opt - 1).setUpgradeNeedTime(24);
                if (civilLevel >= 2) {
                    buildingList.get(opt - 1).setUpgradeResource(new Resource(60, 30, 10));
                }
                break;
            case 3:
                unit.setArmyGenRate(unit.getArmyGenRate() + 2);
                buildingList.get(opt - 1).setUpgradeCheck(Building.UpgradeCheck.UPGRADEABLE);
                buildingList.get(opt - 1).setUpgradeNeedTime(30);
                break;
            case 4:
                resource.setWoodRate(resource.getWoodRate() + 2);
                buildingList.get(opt - 1).setUpgradeCheck(Building.UpgradeCheck.UPGRADEABLE);
                buildingList.get(opt - 1).setUpgradeNeedTime(30);
                break;
            case 5:
                resource.setSteelRate(resource.getSteelPeople() + 1);
                buildingList.get(opt - 1).setUpgradeCheck(Building.UpgradeCheck.UPGRADEABLE);
                buildingList.get(opt - 1).setUpgradeNeedTime(30);
                break;
            case 6:
                unit.setArmyLife(unit.getArmyLife() + 3);
                buildingList.get(opt - 1).setUpgradeCheck(Building.UpgradeCheck.UPGRADEABLE);
                buildingList.get(opt - 1).setUpgradeNeedTime(48);
                break;
            case 7:
                resource.setGasRate(resource.getGasRate() + 1);
                buildingList.get(opt - 1).setUpgradeCheck(Building.UpgradeCheck.UPGRADEABLE);
                buildingList.get(opt - 1).setUpgradeNeedTime(30);
                break;
            case 8:
                //消耗資源要增加
                buildingList.get(opt - 1).setUpgradeCheck(Building.UpgradeCheck.UPGRADEABLE);
                buildingList.get(opt - 1).setUpgradeNeedTime(48);
                break;
        }
    }

    public void showManual() {
        System.out.println("《遊戲操作手冊》");
        System.out.println("manual : 操作說明");
        System.out.println("status : 顯示狀態");
        System.out.println("dist w s : 分配採集資源人數 如(dist 12 8 >> 伐木12人及煉鋼8人)");
        System.out.println("build b  : 建造建築物       如(build 3   >> 建造兵營)");
        System.out.println("nexthours(hr) : 時間進行 hr小時");
        System.out.println("建築物編號和功能介紹:");
        System.out.println("1.房屋  :(建造成本:"+") \t每24小時產生市民+1\t" + "(升級成本:木材50 鋼鐵20 文明等級2)\t每24小時產生市民+2");
        System.out.println("2.研究所:(建造成本:木材10 鋼鐵5) \t可升級建築等級\t\t" + "(升級成本:木材30 鋼鐵15 文明等級)\t文明等級+1");
        System.out.println("3.軍營  :(建造成本:木材20 鋼鐵10)\t每 3小時產生士兵+1\t" + "(升級成本:木材30 鋼鐵15 文明等級2)\t每3小時產生士兵+2");
        System.out.println("4.筏木場:(建造成本:木材15 鋼鐵0) \t採集木材效率+1\t\t" + "(升級成本:木材30 鋼鐵15 文明等級2)\t採集木材效率+2");
        System.out.println("5.煉鋼場:(建造成本:木材15 鋼鐵5) \t採集鋼鐵效率+1\t\t" + "(升級成本:木材30 鋼鐵15 文明等級2)\t採集鋼鐵效率+2");
        System.out.println("6.兵工廠:(建造成本:木材30 鋼鐵5) \t文明等級須達到2\t" + "(升級成本:木材30 鋼鐵15 文明等級2)\t升級士兵，生命+3");
        System.out.println("7.瓦斯場:(建造成本:木材15 鋼鐵5) \t文明等級須達到2\t" + "(升級成本:木材40 鋼鐵15 文明等級3)\t升級士兵，生命+3");
        System.out.println("8.飛機場:(建造成本:木材15 鋼鐵5 瓦斯5) \t文明等級須達到2\t" + "(升級成本:木材40 鋼鐵15 文明等級3)\t升級士兵，生命+3");
    }


}
