package com.Instagram.Instagram;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByExample {
    public static void main(String[] args) {
        List<Worker> workers = Arrays.asList(
                new Worker(1, "mayank", "fitter"),
                new Worker(2, "shubhas", "lathe"),
                new Worker(3, "mehul", "cnc"),
                new Worker(4, "divyang", "store"),
                new Worker(5, "shailesh", "lathe"),
                new Worker(6, "vatshal", "store")
        );
        Map<String, List<Worker>> collect = workers.stream().collect(Collectors.groupingBy(str -> str.getDesignation()));

        for ( Map.Entry<String,List<Worker>> entry: collect.entrySet()) {
            String designation = entry.getKey();
            List<Worker> detailes = entry.getValue();
            System.out.println("designation: "+designation+"---");
            for ( Worker w:detailes ) {
                System.out.println(w.getId());
                System.out.println(w.getName());
            }
        }
    }
}
