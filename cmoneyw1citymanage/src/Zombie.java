import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Zombie {
    //改
    Random random = new Random();
    public int wave; //殭屍第幾波
    //    public int zombieAttack;
    public int airValue;
    public int landValue;

    public Zombie() {
        this.wave = 0;
    }

    public int getZombieLandValue() {
        return landValue;
    }

    public int setZombieLandValue() {
        int zombieA = 5;
        int zombieB = 7;
        int zombieC = 10;
        int zombieD = 13;
        int zombieE = 17;
        int zombieF = 25;

        landValue = wave * 3 * zombieA + wave / 10 * 5 * zombieB + wave / 10 * 4 * zombieC +
                wave / 10 * 3 * zombieD + wave / 10 * 2 * zombieE + wave / 10 * 1 * zombieF;
        //zombieWave ++ ;
        return landValue;
    }

    public int getZombieAirValue() {
        return airValue;
    }

    public int setZombieAirValue() {

        int zombieFly = 2; //飛行殭屍
        int zombieBigFly = 4; //飛行大僵屍
        airValue = ((wave - 7) * 1 * zombieFly) + ((wave - 7) / 2 * 1 * zombieBigFly);
        return airValue;
    }

    //-----------------------------------
    //if time% 16 == 0
    //timePlus()
    //airStrike()
    //landStrike()
    //-----------------------------------

    public void timePlus() {
        wave++;
    }

    public void airStrike(Unit unit, Resource resource, ArrayList<Building> buildingList) throws InterruptedException {
        //殭屍空中攻擊
        setZombieAirValue();
        Blacksmith airCraft = ((Blacksmith) buildingList.get(5));
        if (airValue >= airCraft.getAircraftLife() * unit.getAircraftCount() + unit.getVillagerCount()) {
            //1.飛機全數墜毀 + 市民全數死亡，房屋遭受攻擊
            //飛機數量歸零，市民數量歸零
            airValue -= airCraft.getAircraftLife() * unit.getAircraftCount() + unit.getVillagerCount();
            unit.setAircraftCount(0);
            unit.setVillagerCount(0);
            //未增加房屋攻擊-------------------------------------------------------------------------------------------
            while (airValue > 0) {
                ArrayList<Building> tempBuildingList = new ArrayList<>();
                for (Building building : buildingList) {
                    if (building.getBuildCheck() == Building.BuildCheck.UNBUILDABLE) {
                        tempBuildingList.add(building);
                    }
                }
                if (buildingList.size() == 0) {
                    break;
                }
                Building buildingIsAttacked = tempBuildingList.get(random.nextInt(tempBuildingList.size()));
                if (airValue >= buildingIsAttacked.getLife()) {
                    airValue -= buildingIsAttacked.getLife();
                    showAttacked(buildingIsAttacked);
                    System.out.println(buildingIsAttacked.getName() + "已被殭屍摧毀!!!");
                    buildingIsAttacked.setLife(0);
                    buildingIsAttacked.setBuildCheck(Building.BuildCheck.BUILDABLE);
                    buildingIsAttacked.setOnOff(false);
                    buildingIsAttacked.buildReset();
                    //要記得房屋毀壞要做的事
                } else {
                    showAttacked(buildingIsAttacked);
                    System.out.println("雖然被攻擊但建築沒事!!");
                }
            }
            //顯示哪間房屋被攻擊，多少傷害(未增加在showZombie)
            //-------------------------------------------------------------------------------------------------------

        } else if (airValue >= airCraft.getAircraftLife() * unit.getAircraftCount()) {
            //2.飛機全數墜毀，市民人數夠
            //市民人數=市民人數-(飛行僵屍素質-飛機素質*飛機數量)
            //飛機數量歸零
            unit.setVillagerCount(unit.getVillagerCount() - (airValue - airCraft.getAircraftLife() * unit.getAircraftCount()));
            unit.setAircraftCount(0);
        } else {
            //3.飛機沒全部墜毀 => 飛機數量 = 飛機數量 - (飛行僵屍素質-飛機素質*飛機數量)/飛機素質
            unit.setAircraftCount(unit.getAircraftCount() - (airValue - airCraft.getAircraftLife() * unit.getAircraftCount()) / airCraft.getAircraftLife());
        }
    }

    public void landStrike(Unit unit, Resource resource, ArrayList<Building> buildingList) throws InterruptedException {
        //殭屍地面攻擊
        Blacksmith army = ((Blacksmith) buildingList.get(5));
        setZombieLandValue();
        if (landValue >= army.getArmyLife() * unit.getArmyCount() + unit.getVillagerCount()) {
            //1.士兵全數死亡 + 市民全數死亡
            //房屋遭受攻擊
            //士兵數量歸零，市民數量歸零
            unit.setArmyCount(0);
            unit.setArmyCount(0);
            //未增加房屋攻擊-------------------------------------------------------------------------------------------

            while (airValue > 0) {
                ArrayList<Building> tempBuildingList = new ArrayList<>();
                for (Building building : buildingList) {
                    if (building.getBuildCheck() == Building.BuildCheck.UNBUILDABLE) {
                        tempBuildingList.add(building);
                    }
                }
                if (buildingList.size() == 0) {
                    break;
                }
                Building buildingIsAttacked = tempBuildingList.get(random.nextInt(tempBuildingList.size()));
                if (airValue >= buildingIsAttacked.getLife()) {
                    airValue -= buildingIsAttacked.getLife();
                    showAttacked(buildingIsAttacked);
                    buildingIsAttacked.setLife(0);
                    System.out.println(buildingIsAttacked.getName() + "已被殭屍摧毀!!!");
                    buildingIsAttacked.setBuildCheck(Building.BuildCheck.BUILDABLE);
                    buildingIsAttacked.setOnOff(false);
                    buildingIsAttacked.buildReset();
                    //要記得房屋毀壞要做的事
                } else {
                    showAttacked(buildingIsAttacked);
                    System.out.println("雖然被攻擊但建築沒事!!");
                }
            }

            //顯示哪間房屋被攻擊，多少傷害(未增加在showZombie)
            //-------------------------------------------------------------------------------------------------------

        } else if (landValue >= army.getArmyLife() * unit.getArmyCount()) {
            //2.士兵全部死亡，，市民人數夠
            //市民人數=市民人數-(陸地僵屍素質-士兵素質*士兵數量)
            //士兵數量歸零
            unit.setVillagerCount(unit.getVillagerCount() - (landValue - army.getArmyLife() * unit.getArmyCount()));
            unit.setArmyCount(0);
            //break inner;
        } else {
            //3.士兵有存活
            //士兵數量=士兵人數-(陸地僵屍素質-士兵素質*士兵數量)/士兵素質
            unit.setArmyCount(unit.getArmyCount() - (landValue - army.getArmyLife() * unit.getArmyCount()) / army.getArmyLife());
        }

        //秀出僵屍戰鬥結果
        showZombie(unit, resource, buildingList);
    }

    public void showZombie(Unit unit, Resource resource, ArrayList<Building> buildingList) { //新增
        System.out.println("\n殭屍來襲: 第" + wave + "波");
        System.out.println("當前時間: " + wave * 16);
        System.out.println("市民: " + unit.getVillagerCount() + "\t士兵: " + unit.getArmyCount() + "\t飛機: " + unit.getAircraftCount());
        System.out.println("當前木頭: " + resource.getWood() + "\t當前鐵礦: " + resource.getSteel() + "\t當前瓦斯: " + resource.getGas());
        System.out.println("採集wood: " + resource.getWoodPeople() + "人" + " 採集steel: " + resource.getSteelPeople() + "人");
        System.out.println("遭受攻擊建築物:");
        System.out.println();
    }

    public void showAttacked(Building building) throws InterruptedException {
        int repeatTimes = 3;
        for (int i = 0; i <= repeatTimes; i++) {
            Thread.sleep(1500);
            System.out.println("--------" + building.getName() + "被攻擊中--------");
        }
    }
}