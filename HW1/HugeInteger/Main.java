public class Main {
    public static void main(String args[]) {
        if (args.length != 2) {
            System.out.println("Please enter exactly two integer!");
            return ;
        }
        HugeInteger a = new HugeInteger(args[0]);
        HugeInteger b = new HugeInteger(args[1]);
        System.out.println ("Note:\nOnly implements positive integers\n");
        System.out.println ("First HugeInteger:\t"+a);
        System.out.println ("Second HugeInteger:\t"+b);
        System.out.println ("First double:\t"+a.toDouble());
        System.out.println ("Second double:\t"+b.toDouble());
        System.out.println (a+" isZero:\t"+a.isZero());
        System.out.println (b+" isZero:\t"+b.isZero());
        System.out.println (a+" < "+b+" : "+a.isLessThan(b));
        System.out.println (a+" = "+b+" : "+a.isEqualTo(b));
        System.out.println (a+" > "+b+" : "+a.isGreaterThan(b));
        System.out.println (a+" <= "+b+" : "+a.isLessThanOrEqualTo(b));
        System.out.println (a+" >= "+b+" : "+a.isGreaterThanOrEqualTo(b));
        System.out.println (a+" != "+b+" : "+a.isNotEqualTo(b));
        System.out.println (a+" + "+b+" = "+a.add(b));
        System.out.println ("| "+a+" - "+b+" | = "+a.subtract(b));
        System.out.println (a+" * "+b+" = "+a.multiply(b));
        System.out.println (a+" / "+b+" = "+a.divide(b));
        System.out.println (a+" % "+b+" = "+a.remainder(b));
    }
};
