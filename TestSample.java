package POIAPITutorial.POIAPI;

import java.io.IOException;
import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TestSample {
	public static void main(String[] args) throws IOException {
		
		dataDriven d = new dataDriven();
		
		ArrayList datalist=d.getData("Add Profile");
		
		System.out.println(datalist.get(0));
		System.out.println(datalist.get(1));
		
		System.out.println(datalist.get(2));
		System.out.println(datalist.get(3));
	
	}
}
