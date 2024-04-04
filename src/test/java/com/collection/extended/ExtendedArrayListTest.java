/**
 * 
 */
package com.collection.extended;



import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for Extended ArrayList
 * 
 */
class ExtendedArrayListTest {
	
	ExtendedArrayList<String> test;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		test = new ExtendedArrayList<String>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAdd() {
		test.add("test");
		Assert.assertTrue(test.contains("test"));
	}
	@Test
	void testGet() {
		test.add("test");
		Assert.assertEquals("test",test.get(0));
	}
	@Test
	void testSize() {
		test.add("testing");
		test.add("testing");
		test.add("testing3");
		Assert.assertEquals(3,test.size());
	}
	@Test
	void testDynamicIncrease() {
		test = new ExtendedArrayList<String>(100);
		for(int i=0;i<200000;i++)
			test.add("t");
		Assert.assertEquals(200000, test.size());
	}
	
	@Test
	void testIndexOf() {
		test.add("abc");
		test.add("test");
		Assert.assertEquals(1, test.indexOf("test"));
	}
	
	@Test
	void testClear() {
		test.add("test");
		test.add("test2");
		test.clear();
		Assert.assertTrue(test.isEmpty());
	}
	
	@Test
	void testToArray() {
		test.add("test");
		test.add("test2");
		Assert.assertNotNull(test.toArray());
	}
	
	@Test
	void testEquals() {
		test.add("test");
		ExtendedArrayList<String> test2 = new ExtendedArrayList<String>();
		test2.add("test");
		Assert.assertTrue(test.equals(test2));
	}

}
