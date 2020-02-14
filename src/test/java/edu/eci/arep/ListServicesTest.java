package edu.eci.arep;


import java.io.FileNotFoundException;

import org.junit.Test;

import edu.eci.arep.services.ListServices;
import edu.eci.arep.utils.LinkedList;


/**
 * Unit test for simple App.
 */
public class ListServicesTest
{
	private LinkedList<Float> unsortedList;
	private LinkedList<Float> sortedList;
	public void setup() {
		unsortedList = new LinkedList<Float>();
		try {
			ListServices.readFile( unsortedList, "./src/test/List.txt");
			ListServices.readFile(sortedList, "./src/test/SortedList.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void mergeSortTest() {
		
	}
}
