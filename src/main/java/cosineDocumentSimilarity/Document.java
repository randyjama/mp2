package cosineDocumentSimilarity;

import java.io.IOException;
//added 2 imports, idea from https://stackoverflow.com/questions/33244502/word-count-program-using-hashmaps
import java.io.*;
import java.util.*;
import java.net.URL;

public class Document implements Comparable<Document> {

	// Partial Representation of a Document
	// You may need to add more...
	private String url;
	private Scanner scanner;

	/**
	 * Create a Document object given a URL to the document
	 * 
	 * @param url
	 *            is not null or an empty String
	 */
	public Document(String url) throws IOException {

		// TODO: Implement this method
		InputStream stream = new URL(url).openStream();
		this.scanner = new Scanner(stream);
		this.url = url;
	}

	/**
	 * 
	 */
	public Scanner getScanner() {
		return this.scanner;
	}

	/**
	 * Compute the cosine similarity percentage between this Document and another
	 * Document.
	 * 
	 * @param otherDoc
	 *            is not null
	 * @return the cosine similarity percentage between this Document and another
	 *         Document.
	 */
	public int cosineSimilarity(Document otherDoc) {
		// TODO: Implement this method

		Scanner scan_otherDoc = otherDoc.getScanner();
		HashMap<String, int[]> words = new HashMap<String, int[]>();
		//place scanners into array to use in for loop
		Scanner[] scanArray = new Scanner[2];
		scanArray[0] = this.scanner;
		scanArray[1] = scan_otherDoc;
		
		// while loop for counting first doc
		for (int i = 0; i < 2; i++) {
			while (scanArray[i].hasNext()) {
				String word = scanArray[i].next();
				// remove all punctuation and set all words to lowercase
				//word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
				// need to account for skipping empty strings
				//if (word.equals("")) {
				//		continue;
				//	}
				
				if (words.containsKey(word)) {
					int[] counts = words.get(word);
					counts[i]++;
					words.put(word, counts);
				} else {// unique word found
					int[] counts = new int[2];
					counts[i] = 1;
					//0 ^ 1 = 1
					//1 ^ 1 = 0
					counts[i ^ 1] = 0;
					words.put(word, counts);
				}
			}
		}
		
		//prints all unique words and their respective counts per document
		for (String key : words.keySet()) {
			int[] counts = words.get(key);
			//System.out.println(key + "= [" + counts[0] + ", " + counts[1] + "] ");
		}
		//System.out.println(words.toString());
		
		//calculate dot product
		double dotProduct = 0;
		for (String key : words.keySet()) {
			int[] counts = words.get(key);
			dotProduct += counts[0] * counts[1];
		}
		//System.out.println("Dot Product = " + dotProduct);
		
		//calculate cross product
		double crossProduct = 0;
		int[] sums = new int[2];
		sums[0] = 0;
		sums[1] = 0;
		for(int i = 0; i < 2; i++) {
			for(String key : words.keySet()) {
				int[] counts = words.get(key);
				sums[i] += counts[i]*counts[i];
			}
		}
		crossProduct = Math.sqrt(sums[0]) * Math.sqrt(sums[1]);
		//System.out.println(crossProduct);
		
		//calculate cosine similarity
		double csim100 = 100 * (dotProduct / crossProduct);
		//round down csim100 to nearest integer
		double d = csim100;
		
		return (int) d;
		
	}

	// You should not have to change any of the methods below this comment
	/**
	 * Return a String that represents the URL for the document
	 */
	public String toString() {
		// TODO: Implement this method
		return null;
	}

	/**
	 * Compare two Document objects for equality
	 * 
	 * @param other
	 * @return true if this Document and the other Document represent the same
	 *         document.
	 */
	@Override
	public boolean equals(Object other) {

		if (other instanceof Document) {
			Document otherDoc = (Document) other;
			return (this.url.equals(otherDoc.url));
		} else {
			return false;
		}
	}

	/**
	 * Compute the hashCode for this Document object
	 * 
	 * @return the hashCode for this Document object
	 */
	@Override
	public int hashCode() {
		return url.hashCode();
	}

	/**
	 * Compare two Document objects. Allows for ordering of Document objects.
	 * 
	 * @param other
	 *            Document to compare this document with
	 * @return 0 if the two Documents are equal, and a non-zero value otherwise
	 */
	public int compareTo(Document other) {
		if (this.equals(other))
			return 0;
		else
			return url.compareTo(other.url);
	}

/*
	public static void main(String args[]) {
		try {
			// test for valid url input
			Document firstDoc = new Document(
					"https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/beatles.txt");
			Document secondDoc = new Document(
					"https://docs.oracle.com/javase/7/docs/api/java/net/URL.html#openStream()");
			
			//print csim100
			System.out.println(firstDoc.cosineSimilarity(secondDoc));

			System.out.println("Success! Printed document without exception.");
		} catch (IOException e) {
			System.out.println("Got exception. OH NO! " + e.toString()); // print out error message
		}
	}
*/

}
