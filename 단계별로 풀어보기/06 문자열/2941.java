import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.length() - 1 > i) {
                switch (str.charAt(i)) {
                    case ('c'):
                        if (str.charAt(i+1) == '=' | str.charAt(i+1) == '-') i++;
                        break;
                    case ('d'):
                        if (str.charAt(i+1) == '-') i++;
                        else if (str.length() - 2 > i && str.charAt(i+1) == 'z' && str.charAt(i+2) == '=') i += 2;
                        break;
                    case ('l'):
                    case ('n'):
                        if (str.charAt(i+1) == 'j') i++;
                        break;
                    case ('s'):
                    case ('z'):
                        if (str.charAt(i+1) == '=') i++;
                        break;
                }
            }
            count++;
        }
        bw.write(count+"");
        
        bw.flush();
        br.close();
        bw.close();
    }

}