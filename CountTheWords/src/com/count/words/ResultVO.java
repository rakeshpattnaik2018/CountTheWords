package com.count.words;

import java.util.List;

public class ResultVO {

	private int wordCountStartsWith;
	private List<String> wordsGrtThanFive;
	public int getWordCountStartsWith() {
		return wordCountStartsWith;
	}
	public void setWordCountStartsWith(int wordCountStartsWith) {
		this.wordCountStartsWith = wordCountStartsWith;
	}
	public List<String> getWordsGrtThanFive() {
		return wordsGrtThanFive;
	}
	public void setWordsGrtThanFive(List<String> wordsGrtThanFive) {
		this.wordsGrtThanFive = wordsGrtThanFive;
	}
	
}
