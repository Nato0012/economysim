public class BoroughEconomy{
  private String name;
  private double rent;
  private double materialCost;

  public BoroughEconomy(){
    this("None",1000.0,5.0);
  }
  public BoroughEconomy(String name, double rent, double materialCost){
    this.name = name;
    this.rent = rent;
    this.materialCost = materialCost;
  }
}
