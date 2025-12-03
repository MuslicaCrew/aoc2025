import utils.Utils;

void main() throws IOException {
    long start = System.nanoTime();
    List<String> lines = Files.readAllLines(Path.of(Utils.Strings.BASE + 2 + Utils.Strings.INPUT));
    String[] ranges = lines.getFirst().split(",");
    String[][] rangeValues = new String[ranges.length][2];
    long answer = 0;
    for (int i = 0; i < ranges.length; i++) {
        rangeValues[i][0] = ranges[i].split("-")[0];
        rangeValues[i][1] = ranges[i].split("-")[1];
    }

    //PART1 - Compare strings
    //TODO: Using division by 10^x
    for (String[] values : rangeValues) {
        long startValue = Long.parseLong(values[0]);
        long endValue = Long.parseLong(values[1]);
        String stringified;
        for (; startValue <= endValue; startValue++) {
            stringified = String.valueOf(startValue);
            //System.out.println("First digit: " + startValue / 10 + " Second digit: " + startValue % 10);
            if (stringified.length() % 2 == 0) {
                String firstHalf = stringified.substring(0, stringified.length() / 2);
                String secondHalf = stringified.substring(stringified.length() / 2);
                if (firstHalf.equals(secondHalf)) {
                    answer += startValue;
                }
            }
        }
    }

    System.out.println(answer);

    long end = System.nanoTime();
    double milliTime = (end - start) / 1_000_000_000D;
    System.out.println("Solution found in: " + milliTime + " seconds");
}
