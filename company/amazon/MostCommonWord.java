//Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
//
//        Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
//
//
//
//        Example:
//
//        Input:
//        paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
//        banned = ["hit"]
//        Output: "ball"
//        Explanation:
//        "hit" occurs 3 times, but it is a banned word.
//        "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
//        Note that words in the paragraph are not case sensitive,
//        that punctuation is ignored (even if adjacent to words, such as "ball,"),
//        and that "hit" isn't the answer even though it occurs more because it is banned.
//
//
//        Note:
//
//        1 <= paragraph.length <= 1000.
//        0 <= banned.length <= 100.
//        1 <= banned[i].length <= 10.
//        The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
//        paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
//        There are no hyphens or hyphenated words.
//        Words only consist of letters, never apostrophes or other punctuation symbols.

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        for(String s: banned) {
            bannedWords.add(s);
        }

        Map<String, Integer> counts = new HashMap<>();
        String filteredParagraph = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase();
        // Splitting by one or more spaces
        // Could even use " +" instead of "\\s+"
        String[] words = filteredParagraph.split("\\s+");
        for(String word: words) {
            if(!bannedWords.contains(word)) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
        }

        String result = "";
        int maxCount = 0;
        for(String key: counts.keySet()) {
            if(counts.get(key) > maxCount) {
                result = key;
                maxCount = counts.get(key);
            }
        }

        return result;
    }
}

/**
 * Alternative solution: Faster runtime
 */
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        for(String s: banned) {
            bannedWords.add(s);
        }

        Map<String, Integer> counts = new HashMap<>();
        StringBuilder word = new StringBuilder();
        int n = paragraph.toCharArray().length;
        for(int i = 0; i < n; i++) {
            char c = paragraph.charAt(i);
            if(Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if(word.length() > 0) {
                String finalWord = word.toString();
                if(!bannedWords.contains(finalWord)) {
                    counts.put(finalWord, counts.getOrDefault(finalWord, 0) + 1);
                }
                if(i != n - 1) {
                    word = new StringBuilder();
                }
            }
        }

        // Counting the last word
        if(!bannedWords.contains(word.toString())) {
            counts.put(word.toString(), counts.getOrDefault(word.toString(), 0) + 1);
        }

        String result = "";
        int maxCount = 0;
        for(String key: counts.keySet()) {
            if(counts.get(key) > maxCount) {
                result = key;
                maxCount = counts.get(key);
            }
        }

        return result;
    }
}