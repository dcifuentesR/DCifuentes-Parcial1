package edu.eci.arep.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



public class ListServices {
	
	private LinkedList<Float> list;
	
	/**
     * Reads a file of reals and stores it in a list 
     * @param l - the list to store the decimals in
     * @param path - the path of the file
     * @throws FileNotFoundException if the file is not found
     */
    public static void readFile(List<Float> l,String path) throws FileNotFoundException {
    	File f = new File(path);
    	Scanner scanner = new Scanner(f);
    	while(scanner.hasNext()) {
        	Float myInt = scanner.nextFloat();
        	l.add(myInt);
    	}
    	scanner.close();
    }
    
    /**
     * given a list of reals, this method calculates the sum of its elements
     * @param l - the list of reals
     * @return the sum of the elements in the list
     */
    public static float sum(List<Float> l) {
    	float sum=0;
    	for(Float d:l)
    		sum+=d;
    	return sum;
    }
    
    public static void generateJSON(List<Float> l) throws IOException {
    	
    	FileOutputStream fileOutputStream = new FileOutputStream("./results/resultado.json");
    	JSONArray list= new JSONArray();
    	list.addAll(l);
    	JSONObject sortedList = new JSONObject();
    	sortedList.put("list", list);
    	sortedList.put("sum", sum(l));
    	fileOutputStream.write(sortedList.toJSONString().getBytes());
    	fileOutputStream.close();
    }
    
    
//    void merge(int from, int pivot, int to, int len1, int len2) {
//    	  delay(ext);
//    	  if (len1 == 0 || len2==0) return;
//    	  if (len1+len2 == 2) {
//    	   if (compare(pivot, from) < 0)
//    	    exchange(pivot, from);
//    	   return;
//    	  }
//    	  int first_cut, second_cut;
//    	  int len11, len22;
//    	  if (len1 > len2) {
//    	   len11=len1/2;
//    	   first_cut = from + len11;
//    	   second_cut = lower(pivot, to, first_cut);
//    	   len22 = second_cut - pivot;
//    	  } else {
//    	   len22 = len2/2;
//    	   second_cut = pivot + len22;
//    	   first_cut = upper(from, pivot, second_cut);
//    	   len11=first_cut - from;
//    	  }
//    	  rotate(first_cut, pivot, second_cut);
//    	  int new_mid=first_cut+len22;
//    	  merge(from, first_cut, new_mid, len11, len22);
//    	  merge(new_mid, second_cut, to, len1 - len11, len2 - len22);
//    	}
//    	 
//    	void sort(int from, int to) {
//    	 
//    	  if (to - from < 2) {
//    	   return;
//    	  }
//    	  int middle = (from + to)/2;
//    	  sort (from, middle);
//    	  sort (middle, to);
//    	  merge(from, middle, to, middle-from, to - middle);
//    	 }
//    
//    //TODO: should sort according to any criteria
//    public void Sort(int left,int right) {
//    	
//    	
//    	int mid=(left+right)/2;
//    	if(mid<2)
//    		return;
//    	
//    	Sort(left,mid);
//    	Sort(mid,right);
//    	
//    	merge();
//    }
//    
//   
//    
//    private void merge(int left, int pivot, int r, int len1, int len2) {
//    	int i,j,k =0;
//    	while (i < list1.size() && j < list2.size()) 
//        { 
//            if (list1.get(i) <= list2.get(j)) 
//            { 
//                arr[k] = L[i]; 
//                i++; 
//            } 
//            else
//            { 
//                arr[k] = R[j]; 
//                j++; 
//            } 
//            k++; 
//        }
//    }
    
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
     
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
     
        merge(a, l, r, mid, n - mid);
    }
    
    public static void merge(
    		  int[] a, int[] l, int[] r, int left, int right) {
    		  
    		    int i = 0, j = 0, k = 0;
    		    while (i < left && j < right) {
    		        if (l[i] <= r[j]) {
    		            a[k++] = l[i++];
    		        }
    		        else {
    		            a[k++] = r[j++];
    		        }
    		    }
    		    while (i < left) {
    		        a[k++] = l[i++];
    		    }
    		    while (j < right) {
    		        a[k++] = r[j++];
    		    }
    		}

}
