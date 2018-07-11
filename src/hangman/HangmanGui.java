/* Program Description: A program to let you play Hangman
 * Author: Brandi Morgan, Quintin Gossen
 * Assignment: Group Project
 * Date: July 10, 2018
 * Class: CSCI 1082
 */
package hangman;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Dimension;


public class HangmanGui extends javax.swing.JFrame
{
	 // Variables declaration
    private javax.swing.JButton getVowelButton;
    private javax.swing.JButton enterButton;
    private javax.swing.JLabel guessLetterLabel;
    private javax.swing.JTextField guessLetterTextField;
    private javax.swing.JLabel guessedLeftLabel;
    private javax.swing.JLabel guessedWordLabel;
    private javax.swing.JTextField guessedWordTextField;
    private javax.swing.JTextField guessesLeftTextField;
    private hangman.DrawMan drawMan;
    private javax.swing.JButton hintButton;
    private javax.swing.JDialog hintDialog;
    private javax.swing.JLabel hintLabel1;
    private javax.swing.JTextField hintfield;
    private javax.swing.JLabel incorrectLettersLabel;
    private javax.swing.JTextField incorrectLettersTextField;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JMenuItem newGameMenuItem;
    private javax.swing.JLabel statusLabel;
    private JMenuItem menuQuit;
    // The instance of the hangman game being played
    private HangmanGame game = null;
    
    
      //Creates new form HangmanFrame
     
    public HangmanGui()
    {
    	getContentPane().setSize(new Dimension(800, 600));
    	getContentPane().setBackground(new Color(30, 144, 255));
        initComponents();
        
        // Center the frame on the screen
        this.setLocationRelativeTo(null);
        
        // Start a new game
        this.newGame();
    }

    // starts new game
    private void newGame()
    {
        while (true)
        {
            // Display dialog box for selecting a category
            TopicChooser panel = new TopicChooser();
            String[] options = new String[]{"OK"};
            int option = javax.swing.JOptionPane.showOptionDialog(null,
                    panel, "Secret Word", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);
            if (option != 0)
                return; // the user did not click OK; do not retry
            TopicChooser.WordAndHint wordAndHint = panel.getSelectedWordAndHint();
            if (wordAndHint == null)
                continue; // the user did not choose anything; retry
            try
            {
                game = new HangmanGame(wordAndHint.word);
                game.setHint(wordAndHint.hint);
                break;
            }
            catch (IllegalArgumentException ex)
            {
                // Do nothing; continue in loop
            }
        }
        
        this.drawMan.reset();
        this.refreshGUI(null);
    }
    
    // New game
    private void refreshGUI(String strMessage)
    {
        // Set GUI objects to represent state of the game
        this.guessedWordTextField.setText(game.getGuessedWord());
        this.incorrectLettersTextField.setText(game.getMissedLetters());
        this.guessesLeftTextField.setText("" + game.getNumberOfGuessesRemaining());
        this.hintfield.setText(game.getHint());
        String status = game.getGameStatus().toString();
        if (strMessage != null && strMessage.length() > 0)
            status += "; " + strMessage;
        this.statusLabel.setText(status);
    }
    
    
     // Initialize form
     // Do NOT modify this code.
     
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        hintDialog = new javax.swing.JDialog();
        hintfield = new javax.swing.JTextField();
        hintLabel1 = new javax.swing.JLabel();
        guessedWordTextField = new javax.swing.JTextField();
        guessedWordLabel = new javax.swing.JLabel();
        incorrectLettersLabel = new javax.swing.JLabel();
        incorrectLettersTextField = new javax.swing.JTextField();
        guessedLeftLabel = new javax.swing.JLabel();
        guessesLeftTextField = new javax.swing.JTextField();
        guessLetterLabel = new javax.swing.JLabel();
        guessLetterTextField = new javax.swing.JTextField();
        enterButton = new javax.swing.JButton();
        enterButton.setBackground(SystemColor.scrollbar);
        statusLabel = new javax.swing.JLabel();
        hintButton = new javax.swing.JButton();
        hintButton.setBackground(SystemColor.scrollbar);
        drawMan = new hangman.DrawMan();
        getVowelButton = new javax.swing.JButton();
        getVowelButton.setBackground(SystemColor.scrollbar);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newGameMenuItem = new javax.swing.JMenuItem();

        jRadioButton1.setText("jRadioButton1");

        hintDialog.setTitle("HINT");
        hintDialog.setLocationByPlatform(true);
        hintDialog.setMinimumSize(new java.awt.Dimension(250, 200));

        hintfield.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        hintfield.setEnabled(false);
        hintfield.setFocusCycleRoot(true);
        hintfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hintfieldActionPerformed(evt);
            }
        });

        hintLabel1.setText("Hint: ");

        javax.swing.GroupLayout hintDialogLayout = new javax.swing.GroupLayout(hintDialog.getContentPane());
        hintDialog.getContentPane().setLayout(hintDialogLayout);
        hintDialogLayout.setHorizontalGroup(
            hintDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hintDialogLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(hintDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hintfield)
                    .addComponent(hintLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        hintDialogLayout.setVerticalGroup(
            hintDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hintDialogLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(hintLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hintfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        hintLabel1.getAccessibleContext().setAccessibleName("HINT FOR YOU");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hangman");

        guessedWordTextField.setBackground(new java.awt.Color(240, 240, 240));
        guessedWordTextField.setEnabled(false);
        guessedWordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessedWordTextFieldActionPerformed(evt);
            }
        });

        guessedWordLabel.setText("Word to Guess:");

        incorrectLettersLabel.setText("Incorrect Letters:");

        incorrectLettersTextField.setEnabled(false);

        guessedLeftLabel.setText("Lives Left:");

        guessesLeftTextField.setEnabled(false);

        guessLetterLabel.setText("Guess Letter:");

        guessLetterTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                guessLetterTextFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                guessLetterTextFieldKeyTyped(evt);
            }
        });

        enterButton.setText("Enter");
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guessButtonActionPerformed(evt);
            }
        });

        statusLabel.setText("Ready");

        hintButton.setText("Hint");
        hintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hintButtonActionPerformed(evt);
            }
        });

        getVowelButton.setText("Get a vowel");
        getVowelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyavowelButtonActionPerformed(evt);
            }
        });

        jMenu1.setText("Options");

        newGameMenuItem.setText("New Game");
        newGameMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(newGameMenuItem);

        jMenuBar1.add(jMenu1);
        
        menuQuit = new JMenuItem("Quit");
        menuQuit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		System.exit(0);
        	}
        });
        jMenu1.add(menuQuit);
      

        setJMenuBar(jMenuBar1);
        
        JTextArea txtrRulesType = new JTextArea();
        txtrRulesType.setText("Rules:\r\n- Type 1 Character only. (Strings/Digits not allowed)\\n\r\n- After you type the character, click enter to submit your guess\r\n- If you are stuck on a word, click \"Hint\" to get a phrase that may help \r\nor you can click \"Get a vowel\" to find where some vowels are in the word.\r\n- Clicking the \"Get a vowel\" button costs you lives\r\n- Clicking the \"Hint\" button also costs you a life. You only get 1 hint.\r\n- You only get 6 guesses\r\n- \r\n\r\n");
        txtrRulesType.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(24)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(incorrectLettersTextField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
        					.addGap(33)
        					.addComponent(guessesLeftTextField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
        					.addGap(121)
        					.addComponent(statusLabel, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(incorrectLettersLabel)
        							.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
        							.addComponent(guessedLeftLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
        						.addComponent(drawMan, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
        							.addComponent(guessLetterLabel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(guessLetterTextField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        							.addGap(14)
        							.addComponent(enterButton)
        							.addGap(84))
        						.addGroup(layout.createSequentialGroup()
        							.addGap(38)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(guessedWordLabel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
        								.addComponent(guessedWordTextField, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
        							.addGap(31)))
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(getVowelButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
        							.addComponent(hintButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
        							.addGap(371))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(txtrRulesType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addContainerGap())))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(30)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(guessLetterLabel)
        								.addComponent(guessLetterTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(enterButton))
        							.addGap(60)
        							.addComponent(guessedWordLabel)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(guessedWordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(137))
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(getVowelButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        								.addComponent(hintButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(txtrRulesType, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED))))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(drawMan, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)))
        			.addGap(28)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(incorrectLettersTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(guessesLeftTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(statusLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
        					.addGap(22))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(guessedLeftLabel)
        					.addGap(55))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(incorrectLettersLabel)
        					.addGap(55))))
        );
        getContentPane().setLayout(layout);

        pack();
    }
    
    //Guess listener
    private void guessButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (game == null || game.getGameStatus() != HangmanGame.GameStatus.InProgress)
            return; // the game is not in progress; no more moves to be played
        
        String guessedLetter = this.guessLetterTextField.getText();
        if (guessedLetter.length() == 0)
            return;
        HangmanGame.GuessResult guessResult = game.guessLetter(guessedLetter.charAt(0));
        if (guessResult == HangmanGame.GuessResult.Incorrect)
            this.drawMan.advancePicture();
        if (game.isHintAlreadyUsed)
            hintButton.setText("Hint");
        if (game.getNumberOfGuessesRemaining() <= 1 && !game.isHintAlreadyUsed)
        {
            hintDialog.setVisible(false);
        }
        if ( game.getGameStatus().equals(HangmanGame.GameStatus.Success))
         {
            hintDialog.setVisible(false);
         }
        if(!game.getGameStatus().equals(HangmanGame.GameStatus.Failed)) {
            String strMessage = guessResult == HangmanGame.GuessResult.Correct ? "Correct guess" : "Missed guess";
            this.refreshGUI(strMessage);
            this.guessLetterTextField.setText("");
            this.guessLetterTextField.requestFocus();
        } else {
            this.refreshGUI("The Word is "+game.getSecretWord());
        }
    }
     // Responds to a click of the 'new game' menu item.
     //Starts a new game of hangman.
  
    private void newGameMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        this.newGame();
    }//GEN-LAST:event_newGameMenuItemActionPerformed

    //ensures that only one key is typed at once
    private void guessLetterTextFieldKeyTyped(java.awt.event.KeyEvent evt) {
        if (this.guessLetterTextField.getText().length() >= 1)
            evt.consume(); // block the character
    }

    private void guessedWordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
        // To Activate ENTER Key for GUESS Button
    private void guessLetterTextFieldKeyPressed(java.awt.event.KeyEvent evt) {
       if(evt.getKeyCode() != KeyEvent.VK_ENTER)
            return; // only respond to enter key events
        
       this.guessButtonActionPerformed(null);
    }
    private void hintButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.guessLetterTextField.setText(" ");
        
        if (game.getGameStatus().equals(HangmanGame.GameStatus.InProgress) && (game.getNumberOfGuessesRemaining() > 1 || game.isHintAlreadyUsed))
        {
            hintDialog.setVisible(true);
            boolean hintUsed = this.game.isHintUsed();
            if (hintUsed) 
            {
            // Trigger the guess letter action
            this.guessButtonActionPerformed(null);
            // Advance the hangman picture to keep up with the penalty
            this.drawMan.advancePicture();
            }
            else {}
        }
       
        else{
           hintDialog.setVisible(false);
        }  
    }
    private void hintfieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void buyavowelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Clear guessed letter
        this.guessLetterTextField.setText("");
        
        // Get random vowel from the word
        Character vowel = this.game.getRandomUnguessedVowel();
        if (vowel == null)
            return; // if no vowels remain disallow clicking
        
        // Set the guessed letter
        this.guessLetterTextField.setText(vowel.toString());
        
        // Trigger the guess letter action
        this.guessButtonActionPerformed(null);
        // Advance the hangman picture to keep up with the penalty
        this.drawMan.advancePicture();
    }
     // Main method, set look
    public static void main(String args[]) {
        // Set the Nimbus look and feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HangmanGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HangmanGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HangmanGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HangmanGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Create and display form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HangmanGui().setVisible(true);
            }
        });
    }
   
}
