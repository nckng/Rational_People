//Team Rational_RationALIziNG -- Nicholas Ng, Ruochong Wu
//APCS1 pd10
//HW #32: Irrationality Stops Here
//2015-11-17

public class Rational{

    //instance variables
    private int numerator;
    private int denominator;
    public Rational(){
	numerator = 0;
	denominator = 1;
    }
    //Constructor
    public Rational(int a, int b){
	numerator = a;
	if (b != 0){
	    denominator = b;
	}
	else{
	    numerator = 0;
	    denominator = 1;
	}
    }
    //Mutators
    public int getNum(){
	return numerator;
    }

    public int getDen(){
	return denominator;
    }
    public String toString(){
	return ""+numerator+"/"+denominator;
    }
    public double floatValue(){
	return numerator*(1.0)/denominator; 
	// division by a floating point # converts the fraction into a float
    }
    public void multiply(Rational Q){
	this.numerator = this.numerator * Q.numerator;
	this.denominator = this.denominator * Q.denominator;
    }
    public void divide(Rational Q){
	this.numerator = this.numerator * Q.denominator;
	if (Q.numerator != 0){  //makes sure there is no division by 0
	    this.denominator = this.denominator * Q.numerator;
	}
	else{
	    this.numerator = 00;
	    this.denominator = 1;
	}
    }
    public void add(Rational Q){
	this.numerator = this.numerator*Q.denominator
	    + Q.numerator*this.denominator;
	this.denominator = this.denominator*Q.denominator;
    }
    public void subtract(Rational Q){
	this.numerator = this.numerator*Q.denominator -
	    Q.numerator*this.denominator;
	this.denominator = this.denominator*Q.denominator;
    }
    public static int GCD(int a, int b){
	while (a != b){
	    if (a > b){
		a -= b;
	    }
	    else{
		b -= a;
	    }
	}
	return a;
    }

    public void reduce(){
	int gcd = GCD(numerator, denominator);
	numerator /= gcd;
	denominator /= gcd;
    }
    public int compareTo(Rational Q){
	if (this.numerator * denominator > this.denominator * Q.numerator){
	    return 1;
	}
	else if (this.numerator * Q.denominator < this.denominator * Q.numerator){
	    return -1;
	}
	else{
	    return 0;
	}
    }
	
    public static void main(String[] args){
	Rational george = new Rational();
	Rational marley = new Rational(17,38);
	Rational tigger = new Rational(21,69);
	System.out.println(tigger.GCD(tigger.numerator, tigger.denominator));
	System.out.println(george);
	System.out.println(marley);
	System.out.println(tigger);
	tigger.reduce();
	System.out.println(tigger);
	System.out.println(george.floatValue());
	System.out.println(marley.floatValue());
	System.out.println(tigger.floatValue());
	george.multiply(marley);
	tigger.multiply(tigger);
	System.out.println(george);
	System.out.println(marley);
	System.out.println(tigger);
	tigger.divide(marley);
	System.out.println(tigger);
	tigger.divide(george);
	System.out.println(tigger);
	
    }
}
