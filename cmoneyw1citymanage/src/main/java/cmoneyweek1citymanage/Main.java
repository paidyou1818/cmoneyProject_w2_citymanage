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

        // 設置初始村名數量、初始時間、初始士兵數量、殭屍
        NewStatus newStatus = new NewStatus();

        // 顯示狀態
        newStatus.showStatus();

        // 顯示操作手冊
        newStatus.showManual();

        // 判定是否還有村民or建築物，若均歸零則結束遊戲
        while (newStatus.getUnit().getVillagerCount() > 0) {
            System.out.print("\n市長請下令:");
            // 輸入指令(統一轉換為英文小寫)
            String order = sc.next().toLowerCase();

            // 指令manual >> 顯示操作手冊
            if (order.equals("manual")) {
                newStatus.showManual();
            }

            // 指令status >> 顯示狀態指令
            if (order.equals("status")) {
                newStatus.showStatus();  //秀出資訊
            }

            // 採集分配指令
            if (order.equals("dist")) {
                int woodPeople = sc.nextInt();
                int steelPeople = sc.nextInt();
                newStatus.distribute(woodPeople, steelPeople);
            }

            // 建造指令
            if (order.equals("build")) {
                newStatus.showBuilding();
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
                newStatus.showUpgrade();
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

            // 時間前進指令
            if (order.equals("nexthours")) {
                System.out.println("市長請輸入要過幾小時:");
                // 輸入經過小時
                int hr = sc.nextInt();
                // 看經過幾小時就跑幾次nextHour
                newStatus.nextHours(hr);
            }
        }
        System.out.println("\nGame Over!" +
                            "\n城市已被摧毀，市長請下次再來加油吧! இдஇ");
    }
}
