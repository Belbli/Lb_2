package list;
import abstractTest.AbstractTest;

import java.util.function.BiFunction;

public class LinkedList <E extends AbstractTest>{
    private int size;
    private Node<E> first;
    private Node<E> last;

    public LinkedList() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    private static class Node<E> {
        E item;
        LinkedList.Node<E> next;
        LinkedList.Node<E> prev;

        public Node() {
        }

        public Node(Node<E> node){
            this.prev = node.prev;
            this.item = node.item;
            this.next = node.next;
        }

        Node(LinkedList.Node<E> prev, E element, LinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }

    public void add(E node){
        linkLast(node);
    }

    public Node<E> getByIndex(int index){
        checkPositionIndex(index);
        Node<E> node = first;
        int i = 0;
        while (i < index){
            i++;
            node = node.next;
        }
        return node;
    }

    public void add(int index, E node) {
        checkPositionIndex(index);

        if(index == size) {
            linkLast(node);
        } else {
            linkBefore(node, getByIndex(index));
        }
    }

    public void delete(int index){
        checkPositionIndex(index);

        Node node = getByIndex(index);
        if(index == 0) {
            first = first.next;
            first.prev = null;
        }
        else if(index == size - 1){
            node.prev.next = null;
            node = null;
        } else {
            Node<E> tmp = node;
            node.prev.next = node.next;
            tmp.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
    }

        public void deleteAll(){
        Node tmp = last;
            while(tmp.prev != null){
                last.item = null;
                last = tmp.prev;
                last.next = null;
                tmp = tmp.prev;
                size--;
           }
            if(tmp.prev == null){
                last.item = null;
                last.next = null;
                last.prev = null;
                last = null;
                first.item = null;
                first.next = null;
                first = null;
            }
        }

        public void changeByIndex(int index, E data) {
            checkPositionIndex(index);
            getByIndex(index).item = data;
        }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String res = "";
        Node<E> n = first;
        while (n != null) {
            res += n.item.toString() + "\n";
            n = n.next;
        }
        return res;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index out of bound [ 0 - " + (size - 1) + " ]");
    }

    void linkLast(E e) {
        final LinkedList.Node<E> l = last;
        final Node<E> newNode = new LinkedList.Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    void linkBefore(E e, Node <E> node) {
        final LinkedList.Node<E> prev = node.prev;
        final LinkedList.Node<E> newNode = new LinkedList.Node<>(prev, e, node);
        node.prev = newNode;
        if (prev == null)
            first = newNode;
        else
            prev.next = newNode;
        size++;
    }

    public void swap (Node<E> left, Node<E> right) {
        E tmp = left.item;
        left.item = right.item;
        right.item = tmp;
    }

    public LinkedList sort(LinkedList list, BiFunction< E , E, Integer> sortingField) {
        boolean flag = true;
        while (flag) {
            Node<E> le = list.first;
            flag = false;
            while (le != list.last) {
                if (le.item.getClass().getName().compareTo(le.next.item.getClass().getName()) > 0) {
                    swap(le, le.next);
                    flag = true;
                }
                le = le.next;
            }
        }
        flag = true;
        while (flag) {
            Node<E> le = list.first;
            flag = false;
            while (le != list.last) {
                if (le.item.getClass().getName().compareTo(le.next.item.getClass().getName()) == 0 && sortingField.apply(le.item, le.next.item) > 0) {
                    swap(le, le.next);
                    flag = true;
                }
                le = le.next;
            }
        }

        return list;
    }

    public LinkedList sort2(LinkedList<E> list){
        boolean flag = true;
        while (flag) {
            Node<E> le = list.first;
            flag = false;
            while (le != list.last) {
               /* if (le.item.getClass().getName().compareTo(le.next.item.getClass().getName()) > 0 ||
                    le.item.getClass().getName().compareTo(le.next.item.getClass().getName()) == 0 && le.item.compare(le.next.item) > 0){*/
                if(le.item.compare2(le.next.item) < 0){
                    swap(le, le.next);
                    flag = true;
                }
                le = le.next;
            }
        }
        return list;
    }
}
