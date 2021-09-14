package cmoneyweek1citymanage;

public class Status {
    public void showManual(){
        System.out.println("《遊戲操作手冊》");
        System.out.println("manual : 操作說明");
        System.out.println("status : 顯示狀態");
        System.out.println("dist w s : 分配採集資源人數 如(dist 12 8 >> 伐木12人及煉鋼8人)");
        System.out.println("build b  : 建造建築物       如(build 3   >> 建造兵營)");        
        System.out.println("nexthour    : 時間進行 1 小時");
        System.out.println("nexthalfday : 時間進行 12小時");
        System.out.println("nextday     : 時間進行 24小時");
        System.out.println("建築物編號和功能介紹:");
        System.out.println("1.房屋  :(建造成本:木材10 鋼鐵0) \t每24小時產生市民+1\t"  +    "(生級成本:木材50 鋼鐵20)\t每24小時產生市民+2");
        System.out.println("2.研究所:(建造成本:木材10 鋼鐵5) \t可升級建築等級\t\t"     +    "(生級成本:木材30 鋼鐵15)\t文明等級+1");
        System.out.println("3.軍營  :(建造成本:木材20 鋼鐵10)\t每 3小時產生士兵+1\t"  +    "(生級成本:木材30 鋼鐵15)\t每 3小時產生士兵+2");
        System.out.println("4.筏木場:(建造成本:木材15 鋼鐵0) \t採集木材效率+1\t\t"     +    "(升級成本:木材30 鋼鐵15)\t採集木材效率+2");
        System.out.println("5.煉鋼場:(建造成本:木材15 鋼鐵5) \t採集鋼鐵效率+1\t\t"     +    "(升級成本:木材30 鋼鐵15)\t採集鋼鐵效率+2");
        System.out.println("6.兵工廠:(建造成本:木材30 鋼鐵5) \t文明等級須達到2\t"     +    "(升級成本:木材30 鋼鐵15)\t升級士兵，生命+3");
    }
    public void showStatus(Date date,Villager villagers,Soldier soldiers,Resource resource,Building building){
        System.out.println("時間: " + date.time);
        System.out.println("市民狀態: " + villagers);
        System.out.println("士兵狀態: " + soldiers);
        System.out.println("現有木頭: " + resource.getWood());
        System.out.println("現有鐵礦: " + resource.getSteel());
        System.out.println("採集木頭人數: " + resource.woodPeople + "人" + 
                            "\t採集鋼鐵人數: " + resource.steelPeople + "人" + 
                            "\t建築人數:" + building + "人");
        System.out.println("採集木頭效率: " + resource.woodEfficiency);
        System.out.println("採集鋼鐵效率: " + resource.steelEfficiency);
        System.out.println();
        System.out.println("建築狀態  0>>可建造 1>>建造中 2>>不可建造");
        System.out.println("升級狀態  0>>可升級 1>>升級中");
        System.out.println("建築完成時間  -1>>未建造 n>>於遊戲時間n時建造完成");
        for(int i=0; i<building.buildingObj.size(); i++){
            System.out.print("編號:" + building.buildingObj.get(i)[0]);
            System.out.print("  房屋等級:" + building.buildingObj.get(i)[1]);
            System.out.print("  建築狀態:" + building.buildingObj.get(i)[8]);
            System.out.print("  建築剩餘時間:" + building.buildingObj.get(i)[9]);
            System.out.print("  建築完成時間:" + building.buildingObj.get(i)[10]);
            System.out.print("  升級狀態:" + building.buildingObj.get(i)[4]);
            System.out.println("  升級剩餘時間:" + building.buildingObj.get(i)[7]);
//            for(int j=0; j<building.buildingObj.get(0).length; j++){
//                System.out.print(building.buildingObj.get(i)[j]);
//            }
        }
    }
}
