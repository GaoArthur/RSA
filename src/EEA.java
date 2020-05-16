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
        if (b.equals(BigInteger.ZERO)) {
            BigInteger x1 = BigInteger.ONE;
            BigInteger y1 = BigInteger.ZERO;
            BigInteger x = x1;
            BigInteger y = y1;
            BigInteger r = a;
            BigInteger[] result = {r, x, y};
            return result;
        } else {
            BigInteger[] temp = exGCD(b, a.mod(b));
            BigInteger r = temp[0];
            BigInteger x1 = temp[1];
            BigInteger y1 = temp[2];

            BigInteger x = y1;
            BigInteger y = x1.subtract(a.divide(b).multiply(y1));
            BigInteger[] result = {r, x, y};
            return result;
        }
    }

    public static void main(String[] args) {
        EEA eea = new EEA();
        BigInteger a = new BigInteger("1240");
        BigInteger b = new BigInteger("870");
        System.out.println(eea.gcd(a,b));
        BigInteger[] r = eea.exGCD(a,b);
        for(int i = 0; i<3;i++){
            System.out.println(r[i].toString());
        }
    }

}
