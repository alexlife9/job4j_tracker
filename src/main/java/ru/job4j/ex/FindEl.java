package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("ElementNotFound");
        }
        return rsl;
    }

    public static void main(String[] args) throws ElementNotFoundException {
        String[] elements = new String[]{"test1", "test2"};
        try {
            System.out.println(indexOf(elements,"test3"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
