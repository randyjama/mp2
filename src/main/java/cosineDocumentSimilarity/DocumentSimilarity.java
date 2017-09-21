package cosineDocumentSimilarity;

import java.util.Map;
import java.util.Set;
import java.util.List;

public class DocumentSimilarity {

	/**
	 * Determine the two Documents from a given List that are most similar to
	 * each other according to the cosine similarity metric
	 * 
	 * @param docList
	 *            is a List with at least two Document references
	 * @return the DocumentPair that holds the two Documents most similar to
	 *         each other using the cosine similarity metric. If more than one
	 *         pair of Documents has the same similarity then returns any one.
	 */
	public static DocumentPair closestMatch(List<Document> docList) {
		// TODO: Implement this method
		return null;
	}

	/**
	 * Determine a set of document groups where a group of documents are more
	 * similar to each other than to documents in a different group.
	 * 
	 * @param docList
	 *            is a List with at least two Document references from which we
	 *            want to group documents by similarity
	 * @param numGroups
	 *            > 0 is the number of Document groups to create
	 * @return a Map that represents how documents are grouped. Two documents
	 *         that are in the same group will map to the same value and two
	 *         documents that are not in the same group will map to different
	 *         values.
	 */
	public static Map<Document, Integer> groupSimilarDocuments(List<Document> docList, int numGroups) {
		// TODO: Implement this method
		return null;
	}

}
