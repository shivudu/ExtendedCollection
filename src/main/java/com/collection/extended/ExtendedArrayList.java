/**
 * 
 */
package com.collection.extended;

import java.util.Arrays;
import java.util.Objects;

import com.collection.extended.helpers.ExtendedArrayListIndexOutofBoundsException;

/**
 * Extended Array layout the foundation design for achieving having Long range
 * values in Array List Though it may not be use case for many but idea is to
 * lay out design for those who need this case and memory is not a concern
 * 
 */
public class ExtendedArrayList<E> {

	/**
	 * Base data structure to back the dynamic elements supporting long range values
	 */
	private Object[][] base;

	// Max value for single row is being considered as 90% of Max value
	private static final int MAX_LENGTH = (int) (Integer.MAX_VALUE * 0.9);

	// col capacity
	private int colCapacity;

	// Cursors
	private int rIndex = 0;
	// Last column index
	private int cIndex = 0;

	private long size = 0L;

	private static final int DEFAULT_SIZE = 10;

	/**
	 * Default constructor assigns initial capacity 10
	 */
	public ExtendedArrayList() {
		this(DEFAULT_SIZE);
	}

	/**
	 * Constructs ExtendedArrayList with specified extended initial capacity It
	 * constructs 2D array to match the initial capacity the more value the more
	 * heap allocation to be mind by users before utilizing If not sure prefer to
	 * use default constructs that grows at constant rate
	 * 
	 * @param initialCapacity
	 */
	public ExtendedArrayList(long initialCapacity) {
		if (initialCapacity <= MAX_LENGTH) {
			base = new Object[1][(int) initialCapacity];
		} else {
			initializeBase(initialCapacity);
		}
	}

	/**
	 * Private to Extended array list initializes an array dynamically based on
	 * specified full capacity
	 * 
	 * @param capacity
	 */
	private void initializeBase(long capacity) {
		int tRSize = (int) (capacity / MAX_LENGTH);
		int cSize = (int) (capacity % MAX_LENGTH);
		int rSize = cSize == 0 ? tRSize : tRSize + 1;
		base = new Object[rSize][];
		for (int i = 0; i < (rSize != tRSize ? rSize - 1 : rSize); i++) {
			base[i] = new Object[MAX_LENGTH];
		}
		if (rSize != tRSize)
			base[rSize - 1] = new Object[cSize];
	}

	/**
	 * Add an element to Extended Array List similar to
	 * 
	 * @see java.util.ArrayList
	 * @param e
	 */
	public void add(E e) {
		checkResize();
		base[rIndex][cIndex++] = e;
		size++;
	}

	/**
	 * Fetches an element specified at index Index for rows and columns can be
	 * constructed internally Users just specify index similar to ArrayList
	 * 
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E get(long index) {
		if (size <= index)
			throw new ExtendedArrayListIndexOutofBoundsException("index " + index + " out of boundary size " + size);
		int rIndex = (int) (index / MAX_LENGTH);
		int cIndex = (int) (index % MAX_LENGTH);
		return (E) base[rIndex][cIndex];

	}

	/**
	 * This is a more iterative approach when filled with more elements We don't
	 * encourage to use unless required when dealing with large data sets
	 * 
	 * @param e
	 * @return
	 */
	public boolean contains(E e) {
		for (int i = 0; i < rIndex; i++) {
			for (int j = 0; j < cIndex; j++) {
				if (e.equals(base[i][j]))
					return true;
			}
		}
		return false;
	}

	/**
	 * removes an element at specified index and adjusts the internal 2D array
	 * 
	 * @param index
	 * @return
	 */
	public boolean remove(int index) {
		// TODO
		return false;
	}

	/**
	 * Clears the elements of this Extended ArrayList Does not actually change the
	 * value of each position as it does not add any value in doing so hence tricks
	 * the internal cursors to make the impact
	 */
	public void clear() {
		size = 0L;
		rIndex = 0;
		cIndex = 0;
	}

	private void checkResize() {
		if (cIndex == MAX_LENGTH) {
			Object[][] tmp = new Object[rIndex + 2][];
			for (int i = 0; i <= rIndex; i++) {
				tmp[i] = base[i];
			}
			colCapacity = (int) (0.05 * MAX_LENGTH);
			tmp[rIndex + 1] = new Object[colCapacity];
			rIndex++;
		} else if (cIndex == colCapacity) {
			int newColCapacity = (int) (colCapacity * 0.15) > MAX_LENGTH ? MAX_LENGTH : (int) (0.05 * MAX_LENGTH);
			base[rIndex] = Arrays.copyOf(base[rIndex], newColCapacity);
		}
	}

	@Override
	public String toString() {
		return "ExtendedArrayList [base=" + Arrays.toString(base) + ", colCapacity=" + colCapacity + ", rIndex="
				+ rIndex + ", cIndex=" + cIndex + ", size=" + size + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(base);
		result = prime * result + Objects.hash(cIndex, colCapacity, rIndex, size);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExtendedArrayList other = (ExtendedArrayList) obj;
		return Arrays.deepEquals(base, other.base) && cIndex == other.cIndex && colCapacity == other.colCapacity
				&& rIndex == other.rIndex && size == other.size;
	}
	
}
