import java.io.*;

public class Cleaner {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/DeathsOnMountain.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/deaths.txt"));
            String line = br.readLine();
            int count = 0, count2 = 0;
            while (line != null) {
                String newLine = line.replaceAll("\" \"", "~");
                String[] parts = newLine.split("~");
                count++;
                if (parts.length <= 3) {
                    System.out.println(newLine);
                }
                if (parts.length > 3) {
                    bw.write(newLine + "\n");
                    count2++;
                }
                line = br.readLine();
            }
            br.close();
            bw.close();
            System.out.println(count + "\t" + count2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
