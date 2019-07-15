package test;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class test3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.remove("a");
        list.add("a");
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("e");
        set.remove("a");
        set.add("a");
        for (String s:list) {
            System.out.printf(s+"  ");
        }
        System.out.println();
        for (String s:set) {
            System.out.printf(s+"  ");
        }
    }

}
