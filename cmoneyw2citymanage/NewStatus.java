package cmoneyweek1citymanage;

import java.util.ArrayList;

/**
 * 遊戲狀態列表(數值儲存於此，取用於此)
 */
public class NewStatus {
    private int time;
    private Resource resource = new Resource();
    private Unit unit = new Unit();
    private ArrayList<Building> buildingList = new ArrayList<Building>();
}
