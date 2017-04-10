public class test {
    public static void main(String args[]) {
        Rational rat1 = new Rational();
        Rational rat2 = new Rational(4,6);
        Rational rat3 = new Rational(3,7);
        System.out.println( "(default) rat1: " + rat1 );
        System.out.println( "(5 digit) rat1: " + rat1.DecimalString(5) );
        System.out.println( "(4 , 6)   rat2: " + rat2 );
        System.out.println( "(7 digit)   rat2: " + rat2.DecimalString(7) );
        System.out.println( "(3 , 7)   rat3: " + rat3 );
        System.out.println( "(9 digit)   rat3: " + rat3.DecimalString(9) );
        System.out.println( "rat2 + rat3 = " + Rational.Add(rat2,rat3) );
        System.out.println( "rat2 - rat3 = " + Rational.Subtract(rat2,rat3) );
        System.out.println( "rat2 * rat3 = " + Rational.Multiply(rat2,rat3) );
        System.out.println( "rat2 / rat3 = " + Rational.Divide(rat2,rat3) );
    }
};
