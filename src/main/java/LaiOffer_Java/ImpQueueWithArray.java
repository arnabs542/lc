package LaiOffer_Java;

/**
 * Created by yuehu on 8/21/19.
 */
public class ImpQueueWithArray {
    int head;
    int tail;
    int size;
    Integer[] array;
    public ImpQueueWithArray(int cap) {
        array = new Integer[cap];
        head = tail = 0;
        size = 0;
    }

    public boolean offer(Integer ele) {
        if (size == array.length) {
            return false;
        }

        array[tail] = ele;
        tail = tail + 1 == array.length ? 0 : tail + 1;
        size++;
        return true;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }

        return array[head];
    }

    public Integer poll() {
        if (size == 0) {
            return null;
        }

        Integer result = array[head];
        head = head + 1 == array.length ? 0 : head + 1;
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }




}
