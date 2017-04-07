public class Main {
    public static void main(String args[]) {
        if (args.length != 2) {
            System.out.println("Please enter exactly two integer!");
            return ;
        }
        Bigint a = new Bigint(args[0]);
        Bigint b = new Bigint(args[1]);
        System.out.println ("Note:\nOnly implements positive integers");
        System.out.println ("First Bigint:\t"+a);
        System.out.println ("Second Bigint:\t"+b);
        System.out.println ("First double:\t"+a.toDouble());
        System.out.println ("Second double:\t"+b.toDouble());
        System.out.println (a+" < "+b+" : "+a.isLessThan(b));
        System.out.println (a+" = "+b+" : "+a.isEqualTo(b));
        System.out.println (a+" > "+b+" : "+a.isGreaterThan(b));
        System.out.println (a+" <= "+b+" : "+a.isLessThanOrEqulTo(b));
        System.out.println (a+" >= "+b+" : "+a.isGreaterThanOrEqulTo(b));
        System.out.println (a+" != "+b+" : "+a.isNotEqualTo(b));
        System.out.println (a+" + "+b+" = "+a.Add(b));
        System.out.println ("| "+a+" - "+b+" | = "+a.Diff(b));
        System.out.println (a+" * "+b+" = "+a.Mul(b));
    }
};
