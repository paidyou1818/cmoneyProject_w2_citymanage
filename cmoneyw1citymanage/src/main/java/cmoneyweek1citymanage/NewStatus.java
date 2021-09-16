package cmoneyweek1citymanage;

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

    public int getTime() {
        return time;
    }

    public Resource getResource() {
        return resource;
    }

    public Unit getUnit() {
        return unit;
    }

    public Zombie getZombie() {
        return zombie;
    }

    public ArrayList<Building> getBuildingList() {
        return buildingList;
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
            unit.addVillager(((House) buildingList.get(0)).getVillagerGenRate());
            resource.reduceResource(buildingList.get(0).getEffectResource());
            buildingList.get(0).setBuildTime(time);
        }
        //增加士兵
        if (isEnough(buildingList.get(2).getEffectResource()) &&
                buildingList.get(2).isOnOff() &&
                buildingList.get(2).getBuildCheck() == Building.BuildCheck.UNBUILDABLE &&
                (time - buildingList.get(2).getBuildTime()) % 3 == 0) {
            unit.addArmy(((Barracks) buildingList.get(2)).getArmyGenRate());
            resource.reduceResource(buildingList.get(2).getEffectResource());
            buildingList.get(2).setBuildTime(time);

        }
        //增加飛機
        if (isEnough(new Resource(0, 0, 5 * buildingList.get(7).getBuildingLevel())) &&
                buildingList.get(7).isOnOff() &&
                buildingList.get(7).getBuildCheck() == Building.BuildCheck.UNBUILDABLE &&
                (time - buildingList.get(7).getBuildTime()) % 3 == 0) {
            unit.addAircraft(((AirFactory) buildingList.get(7)).getAircraftGenRate());
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
        int civilLevel = ((University) buildingList.get(1)).getCivilLevel();
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
        if (opt == 2 && ((University)buildingList.get(1)).getCivilLevel() == 3) {
            System.out.println("文明等級已達上限，研究所無法升級");
        } else if (((University)buildingList.get(1)).getCivilLevel() >= buildingList.get(opt - 1).getUpNeedCivilLevel()) {
            System.out.println("文明等級不足");
        } else if (((University)buildingList.get(1)).getCivilLevel() >= buildingList.get(opt - 1).getUpNeedCivilLevel() &&
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

    public void showManual() {
        System.out.println("\n《遊戲指令操作手冊》");
        System.out.println("manual : 操作說明");
        System.out.println("status : 顯示狀態");
        System.out.println("dist w s : 分配採集資源人數 如(dist 12 8 >> 伐木12人及煉鋼8人)");
        System.out.println("build    : 建造建築物");
        System.out.println("upgrade  : 升級建築物");
        System.out.println("nexthours(hr) : 時間進行 hr 小時");
    }

    public void showBuilding() {
        System.out.println("《建築物編號和功能介紹》");
        for (int i = 0; i < getBuildingList().size(); i++) {
            getBuildingList().get(i).printBuild();
        }
//        System.out.println("1.房屋　:(建造成本:木材" +  "鋼鐵0) \t功能：每24小時產生市民+1\t" + "(升級成本:木材50 鋼鐵20)\t每24小時產生市民+2");
//        System.out.println("2.研究所:(建造成本:木材10 鋼鐵5) \t功能：可升級建築等級\t\t" + "(升級成本:木材30 鋼鐵15)\t文明等級+1");
//        System.out.println("3.軍營　:(建造成本:木材20 鋼鐵10)\t功能：每 3小時產生士兵+1\t" + "(升級成本:木材30 鋼鐵15)\t每 3小時產生士兵+2");
//        System.out.println("4.伐木場:(建造成本:木材15 鋼鐵0) \t功能：採集木材效率+1\t\t" + "(升級成本:木材30 鋼鐵15)\t採集木材效率+2");
//        System.out.println("5.煉鋼場:(建造成本:木材15 鋼鐵5) \t功能：採集鋼鐵效率+1\t\t" + "(升級成本:木材30 鋼鐵15)\t採集鋼鐵效率+2");
//        System.out.println("6.兵工廠:(建造成本:木材30 鋼鐵5) \t功能：文明等級須達到2\t\t" + "(升級成本:木材30 鋼鐵15)\t升級士兵，生命+3");
    }

    public void showUpgrade() {
        System.out.println("《建築物編號和升級功能介紹》");
        for (int i = 0; i < getBuildingList().size(); i++) {
            getBuildingList().get(i).printUpgrade();
        }
//        System.out.println("1.房屋　:(升級成本:木材50 鋼鐵20) \t功能：每24小時產生市民+1\t" + "(升級成本:木材50 鋼鐵20)\t每24小時產生市民+2");
//        System.out.println("2.研究所:(升級成本:木材30 鋼鐵15) \t功能：可升級建築等級\t\t" + "(升級成本:木材30 鋼鐵15)\t文明等級+1");
//        System.out.println("3.軍營　:(升級成本:木材30 鋼鐵15)\t功能：每 3小時產生士兵+1\t" + "(升級成本:木材30 鋼鐵15)\t每 3小時產生士兵+2");
//        System.out.println("4.伐木場:(升級成本:木材30 鋼鐵15) \t功能：採集木材效率+1\t\t" + "(升級成本:木材30 鋼鐵15)\t採集木材效率+2");
//        System.out.println("5.煉鋼場:(升級成本:木材30 鋼鐵15) \t功能：採集鋼鐵效率+1\t\t" + "(升級成本:木材30 鋼鐵15)\t採集鋼鐵效率+2");
//        System.out.println("6.兵工廠:(升級成本:木材30 鋼鐵15) \t功能：文明等級須達到2\t\t" + "(升級成本:木材30 鋼鐵15)\t升級士兵，生命+3");
    }

    public void showStatus() {
        System.out.println("\n《目前城市狀態》");
        System.out.println("時間: 第" + getTime() + "小時" +
                "\t文明等級: " + ((University)buildingList.get(1)).getCivilLevel());
        System.out.println("總市民數: " + getUnit().getVillagerCount() +
                "\t總士兵數: " + getUnit().getArmyCount() +
                "\t總飛機數: " + getUnit().getAircraftCount());
        System.out.println("現有木材: " + getResource().getWood() +
                "\t採集木材人數: " + getResource().getWoodPeople() + "人" +
                "\t採集木材效率: 每小時採集 " + getResource().getWoodRate() + " 木材");
        System.out.println("現有鋼鐵: " + getResource().getSteel() +
                "\t採集鋼鐵人數: " + getResource().getSteelPeople() + "人" +
                "\t採集鋼鐵效率: 每小時採集" + getResource().getSteelRate() + " 鋼鐵");
        System.out.println("現有瓦斯: " + getResource().getGas() +
                "\t市民無法採集瓦斯，請建造瓦斯廠來生產瓦斯" +
                "\t生產瓦斯效率: 每小時生產" + getResource().getGasRate() + " 瓦斯");
        System.out.println();
        for (int i = 0; i < buildingList.size(); i++) {
            Building build = buildingList.get(i);
            System.out.println(
                    "編號:" + build.getNumber() +
                    "\t房屋等級:" + build.getName() +
                    "\t建築狀態:" + build.getBuildCheck() +
                    "\t建築剩餘時間:" + build.getBuildNeedTime() +
                    "\t升級狀態:" + build.getUpgradeCheck() +
                    "\\t升級剩餘時間:" + build.getUpgradeNeedTime());
        }
//        System.out.println("建築狀態  0>>可建造 1>>建造中 2>>不可建造\t\t建築人數:" + building + "人");
//        System.out.println("升級狀態  0>>可升級 1>>升級中");
//        System.out.println("建築完成時間  -1>>未建造 n>>於遊戲時間n時建造完成");
//        for (int i = 0; i < building.buildingObj.size(); i++) {
//            System.out.print("\t編號:" + building.buildingObj.get(i)[0]);
//            System.out.print("\t房屋等級:" + building.buildingObj.get(i)[1]);
//            System.out.print("\t建築狀態:" + building.buildingObj.get(i)[8]);
//            System.out.print("\t建築剩餘時間:" + building.buildingObj.get(i)[9]);
//            System.out.print("\t建築完成時間:" + building.buildingObj.get(i)[10]);
//            System.out.print("\t升級狀態:" + building.buildingObj.get(i)[4]);
//            System.out.println("\t升級剩餘時間:" + building.buildingObj.get(i)[7]);

    }
}