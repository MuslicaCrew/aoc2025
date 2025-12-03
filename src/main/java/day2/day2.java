import utils.Utils;

void main() throws IOException {
    long start = System.nanoTime();
    List<String> lines = Files.readAllLines(Path.of(Utils.Strings.BASE + 2 + Utils.Strings.INPUT));

    long end = System.nanoTime();

    double milliTime = (end - start) / 1_000_000_000D;
    System.out.println("Solution found in: " + milliTime + " seconds");
}
