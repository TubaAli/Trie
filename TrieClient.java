package Trie;

public class TrieClient {

	public static void main(String[] args) {
		Trie t = new Trie();
		t.addWords("are");
		t.addWords("art");
		t.addWords("ant");
		t.addWords("and");
		t.addWords("an");
		t.addWords("as");
		t.addWords("ask");
		t.addWords("see");
		t.addWords("seen");
		t.addWords("sea");
		
		t.display();
		t.displayWords();
	}

}
