/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
/**
 *
 * @author kisso
 */
public class BuildingArray{
    private ArrayList<Building> buildingArr = new ArrayList<Building>();
    public BuildingArray(){
//number,name,life,buildResource,buildCheck,buildNeedTime,buildTime,needCivilLevel,
//upgradeResource,upgradeCheck,upgradeNeedTime,onOff
//編號,名稱,生命,建資源,建判,建需時,建時,建文明,
//升級資源,升判,升級需時,開關)
//Resource(10,0,0)Resource(30,15,0)
        buildingArr.add(new Building(1,"房屋",1,10,new Resource(10,0,0),-1,1,-1,1,new Resource(30,15,0),-1,30,false,2));
        buildingArr.add(new Building(2,"研究所",1,30,new Resource(10,5,0),-1,3,-1,1,new Resource(50,20,0),-1,24,false,1));
        buildingArr.add(new Building(3,"軍營",1,30,new Resource(20,10,0),-1,2,-1,1,new Resource(30,15,0),-1,30,false,2));
        buildingArr.add(new Building(4,"伐木場",1,10,new Resource(15,0,0),-1,1,-1,1,new Resource(30,15,0),-1,30,false,2));
        buildingArr.add(new Building(5,"煉鋼廠",1,10,new Resource(15,5,0),-1,1,-1,1,new Resource(15,5,0),-1,30,false,2));
        buildingArr.add(new Building(6,"兵工廠",1,30,new Resource(30,10,0),-1,3,-1,2,new Resource(70,40,0),-1,48,false,2));
        buildingArr.add(new Building(7,"瓦斯廠",1,20,new Resource(15,5,0),-1,1,-1,2,new Resource(40,20,0),-1,30,false,3));
        buildingArr.add(new Building(8,"飛機工廠",1,50,new Resource(15,5,5),-1,2,-1,2,new Resource(15,5,5),2,0,false,2));
    }

    
}
