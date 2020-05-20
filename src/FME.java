import java.math.BigInteger;

public class FME {

    //a^b mod c
    public static BigInteger Fast(BigInteger a, BigInteger b, BigInteger c) {
        BigInteger result = BigInteger.ONE;
        BigInteger two = BigInteger.TWO;
        BigInteger temp = a.mod(c);
        while (b.compareTo(BigInteger.ZERO) == 1) {
            if (b.mod(two).equals(BigInteger.ONE))
                result = result.multiply(temp).mod(c);
            temp = temp.multiply(temp).mod(c);
            b = b.divide(two);
        }
        return result;
    }

    public static void main(String[] args) {
        FME fast = new FME();
        BigInteger a = new BigInteger("3");
        BigInteger b = new BigInteger("3");
        BigInteger c = new BigInteger("5");
        System.out.println(fast.Fast(a, b, c));
    }

}
