package com.devpro.bookstore.dto;

import java.util.*;


class Result {

    /*
     * Complete the 'minimalHeaviestSetA' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        // Write your code here

        int total = 0;
        for (Integer a : arr) {
            total += a;
        }
        Collections.sort(arr, Comparator.reverseOrder());
        List<Integer> res = new ArrayList<>();
        int sumA = 0;
        int minimalSize = arr.size()/2;
        for(Integer a: arr){
            if(res.size()>= minimalSize){
                break;
            }
            if((sumA+a) <= (total-sumA) ){
                sumA += a;
                res.add(a);
            }
        }
        Collections.sort(res);
        return res;

    }

    public static void main(String[] args) {

        List<Integer> integers = minimalHeaviestSetA(Arrays.asList(6,8, 9, 10, 10, 10, 10));
        System.out.println(integers);
    }
}
