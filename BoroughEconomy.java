public class BoroughEconomy{
  private String name;
  private double rent;
  private double economicFactor;

  public BoroughEconomy(){
    this("None",1000.0, 1.0);
  }
  public BoroughEconomy(String name, double rent, double economicFactor){
    this.name = name;
    this.rent = rent;
    this.economicFactor = economicFactor;
  }
}
