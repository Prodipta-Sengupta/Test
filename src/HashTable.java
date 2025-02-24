import java.util.ArrayList;

public class HashTable {

    // CREATE CLASS VARIABLES, NODE CLASS, AND CONSTRUCTOR HERE//
    //                                                         //
    //                                                         //
    //                                                         //
    //                                                         //

    /// //////////////////////////////////////////////////////////
    public class Node {
        String key;
        int value;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node[] dataMap;
    private int size;

    public HashTable() {
        this.size = 7;
        this.dataMap = new Node[size];
    }

    public HashTable(int size) {
        this.size = size;
        this.dataMap = new Node[size];
    }

    public Node[] getDataMap() {
        return dataMap;
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            if (dataMap[i] != null) {
                Node temp = dataMap[i];
                while (temp != null) {
                    System.out.println("   {" + temp.key + ", " + temp.value + "}");
                    temp = temp.next;
                }
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int asciiValue : keyChars) {
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.next != null) {
                if (temp.key.equals(key)) {
                    temp.value = value;
                    return;
                }
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList<String> keys() {
        ArrayList<String> keys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            if (dataMap[i] != null) {
                Node temp = dataMap[i];
                while (temp != null) {
                    keys.add(temp.key);
                    temp = temp.next;
                }
            }
        }
        return keys;
    }
}