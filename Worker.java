public class Worker {
  private String name;
  private double experience;
  private double efficiency;
  private int morale;
  private String role;
  private double desiredWage;


  public Worker(){
    this("None",0.0,0.5,100,"None",14.5);
  }
  public Worker(String name, double experience, double efficiency, int morale, String role, double desiredWage){
    this.name = name;
    this.experience = experience;
    this.efficiency = efficiency;
    this.morale = morale;
    this.role = role;
    this.desiredWage = desiredWage;
  }
  
