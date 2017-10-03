package cosineDocumentSimilarity;

public class DocumentPair implements Comparable<DocumentPair> {

	// Partial Representation
	private Document doc1, doc2;

	/**
	 * Create a new Document pair given two Documents
	 * 
	 * @param doc1
	 *            not null
	 * @param doc2
	 *            not null
	 */
	public DocumentPair(Document doc1, Document doc2) {
		// TODO: Implement this method
		this.doc1 = doc1;
		this.doc2 = doc2;
	}
	
	//find csim100 between doc1 and doc2
	public int docSimilarity() {
		int csim100_pair = doc1.cosineSimilarity(doc2);
		return csim100_pair;
	}

	/**
	 * Compare two DocumentPair objects
	 * 
	 * @param other
	 *            the other DocumentPair to compare this to
	 * 
	 * @return a value less than 0 if this DocumentPair is less similar
	 *         internally than the other DocumentPair, 0 if the similarity of
	 *         the two pairs is the same, and a value > 0 if this pair is more
	 *         similar than the other pair.
	 */
	public int compareTo(DocumentPair other) {
		// TODO: Implement this method
		if (docSimilarity() < other.docSimilarity()) {
			return -1;
		}
		else if (docSimilarity() > other.docSimilarity()) {
			return 1;
		}
		else {//equal to
			return 0;
		}
	}
	// You should not have to implement/change anything below this comment

	/**
	 * Compare two DocumentPair objects for equality.
	 * 
	 * @param other
	 *            is not null
	 * @return true if this DocumentPair and the other DocumentPair represent
	 *         the same two Document objects and false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj instanceof DocumentPair) {
			DocumentPair other = (DocumentPair) obj;
			return ((this.doc1.equals(other.doc1) && this.doc2.equals(other.doc2))
					|| (this.doc1.equals(other.doc2) && (this.doc2.equals(other.doc1))));
		} else
			return false;

	}

	/**
	 * Compute the hashCode for a DocumentPair
	 * 
	 * @return the hashCode for this DocumentPair
	 */
	@Override
	public int hashCode() {
		return doc1.hashCode() + doc2.hashCode();
	}

	/**
	 * Return the first Document in the DocumentPair. The ordering of Document
	 * objects in a DocumentPair is arbitrary.
	 * 
	 * @return the first Document in the DocumentPair.
	 */
	public Document getDoc1() {
		return doc1;
	}

	/**
	 * Return the second Document in the DocumentPair. The ordering of Document
	 * objects in a DocumentPair is arbitrary.
	 * 
	 * @return the second Document in the DocumentPair.
	 */
	public Document getDoc2() {
		return doc2;
	}

}
