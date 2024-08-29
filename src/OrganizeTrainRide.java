import java.util.*;

public class OrganizeTrainRide {
    public static void main(String[] args) {
        List<BoardingPass> passes = new ArrayList<>();
        passes.add(new BoardingPass("E", "Z"));
        passes.add(new BoardingPass("B", "C"));
        passes.add(new BoardingPass("D", "E"));
        passes.add(new BoardingPass("A", "B"));
        passes.add(new BoardingPass("C", "D"));

        // Get the ordered list of the boarding passes.
        List<BoardingPass> orderedPasses = orderBoardingPasses(passes);

        // Print the ordered passes.
        for (BoardingPass pass : orderedPasses) {
            System.out.println(pass);
        }
    }

    public static List<BoardingPass> orderBoardingPasses(List<BoardingPass> passes) {
        // Map to store each start location and BoardingPass object.
        Map<String, BoardingPass> startMap = new HashMap<>();
        // HashSet to track all ending locations.
        Set<String> endSet = new HashSet<>();

        for (BoardingPass pass : passes) {
            startMap.put(pass.start, pass);
            endSet.add(pass.end);
        }

        // Find pass with start that is not in the endSet.
        String startLocation = null;
        for (BoardingPass pass : passes) {
            if (!endSet.contains(pass.start)) {
                startLocation = pass.start;
                break;
            }
        }

        // List passes in order.
        List<BoardingPass> orderedPasses = new ArrayList<>();
        while (startLocation != null) {
            BoardingPass pass = startMap.get(startLocation);
            if (pass != null) {
                orderedPasses.add(pass);
                startLocation = pass.end;
            } else {
                break;
            }
        }
        return orderedPasses;
    }
}
