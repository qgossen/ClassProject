/* Program Description: A program to let you play Hangman
 * Author: Brandi Morgan, Quintin Gossen
 * Assignment: Group Project
 * Date: July 10, 2018
 * Class: CSCI 1082
 */

package hangman;

import java.util.Random;
import javax.swing.ButtonGroup;

public class TopicChooser extends javax.swing.JPanel {
	
	 // Variables 
    private javax.swing.JRadioButton rCountry;
    private javax.swing.JRadioButton rRelatives;
    private javax.swing.JRadioButton rProduce;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton rMovies;
    private javax.swing.JRadioButton majors;

    // Hints for words
    public final class WordAndHint {
        public final String word;
        public final String hint;
        public WordAndHint(final String word, final String hint) {
            this.word = word;
            this.hint = hint;
        }
    }
    
    // List of all the words in the string array
    private final String produce[]={"banana","mango","cauliflower","carrot", "strawberry"};
    private final String countries[]={"india","america","germany","korea","zimbabwe"};
    private final String genres[]={"scifi","horror","thriller","drama","action"};
    private final String family[]={"uncle","aunt","stepsister","grandmother","brother"};
    private final String major[]={"Computer_Science","Physics","Art","Media","Cyber_Security"};
    
    // List of all hints in a String array
    private final String produce_hint[]={"yellow and curved","sweet and tropical","white tree shape","crunchy","sweet and red"};
    private final String countries_hint[]={"industry bigger than hollywood","freedeom of speech","economic power","north and south","in africa"};
    private final String genres_hint[]={"science and tech","frightening","exciting","Over The top","Explosions and fighting"};
    private final String family_hint[]={"your parents' brother", "your parents' sister","step-parents' child","your parents mom","your male sibling"};
    private final String major_hint[]={"Someone who likes programming might major in...","The Mathy one of Sciences","Someone who loves to draw","studies governments","basis of communication"};

    //Creates a Topic panel
    public TopicChooser() {
        initComponents();
        
        // Create button group around options
        ButtonGroup bg = new ButtonGroup();
        bg.add(rProduce);
        bg.add(rCountry);
        bg.add(rRelatives);
        bg.add(rMovies);
        bg.add(majors);
    }
    
    public WordAndHint getSelectedWordAndHint() {
        // Generates a random number between 0 and 4
        int n = new Random().nextInt(5);
        
        if(rProduce.isSelected()) {
            return new WordAndHint(produce[n],produce_hint[n]);
        }
        else if(rRelatives.isSelected()) {
            return new WordAndHint(family[n],family_hint[n]);
        }
        else if(majors.isSelected()) {
            return new WordAndHint(major[n],major_hint[n]);
        }
        else if(rMovies.isSelected()) {
            return new WordAndHint(genres[n],genres_hint[n]);
        }
        else if(rCountry.isSelected()) {
            return new WordAndHint(countries[n],countries_hint[n]);
        }
        
        //Nothing 
        return null;
    }

    //initialize form
    @SuppressWarnings("unchecked")
    
    //components
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        rCountry = new javax.swing.JRadioButton();
        rMovies = new javax.swing.JRadioButton();
        rRelatives = new javax.swing.JRadioButton();
        rProduce = new javax.swing.JRadioButton();
        majors = new javax.swing.JRadioButton();

        jLabel1.setText("Choose a topic to begin the game.");

        rCountry.setText("Countries");

        rMovies.setText("Movie Genres");
        rMovies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSportsActionPerformed(evt);
            }
        });

        rRelatives.setText("Relatives");

        rProduce.setText("Produce");

        majors.setText("Majors");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(majors)
                            .addComponent(rProduce)
                            .addComponent(rRelatives)
                            .addComponent(rMovies)
                            .addComponent(rCountry)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rCountry)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rMovies)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rRelatives)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rProduce)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(majors)
                .addContainerGap(116, Short.MAX_VALUE))
        );
    }//

    private void jSportsActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }//

}