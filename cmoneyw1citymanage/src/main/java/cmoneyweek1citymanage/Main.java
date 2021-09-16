package cmoneyweek1citymanage;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 歡迎詞
	    System.out.println("市長你好!歡迎來到愛好世界和平城市~\n" +
                            "本城市需要市長你跟大家一起努力，才能共同抵抗恐怖的殭屍大軍!\n" +
                            "殭屍每16小時會來襲一次，記得在此之前先做好準備\n" +
                            "如果所有人民都死了，建築也被破壞殆盡的話，就遊戲結束囉!\n" +
                            "英明的市長，快來領導人民，建築你們的城市吧!o(-`д´- ｡)");
//        // 設置初始村名數量
//        Villager villagers = new Villager();
//        villagers.villagerLife(1);
//        villagers.villagerNumber(20);
//        villagers.villagerLevel = 0;
//        int passTime = 0;
//        // 設置初始時間
//        Date date = new Date();
//        date.time(0);
//
//        // 設置初始士兵數量
//        Soldier soldiers = new Soldier();
//        soldiers.soldierLife(2);
//        soldiers.soldierNumber(10);
//        soldiers.soldierLifeLevel = 0;
//        soldiers.soldierProduceLevel = 0;
//        //設置殭屍
//        Zombie zombie = new Zombie();//新增
//        boolean start = true;//新增
//        cmoneyweek1citymanage.Building building = new cmoneyweek1citymanage.Building();
//        int[] levelTime = new int[]{30,24,30,30,30,48};
//        // 設置初始資源和初始採集速度
//        Resource resource = new Resource(0, 0);//新增
//        resource.woodEfficiency = 3;//木材效率
//        resource.steelEfficiency = 1;//鋼鐵效率

        // 設置初始村名數量、初始時間、初始士兵數量、殭屍
        NewStatus newStatus = new NewStatus();

        // 顯示狀態
        Status status = new Status();
        status.showStatus(newStatus);

        // 顯示操作手冊
        status.showManual();

        // 判定是否還有村民or建築物，若均歸零則結束遊戲
        while (newStatus.getUnit().getVillagerCount() > 0) {
            System.out.print("\n市長請下令:");
            // 輸入指令
//            String order = sc.nextLine();
//            order = order.toLowerCase();
//            String[] orderArray = order.replaceAll("　", " ").trim().split("\\s+");
            // 輸入指令(統一轉換為英文小寫)
            String order = sc.next().toLowerCase();

            // 指令manual >> 顯示操作手冊
            if (order.equals("manual")) {
                status.showManual();
            }

            // 指令status >> 顯示狀態指令
            if (order.equals("status")) {
                status.showStatus(newStatus);//秀出資訊
            }

//            // 採集分配指令
//            if (order.equals("dist")) {
//                //System.out.println("請輸入2個參數分配採集木頭與鋼鐵人數 如\n2 4");
//                resource.distribution(Integer.parseInt(orderArray[1]), Integer.parseInt(orderArray[2]));
//                if (villagers.villagerNumber >= resource.woodPeople + resource.steelPeople + Integer.parseInt(building.toString())){
//                    System.out.println(resource.getDistribution());
//                } else {
//                    System.out.println("人數不足，採集人數歸0，請重新分配採集人數(建築無法取消)");
//                    resource.distribution(0, 0);
//                }
//            }


            // 建造指令
            if (order.equals("build")) {
                status.showBuilding(newStatus);
                System.out.print("請選擇要建造的建築物:");
                // 輸入建築物編號
                int opt = sc.nextInt();
                // 判定是否可以建造
                if (newStatus.build(opt)) {
                    System.out.println("開始建造" + newStatus.getBuildingList().get(opt - 1).getName() +
                                        " 預計" + newStatus.getBuildingList().get(opt - 1).getBuildNeedTime() + "小時後完成");
                } else {
                    System.out.println("無法建造" + newStatus.getBuildingList().get(opt - 1).getName() + "!");
                }
            }

            // 升級指令
            if (order.equals("upgrade")) {
                status.showUpgrade(newStatus);
                System.out.print("請選擇要升級的建築物:");
                // 輸入建築物編號
                int opt = sc.nextInt();
                // 判定是否可以升級
                if (newStatus.upgrade(opt)) {
                    System.out.println("開始升級" + newStatus.getBuildingList().get(opt - 1).getName() +
                                        " 預計" + newStatus.getBuildingList().get(opt - 1).getUpgradeNeedTime() + "小時後完成");
                } else {
                    System.out.println("無法建造" + newStatus.getBuildingList().get(opt - 1).getName() + "!");
                }
            }
//                int buildingNumber = Integer.parseInt(orderArray[1]);
//                if(resource.getWood() >= building.buildingObj.get(buildingNumber)[5] &&
//                    resource.getSteel() >= building.buildingObj.get(buildingNumber)[6] ){
//
//                    switch(buildingNumber){
//                        case 1:
//                            if(building.buildingObj.get(0)[8]==2 && building.buildingObj.get(1)[8]>=2){
//                                building.buildingObj.get(0)[4]=1;
//                                resource.setWood(resource.getWood() - building.buildingObj.get(0)[5]);
//                                resource.setSteel(resource.getSteel() - building.buildingObj.get(0)[6]);
//                            }else{
//                                System.out.println("房屋或研究所尚未被建造");
//                            }
//                            break;
//                        case 2:
//                            if(building.buildingObj.get(1)[8]==2){
//                                building.buildingObj.get(1)[4]=1;
//                                resource.setWood(resource.getWood() - building.buildingObj.get(1)[5]);
//                                resource.setSteel(resource.getSteel() - building.buildingObj.get(1)[6]);
//                            }else{
//                                System.out.println("研究所尚未被建造");
//                            }
//                            break;
//                        case 3:
//                            if(building.buildingObj.get(2)[8]==2 && building.buildingObj.get(1)[8]>=2){
//                                building.buildingObj.get(2)[4]=1;
//                                resource.setWood(resource.getWood() - building.buildingObj.get(2)[5]);
//                                resource.setSteel(resource.getSteel() - building.buildingObj.get(2)[6]);
//                            }else{
//                                System.out.println("軍營或研究所尚未被建造");
//                            }
//                            break;
//                        case 4:
//                            if(building.buildingObj.get(3)[8]==2 && building.buildingObj.get(1)[8]>=2){
//                                building.buildingObj.get(3)[4]=1;
//                                resource.setWood(resource.getWood() - building.buildingObj.get(3)[5]);
//                                resource.setSteel(resource.getSteel() - building.buildingObj.get(3)[6]);
//                            }else{
//                                System.out.println("伐木廠或研究所尚未被建造");
//                            }
//                            break;
//                        case 5:
//                            if(building.buildingObj.get(4)[8]==2 && building.buildingObj.get(1)[8]>=2){
//                                building.buildingObj.get(4)[4]=1;
//                                resource.setWood(resource.getWood() - building.buildingObj.get(4)[5]);
//                                resource.setSteel(resource.getSteel() - building.buildingObj.get(4)[6]);
//                            }else{
//                                System.out.println("煉鋼廠或研究所尚未被建造");
//                            }
//                            break;
//                        case 6:
//                            if(building.buildingObj.get(5)[8]==2){
//                                building.buildingObj.get(5)[4]=1;
//                                resource.setWood(resource.getWood() - building.buildingObj.get(4)[5]);
//                                resource.setSteel(resource.getSteel() - building.buildingObj.get(4)[6]);
//                            }else{
//                                System.out.println("兵工廠尚未被建造");
//                            }
//                            break;
//                        default:
//                            break;
//                    }
//                }else{
//                    System.out.println("資源或人數不足");
//                }
//
//
//                //建造判定
//                if(building.buildingObj.get(buildingNumber)[8]==0){
//                    if(resource.getWood() >= building.buildingObj.get(buildingNumber)[2] &&
//                            resource.getSteel() >= building.buildingObj.get(buildingNumber)[3] ){
//                        building.buildingObj.get(buildingNumber)[8]=1;
//                        resource.setWood(resource.getWood() - building.buildingObj.get(buildingNumber)[2]);
//                        resource.setSteel(resource.getSteel() - building.buildingObj.get(buildingNumber)[3]);
//                    }else{
//                        System.out.println("資源不足");
//                    }
//                }else if((building.buildingObj.get(buildingNumber)[8]==1)){
//                    System.out.println("已配置村民建造");
//                }else if((building.buildingObj.get(buildingNumber)[8]==2)){
//                    System.out.println("已存在該建築1");
//                }
//            }


            // 時間前進指令
            if (order.equals("nexthours")) {
                System.out.println("市長請輸入要過幾小時:");
                // 輸入經過小時
                int hr = sc.nextInt();
                // 看經過幾小時就跑幾次nextHour
                for (int i = 0; i < hr; i++) {
                    newStatus.nextHour();
                }
            }
//---------------------------------------------------------------------//新增
//            if (orderArray[0].substring(0,4).equals("next")) { //1小時
//                switch(orderArray[0].substring(4)){
//                    case "hour":
//                        passTime = 1;
//                        break;
//                    case "halfday":
//                        passTime = 12;
//                        break;
//                    case "day":
//                        passTime = 24;
//                        break;
//                }
//            //=================================================================for
//                int tmp = passTime;
//                inner: for (int i = 0; i < tmp; i++) {
//                    date.nextHour();
//                    date.time++;
//                    resource.resourceTime = 1;
//                    resource.woodAdd();//新增
//                    resource.steelAdd();//新增
//                // 產生村民和士兵=================================================
//                if(building.buildingObj.get(0)[8] == 2 && (date.time-building.buildingObj.get(0)[10])%24 == 0){
//                    villagers.villagerAdd();
//                }
//                if(building.buildingObj.get(2)[8] == 2 && (date.time-building.buildingObj.get(2)[10])%3 == 0){
//                    soldiers.soldierAdd();
//                }
//
////判定是否完成建造
//                    for(int bs=0; bs<building.buildingObj.size(); bs++){
//
//                        if(building.buildingObj.get(bs)[9] > 0 && building.buildingObj.get(bs)[8]==1){
//                            building.buildingObj.get(bs)[9] -= 1;
//                            if(building.buildingObj.get(bs)[9] == 0){
//                                building.buildingObj.get(bs)[8]++;
//                                building.buildingObj.get(bs)[1]++;
//                                building.buildingObj.get(bs)[10] = date.time;
//
//                            }
//                        }
//                    }
//
//
//
////判定是否完成升級
//                    for(int up=0; up < building.buildingObj.size(); up++){
//
//                        if(building.buildingObj.get(up)[7] > 0 && building.buildingObj.get(up)[4]==1){
//                            building.buildingObj.get(up)[7] -= 1;
//                            if(building.buildingObj.get(up)[7] == 0){
//                                building.buildingObj.get(up)[1]++;
//                                building.buildingObj.get(up)[4]=0;
//                                building.buildingObj.get(up)[7]= levelTime[building.buildingObj.get(up)[0]-1];
//
//                            }
//                        }
//                    }
//                    //更改各資源生產速度
//                    villagers.villagerLevel = building.buildingObj.get(0)[1];
//                    soldiers.soldierProduceLevel = building.buildingObj.get(2)[1];
//                    soldiers.soldierLifeLevel = building.buildingObj.get(5)[1];
//                    villagers.villagerProduce = Math.max(0, villagers.villagerLevel*2-1);
//                    soldiers.soldierProduce = Math.max(0, soldiers.soldierProduceLevel*2-1);
//                    soldiers.soldierLife = soldiers.soldierLifeLevel*3 + 2;
//                    if(building.buildingObj.get(3)[1]==0){
//                        resource.woodEfficiency=3;
//                    }else{
//                        resource.woodEfficiency = 2*(building.buildingObj.get(3)[1]+1);
//                    }
//                    resource.steelEfficiency = building.buildingObj.get(4)[1] + 1;
//
//
//
//
////殭屍來襲
//                    if (date.time % 16 == 0) {
//                        zombie.zombieWave = date.time / 16;
//                        zombie.setZombieAttack();
//                        if (zombie.zombieAttack >= soldiers.soldierLife * soldiers.soldierNumber) {
//                            //失敗
//                            zombie.failZombie(soldiers, villagers, resource);
//                            zombie.showZombie(date, villagers, soldiers, resource);
//                            resource.distribution(0, 0);
//                            System.out.println("請重新分配採集木頭與鋼鐵人數 如:woodsteel 2 4");
//                            break inner;
//                        } else if (zombie.zombieAttack < soldiers.soldierLife * soldiers.soldierNumber) {
//                            //成功
//                            zombie.successZombie(soldiers);
//                            zombie.showZombie(date, villagers, soldiers, resource);
//                        }
//                    }
//                    if (i == tmp-1) { //最後執行次數顯示狀態
//                        status.showStatus(date, villagers, soldiers, resource, building);//秀出資訊
//
//                    }
//                }
//            }
//-----------------------------------------------------------------------------
        }
        System.out.println("\nGame Over!" +
                            "\n城市已被摧毀，市長請下次再來加油吧! இдஇ");
    }
}
