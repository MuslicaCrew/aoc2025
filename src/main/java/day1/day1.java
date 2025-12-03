import utils.Utils;

void main() throws IOException {
    long start = System.nanoTime();
    List<String> lines = Files.readAllLines(Path.of(Utils.Strings.BASE + 1 + Utils.Strings.INPUT));
    int position = 50, numberOfTurns = 0, amount, remainder, revolutions;
    final int TOTAL = 100;
    //PART2 - BRUTE FORCE - Clicking 6738
    /*
    for (String line : lines) {
        amount = Integer.parseInt(line.substring(1));
        if (line.startsWith("L")) {
            while (amount > 0) {
                position--;
                if (position < 0) position = 99;
                if (position == 0) numberOfTurns++;
                amount--;
            }
        } else {
            while (amount > 0) {
                position++;
                if (position > 99) position = 0;
                if (position == 0) numberOfTurns++;
                amount--;
            }
        }
    }*/
    //PART2 - "Normal"
    /*for (String line : lines) {
        amount = (line.charAt(0) == 'L' ? -1 : 1) * Integer.parseInt(line.substring(1));
        //revolutions = amount / (amount < 0 ? -100 : 100);
        revolutions = Math.abs(amount / TOTAL);
        remainder = amount % TOTAL;
        numberOfTurns += revolutions;
        if ((amount < 0 && position != 0 && position + remainder <= 0) || (amount > 0 && position + remainder >= TOTAL)) {
            numberOfTurns++;
        }
        //position = Math.floorMod(position + amount, 100);
        position = (position + amount) % TOTAL;
        position = position < 0 ? position + TOTAL : position;
    }*/

    //PART2 - "Normal" my way
    for (String line : lines) {
        amount = Integer.parseInt(line.substring(1));
        if (line.startsWith("L")) {
            amount *= -1;
            numberOfTurns += Math.abs(amount / 100);
            remainder = amount % 100;
            if (position != 0 && position + remainder <= 0) {
                numberOfTurns++;
            }
        } else {
            numberOfTurns += amount / 100;
            remainder = amount % 100;
            if (position + remainder >= 100) {
                numberOfTurns++;
            }
        }
        position = (position + amount) % 100;
        position = position < 0 ? position + 100 : position;
    }


    //PART1
    /*for (String line : lines) {
        amount = Integer.parseInt(line.substring(1));
        if (line.startsWith("L")) {
            position += amount;
        } else {
            position -= amount;
        }
        if (position % 100 == 0) {
            numberOfTurns++;
            position = 0;
        }
    }*/
    long end = System.nanoTime();
    System.out.println("Number of turns: " + numberOfTurns);
    double milliTime = (end - start) / 1_000_000_000D;
    System.out.println("Solution found in: " + milliTime + " seconds");
}
