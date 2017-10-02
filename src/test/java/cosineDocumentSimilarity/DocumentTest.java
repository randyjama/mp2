package cosineDocumentSimilarity;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Test;

public class DocumentTest {

	@Test
	public void test0() throws IOException {
		List<Document> docList = new ArrayList<Document>();
		Scanner sc = new Scanner(
				new URL("https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/file-list.txt")
						.openStream());
		while (sc.hasNext()) {
			String url = sc.nextLine().trim();
			Document doc = new Document(url);
			docList.add(doc);
		}

		sc.close();

		Map<Document, Integer> docGroups = DocumentSimilarity.groupSimilarDocuments(docList, 2);
		
		System.out.println(docGroups);

		Document d1 = new Document("https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/sonnets.txt");
		Document d2 = new Document("https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/beatles.txt");
		Document d3 = new Document("https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/cthulhu.txt");

		// d1 and d2 should be in different groups
		// d2 and d3 should be in the same group
		assertTrue(docGroups.get(d1) != docGroups.get(d2));
		assertEquals(docGroups.get(d2), docGroups.get(d3));
	}

	@Test
	public void test1() throws IOException {
		Document doc1 = new Document(
				"https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/sonnets.txt");
		Document doc2 = new Document(
				"https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/cthulhu.txt");
		assertEquals(51, doc1.cosineSimilarity(doc2));
	}

	@Test
	public void test4() throws IOException {
		Document doc1 = new Document("https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/aliens.txt");
		Document doc2 = new Document(
				"https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/cthulhu.txt");
		assertEquals(73, doc1.cosineSimilarity(doc2));
	}

	@Test
	public void test2() throws IOException {
		Document doc1 = new Document("https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/aliens.txt");
		Document doc2 = new Document(
				"https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/beatles.txt");
		assertEquals(92, doc1.cosineSimilarity(doc2));
	}

	@Test
	public void test3() throws IOException {
		Document doc1 = new Document(
				"https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/sonnets.txt");
		Document doc2 = new Document(
				"https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/police-practices.txt");
		assertEquals(47, doc1.cosineSimilarity(doc2));
	}

}