import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Hangman {

    

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Hangman! Can you guess the word? Type anything to continue");
        scan.nextLine();

        int randomNumber = randomWord();
        int wrongGuesses = 0;
        List<Character> wrongGuessesList = new ArrayList<>();
        String word = words[randomNumber];
        char[] charWord = word.toCharArray();
        char[] underscoreArray = new char[charWord.length];
        Arrays.fill(underscoreArray, '_');
        System.out.println(gallows[0]);

        while(!word.toString().equals(new String(underscoreArray))) {
        System.out.println("\nWord: " + new String(underscoreArray));
        System.out.println("\nMisses: " + wrongGuessesList);
        System.out.println("\nGuess: ");
        char userGuess = scan.next().charAt(0);
        String check = checkGuess(userGuess, word);
        
        for (int i= 0; i < word.length(); i++){
        if (check.equals("true") && (word.charAt(i) == userGuess)) {
        underscoreArray[i] = userGuess;
        } else if (check.equals("false")) {
        wrongGuesses++;
        wrongGuessesList.add(userGuess);
        System.out.println(gallows[wrongGuesses]);
        break;
        }

        }
        if (wrongGuesses >= 6)  {
            System.out.println("\nSorry, you lost the game. RIP! The word was " + word);
            System.exit(0);
          } 
        }
        
        System.out.println("\nWow congrats, you won! The word is " + new String(underscoreArray));
        
        scan.close();

    }


    public static int randomWord() {
    double wordNumber = Math.random() * 64; 
    wordNumber += 1;
    return (int) wordNumber;
    }

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String checkGuess(char userGuess, String word) {
    if (word.indexOf(userGuess) != -1) {
    return "true";
    } else {
    return "false";
    }
    }




    }






