package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> readInput(int day) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/day" + day + "/input.txt"));
        List<String> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        return list;
    }

    public static List<String> readTest(int day) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/day" + day + "/test.txt"));
        List<String> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        return list;
    }
}




