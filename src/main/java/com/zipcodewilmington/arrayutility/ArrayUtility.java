package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    T[] list;

    public ArrayUtility(T[] list){
        this.list = list;
    }

    public int getNumberOfOccurrences(T element) {
        int count = 0;
        for (T el: list){
            if(el.equals(element)){
                count++;
            }
        }
        return count;
    }

    public T[] removeValue(T valueToRemove) {
        ArrayList<T> newArr = new ArrayList<>();
        for (int i = 0; i < list.length; i++){
            if (!list[i].equals(valueToRemove)){
                newArr.add(list[i]);
            }
        }
        int newLength = newArr.size();
        list = (T[]) Array.newInstance(list.getClass().getComponentType(), newLength);
        return newArr.toArray(list);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        ArrayUtility arrayUtil = new ArrayUtility(merge(arrayToMerge));
        T mostCommonObject = null;
        int tempCount = 0;
        for(Object w: arrayUtil.list){
            if(getNumberOfOccurrences((T) w)>tempCount){
                tempCount=getNumberOfOccurrences((T) w);
                mostCommonObject = (T) w;
            }
        }
        return mostCommonObject;
    }

    public int countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        ArrayUtility arrayUtil = new ArrayUtility(merge(arrayToMerge));
        return arrayUtil.getNumberOfOccurrences(valueToEvaluate);
    }

    public Object[] merge(T[] arr1){
        Object[] mergeArr = new Object[list.length+arr1.length];
        int counter = 0;
        for(T w : list){
            mergeArr[counter] = w;
            counter++;
        }
        for (T w: arr1) {
            mergeArr[counter] = w;
            counter++;
        }
        return mergeArr;
    }
}
