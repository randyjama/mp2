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

	@Test
	public void test5() throws IOException {
		Document doc1 = new Document(
				"https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/sonnets.txt");
		Document doc2 = new Document(
				"https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/police-practices.txt");
		Document doc3 = new Document(
				"https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/beatles.txt");
		Document doc4 = new Document(
				"https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/cthulhu.txt");
		DocumentPair doc12 = new DocumentPair(doc1, doc2);
		DocumentPair doc34 = new DocumentPair(doc3, doc4);
		DocumentPair doc14 = new DocumentPair(doc1, doc4);
		DocumentPair doc23 = new DocumentPair(doc2, doc3);
		DocumentPair doc11 = new DocumentPair(doc1, doc1);
		assertEquals(0, doc12.compareTo(doc12));
		assertEquals(-1, doc11.compareTo(doc34));
	}

	@Test
	public void test6() throws IOException {
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

		Map<Document, Integer> docGroups = DocumentSimilarity.groupSimilarDocuments(docList, 1);

		System.out.println(docGroups);

		Document d1 = new Document("https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/sonnets.txt");
		Document d2 = new Document("https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/beatles.txt");
		Document d3 = new Document("https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/cthulhu.txt");

		// d1 and d2 and d3 should be in same group
		assertEquals(docGroups.get(d1), docGroups.get(d2), docGroups.get(d3));
	}
	
	@Test
	public void test7() throws IOException {
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

		Map<Document, Integer> docGroups = DocumentSimilarity.groupSimilarDocuments(docList, 5);

		System.out.println(docGroups);

		Document d1 = new Document("https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/sonnets.txt");
		Document d2 = new Document("https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/beatles.txt");
		Document d3 = new Document("https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/cthulhu.txt");
		
		// d1 and d2 and d3 should be in different groups
		assertTrue(docGroups.get(d1) != docGroups.get(d2) && docGroups.get(d1) != docGroups.get(d3) && docGroups.get(d2) != docGroups.get(d3));
	}
	
	@Test
	public void test8() throws IOException {
		Document doc1 = new Document(
				"https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/sonnets.txt");
		Document doc2 = new Document(
				"https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/police-practices.txt");
		Document doc3 = new Document(
				"https://raw.githubusercontent.com/CPEN-221/docSimilarityTests/master/beatles.txt");
		List<Document> docList = new ArrayList<Document>();
		docList.add(doc1);
		docList.add(doc2);
		docList.add(doc3);
		DocumentPair doc12 = new DocumentPair(doc2, doc3);
		
		assertEquals(doc12, DocumentSimilarity.closestMatch(docList));
	}

}