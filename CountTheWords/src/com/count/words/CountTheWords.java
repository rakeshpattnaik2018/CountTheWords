package com.count.words;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class CountTheWords is responsible for set of below operations
 * - Count the number of words starts with "m" Or "M"
 * - Count the number of words greater than 5 characters
 * 
 * @author Rakesh
 *
 */
public class CountTheWords {

	static Logger logger = Logger.getLogger(CountTheWords.class.getName());

	/**
	 * <p> The method counts the number of words in a given
	 * string which starts with either "m" Or "M"  and 
	 * number of words greater than 5 characters <p>
	 * 
	 * @param  - accepts and String input
	 * @return - a count of letters starts with "m" Or "M"
	 */
	public ResultVO countNumberOfWords(String phrase) {

		ResultVO result = new ResultVO();
		int wordCountStartsWith = 0;
		List<String> wordCountGtFive;
		try {
			if( phrase.isBlank() || phrase.isEmpty()) {
				throw new RuntimeException(String.format("The input String %s is not valid", phrase));
			}else {
				List <String> list = Stream.of(phrase).map(w -> w.split("\\W+")).flatMap(Arrays::stream)
						.collect(Collectors.toList());

				wordCountStartsWith = (int) list.stream().filter(e -> e.startsWith("M") || e.startsWith("m")).count();
				wordCountGtFive = list.stream().filter(e -> e.length() > 5).collect(Collectors.toList());
			}
			logger.info(String.format("The total number of words starts with 'm' Or 'M' count is %s", wordCountStartsWith));
			logger.info(String.format("The total number of words having more than five characters is %s", wordCountGtFive));

			result.setWordCountStartsWith(wordCountStartsWith);
			result.setWordsGrtThanFive(wordCountGtFive);

		}catch (Exception e) {
			throw new RuntimeException("Issue while evaluating the word counts");
		}
		return result;
	}

}
