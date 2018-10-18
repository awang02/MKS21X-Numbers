public class RealNumber{
  private double value;

  public RealNumber(double v){
    value = v;
  }

  public double getValue(){
    return value;
  }

  public String toString(){
    return "" + value;
  }
  
  public double add(RealNumber other){
     return other.getValue() + this.getValue();
  }

  public double multiply(RealNumber other){
    return this.getValue() * other.getValue();
  }

  public double divide(RealNumber other){
    return this.getValue() / other.getValue();
  }

  public double subtract(RealNumber other){
    return this.getValue() - other.getValue();
  }
}
