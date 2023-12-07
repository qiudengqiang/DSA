package com.alphabethub.exam.iqiyi;

import java.util.*;
import java.util.stream.Collectors;

public class Window {
    public static void main(String[] args) {
        final Scanner reader = new Scanner(System.in);
        final String next = reader.next();
        String[] split = next.split(":");
        List<Integer> list = Arrays.stream(split[0].split(",")).map(str -> Integer.valueOf(str)).collect(Collectors.toList());
        Integer k = Integer.valueOf(split[1]);

        List<Double> aves = averages(list, k);
        double maxPercent = Integer.MIN_VALUE;
        for (int i = 1; i < aves.size(); i++) {
            double v = (aves.get(i) / aves.get(i - 1)) * 100;
            if (v > 0 && maxPercent < v) {
                maxPercent = v;
            }
        }

        System.out.println(String.format("%.2f", maxPercent) + "%");
    }

    private static List<Double> averages(List<Integer> nums, int k) {
        if (nums == null || nums.size() == 0 || k < 1) return null;
        if (k == 1) return nums.stream().map(num -> Double.valueOf(num)).collect(Collectors.toList());
        List<Double> aves = new ArrayList<>(nums.size() - k + 1);
        for (int ri = 0; ri < nums.size(); ri++) {
            //检查li的合法性
            int li = ri - k + 1;
            if (li < 0) continue;
            double sum = 0;
            for (int i = li; i <= ri; i++) {
                sum += nums.get(i);
            }
            double ave = sum / k;
            aves.add(ave);
        }
        return aves;
    }
}
