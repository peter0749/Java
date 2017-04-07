public class Main {
    public static void main(String args[]) {
        if (args.length != 2) {
            System.out.println("Please enter two integer!");
            return ;
        }
        Bigint a = new Bigint(args[0]);
        Bigint b = new Bigint(args[1]);
        System.out.println ("First Bigint:\t"+a);
        System.out.println ("Second Bigint:\t"+b);
        System.out.println ("First + Second:\t"+a.Add(b));
    }
};
