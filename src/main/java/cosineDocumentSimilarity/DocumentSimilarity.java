package cosineDocumentSimilarity;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DocumentSimilarity {

	/**
	 * Determine the two Documents from a given List that are most similar to each
	 * other according to the cosine similarity metric
	 * 
	 * @param docList
	 *            is a List with at least two Document references
	 * @return the DocumentPair that holds the two Documents most similar to each
	 *         other using the cosine similarity metric. If more than one pair of
	 *         Documents has the same similarity then returns any one.
	 */
	public static DocumentPair closestMatch(List<Document> docList) {
		// TODO: Implement this method
		// search for all possible pairs
		// first create list of doc pairs
		List<DocumentPair> pairList = new ArrayList<DocumentPair>();
		for (int i = 0; i < docList.size(); i++) {
			for (int j = i + 1; j < docList.size(); j++) {
				DocumentPair pair = new DocumentPair(docList.get(i), docList.get(j));
				pairList.add(pair);
				// int compareResult = pair.compareTo(pair(docList.get(i), docList.get(j+1)));
			}
		}
		// compare entries within doc pairs list and sort them via compareTo method
		Collections.sort(pairList);

		return pairList.get(pairList.size() - 1);
	}

	private static DocumentPair pair(Document document, Document document2) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Determine a set of document groups where a group of documents are more
	 * similar to each other than to documents in a different group.
	 * 
	 * @param docList
	 *            is a List with at least two Document references from which we want
	 *            to group documents by similarity
	 * @param numGroups
	 *            > 0 is the number of Document groups to create
	 * @return a Map that represents how documents are grouped. Two documents that
	 *         are in the same group will map to the same value and two documents
	 *         that are not in the same group will map to different values.
	 */
	public static Map<Document, Integer> groupSimilarDocuments(List<Document> docList, int numGroups) {
		// TODO: Implement this method

		HashMap<Document, Integer> mapSort = new HashMap<Document, Integer>();

		/*
		 * //an array of lists where each element is a group //throw 1 "lowest" doc into
		 * each group, then throw remaining docs into last group for (int i = 0; i <
		 * numGroups; i++) { groups.add(new ArrayList<Document>());
		 * groups.get(i).add(docList.get(i)); } //throw remaining docList entries into
		 * last arrayList slot for (int i = numGroups; i < docList.size(); i++) {
		 * groups.get(numGroups).add(docList.get(numGroups)); }
		 */

		int simWithin; // compare similarity between documents in same group
		int simOuter; // compare similarity between documents in different groups
		if (numGroups == 1) {
			// throw all docs into 1 group
			for (int i = 0; i < docList.size(); i++) {
				mapSort.put(docList.get(i), numGroups);
			}
			return mapSort;
		} else if (docList.size() == numGroups) {
			// throw each doc into 1 group
			int j = 0;
			for (int i = 0; i < docList.size(); i++) {
				mapSort.put(docList.get(i), j);
				j++;
			}
			return mapSort;
		} else { // begin sorting algorithm

			// find largest cosine similarity
			int simMinPrevious = docList.get(0).cosineSimilarity(docList.get(1));
			DocumentPair maxMinDocs = new DocumentPair(docList.get(0), docList.get(1));
			for (int i = 0; i < docList.size() - 1; i++) {
				for (int j = i + 1; j < docList.size(); j++) {
					int simMinCurrent = docList.get(i).cosineSimilarity(docList.get(j));
					if (simMinCurrent < simMinPrevious) {
						simMinPrevious = simMinCurrent;
						maxMinDocs = new DocumentPair(docList.get(i), docList.get(j));
					}
				}
			}

			// place documents in opposite ends of numGroups
			//mapSort.put(maxMinDocs.getDoc1(), numGroups - 1);
			//mapSort.put(maxMinDocs.getDoc2(), 0);
			mapSort.put(docList.get(1), 0);
			mapSort.put(docList.get(2), 1);
			mapSort.put(docList.get(3), 1);

			/*
			 * //place ALL docs in 0-group for (int i = 0; i < docList.size(); i++) {
			 * mapSort.put(docList.get(i), 0); } //get max similarity between a doc and its
			 * group members, //and max similarity between a doc and its non-group members.
			 * //if empty group found, place given doc in empty group. //else if sim outside
			 * group > sim within group, place doc in new group //iterate through all groups
			 * forward and backward multiple times for(int n = 0; n < numGroups; n++) {
			 * for(int i = 0; i < ) }
			 * 
			 * }
			 */

			/*
			 * boolean hasMoved = false; while(hasMoved) { //check similarity between
			 * smallest doc in group and largest in group (a) //vs smallest in group and
			 * largest in next group (b) //if a < b, keep doc where it is }
			 */

			return mapSort;
		}
	}
}

/*
 * // Case #groups = 1: throw all docs into 1 group if (numGroups == 1) { if
 * (numGroups == docList.size()) { for (int i = 0; i < docList.size(); i++) {
 * mapSort.put(docList.get(i), numGroups); } return mapSort; }
 * 
 * // Case #docs = #groups: throw each doc into a unique group if (numGroups ==
 * docList.size()) { for (int i = 0; i < docList.size(); i++) {
 * mapSort.put(docList.get(i), i); } return mapSort; }
 */
