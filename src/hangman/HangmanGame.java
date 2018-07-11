/* Program Description: A program to let you play Hangman
 * Author: Brandi Morgan, Quintin Gossen
 * Assignment: Group Project
 * Date: July 10, 2018
 * Class: CSCI 1082
 */

package hangman;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class HangmanGame
{
    // Enumeration describing the current game status
    public enum GameStatus
    {
        InProgress("Game in Progress"),
        Failed("You Lose"),
        Success("Congrats You Win");

        // String used for display purposes
        private String displayString = null;

       
         // Creates a new enumeration object with the provided display
         // string
         
        GameStatus(String displayString)
        {
            this.displayString = displayString;
        }

        
         //Overrides the toString method to print a readable version of the
          //enumeration
         
        @Override
        public String toString()
        {
            return this.displayString;
        }
    }
    
    public enum GuessResult {
        Invalid,
        Repeated,
        Incorrect,
        Correct
    }

    // Number of incorrect guesses before the game is over
    public static final int NUMBER_OF_INCORRECT_GUESSES = 6;
    // The word to be guessed
    private String word = null;
    // The word is hint
    private String hint = null;
    // Set of letters guessed so far
    private Set<Character> guessedLetters = new HashSet<Character>();
    // Set of incorrect guessed letters so far
    private List<Character> missedLetters = new ArrayList<Character>();
    // Number of penalty guesses (for buying a vowel and buying hint)
    private int penalty = 0;
    
    public boolean isHintAlreadyUsed = false;

    // Initializes a new HangmanGame with the given secret word
    public HangmanGame(String secretWord)
    {
        // Convert the word to lower case
        secretWord = secretWord.toLowerCase();

        // Validate the secret word
        if (!isValidWord(secretWord))
            throw new IllegalArgumentException("Invalid Input");

        this.word = secretWord;
    }

    //Returns the current game status 

    public GameStatus getGameStatus()
    {
        // Check for success
        boolean win = true;
        for (char c : this.word.toCharArray())
        {
            if (!this.guessedLetters.contains(c))
            {
                win = false;
                break;
            }
        }
        if (win)
            return GameStatus.Success;

        // Check for failure
        if (this.getNumberOfGuessesRemaining() <= 0)
            return GameStatus.Failed;

        // Otherwise, game still in progress
        return GameStatus.InProgress;
    }

  
     // Allows the user to guess another letter, and tests for the other letters the word contains
    
    public GuessResult guessLetter(char letter)
    {
        // Convert character to lower case
        letter = Character.toLowerCase(letter);

        // Only process valid characters
        if (!this.isValidCharacter(letter))
            return GuessResult.Invalid;

        // Check if the user already guessed this letter
        if (this.guessedLetters.contains(letter))
            return GuessResult.Repeated;

        // Record the guess
        this.guessedLetters.add(letter);

        if (this.word.contains(String.valueOf(letter)))
        {
            // Record a correct guess
            return GuessResult.Correct;
        }
        else
        {
            // Record an incorrect guess
            this.missedLetters.add(letter);
            return GuessResult.Incorrect;
        }
    }

    // Returns a string representation of the hidden word.
     
    public String getGuessedWord()
    {
        StringBuilder sb = new StringBuilder();
        for (char c : this.word.toCharArray())
        {
            if (this.guessedLetters.contains(c))
                sb.append(c).append(" ");
            else
                sb.append("_ ");
        }
        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * Returns the number of missed guesses remaining before the game
     * is over.
     * @return the number of missed guesses remaining in this game
     */
    public int getNumberOfGuessesRemaining()
    {
        return NUMBER_OF_INCORRECT_GUESSES - (this.missedLetters.size() + penalty);
    }

    // Returns a comma-separated list of missed letters
    public String getMissedLetters()
    {
        StringBuilder sb = new StringBuilder();
        for (char c : this.missedLetters)
            sb.append(c).append(",");
        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    public boolean isHintUsed() {
        if(isHintAlreadyUsed) {
            return false;
        }
        else{
            this.penalty++;
            isHintAlreadyUsed = true;
            return(true);}
    
        
    }
    public Character getRandomUnguessedVowel() {
        if (this.getNumberOfGuessesRemaining() <= 1)
            return null; // Cannot buy a vowel
        
        // Get list of remaining vowels
        Set<Character> consonants = new HashSet<Character>();
        Set<Character> vowels = new HashSet<Character>();
        for (char c : this.word.toCharArray())
        {
            if (!this.guessedLetters.contains(c)) {
                if (isVowel(c))
                    vowels.add(c);
                else
                    consonants.add(c);
            }
        }
        
        // check for available vowels
        if (vowels.isEmpty())
            return null;
        
        // If the vowel is the last vowel before win, don't return anything
        if (vowels.size() == 1 && consonants.isEmpty())
            return null;
        
        // get a vowel for a penalty
        this.penalty++;
        return vowels.iterator().next();
    }

    // check if the word is a valid word. False otherwise
    
    private boolean isValidWord(String word)
    {
        for (char c : word.toCharArray())
        {
            if (!isValidCharacter(c))
                return false;
        }

        return true;
    }
    
    public String getSecretWord(){
        return this.word;
    }

    
    //  Determines if a single character is a valid character in the
     // hangman game. The character must be a lower-case alphabetic character.
    private boolean isValidCharacter(char character)
    {
        if (character >= 'a' && character <= 'z')
            return true;
        return false;
    }
    
    private boolean isVowel(char character) {
        switch(character) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
                return true;
        }
        
        return false;
    }
    
   public void setHint(String hint) {
        this.hint = hint;
    }

    public String getHint() {
        return hint;
    }

    
      //Returns a string representation of the current game state
   
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Word: ").append(this.getGuessedWord()).append("\n");
        sb.append("Guesses Remaining: ").append(this.getNumberOfGuessesRemaining()).append("\n");
        sb.append("Missed Letters: ").append(this.getMissedLetters()).append("\n");
        return sb.toString();
    }
}