package cmoneyweek1citymanage;

public class Zombie {
    //改
    public int wave; //殭屍第幾波
//    public int zombieAttack;
    public int airValue;
    public int landValue;
    public Zombie(){
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
        airValue = ((wave-7) * 1 * zombieFly) + ((wave-7)/2 * 1 * zombieBigFly);
        return airValue;
    }

    //-----------------------------------
    //if time% 16 == 0
    //timePlus()
    //airStrike()
    //landStrike()
    //-----------------------------------

    public void timePlus(){
        wave++;
    }

    public  void airStrike(Unit unit,Resource resource) {
        //殭屍空中攻擊
        setZombieAirValue();
        if (airValue >= unit.getAircraftLife() * unit.getAircraftCount() + unit.getVillagerCount()){
            //1.飛機全數墜毀 + 市民全數死亡，房屋遭受攻擊
            //飛機數量歸零，市民數量歸零
            unit.setAircraftCount(0);
            unit.setVillagerCount(0);
            //未增加房屋攻擊-------------------------------------------------------------------------------------------



            //顯示哪間房屋被攻擊，多少傷害(未增加在showZombie)
            //-------------------------------------------------------------------------------------------------------

        }else if (airValue >= unit.getAircraftLife() * unit.getAircraftCount()) {
            //2.飛機全數墜毀，市民人數夠
            //市民人數=市民人數-(飛行僵屍素質-飛機素質*飛機數量)
            //飛機數量歸零
            unit.setVillagerCount(unit.getVillagerCount() - (airValue - unit.getAircraftLife() * unit.getAircraftCount()));
            unit.setAircraftCount(0);
        }else {
            //3.飛機沒全部墜毀 => 飛機數量 = 飛機數量 - (飛行僵屍素質-飛機素質*飛機數量)/飛機素質
            unit.setAircraftCount(unit.getAircraftCount() - (airValue - unit.getAircraftLife() * unit.getAircraftCount())/unit.getAircraftLife());
        }
    }

    public  void landStrike(Unit unit,Resource resource) {
        //殭屍地面攻擊
        setZombieLandValue();
        if (landValue >=  unit.getArmyLife() * unit.getArmyCount() + unit.getVillagerCount()){
            //1.士兵全數死亡 + 市民全數死亡
            //房屋遭受攻擊
            //士兵數量歸零，市民數量歸零
            unit.setArmyCount(0);
            unit.setArmyCount(0);
            //未增加房屋攻擊-------------------------------------------------------------------------------------------



            //顯示哪間房屋被攻擊，多少傷害(未增加在showZombie)
            //-------------------------------------------------------------------------------------------------------

        }else if (landValue >= unit.getArmyLife() * unit.getArmyCount()) {
            //2.士兵全部死亡，，市民人數夠
            //市民人數=市民人數-(陸地僵屍素質-士兵素質*士兵數量)
            //士兵數量歸零
            unit.setVillagerCount(unit.getVillagerCount() - (landValue - unit.getArmyLife() * unit.getArmyCount()));
            unit.setArmyCount(0);
            //break inner;
        } else {
            //3.士兵有存活
            //士兵數量=士兵人數-(陸地僵屍素質-士兵素質*士兵數量)/士兵素質
            unit.setArmyCount(unit.getArmyCount() - (landValue - unit.getArmyLife() * unit.getArmyCount()) / unit.getArmyLife());
        }

        //秀出僵屍戰鬥結果
        showZombie( unit, resource);
//            人民被攻擊，採集人數歸0，要重新分配人數
//            resource.woodPeople = 0;
//            resource.steelPeople = 0;
//            System.out.println("請重新分配採集木頭、鋼鐵人數 如:woodsteel 2 4 ");


    }

    public void showZombie(Unit unit,Resource resource){ //新增
        System.out.println();
        System.out.println("殭屍來襲: 第"+ wave +"波");
        System.out.println("當前時間: " + wave*16);
        System.out.println("市民: " + unit.getVillagerCount() + "\t士兵: " + unit.getArmyCount() + "\t飛機: " + unit.getAircraftCount());
        System.out.println("當前木頭: " + resource.getWood() + "\t當前鐵礦: " + resource.getSteel() + "\t當前瓦斯: " + resource.getGas());
        System.out.println("採集wood: " + resource.woodPeople + "人" + " 採集steel: " + resource.steelPeople + "人");
        //if
        //System.out.println("對 building x 造成xx傷害");
        System.out.println();
    }

}
