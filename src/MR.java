import java.math.BigInteger;
import java.util.Random;

public class MR {

    public boolean MR(BigInteger n) {

        if(n.mod(BigInteger.TWO).equals(0))return false;
        Random random = new Random();
        BigInteger a;
        a = new BigInteger(5,random);
        //a = new BigInteger((n.subtract(BigInteger.ONE)).bitLength()-1,random);
        BigInteger t = n.subtract(BigInteger.ONE);
        int s = 0;
        BigInteger d = t;

        while (d.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            d = d.divide(BigInteger.TWO);
            //d = d.mod(BigInteger.TWO);
            s++;
        }

        //step1
        if (FME.Fast(a, d, n).equals(BigInteger.ONE.mod(n))) {
            return true;
        }

        //step2
        BigInteger ex;
        BigInteger minusOne = BigInteger.ONE.negate();
        for (int i = 0; i < s; i++) {
            ex=BigInteger.TWO.pow(i).multiply(d);
            if(FME.Fast(a,ex,n).equals(minusOne.mod(n)))
                return true;
        }

        return false;

    }

    public static void main(String[] args) {
        MR mr = new MR();
        BigInteger n = new BigInteger("113");
        System.out.println(mr.MR(n));
    }

}
