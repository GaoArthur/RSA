import java.math.BigInteger;

public class EEA {
    public BigInteger gcd(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return a;
        } else {
            return gcd(b, a.mod(b));
        }
    }

    public BigInteger[] exGCD(BigInteger a, BigInteger b) {
        //x0 = 1, x1 = 0, q = a/b, x = q*x1+x0
        int count=0;
        BigInteger temp, r, q;
        BigInteger[] x = {BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO};
        do {
            r = a.mod(b);
            q = a.divide(b);
            x[2] = q.multiply(x[1]).add(x[0]);

            //give the new value
            temp = b;
            a = b;
            b = r;
            x[0]=x[1];
            x[1]=x[2];
            count++;
        } while (!r.equals(BigInteger.ZERO));
        if(count%2!=0)x[0]=x[0].negate();
        BigInteger[] result = {a,x[0]};
        return result;
    }

    public static void main(String[] args) {
        EEA eea = new EEA();
        BigInteger a = new BigInteger("4862");
        BigInteger b = new BigInteger("870");
        System.out.println(eea.gcd(a, b));
        BigInteger[] r = eea.exGCD(a, b);
        for (int i = 0; i < 2; i++) {
            System.out.println(r[i].toString());
        }
    }

}
