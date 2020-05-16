import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSA {

    public static void main(String[] args) {

        KeyGen keyGen = new KeyGen();
        BigInteger[] pq = keyGen.gen();
        BigInteger p = pq[0];
        BigInteger q = pq[1];
        Random random = new Random();
        BigInteger n = p.multiply(q);
        BigInteger phiN = (p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));
        BigInteger e;
        EEA eea = new EEA();
        do {
            e = new BigInteger(10, random).nextProbablePrime();
        } while (!eea.gcd(phiN, e).equals(BigInteger.ONE));
        BigInteger d;
        //eeaResult[] is r,x,y
        BigInteger[] eeaResult = eea.exGCD(e,phiN);
        if (eeaResult[1].compareTo(BigInteger.ZERO)>0) {
            d = eeaResult[1];
        } else {
            d = eeaResult[1].add(phiN);
        }
        //pk = (n;e)
        //sk = d;

        BigInteger m = null;
        BigInteger c = null;

        Scanner scanner = new Scanner(System.in);
        int choseNum = 0;
        while (choseNum != 3) {
            System.out.println("[1]Encryption [2]Decryption [3]Exit");
            choseNum = scanner.nextInt();
            Scanner scanner1 = new Scanner(System.in);
            if (choseNum == 1) {
                System.out.println("Input the message: ");
                m = scanner1.nextBigInteger();
                if (m.compareTo(n) == 1) {
                    System.out.println("m is too large, try again!");
                } else {
                    c = FME.Fast(m, e, n);
                    System.out.println("Cipher：" + c);
                }
            } else if (choseNum == 2) {
                System.out.println("Input the cipher:");
                c = scanner1.nextBigInteger();
                m = FME.Fast(c, d, n);
                System.out.println("Message：" + m);
            } else if (choseNum == 3) {
                System.out.println("Good Bye!");
                choseNum = 3;
            } else {
                System.out.println("Wrong!");
            }
        }

    }
}
