package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static utils.Utils.Strings.*;

public class Utils {

    public static List<String> readInput(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        List<String> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        return list;
    }

    public static class Strings{
        public static final String BASE = "src/main/java/day";
        public static final String INPUT = "/input.txt";
        public static final String TEST = "/test.txt";
    }
}




