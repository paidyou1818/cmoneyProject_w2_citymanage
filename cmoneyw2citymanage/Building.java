/**
 *
 * @author kisso
 */
public class Building {
    private int number;
    private String name;
    private int life;

    private Resource buildResource;
    private int buildCheck;
    private int buildNeedTime;
    private int buildTime;
    private int needCivilLevel;

    private Resource upgradeResource;
    private int upgradeCheck;
    private int upgradeNeedTime;

    private boolean onOff;
    public Building(){}
    public Building(int number, String name, int life, Resource buildResource, int buildCheck, int buildNeedTime, int buildTime, int needCivilLevel, Resource upgradeResource, int upgradeCheck, int upgradeNeedTime, boolean onOff) {
        this.number = number;
        this.name = name;
        this.life = life;
        this.buildResource = buildResource;
        this.buildCheck = buildCheck;
        this.buildNeedTime = buildNeedTime;
        this.buildTime = buildTime;
        this.needCivilLevel = needCivilLevel;
        this.upgradeResource = upgradeResource;
        this.upgradeCheck = upgradeCheck;
        this.upgradeNeedTime = upgradeNeedTime;
        this.onOff = onOff;
    }
    

    
    
    


    @Override
    public String toString() {
        return "Building{" + "number=" + number + ", name=" + name + ", buildNeedTime=" + buildNeedTime + ", buildTime=" + buildTime + ", life=" + life + ", buildResource=" + buildResource + ", needCivilLevel=" + needCivilLevel + ", buildCheck=" + buildCheck + ", upgradeResource=" + upgradeResource + ", upgradeCheck=" + upgradeCheck + ", onOff=" + onOff + '}';
    }
    
    

    
}
