package tilegame.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

    public static String loadFileAsString(String path){
        StringBuilder builder = new StringBuilder();
        try{
           BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)));
            String line;
            while((line = bufferedReader.readLine()) != null)
                builder.append(line + "\n");
            bufferedReader.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(builder);
        return builder.toString();
    }

    public static int parseInt(String number){
        try{
            return Integer.parseInt(number);
        }catch(NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }
}