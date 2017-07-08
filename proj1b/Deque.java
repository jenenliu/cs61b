/**
 * Created by jenenliu on 2017/7/7.
 */
public interface Deque<ItemType> {
    void addFirst(ItemType item);
    void addLast(ItemType item);

    ItemType removeFirst();
    ItemType removeLast();
    ItemType get(int i);

    boolean isEmpty();
    int size();

    void printDeque();
}
