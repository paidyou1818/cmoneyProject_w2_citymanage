package cmoneyweek1citymanage;

public class Zombie {
    //改
    public int wave = 1; //殭屍第幾波
    //    public int zombieAttack;
    public int airValue;
    public int landValue;

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

    public void strike(int time, Unit unit, Resource resource) {
        if (time % 16 == 0) {
            wave = time / 16;
            setZombieAirValue();
            setZombieLandValue();
            if (airValue >= unit.getAircraftLife() * unit.getAircraftCount()) {
                //飛機失敗
                //飛機數量歸零
                //市民人數=市民人數-(飛行僵屍素質-飛機素質*飛機數量)
                unit.setAircraftCount(0);
                unit.setVillagerCount(unit.getVillagerCount() - (airValue - unit.getAircraftLife() * unit.getAircraftCount()));
            } else if (landValue >= unit.getArmyLife() * unit.getArmyCount()) {
//              //士兵失敗
                //市民人數=市民人數-(陸地僵屍素質-士兵素質*士兵數量)
                //士兵數量歸零
                //人民被攻擊，採集人數歸0，要重新分配人數
                unit.setVillagerCount(unit.getVillagerCount() - (landValue - unit.getArmyLife() * unit.getArmyCount()));
                unit.setArmyCount(0);
                showZombie(time, unit, resource);

                resource.setWoodPeople(0);
                resource.setSteelPeople(0);

                System.out.println("請重新分配分配採集資源人數 如(dist 12 8 >> 伐木12人及煉鋼8人)");
                //break inner;
            } else if (airValue + landValue < unit.getArmyLife() * unit.getArmyCount()) {
                //成功，市民沒減少
                //士兵數量
                //飛機數量
                //秀出僵屍戰鬥結果
                unit.setArmyCount((unit.getArmyLife() * unit.getArmyCount() - landValue) / unit.getArmyLife());
                unit.setAircraftCount((unit.getAircraftLife() * unit.getAircraftCount() - airValue) / unit.getAircraftLife());
                showZombie(time, unit, resource);
            }
        }
    }

    public void showZombie(int time, Unit unit, Resource resource) { //新增
        System.out.println();
        System.out.println("殭屍來襲: 第" + wave + "波");
        System.out.println("當前時間: " + time);
        System.out.println("市民: " + unit.getVillagerCount());
        System.out.println("士兵: " + unit.getArmyCount());
        System.out.println("飛機: " + unit.getAircraftCount());
        System.out.println("當前木頭: " + resource.getWood());
        System.out.println("當前鐵礦: " + resource.getSteel());
        System.out.println("當前瓦斯: " + resource.getGas());
        System.out.println("採集wood: " + resource.getWoodPeople() + "人" + " 採集steel: " + resource.getSteelPeople() + "人");
        //if
        //System.out.println("對 building x 造成xx傷害");
        System.out.println();
    }

}
