# Extended Dynamic Collection Framework
## Overview
The Extended Dynamic Collection Framework is an enhancement of Java's native Collection Framework, designed to support larger collections by using 2D data structure internally. This allows for greater flexibility and scalability in handling vast amounts of data, overcoming the limitations imposed by Java's default int-based size constraints.

Of course, the use case may be impractical for many users and has performance considerations, but intend is to help those in rare use cases and provide the design the allows / helps user in over coming.

##Features
Long Size Support: Unlike Java's standard collections, which are limited to Integer.MAX_VALUE elements due to int-based size representations, our framework can handle collections with sizes beyond this limit by utilizing 2D data structure.

Efficient Storage: Internally, the framework employs optimized data structures such as 2D arrays to efficiently manage large collections while maintaining performance and memory efficiency.

Familiar API: The API maintains familiarity with Java's Collection Framework, ensuring ease of use and seamless integration into existing Java projects.

##Supported Classes
The Extended Dynamic Collection Framework includes the following classes with extended long size support:

ExtendedArrayList: A dynamic array-based list supporting long sizes.
ExtendedLinkedList: A dynamic linked list supporting long sizes.TODO
ExtendedHashMap: A hash map supporting long sizes for both keys and values.TODO
ExtendedHashSet: A hash set supporting long sizes for elements.TODO
##Usage
To incorporate the Extended Dynamic Collection Framework into your Java project, follow these steps:

Download the jar file from the project's releases section / have open source code if you are looking to go over enhancements with this.

Add the JAR file to your project's classpath or dependencies.

Import the required classes from the framework into your Java code:


import com.collection.extended.ExtendedArrayList;
import com.collection.extended.ExtendedHashMap;
Create instances of the desired collection classes and utilize their extended long size capabilities:

]
ExtendedArrayList<String> arrayList = new ExtendedArrayList<>();
long size = arrayList.size(); // returns long range size now

ExtendedHashMap<Long, String> hashMap = new ExtendedHashMap<>();
hashMap.put(987654321L, "Value");
Explore the extensive methods available in each collection class, including operations on large collections and efficient memory management.

##Contribution Guidelines
We are starting to lay foundation. Feel free to contribute to this and provide solution if any. 

