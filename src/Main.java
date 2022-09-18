import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] arg) throws IOException{

        List<String>list = readFile("read.txt");
        var result = FilterStrings(list);

        // print result to console window
        for (int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
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

    // check or string has at least one number equals or higher than 10
    public static String CheckString (String input){
        char[] array = input.toCharArray();
        String value = "";
        int i = 0;
        while(value.length() != 2)
        {
            if(i == array.length-1)
            {
                break;
            }

            else if(Character.isDigit(array[i]) && Character.isDigit(array[i+1]))
            {
                String number = String.format("%s%s", array[i],array[i+1]);
                if(Integer.parseInt(number) >= 10)
                {
                    value = input;
                    break;
                }
            }
            i+=1;
        }
        return value;
    }

    // run for all list values and check or string has at least one number equals or higher than 10
    public static List<String> FilterStrings(List<String> input){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < input.size()-1; i++){
            if(CheckString(input.get(i)) != "")
            {
                list.add(input.get(i));
            }
        }
        return list;
    }
}
