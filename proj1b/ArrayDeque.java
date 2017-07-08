// Circle based
public class ArrayDeque<ItemType> implements Deque<ItemType> {
    private ItemType[] items;
    private int size;
    private int capacity;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        capacity = 8;
        size = 0;
        items = (ItemType[]) new Object[capacity];
        nextFirst = capacity / 2;
        nextLast = nextFirst + 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(ItemType item) {
        if (size == capacity - 1) {
            resize(2 * capacity);
        }

        items[nextFirst] = item;
        nextFirst = getPrevIndex(nextFirst);

        size = size + 1;
    }

    public void addLast(ItemType item) {
        if (size == capacity - 1) {
            resize(2 * capacity);
        }

        items[nextLast] = item;
        nextLast = getNextIndex(nextLast);

        size = size + 1;
    }

    public void printDeque() {
        int first = getNextIndex(nextFirst);
        for (int i = first; i != nextLast; i = getNextIndex(i)) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public ItemType removeFirst() {
        if (isEmpty()) {
            return null;
        }

        if (size <= capacity / 4) {
            resize(capacity / 2);
        }

        int first = getNextIndex(nextFirst);
        ItemType originalFirst = items[first];
        items[first] = null;
        nextFirst = first;

        size = size - 1;

        return originalFirst;
    }

    public ItemType removeLast() {
        if (isEmpty()) {
            return null;
        }

        if (size <= capacity / 4) {
            resize(capacity / 2);
        }

        int last = getPrevIndex(nextLast);
        ItemType originalLastItem = items[last];
        items[last] = null;
        nextLast = last;

        size = size - 1;

        return originalLastItem;
    }

    public ItemType get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        int first = getNextIndex(nextFirst);
        int realIndex = (first + index) % capacity;

        return items[realIndex];
    }

    private int getPrevIndex(int index) {
        return (capacity + index - 1) % capacity;
    }

    private int getNextIndex(int index) {
        return (capacity + index + 1) % capacity;
    }

    private void resize(int newCapacity) {
        ItemType[] newItems = (ItemType[]) new Object[newCapacity];
        int newFirst = newCapacity / 2;
        ItemType[] allItems = getAllItems();
        System.arraycopy(allItems, 0, newItems, newFirst, size);
        items = newItems;
        capacity = newCapacity;

        nextFirst = getPrevIndex(newFirst);
        nextLast = getNextIndex(newFirst + size - 1);
    }

    private ItemType[] getAllItems() {
        ItemType[] allItems = (ItemType[]) new Object[size];
        int first = getNextIndex(nextFirst);
        int itemIndex = 0;
        for (int i = first; i != nextLast; i = getNextIndex(i)) {
            allItems[itemIndex] = items[i];
            itemIndex = itemIndex + 1;
        }

        return allItems;
    }
}
