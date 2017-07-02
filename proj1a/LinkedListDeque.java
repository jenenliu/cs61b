
public class LinkedListDeque<ItemType> {
    public class ItemNode {
        private ItemType item;
        private ItemNode next;
        private ItemNode prev;

        public ItemNode(ItemType t, ItemNode n, ItemNode p) {
            item = t;
            next = n;
            prev = p;
        }
    }

    private ItemNode first;
    private ItemNode sentinel;
    private int size;

    public LinkedListDeque() {
        size = 0;
        first = null;
        sentinel = new ItemNode(null, sentinel, sentinel);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /** Add the item to the first of Deque */
    public void addFirst(ItemType item) {
        ItemNode newItem = new ItemNode(item, sentinel.next, sentinel);

        if (first == null) {
            sentinel.prev = newItem;
        } else {
            first.prev = newItem;
        }

        sentinel.next = newItem;
        first = newItem;

        size = size + 1;
    }

    /* Add the item to the last of Dequeue*/
    public void addLast(ItemType item) {
        ItemNode originalLastItem = sentinel.prev;
        ItemNode newItem = new ItemNode(item, sentinel, originalLastItem);
        originalLastItem.next = newItem;
        sentinel.prev = newItem;

        if (first == null) {
            first = newItem;
        }

        size = size + 1;
    }


    /* Check if Dequeue is empty*/
    public boolean isEmpty() {
        return size == 0;
    }

    /* Get the size of Deque*/
    public int size() {
        return size;
    }

    /* Print Deque*/
    public void printDeque() {
        for (ItemNode p = first; p.next != first; p = p.next) {
            System.out.println(p.item + " ");
        }
    }

    /* Remove first item of Deque
     * If not found, return null */
    public ItemType removeFirst() {
        if (isEmpty()) {
            return null;
        }

        ItemNode originalFirst = first;
        ItemNode nodeAfterFirst = first.next;
        sentinel.next = nodeAfterFirst;
        nodeAfterFirst.prev = sentinel;

        if (nodeAfterFirst == sentinel) {
            first = null;
        } else {
            first = nodeAfterFirst;
        }

        size = size - 1;

        originalFirst.next = null;
        originalFirst.prev = null;
        return originalFirst.item;
    }

    /* Remove last item of Deque
     * If not found, return null */
    public ItemType removeLast() {
        if (isEmpty()) {
            return null;
        }

        ItemNode originalLastNode = sentinel.prev;
        ItemNode nodeBeforeLast = originalLastNode.prev;
        nodeBeforeLast.next = sentinel;
        sentinel.prev = nodeBeforeLast;

        if (originalLastNode == first) {
            first = null;
        }

        size = size - 1;

        originalLastNode.prev = null;
        originalLastNode.next = null;
        return originalLastNode.item;
    }

    /* Get the item at the given index
     * If not found, return null */
    public ItemType get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        ItemNode p = first;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p.item;
    }

    public ItemType recursiveGet(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        ItemNode p = first;
        return recursiveGetHelper(p, index);
    }

    private ItemType recursiveGetHelper(ItemNode p, int index) {
        if (index == 0) {
            return p.item;
        }

        return recursiveGetHelper(p.next, index - 1);
    }
}

