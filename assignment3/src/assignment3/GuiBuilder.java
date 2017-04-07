package assignment3;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

public class GuiBuilder extends JFrame {
    
    
    
    /******************************
    * Declared variables
    ********************************/
    private JPanel contentPane;
    
    //Radio Buttons
    private JRadioButton rbLowerCase;
    private JRadioButton rbUpperCase;
    //Radio Button Groups
    private ButtonGroup buttonGroupCases = new ButtonGroup();
    private ButtonGroup buttonGroupTables = new ButtonGroup();

    //Buttons
    private JButton btnFormat;
    private JButton btnReset;
    private JButton BtnRetrieveQuery;
    
    //Text input
    private JTextArea textInput;
    
    //TextOutput
    private JTextArea textOutput1;
    private JTextArea textOutput2;
    
    //table
    private JTable tableOutput;
    
    //Check boxes
    private JCheckBox tenSpaces;
    
    //Drop down menus
    private JComboBox charPerLine;
    
    //Variables for calculation
    private int characters;
    private boolean spaces;
    private boolean cases;
    private String inputSequence;
    
    private JScrollPane scrollPane;
    private JTabbedPane tabbedPane;
    private JPanel assignment2;
    private JPanel assignment3;
    private JScrollPane scrollPaneInput1;
    private JScrollPane scrollPaneTextOutput1a2;
    private JScrollPane scrollPaneTextOutput2a2;
    private JScrollPane scrollPaneTextOutput1a3;

    /**
     * Launch the application.
     */
    //public static void main(String[] args) {
       // Database database = new Database();
        //EventQueue.invokeLater(new Runnable() {
           /* public void run() {
                try{
                    GuiBuilder frame = new GuiBuilder();
                    frame.setVisible(true);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }*/
    //}

    /**
     * Create the frame.
     */
    public GuiBuilder() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1160, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        

        scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        scrollPane.setViewportView(tabbedPane);
        
        JPanel assignment2 = new JPanel();
        assignment2.setPreferredSize(new Dimension(1160, 500));
        tabbedPane.addTab("New tab", null, assignment2, null);
        SpringLayout sl_assignment2 = new SpringLayout();
        assignment2.setLayout(sl_assignment2);
        
        JScrollPane scrollPaneInput1 = new JScrollPane();
        sl_assignment2.putConstraint(SpringLayout.NORTH, scrollPaneInput1, 10, SpringLayout.NORTH, assignment2);
        sl_assignment2.putConstraint(SpringLayout.WEST, scrollPaneInput1, 10, SpringLayout.WEST, assignment2);
        sl_assignment2.putConstraint(SpringLayout.SOUTH, scrollPaneInput1, 291, SpringLayout.NORTH, assignment2);
        sl_assignment2.putConstraint(SpringLayout.EAST, scrollPaneInput1, 504, SpringLayout.WEST, assignment2);
        assignment2.add(scrollPaneInput1);
       
        
        JScrollPane scrollPaneTextOutput1a2 = new JScrollPane();
        sl_assignment2.putConstraint(SpringLayout.NORTH, scrollPaneTextOutput1a2, 0, SpringLayout.NORTH, assignment2);
        sl_assignment2.putConstraint(SpringLayout.WEST, scrollPaneTextOutput1a2, 6, SpringLayout.EAST, scrollPaneInput1);
        sl_assignment2.putConstraint(SpringLayout.EAST, scrollPaneTextOutput1a2, -10, SpringLayout.EAST, assignment2);
        scrollPaneTextOutput1a2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        assignment2.add(scrollPaneTextOutput1a2);
        
        //Scroll Pane for text output1
        JScrollPane scrollPaneTextOutput2a2 = new JScrollPane();
        sl_assignment2.putConstraint(SpringLayout.SOUTH, scrollPaneTextOutput1a2, -6, SpringLayout.NORTH, scrollPaneTextOutput2a2);
        sl_assignment2.putConstraint(SpringLayout.NORTH, scrollPaneTextOutput2a2, 6, SpringLayout.SOUTH, scrollPaneInput1);
        sl_assignment2.putConstraint(SpringLayout.WEST, scrollPaneTextOutput2a2, 311, SpringLayout.WEST, assignment2);
        sl_assignment2.putConstraint(SpringLayout.SOUTH, scrollPaneTextOutput2a2, -10, SpringLayout.SOUTH, assignment2);
        sl_assignment2.putConstraint(SpringLayout.EAST, scrollPaneTextOutput2a2, -5, SpringLayout.EAST, assignment2);
        scrollPaneTextOutput2a2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPaneTextOutput2a2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        assignment2.add(scrollPaneTextOutput2a2);
        
        
        //Text box input1 = Enter sequence here
        textInput = new JTextArea();
        textInput.setLineWrap(true);
        textInput.setBackground(new Color(255, 255, 255, 255));
        scrollPaneInput1.setViewportView(textInput);
        
        //Text box output1 = reformatted sequenced
        textOutput1 = new JTextArea();
        textOutput1.setEditable(false);
        textOutput1.setBackground(new Color(240, 240, 240, 240));
        textOutput1.setLineWrap(true);
        scrollPaneTextOutput1a2.setViewportView(textOutput1);
        
        //Text box output2 = Statistics
        textOutput2 = new JTextArea();
        textOutput2.setBackground(new Color(240, 240, 240, 240));
        textOutput2.setEditable(false);
        scrollPaneTextOutput2a2.setViewportView(textOutput2);
        
        /********************************
         *  Labels
         ********************************/
        
        JLabel labelCharacter = new JLabel("Characters Per Line");
        sl_assignment2.putConstraint(SpringLayout.NORTH, labelCharacter, 292, SpringLayout.NORTH, assignment2);
        sl_assignment2.putConstraint(SpringLayout.WEST, labelCharacter, 10, SpringLayout.WEST, assignment2);
        assignment2.add(labelCharacter);

        JLabel labelSpace = new JLabel("Space per 10 chars");
        sl_assignment2.putConstraint(SpringLayout.NORTH, labelSpace, 17, SpringLayout.SOUTH, labelCharacter);
        sl_assignment2.putConstraint(SpringLayout.WEST, labelSpace, 0, SpringLayout.WEST, scrollPaneInput1);
        assignment2.add(labelSpace);
        
        JLabel labelLetterCase = new JLabel("Letter Case");
        sl_assignment2.putConstraint(SpringLayout.WEST, labelLetterCase, 0, SpringLayout.WEST, scrollPaneInput1);
        assignment2.add(labelLetterCase);
        
        /********************************
         *  Drop down menu for sequence line length
         ********************************/        
        
        charPerLine = new JComboBox();
        sl_assignment2.putConstraint(SpringLayout.NORTH, charPerLine, 292, SpringLayout.NORTH, assignment2);
        sl_assignment2.putConstraint(SpringLayout.WEST, charPerLine, 6, SpringLayout.EAST, labelCharacter);
        charPerLine.setModel(new DefaultComboBoxModel(new String[] {"40", "50", "60", "70"}));
        charPerLine.setSelectedIndex(2);
        assignment2.add(charPerLine);
        
        /********************************
         *  Spaces check box per 10
         ********************************/
        
        tenSpaces = new JCheckBox("");
        sl_assignment2.putConstraint(SpringLayout.NORTH, tenSpaces, 6, SpringLayout.SOUTH, charPerLine);
        sl_assignment2.putConstraint(SpringLayout.WEST, tenSpaces, 0, SpringLayout.WEST, charPerLine);
        sl_assignment2.putConstraint(SpringLayout.EAST, tenSpaces, 0, SpringLayout.EAST, charPerLine);
        assignment2.add(tenSpaces);
       
        /********************************
         *  Radio buttons for case sensitivity
         ********************************/
        
        rbUpperCase = new JRadioButton("Upper Case");
        sl_assignment2.putConstraint(SpringLayout.NORTH, labelLetterCase, 4, SpringLayout.NORTH, rbUpperCase);
        buttonGroupCases.add(rbUpperCase);
        assignment2.add(rbUpperCase);
        
        rbLowerCase = new JRadioButton("Lower Case");
        sl_assignment2.putConstraint(SpringLayout.WEST, rbUpperCase, 6, SpringLayout.EAST, rbLowerCase);
        sl_assignment2.putConstraint(SpringLayout.SOUTH, tenSpaces, -11, SpringLayout.NORTH, rbLowerCase);
        sl_assignment2.putConstraint(SpringLayout.NORTH, rbLowerCase, -4, SpringLayout.NORTH, labelLetterCase);
        sl_assignment2.putConstraint(SpringLayout.WEST, rbLowerCase, 6, SpringLayout.EAST, labelLetterCase);
        rbLowerCase.setSelected(true);
        buttonGroupCases.add(rbLowerCase);
        assignment2.add(rbLowerCase);
        
        /********************************
         *  Buttons : Reset + Reformat
         ********************************/
        
        btnReset = new JButton("Reset");
        sl_assignment2.putConstraint(SpringLayout.NORTH, rbUpperCase, 44, SpringLayout.SOUTH, btnReset);
        sl_assignment2.putConstraint(SpringLayout.NORTH, btnReset, 292, SpringLayout.NORTH, assignment2);
        sl_assignment2.putConstraint(SpringLayout.EAST, btnReset, -17, SpringLayout.WEST, scrollPaneTextOutput2a2);
        assignment2.add(btnReset);
        
        btnFormat = new JButton("Format");
        sl_assignment2.putConstraint(SpringLayout.WEST, btnFormat, 10, SpringLayout.WEST, assignment2);
        sl_assignment2.putConstraint(SpringLayout.SOUTH, btnFormat, -10, SpringLayout.SOUTH, assignment2);
        assignment2.add(btnFormat);

        

        //JScrollPane scrollPaneInput1 = new JScrollPane();
        
        
        JPanel assignment3 = new JPanel();
        tabbedPane.addTab("New tab", null, assignment3, null);
        SpringLayout sl_assignment3 = new SpringLayout();
        assignment3.setLayout(sl_assignment3);
        //assignment3.setPreferredSize(new Dimension(1160, 700));
        
        scrollPaneTextOutput1a3 = new JScrollPane();
        sl_assignment3.putConstraint(SpringLayout.NORTH, scrollPaneTextOutput1a3, 10, SpringLayout.NORTH, assignment3);
        sl_assignment3.putConstraint(SpringLayout.WEST, scrollPaneTextOutput1a3, 190, SpringLayout.WEST, assignment3);
        sl_assignment3.putConstraint(SpringLayout.SOUTH, scrollPaneTextOutput1a3, 421, SpringLayout.NORTH, assignment3);
        sl_assignment3.putConstraint(SpringLayout.EAST, scrollPaneTextOutput1a3, -10, SpringLayout.EAST, assignment3);
        
        //JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
        //sl_assignment3.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_1, 10, SpringLayout.NORTH, assignment3);
        //sl_assignment3.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_1, 10, SpringLayout.WEST, assignment3);
        //assignment3.add(rdbtnNewRadioButton_1);        

        scrollPaneTextOutput1a3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        assignment3.add(scrollPaneTextOutput1a3);
        
        tableOutput = new JTable();
        //scrollPaneTextOutput1a3.setViewportView(tableOutput);
        //tableOutput.
        //textOutput1a3.
        //tableOutput.setEditable(false);
        //tableOutput.setBackground(new Color(240, 240, 240, 240));
        
        Database database = new Database();
        //database.connectDatabase()
       String tables = database.getTableNames();
       String[] elements = (tables.split("\\s+"));
       //int elements = 9;
        
       
       
        if (elements.length>25){
            assignment3.setPreferredSize(new Dimension(1160, 500 + 20*(elements.length-24)));
        }
        for (int i=0;i<elements.length;i++){
        JRadioButton rdbtnNewRadioButton = new JRadioButton(elements[i]);
        rdbtnNewRadioButton.setActionCommand(elements[i]);
        sl_assignment3.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton, 20*i, SpringLayout.NORTH, assignment3);
        sl_assignment3.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton, 10, SpringLayout.WEST, assignment3);    
        assignment3.add(rdbtnNewRadioButton);
        buttonGroupTables.add(rdbtnNewRadioButton);
        }    
        BtnRetrieveQuery = new JButton("Retrieve Query!!!");
        sl_assignment3.putConstraint(SpringLayout.NORTH, BtnRetrieveQuery, 6, SpringLayout.SOUTH, scrollPaneTextOutput1a3);
        sl_assignment3.putConstraint(SpringLayout.WEST, BtnRetrieveQuery, 0, SpringLayout.WEST, scrollPaneTextOutput1a3);
        assignment3.add(BtnRetrieveQuery);
        
        
        createEvents();

    }
    private void createEvents(){
        /********************************
         *  Button action : Reset
         ********************************/
        BtnRetrieveQuery.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent arg0) {
                String selected = buttonGroupTables.getSelection().getActionCommand();
                Database database = new Database();
                //Object[][] data = database.printData(selected); 
                //String[] colNames = database.getColNames(selected);
                tableOutput = new JTable(database.printData(selected),database.getColNames(selected));
                scrollPaneTextOutput1a3.setViewportView(tableOutput);
            }
        });
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int reply = JOptionPane.showConfirmDialog(null, "Are you want to reset?");
                if (reply == JOptionPane.YES_OPTION){
                    rbLowerCase.setSelected(true);
                    charPerLine.setSelectedIndex(2);
                    tenSpaces.setSelected(false);
                    textInput.setText(null);
                    textOutput1.setText(null);
                    textOutput2.setText(null);  
                }
            }
        });
        /********************************
         *  Button action : Format
         ********************************/
        btnFormat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /********************************
                 *  Determine if sequence is valid
                 ********************************/
                inputSequence = textInput.getText();
                Pattern pattern = Pattern.compile("[^acgtACGT]");
                Matcher matcher = pattern.matcher(inputSequence);    
   
                boolean isValid = matcher.find();
                
                if (isValid){
                    JOptionPane.showMessageDialog(null, "INVALID SEQUENCE");
                }
                else {
                    /********************************
                     *  Generation of output for textOutput1 and textOutput2 
                     ********************************/
                    
                    //check user parameters
                    characters = Integer.parseInt((String) charPerLine.getSelectedItem());
                    spaces = tenSpaces.isSelected();
                    cases = rbLowerCase.isSelected();
                    
                    //textOutput1 = reformated string
                    String output1 = processString(inputSequence,characters,spaces,cases);
                    textOutput1.setText(output1);
                    
                   //textOutput1 = statistics
                    String output2 = "Sequence length : " + inputSequence.length() + "\n" 
                                + basePercentCalculate("A",inputSequence.toUpperCase()) 
                                + basePercentCalculate("C",inputSequence.toUpperCase()) 
                                + basePercentCalculate("T",inputSequence.toUpperCase()) 
                                + basePercentCalculate("G",inputSequence.toUpperCase());
                    textOutput2.setText(output2);
               }
            }
        });
    }
    /**
     * processString : reformat string to match user defined parameters
     * @param inputSequence
     * @param characters
     * @param spaces
     * @param cases
     * @return
     */
    private String processString (String inputSequence,int characters,boolean spaces,boolean cases){
        
        //iterates through string 
        char [] stringToCharArray = inputSequence.toCharArray();
        
        //count per char
        int index = 0;
        
        //temporary string handler
        StringBuilder base = new StringBuilder();
        
        for(char current:stringToCharArray){
            //Add to array till index satisfies character length or requires spaces
            base.append(current);
            index++;
            if (index%characters == 0){
                base.append("\n");
            }
            else if((spaces == true)&&(index%10==0) ){
                base.append(" ");
            }
        }
        //Convert according to string sensitivity
        return (cases)? base.toString().toLowerCase() : base.toString().toUpperCase();
    }
    /**
     * basePercentCalculate : # of Bases / String length
     * @param base
     * @param input
     * @return 
     */
    private String basePercentCalculate(String base, String input){
        double original = input.length();
        double replace = input.replace(base, "").length();
        
        BigDecimal result= new BigDecimal((original-replace)/original*100);
        result = result.setScale(2, RoundingMode.CEILING);
        
        String output = "Calculated percentage of "+ base + " : " + result +"%\n";
        return output;
    }
}

