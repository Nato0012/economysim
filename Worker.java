public class Worker {
  private String name;
  private double experience;
  private double efficiency;
  private int morale;

  public Worker(){
    this("None",0.0,0.5,100);
  }
  public Worker(String name, double experience, double efficiency, int morale){
    this.name = name;
    this.experience = experience;
    this.efficiency = efficiency;
    this.morale = morale;
  }
  
