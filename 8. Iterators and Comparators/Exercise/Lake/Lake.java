import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{
    private List<Integer> numbers;

    public Lake(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {
        private int index = 0;
        private boolean isFinishedRound = false;

        @Override
        public boolean hasNext() {
            return index < numbers.size();
        }

        @Override
        public Integer next() {
            Integer currentNum = numbers.get(index);
            index += 2;

            if (!hasNext() && !isFinishedRound) {
                isFinishedRound = true;
                index = 1;
            }
            return currentNum;
        }
    }

}
