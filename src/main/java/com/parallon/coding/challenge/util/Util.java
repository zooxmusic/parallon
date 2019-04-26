package com.parallon.coding.challenge.util;

import com.google.common.collect.Lists;

public class Util {

    public static <T> boolean isNull(T value) {
        return null == value;
    }
    public static <T> boolean isEmpty(Iterable<T> iterable) {
        return isNull(iterable) || Lists.newArrayList(iterable).isEmpty();
    }
}
