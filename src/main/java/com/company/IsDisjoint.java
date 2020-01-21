package com.company;

import java.util.*;

class IsDisjoint {

    static boolean isDisjoint(Set<Integer> a, Set<Integer> b) {
        // merge sort smaller set, then lookup
        List<Integer> la = new ArrayList<Integer>(a);
        List<Integer> lb = new ArrayList(b);
        List<Integer> smaller;
        List<Integer> larger;
        if (la.size() < lb.size()) {
            smaller = mergeSort(la);
            larger = lb;
        } else {
            smaller = mergeSort(lb);
            larger = la;
        }
        for (Integer q: larger) {
            if (binarySearch(smaller, q) != -1)
                return false;
        }
        return true;
    }

    static int binarySearch(List<Integer> a, int v) {
        int n = a.size();
        if (n == 1) {
            if (a.get(0) == v)
                return 0;
            return -1;
        }
        int m = n / 2;
        if (v < a.get(m))
            return binarySearch(a.subList(0, m), v);
        int ir = binarySearch(a.subList(m, n), v);
        if (ir == -1)
            return ir;
        return ir + m;
    }

    static List<Integer> mergeSort(List<Integer> a) {
        int n = a.size();
        if (n == 1)
            return a;
        int m = n / 2;
        List<Integer> s1 = mergeSort(a.subList(0, m));
        List<Integer> s2 = mergeSort(a.subList(m, n));
        return merge(s1, s2);
    }

    static List<Integer> merge(List<Integer> sorted1, List<Integer> sorted2) {
        int l1 = sorted1.size();
        int l2 = sorted2.size();
        List<Integer> merged = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while (i < l1 && j < l2) {
            if (sorted1.get(i) <= sorted2.get(j)) {
                merged.add(sorted1.get(i));
                i++;
            } else {
                merged.add(sorted2.get(j));
                j++;
            }
        }
        if (i < l1)
            merged.addAll(sorted1.subList(i, l1));
        if (j < l2)
            merged.addAll(sorted2.subList(j, l2));
        return merged;
    }
}
