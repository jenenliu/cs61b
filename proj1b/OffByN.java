/**
 * Created by jenenliu on 2017/7/9.
 */
public class OffByN implements CharacterComparator {
    private int n;

    public OffByN() {
        n = 0;
    }

    public OffByN(int num) {
        n = num;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (x - y == n || y - x == n) {
            return true;
        }

        return false;
    }
}
