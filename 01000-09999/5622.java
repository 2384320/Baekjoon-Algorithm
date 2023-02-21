import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] str = br.readLine().toCharArray();
        int clock = 0;

        for (int i = 0; i < str.length; i++) {
            switch (str[i]) {
                case ('A'):
                case ('B'):
                case ('C'):
                    clock += 3;
                    break;
                case ('D'):
                case ('E'):
                case ('F'):
                    clock += 4;
                    break;
                case ('G'):
                case ('H'):
                case ('I'):
                    clock += 5;
                    break;
                case ('J'):
                case ('K'):
                case ('L'):
                    clock += 6;
                    break;
                case ('M'):
                case ('N'):
                case ('O'):
                    clock += 7;
                    break;
                case ('P'):
                case ('Q'):
                case ('R'):
                case ('S'):
                    clock += 8;
                    break;
                case ('T'):
                case ('U'):
                case ('V'):
                    clock += 9;
                    break;
                case ('W'):
                case ('X'):
                case ('Y'):
                case ('Z'):
                    clock += 10;
                    break;
            }
        }
        bw.write(clock + "");


        bw.flush();
        br.close();
        bw.close();
    }

}