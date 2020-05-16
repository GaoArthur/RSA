import java.math.BigInteger;
import java.util.Random;

public class MR {

    public boolean MR(BigInteger n) {

        Random random = new Random();
        BigInteger a = new BigInteger(n.bitLength(),random);
        BigInteger t = n.subtract(BigInteger.ONE);
        int s = 0;
        BigInteger d = t;

        while (t.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            t = t.divide(BigInteger.TWO);
            d = t.mod(BigInteger.TWO);
            s++;
        }

        //step1
        if (FME.Fast(a, d, n).equals(BigInteger.ONE)) {
            return true;
        }

        //step2
        BigInteger ex;
        for (int i = 0; i < s; i++) {
            ex=BigInteger.TWO.pow(i).multiply(d);
            if(FME.Fast(a,ex,n).equals(BigInteger.ONE.negate()))
                return true;
        }

        return false;

    }

    public static void main(String[] args) {
        MR mr = new MR();
        BigInteger n = new BigInteger("17");
        System.out.println(mr.MR(n));
    }

}
