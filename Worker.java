public class Worker{
  private String job;
  private int morale;
  private int experience;

  //Constructors
  public Worker(){
  this("cook",50,50);
  }
  public Worker(String job, int morale, int experience){
    this.job = job;
    this.morale = morale;
    this.experience = experience;
  }
  
//Getters
  public String getJob(){
    return job;
  }
  public int getMorale(){
    return morale;
  }
  public int getExperience(){
    return experience;
  }

//Setters
  public void setJob(String job){
    this.job = job;
  }
  public void setMorale(int morale){
    this.morale = morale;
  }
  public void setExperience(int experience){
    this.experience = experience;
  }
