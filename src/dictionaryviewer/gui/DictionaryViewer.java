/*
 * DictionaryViewer.java
 *
 * Created on May 5, 2010, 6:13:25 PM
 */

package dictionaryviewer.gui;

import dictionaryviewer.Dictionary;
import dictionaryviewer.Dictionary.ListNode;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

/**
 *
 * @author Dang Huy Hoa
 * @since 06 May 2010
 * @version 1.0.1
 *
 * @modified 20 May 2010
 */
public class DictionaryViewer extends javax.swing.JFrame {
    private String      fileName;                   //Contains file name text.
    private int         numberFoundEntries;
    private Dictionary  dict = new Dictionary();

    /** Creates new form DictionaryViewer */
    public DictionaryViewer(Dictionary d) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        initComponents();

        //Customize
        dict = d;
        
        String txtFound = String.valueOf(dict.getNumberOfWords());
        if (this.numberFoundEntries > 1)
            txtFound += " entries found!";
        else
            txtFound += " entry found!";
        lblFound.setText(txtFound);
        
        blkDefintions.append(this.search(txtSearch.getText()));
        //this.input();//Use new method (input()) to handle the larger file.

        // Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Determine the new location of the window
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        // Move the window
        this.setLocation(x, y);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        blkDefintions = new javax.swing.JTextArea();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        lblFound = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        blkDefintions.setColumns(20);
        blkDefintions.setEditable(false);
        blkDefintions.setRows(5);
        jScrollPane1.setViewportView(blkDefintions);

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lblFound.setFont(new java.awt.Font("DejaVu Sans", 1, 13));
        lblFound.setForeground(new java.awt.Color(1, 131, 45));
        lblFound.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(lblFound, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFound, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Search method.
     * Created on   : 11 May 2010
     * Last modified: 11 May 2010
     * Version      : 1.0.0
     */
    private String search(String txtSearch) {
        /*
         * //@Last modified 20 May 2010
         * First purpose is save searched words to history list
         * and get them later.
         *
         * But now, one word need search once time.
         */
        
        numberFoundEntries = 0;
        //Dictionary searchedEntries = new Dictionary();//This line is for first purpose.//@Last modified 20 May 2010
        StringBuffer display=new StringBuffer();
        ListNode current = dict.getListHead();
        while (current != null) {
            if (current.getEntry().containsTheseLetters(txtSearch)) {
                //searchedEntries.add(current.getEntry());//This line is for first purpose.//@Last modified 20 May 2010
                display.append(current.getEntry().getWord() +"\n"+"\t"+ current.getEntry().getDefinition());
                numberFoundEntries++;
            }
            current = current.getNext();
        }
        //Read list//
        ///////////////////////////////////////////////////////
        /*
         * These lines are for first purpose.//@Last modified 20 May 2010
         * 
        ListNode displayEntry = searchedEntries.getListHead();
        while (displayEntry != null){
            display.append(displayEntry.getEntry().getWord() +"\n"+"\t"+displayEntry.getEntry().getDefinition());
            displayEntry = displayEntry.getNext();
        }
        this.numberFoundEntries = searchedEntries.getNumberOfWords();
        System.out.println(display.toString().length());
         * 
         */

        return display.toString();
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        //Modified on: 11 May 2010
        blkDefintions.setText("");
        blkDefintions.append(this.search(txtSearch.getText()));
        String txtFound = String.valueOf(this.numberFoundEntries);
        if (this.numberFoundEntries > 1)
            txtFound += " entries found!";
        else
            txtFound += " entry found!";
        lblFound.setText(txtFound);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER://Press Enter key.
                this.btnSearchActionPerformed(null);//Call btnSearch click action.
                break;
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    /**
    * @param args the command line arguments
    */

    /*
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DictionaryViewer(null).setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DictionaryViewer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(DictionaryViewer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(DictionaryViewer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
     * 
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea blkDefintions;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFound;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
