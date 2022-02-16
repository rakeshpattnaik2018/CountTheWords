package com.count.words.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.junit.Before;
import org.junit.Test;
import com.count.words.CountTheWords;
import com.count.words.ResultVO;


public class CountTheWordsTest {
	
	String phrase;
	
	@Before
	 public void setUp() throws IOException {
		phrase = loadProperties();
	}
	
	private  String loadProperties() throws IOException
	{
		Properties prop = new Properties();
		InputStream inputStream = getClass().getResourceAsStream("A.config");
		prop.load(inputStream);
		return prop.getProperty("myProp");
	}
	
	@Test
	public void testCountNumberOfWords_Valid() {
		List<String> list = Arrays.asList("Mamamma", "finish");
		
		CountTheWords wordCount = new CountTheWords();
		ResultVO resultVO = wordCount.countNumberOfWords(phrase);
		assertEquals("The total number of words starts with 'm' Or 'M' should be ",5, resultVO.getWordCountStartsWith());
		assertEquals("The total number of words in phrase having greater than 5 characters are ",2, resultVO.getWordsGrtThanFive().size());
		assertThat("The expected words having more than 5 characters",list,   is(equalTo(resultVO.getWordsGrtThanFive())));
	
	}

	@Test
	public void testCountNumberOfWords_Invalid() {
		
		CountTheWords wordCount = new CountTheWords();
		RuntimeException ex = assertThrows(RuntimeException.class, () -> wordCount.countNumberOfWords(""));
		assertThat(ex.getMessage(), is("Issue while evaluating the word counts"));
	}
}
