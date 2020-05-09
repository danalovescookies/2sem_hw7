package ru.kfu.itis.muksinova.hw7;

import java.util.*;

public class App {
    public static String almostRandomLine(String alphabet){
        int capacity = 1 + (int)(13*Math.random());
        StringBuilder result = new StringBuilder(capacity);
        for (int i = 0; i < capacity; i++) {
            int index = (int)(alphabet.length()*Math.random());
            result.append(alphabet.charAt(index));
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter number of integers:");
        ArrayList<Integer> list = new ArrayList();
        int n = sc.nextInt();
        System.out.println("Please enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        //comparator as lambda expression
        list.sort((e1, e2) -> e1 - e2);
        System.out.println("Sorted: " + list.toString());
        ArrayList<Integer> list1 = new ArrayList();
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            list1.add(r.nextInt());
        }
        int max = list.get(list.size() - 1);
        System.out.println("Original list: " + list1.toString());

        //finding and printing all elements of list that more than max value of another one
        Iterator<Integer> it = list1.stream().filter(i -> i > max).iterator();
        System.out.print("Elements that more than max value " + max + ":");
        while (it.hasNext()){
            System.out.print(" " + it.next());
        }
        System.out.println();

        //counting strings in set that have more than 3 english vowels
        System.out.println("Please enter capacity of string set: ");
        int setCap = sc.nextInt();
        HashSet<String> story = new HashSet<>(setCap);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
        for (int i = 0; i < setCap; i++) {
            story.add(almostRandomLine(alphabet));
        }
        long sum = story.stream().filter(string -> string.matches("[aeiuoAEIUO]{4,}")).count();
        Iterator<String> setIt = story.iterator();
        System.out.println("All strings of set: ");
        while (setIt.hasNext()){
            System.out.println(setIt.next());
        }
        System.out.println("Number of strings with more than 3 english vowels: " + sum);

        //concatenating all keys in map
        System.out.println("Please enter capacity of Map: ");
        int cap = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>(cap);
        System.out.println("Enter " + cap + " unique strings for keys");
        sc.nextLine();
        for (int i = 0; i < cap; i++) {
            System.out.println(i+1 + " string: ");
            map.put(sc.nextLine(), i);
        }
        String concat = map.keySet().stream().reduce("", String::concat);
        System.out.println("Concatenation of required keys: " + concat);

        //get sum of strings length in collection that have more than 5 symbols
        System.out.println("Please enter capacity of string collection: ");
        int cap2 = sc.nextInt();
        ArrayList<String> list2 = new ArrayList<>(cap2);
        for (int i = 0; i < cap2; i++) {
            list2.add(almostRandomLine(alphabet));
        }
        System.out.println("String collection: " + list2.toString());
        String result = list2.stream().filter(string -> string.length() > 5).reduce("", String::concat);
        System.out.println("Sum length of strings longer than 5 symbols: " + result.length());
    }
}
