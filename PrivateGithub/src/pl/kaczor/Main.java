package pl.kaczor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    Map<String, Integer> firsts = new HashMap<>();

    public static void main(String[] args) {
        String text = "Frodo was the only one present who had said nothing. For some time he had sat silent beside Bilbo’s empty chair, and ignored all remarks and questions. He had enjoyed the joke, of course, even though he had been in the know. He had difficulty in keeping from laughter at the indignant surprise of the guests. But at the same time he felt deeply troubled: he realized suddenly that he loved the old hobbit dearly. Most of the guests went on eating and drinking and discussing Bilbo Baggins’ oddities, past and present; but the Sackville-Bagginses had already departed in wrath. Frodo did not want to have any more to do with the party. He gave orders for more wine to be served; then he got up and drained his own glass silently to the health of Bilbo, and slipped out of the pavilion.";
        String[] words = text.toUpperCase().split("[^A-Z]+");
        int tab[][] = new int[26][3];
        for(int i = 0; i<words.length; i++) {
            for(int j = 0; j<words[i].length(); j++) {
                int w = words[i].codePointAt(j) - 65;
                tab[w][0] += 1;
                if(j==0)tab[w][1] += 1;
                if(j==words[i].length()-1)tab[w][2] += 1;
            }
        }

        for (int[] element : tab) {
            System.out.println(element[0]+" "+element[1]+" "+element[2]);
        }
    }

}
