package cmoneyweek1citymanage;

public class Status {
    public void showManual() {
        System.out.println("\n《遊戲指令操作手冊》");
        System.out.println("manual : 操作說明");
        System.out.println("status : 顯示狀態");
        System.out.println("dist w s : 分配採集資源人數 如(dist 12 8 >> 伐木12人及煉鋼8人)");
        System.out.println("build    : 建造建築物");
        System.out.println("upgrade  : 升級建築物");
        System.out.println("nexthours(hr) : 時間進行 hr 小時");
    }

    public void showBuilding(NewStatus newStatus) {
        System.out.println("《建築物編號和功能介紹》");
        for (int i = 0; i < newStatus.getBuildingList().size(); i++) {

        }
        System.out.println("1.房屋　:(建造成本:木材" +  "鋼鐵0) \t功能：每24小時產生市民+1\t" + "(升級成本:木材50 鋼鐵20)\t每24小時產生市民+2");
        System.out.println("2.研究所:(建造成本:木材10 鋼鐵5) \t功能：可升級建築等級\t\t" + "(升級成本:木材30 鋼鐵15)\t文明等級+1");
        System.out.println("3.軍營　:(建造成本:木材20 鋼鐵10)\t功能：每 3小時產生士兵+1\t" + "(升級成本:木材30 鋼鐵15)\t每 3小時產生士兵+2");
        System.out.println("4.伐木場:(建造成本:木材15 鋼鐵0) \t功能：採集木材效率+1\t\t" + "(升級成本:木材30 鋼鐵15)\t採集木材效率+2");
        System.out.println("5.煉鋼場:(建造成本:木材15 鋼鐵5) \t功能：採集鋼鐵效率+1\t\t" + "(升級成本:木材30 鋼鐵15)\t採集鋼鐵效率+2");
        System.out.println("6.兵工廠:(建造成本:木材30 鋼鐵5) \t功能：文明等級須達到2\t\t" + "(升級成本:木材30 鋼鐵15)\t升級士兵，生命+3");
    }

    public void showUpgrade() {
        System.out.println("《建築物編號和升級功能介紹》");
        System.out.println("1.房屋　:(升級成本:木材50 鋼鐵20) \t功能：每24小時產生市民+1\t" + "(升級成本:木材50 鋼鐵20)\t每24小時產生市民+2");
        System.out.println("2.研究所:(升級成本:木材30 鋼鐵15) \t功能：可升級建築等級\t\t" + "(升級成本:木材30 鋼鐵15)\t文明等級+1");
        System.out.println("3.軍營　:(升級成本:木材30 鋼鐵15)\t功能：每 3小時產生士兵+1\t" + "(升級成本:木材30 鋼鐵15)\t每 3小時產生士兵+2");
        System.out.println("4.伐木場:(升級成本:木材30 鋼鐵15) \t功能：採集木材效率+1\t\t" + "(升級成本:木材30 鋼鐵15)\t採集木材效率+2");
        System.out.println("5.煉鋼場:(升級成本:木材30 鋼鐵15) \t功能：採集鋼鐵效率+1\t\t" + "(升級成本:木材30 鋼鐵15)\t採集鋼鐵效率+2");
        System.out.println("6.兵工廠:(升級成本:木材30 鋼鐵15) \t功能：文明等級須達到2\t\t" + "(升級成本:木材30 鋼鐵15)\t升級士兵，生命+3");
    }



    public void showStatus(NewStatus newStatus) {
        System.out.println("\n《目前城市狀態》");
        System.out.println("時間: 第" + newStatus.getTime() + "小時" +
                           "\t文明等級: " + newStatus.getCivilLevel());
        System.out.println("總市民數: " + newStatus.getUnit().getVillagerCount() +
                            "\t總士兵數: " + newStatus.getUnit().getArmyCount() +
                            "\t總飛機數: " + newStatus.getUnit().getAircraftCount());
        System.out.println("現有木材: " + newStatus.getResource().getWood() +
                            "\t採集木材人數: " + newStatus.getResource().getWoodPeople() + "人" +
                            "\t採集木材效率: 每小時生產 " + newStatus.getResource().getWoodRate() + " 木材");
        System.out.println("現有鋼鐵: " + newStatus.getResource().getSteel() +
                            "\t採集鋼鐵人數: " + newStatus.getResource().getSteelPeople() + "人" +
                            "\t採集鋼鐵效率: 每小時生產" + newStatus.getResource().getSteelRate() + " 鋼鐵");
        System.out.println("現有瓦斯: " + newStatus.getResource().getGas() +
                            "\t採集瓦斯效率: 每小時生產" + newStatus.getResource().getGasRate() + " 瓦斯");
        System.out.println();
        System.out.println("建築狀態  0>>可建造 1>>建造中 2>>不可建造\t\t建築人數:" + building + "人");
        System.out.println("升級狀態  0>>可升級 1>>升級中");
        System.out.println("建築完成時間  -1>>未建造 n>>於遊戲時間n時建造完成");
        for (int i = 0; i < building.buildingObj.size(); i++) {
            System.out.print("\t編號:" + building.buildingObj.get(i)[0]);
            System.out.print("\t房屋等級:" + building.buildingObj.get(i)[1]);
            System.out.print("\t建築狀態:" + building.buildingObj.get(i)[8]);
            System.out.print("\t建築剩餘時間:" + building.buildingObj.get(i)[9]);
            System.out.print("\t建築完成時間:" + building.buildingObj.get(i)[10]);
            System.out.print("\t升級狀態:" + building.buildingObj.get(i)[4]);
            System.out.println("\t升級剩餘時間:" + building.buildingObj.get(i)[7]);
        }
    }
}
