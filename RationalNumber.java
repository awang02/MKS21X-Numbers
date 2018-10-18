public class RationalNumber extends RealNumber {
  private int numerator, denominator;

  public RationalNumber(int nume, int deno){
    super(0.0);
    if (deno == 0) {
      numerator = 0;
      denominator = 1;
    }
    else {
      numerator = nume / gcd(nume,deno);
      denominator = deno / gcd(nume,deno);
    }
    this.reduce();
  }

  public double getValue(){
    return numerator / denominator;
  }

  public int getNumerator(){
    return numerator;
  }

  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    RationalNumber recip = new RationalNumber
    (this.getDenominator(), this.getNumerator());
    return recip;
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    boolean n = (this.getNumerator() == other.getNumerator());
    boolean d = (this.getDenominator() == other.getDenominator());
    return n && d;
  }

  public String toString(){
    return "" + numerator + "/" + denominator + "";
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    if (b != 0){
      return gcd(b,a%b);
    }
    return a;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int reducer = gcd(numerator,denominator);
    numerator /= reducer;
    denominator /= reducer;
    if (denominator < 0) {
      numerator *= -1;
      denominator *= -1;
    }
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
