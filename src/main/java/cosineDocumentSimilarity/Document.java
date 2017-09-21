package cosineDocumentSimilarity;

import java.io.IOException;
import java.net.URL;

public class Document implements Comparable<Document> {

	// Partial Representation of a Document
	// You may need to add more...
	private String url;

	/**
	 * Create a Document object given a URL to the document
	 * 
	 * @param url
	 *            is not null or an empty String
	 */
	public Document(String url) throws IOException {

		// TODO: Implement this method

	}

	/**
	 * Compute the cosine similarity percentage between this Document and
	 * another Document.
	 * 
	 * @param otherDoc
	 *            is not null
	 * @return the cosine similarity percentage between this Document and
	 *         another Document.
	 */
	public int cosineSimilarity(Document otherDoc) {
		// TODO: Implement this method
		return -1;
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

	public int compareTo(Document other) {
		if (this.equals(other))
			return 0;
		else
			return url.compareTo(other.url);
	}

}
