package com.bootcamp.folio_range;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.bootcamp.folio_range.components.FolioTransaction;

public class FolioHelperFunctionTest {

	/*
	 * Cases for split
	 * B overlaps A on left end
	 * A overlaps B on left end
	 * A in middle of B
	 * B in middle of A
	 */
	
	@Test
	public void testSplitOnLeft() {
		FolioTransaction a = new FolioTransaction(1, 12344, "A", 1);
		FolioTransaction aChange2 = new FolioTransaction(12000, 12999, "A", 2);
		
		List<FolioTransaction> expected = Arrays.asList(new FolioTransaction(1, 11999, "A", 1),
														new FolioTransaction(12000, 12999, "A", 2));
		
		assertEquals(expected, FolioHelperFunction.split(a, aChange2));
	}
	
	@Test
	public void testSplitOnRight() {
		FolioTransaction a = new FolioTransaction(1, 12344, "A", 1);
		FolioTransaction b = new FolioTransaction(12000, 12999, "A", 2);
		
		List<FolioTransaction> expected = Arrays.asList(new FolioTransaction(1, 11999, "A", 1),
														new FolioTransaction(12000, 12999, "A", 2));
		
		assertEquals(expected, FolioHelperFunction.split(b, a));
	}
	
	@Test
	public void testSplitOnMiddle() {
		FolioTransaction a = new FolioTransaction(1, 10, "A", 1);
		FolioTransaction b = new FolioTransaction(3, 6, "A", 2);
		
		List<FolioTransaction> expected = Arrays.asList(new FolioTransaction(1, 2, "A", 1),
														new FolioTransaction(3, 6, "A", 2),
														new FolioTransaction(7, 10, "A", 1));
		
		assertEquals(expected, FolioHelperFunction.split(b, a));
	}
	

}
