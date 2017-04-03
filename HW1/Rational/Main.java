public class Main {
    public static void main(String args[]) {
        if( args.length < 5 ) {
            System.out.println( "Please enter 5 integers as arguments." );
            System.out.println( "Usage:" );
            System.out.println( "java Main 1st_num. 1st_deno. 2nd_num. 2nd_deno. prec." );
            return;
        }
        int firstNum=Integer.parseInt(args[0]);
        int firstDeno=Integer.parseInt(args[1]);
        int secNum=Integer.parseInt(args[2]);
        int secDeno=Integer.parseInt(args[3]);
        Rational ret1 = new Rational(firstNum, firstDeno);
        Rational ret2 = new Rational(secNum, secDeno);
        System.out.println( "Decimal form:\t" + ret1.DecimalString( Integer.parseInt(args[4]) ));
        System.out.println( "Decimal form:\t" + ret2.DecimalString( Integer.parseInt(args[4]) ));
        System.out.println( "Add:\t\t" + ret1 + " + " + ret2 + " = " + Rational.Add(ret1,ret2) );
        System.out.println( "Subtract:\t" + ret1 + " - " + ret2 + " = " + Rational.Subtract(ret1,ret2) );
        System.out.println( "Multiply:\t" + ret1 + " * " + ret2 + " = " + Rational.Multiply(ret1,ret2) );
        System.out.println( "Divide:\t\t(" + ret1 + ") / (" + ret2 + ") = " + Rational.Divide(ret1,ret2) );
    }
};
