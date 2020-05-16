import java.math.BigInteger;

public class FME {

    //a^b mod c
    public static BigInteger Fast(BigInteger a, BigInteger b, BigInteger c){
        BigInteger result = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        BigInteger temp = a.mod(c);
        while(b.compareTo(BigInteger.ZERO) ==1){
            if(b.mod(two).equals(BigInteger.ONE))
                result= result.multiply(temp).mod(c);
            temp= temp.multiply(temp).mod(c);
            b= b.divide(two);
        }
        return result;
    }

    public static void main(String[] args) {
        FME fast = new FME();
        BigInteger a = new BigInteger("468163531651");
        BigInteger b = new BigInteger("45");
        BigInteger c = new BigInteger("74526478");
        System.out.println(fast.Fast(a,b,c));
    }

}
