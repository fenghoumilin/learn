package javaSourceTest;

import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        treeMap.put(1, 1);
        treeMap.put(3, 3);
        System.out.println(treeMap.floorKey(2));
    }
}