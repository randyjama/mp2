package cosineDocumentSimilarity;

import java.util.Set;
import java.util.HashSet;

public class DocumentSet {

	private HashSet<Document> internalSet;

	public DocumentSet() {
		internalSet = new HashSet<Document>();
	}

	public void add(Document d) {
		internalSet.add(d);
	}

	public void addAll(DocumentSet ds) {
		internalSet.addAll(ds.internalSet);
	}
	
	public void remove(Document d) {
		internalSet.remove(d);
	}

	public int size() {
		return internalSet.size();
	}

	public boolean contains(Document d) {
		return internalSet.contains(d);
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof DocumentSet) {
			DocumentSet other = (DocumentSet) obj;
			if (internalSet.size() != other.internalSet.size())
				return false;
			for (Document d : internalSet) {
				if (!other.internalSet.contains(d))
					return false;
			}
			return true;
		} else
			return false;
	}

}
