public class RationalNumber extends RealNumber {
  private int numerator, denominator;

  public RationalNumber(int nume, int deno){
    super(0.0);
    if (deno == 0) {
      numerator = 0;
      denominator = 1;
    }
    else {
      numerator = nume;
      denominator = deno;
    }
    this.reduce();
  }

  private void reduce(){
    double reducer = gcd(numerator,denominator);
    numerator /= reducer;
    denominator /= reducer;
    if (denominator < 0) {
      numerator *= -1;
      denominator *= -1;
    }
  }

  private static int gcd(int a, int b){
    if (b != 0){
      return gcd(b,a%b);
    }
    return a;
  }

  public String toString(){
    if (denominator == 1) {
      return "" + numerator;
    }
    return "" + numerator + "/" + denominator + "";
  }

  public double getValue(){
    return (double)numerator / denominator;
  }

  public int getNumerator(){
    return numerator;
  }

  public int getDenominator(){
    return denominator;
  }

  public RationalNumber reciprocal(){
    RationalNumber recip = new RationalNumber
    (this.getDenominator(), this.getNumerator());
    return recip;
  }

  public boolean equals(RationalNumber other){
    boolean n = (this.getNumerator() == other.getNumerator());
    boolean d = (this.getDenominator() == other.getDenominator());
    return n && d;
  }

  public RationalNumber multiply(RationalNumber other){
    RationalNumber product = new RationalNumber
    (this.getNumerator() * other.getNumerator(), this.getDenominator() * other.getDenominator());
    return product;
  }

  public RationalNumber divide(RationalNumber other){
    return this.multiply(other.reciprocal());
  }

  public RationalNumber add(RationalNumber other){
    RationalNumber sum = new RationalNumber
    (this.getNumerator() * other.getDenominator() +
    other.getNumerator() * this.getDenominator(), this.getDenominator() * other.getDenominator());
    return sum;
  }
  public RationalNumber subtract(RationalNumber other){
    RationalNumber diff = new RationalNumber
    (this.getNumerator() * other.getDenominator() -
    other.getNumerator() * this.getDenominator(), this.getDenominator() * other.getDenominator());
    return diff;
  }
}
