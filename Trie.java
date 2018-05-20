package Trie;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
	
	private class Node{
		Character data;
		HashMap<Character, Node> children;
		boolean eow;
		
		public Node(Character ch){
			this.data=ch;
			this.children = new HashMap<Character, Node>();
			this.eow = false;
		}
	}
	
	private Node root;
	private int numWords = 0;
	private int numNodes = 0;
	
	public Trie(){
		this.root = new Node('$');
		
	}
	
	public void addWords(String word){
		this.addWords(root, word);
	}
	
	private void addWords(Node node, String word){
		if(word.length()==0){
			node.eow = true;
			this.numWords++;
			return;
		}
		char ch = word.charAt(0);
		String row = word.substring(1);
		
		Node child = node.children.get(ch);
		if(child==null){
			child = new Node(ch);
			node.children.put(ch,child);
			numNodes++;
		}
		addWords(child,row);
	}
	
	public boolean searchWord(String str){
		boolean st = searchWord(root, str);
		System.out.print(st);
		return st;
	}
	private boolean searchWord(Node node, String word){
		if(word.length()==0){
			return node.eow;
		}
		
		char ch = word.charAt(0);
		String row = word.substring(1);
		
		Node child = node.children.get(ch);
		if(child==null){
			return false;
		}
		return searchWord(child,row);
	}
	
	public void remove(String word){
		this.remove(root,word);
	}
	
	private void remove(Node node, String word){
		if(word.length()==0){
			node.eow = false;
			this.numWords--;
			return;
		}
		char ch = word.charAt(0);
		String row = word.substring(1);
		
		Node child = node.children.get(ch);
		if(child==null){
			return;
		}
		remove(child, row);
		if(child.eow==false && child.children.size()==0){
			node.children.remove(ch);
			this.numNodes--;
		}
	}
	
	public void display(){
		this.display(root);
	}
	
	private void display(Node node){
		String str = node.data + "->";
		for (int i=0; i<node.children.size(); i++) {
			str += node.children.get(i) + ",";
		}
		str += ".";
		System.out.println(str);
		for (int i=0; i<node.children.size(); i++) {
			display(node.children.get(i));
		}
	}
	
	public void displayWords(){
//		this.displayWords(root,word,"");
//		System.out.println(this.displayWords(root,word,""));
		
		this.displayWords(root,"");
	}
	
//	static ArrayList<String> words = new ArrayList<String>();
//	private void displayWords(Node node, String word, String str){
//		if(word.length()==0){
//			words.add(str);
//			return;
//		}
//		char ch = word.charAt(0);
//		String eow = word.substring(1);
//		
//		Node child = node.children.get(ch);
//		if(child==null){
//			return;
//		}
//		displayWords(child,word,str+node.data+" ");
//	}
	
	private void displayWords(Node node, String str){
		if(node==null){
			return;
		}
		
		ArrayList<Character> keys = new ArrayList<>(node.children.keySet());
		
		for(Character key:keys){
			Node child = node.children.get(key);
			displayWords(child, str+key);
		}
	}
}
