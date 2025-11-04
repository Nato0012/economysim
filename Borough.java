public class Borough{
  private String name;
  private double rent;
  private double economicFactor;

  public Borough(){
    this("None",1000.0, 1.0);
  }
  public Borough(String name, double rent, double economicFactor){
    this.name = name;
    this.rent = rent;
    this.economicFactor = economicFactor;
  }
}
