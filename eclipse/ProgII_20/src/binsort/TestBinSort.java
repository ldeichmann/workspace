package binsort;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TestBinSort {

	public static void main(String[] args) {
		List<MyObject> values = new LinkedList<MyObject>();

		Random r = new Random();
		for (int i = 20; i >= 1; i--) {
			values.add(new MyObject(r.nextInt(i)));
		}

		System.out.println("Unsortiert: " + values);
		System.out.println("Sortiert: " + BTree.bsort(values));
	}

}
