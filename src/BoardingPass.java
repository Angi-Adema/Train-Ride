public class BoardingPass {
    String start;
    String end;

    public BoardingPass(String start, String end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "BoardingPass{" + "start='" + start + '\'' + ", end='" + end + '\'' + '}';
    }
}


