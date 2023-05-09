package org.example.Task1;
// Продолжить реализацию листа, реализовать несколько методов на своё усмотрение.
public class CustomArrayList {
    private String[] list = new String[INITIAL_LENGTH];
    private static final int INITIAL_LENGTH = 10;
    private int size = 0;

    public void add(String element) {

        if (size >= list.length) {
            String[] newList = new String[(int) (list.length * 1.5)];
            System.arraycopy(list, 0, newList, 0, size);
            list = newList;
        }
        list[size++] = element;
    }

    public String get(int index) {
        return list[index];
    }

    public boolean remove(String element) {
        int index = indexOf(element);
        if (index == -1) {
            return false;
        }
        String[] newList = new String[list.length - 1];
        System.arraycopy(list, 0, newList, 0, index - 1);
        System.arraycopy(list, index + 1, newList, index, list.length-index-1);
        list = newList;
        size--;

        return true;
    }

    public int indexOf(String element) {
        for (int i = 0; i < list.length; i++) {
            if (element.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }
}


