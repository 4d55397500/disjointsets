package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class IsDisjointTest {

    @Test
    public void testIsDisjoint() {
        Set<Integer> a = new HashSet<Integer>(Arrays.asList(5, 7, 1, -1));
        Set<Integer> b = new HashSet<Integer>(Arrays.asList(56, 12));
        boolean actual = IsDisjoint.isDisjoint(a, b);
        boolean expected = true;
        assertThat(actual, is(expected));
    }

    @Test
    public void testBinarySearch() {
        List<Integer> a = Arrays.asList(5, 7, 12);
        assertThat(IsDisjoint.binarySearch(a, 7), is(1));
        assertThat(IsDisjoint.binarySearch(a, 12),is(2));
        assertThat(IsDisjoint.binarySearch(a, 5), is(0));
        assertThat(IsDisjoint.binarySearch(a, 23), is(-1));
    }

    @Test
    public void testMergeSort() {
        List<Integer> a = Arrays.asList(5, 7, 1, -1);
        List<Integer> actual = IsDisjoint.mergeSort(a);
        List<Integer> expected = Arrays.asList(-1, 1, 5, 7);
        assertThat(actual, is(expected));
    }

    @Test
    public void testMerge() {
        List<Integer> sorted1 = Arrays.asList(1, 5, 48);
        List<Integer> sorted2 = Arrays.asList(2, 230);
        List<Integer> actual = IsDisjoint.merge(sorted1, sorted2);
        List<Integer> expected = Arrays.asList(1, 2, 5, 48, 230);
        assertThat(actual, is(expected));
    }
}