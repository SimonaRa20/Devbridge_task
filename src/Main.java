import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] arg) throws IOException{

        List<String>list = readFile("read.txt");
        System.out.println(list.size());
    }

    // read data from txt file
    public static List<String> readFile(String fileName) throws IOException {
        List<String> result = new ArrayList<>();
        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                br.close();
            }
        }
        return result;
    }
}
