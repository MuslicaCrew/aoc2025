void main() throws IOException {
    long start = System.nanoTime();
    //List<String> lines = Utils.readInput(1);
    List<String> lines = Files.readAllLines(Path.of("src/main/java/day1/input.txt"));
    int startingPos = 50;
    int amount, numberOfTurns = 0;
    for (String line : lines) {
        amount = Integer.parseInt(line.substring(1));
        if (line.startsWith("L")) {
            startingPos += amount;
        } else {
            startingPos -= amount;
        }
        if (startingPos % 100 == 0){
            numberOfTurns++;
            startingPos = 0;
        }
    }
    long end = System.nanoTime();
    System.out.println("Number of turns: " + numberOfTurns);
    double milliTime = (end-start) / 1_000_000_000D;
    System.out.println("Solution found in: " + milliTime + " seconds");
}