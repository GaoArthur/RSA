import java.math.BigInteger;
import java.util.Random;

public class KeyGen {
    public BigInteger[] gen(){
        Random random = new Random();
        MR mr = new MR();
        BigInteger p, q;
        int count = 0;
        p = new BigInteger(100, random).nextProbablePrime();
        q = new BigInteger(100, random).nextProbablePrime();
        while (count < 3){
            if (mr.MR(p) == false) count++;
            else{
                p = new BigInteger(100, random).nextProbablePrime();
                count = 0;
            }
        }
        count = 0;
        while (count < 3){
            if (mr.MR(q) == false) count++;
            else{
                q = new BigInteger(100, random).nextProbablePrime();
                count = 0;
            }
        }
        BigInteger[] pq = {p,q};
        return pq;
    }

    public static void main(String[] args) {
        KeyGen keyGen = new KeyGen();
        System.out.println(keyGen.gen());
    }
}
