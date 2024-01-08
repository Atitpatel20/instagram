package com.Instagram.Instagram;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
//        Function<String,Integer> val= str->str.length();
//        Integer res = val.apply("stallin");
//        System.out.println(res);

//       Function<Integer,Integer> res= i->i+20;
//        Integer val = res.apply(20);
//        System.out.println(val);

//        List<Integer> numbers = Arrays.asList(10, 20, 30, 60, 90);
//        List<Integer> result1 = numbers.stream().map(i -> i + 10).collect(Collectors.toList());
//        List<Integer> result2 = numbers.stream().filter(s -> s.equals(10)).collect(Collectors.toList());
//        System.out.println(result1);
//        System.out.println(result2);

        // all the names in upper case
        // all the names in lower case
//        List<String> data = Arrays.asList("mike", "chirag", "jay", "neel");
//        List<String> result = data.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
//        List<String> result1 = data.stream().map(str -> str.toLowerCase()).collect(Collectors.toList());
//        System.out.println(result1);
//        System.out.println(result);

        // sort the record of names
//        List<String> names = Arrays.asList("mike", "chiraag", "jay", "neel");
//        List<String> res = names.stream().sorted().collect(Collectors.toList());
//        System.out.println(res);

        //sort the numbers in asscending order
//        List<Integer> numbers = Arrays.asList(12, 25, 36, 8, 28);
//        List<Integer> res = numbers.stream().sorted().collect(Collectors.toList());
//        System.out.println(res);

        // remove duplicte numbers & sort the number
        List<Integer> numbers = Arrays.asList(10, 5, 25, 30, 10, 25, 14);
        List<Integer> res1 = numbers.stream().distinct().collect(Collectors.toList()); // remove duplicte numbers
        List<Integer> res2 = numbers.stream().sorted().distinct().collect(Collectors.toList());// remove duplicte numbers & sort the number
        System.out.println(res1);
        System.out.println(res2);


    }

}
