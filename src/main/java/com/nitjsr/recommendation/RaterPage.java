package com.nitjsr.recommendation;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Locale;

public class RaterPage extends JDialog {
    private JPanel contentPane;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JComboBox comboBox7;
    private JComboBox comboBox8;
    private JComboBox comboBox9;
    private JComboBox comboBox10;
    private JLabel a1;
    private JLabel a2;
    private JLabel b1;
    private JLabel b2;
    private JLabel c1;
    private JLabel c2;
    private JLabel d1;
    private JLabel d2;
    private JLabel e1;
    private JLabel e2;
    private JLabel f1;
    private JLabel f2;
    private JLabel g1;
    private JLabel g2;
    private JLabel h1;
    private JLabel h2;
    private JLabel i1;
    private JLabel i2;
    private JLabel j1;
    private JLabel j2;
    private JTextField genreField;
    private JTextField directorField;
    private JTextField yearField;
    private JTextField minTextField;
    private JTextField maxTextField;
    //    private JButton getRecommendationsButton;
    private JButton filterRecommendationsButton;
    private JButton helpButton;
    private JButton buttonOK;
    private JButton buttonCancel;

    public RaterPage() {


        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        // Centring the window///////////////
        Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        Dimension windowSize = new Dimension(getPreferredSize());
        int wdwLeft = screenSize.width / 2 - windowSize.width / 2;
        int wdwTop = screenSize.height / 2 - windowSize.height / 2;
        pack();
        setLocation(wdwLeft, wdwTop);
        ///////////////////////////////////////

        MovieDatabase.initialize("ratedmoviesfull.csv");

//        System.out.println(MovieDatabase.getTitle("111161"));

        ///////LOADING TITLES////////////
        a2.setText(MovieDatabase.getTitle("3390572"));
        b2.setText(MovieDatabase.getTitle("1201607"));
        c2.setText(MovieDatabase.getTitle("1723121"));
        d2.setText(MovieDatabase.getTitle("1343092"));
        e2.setText(MovieDatabase.getTitle("1951261"));
        f2.setText(MovieDatabase.getTitle("3678782"));
        g2.setText(MovieDatabase.getTitle("2184339"));
        h2.setText(MovieDatabase.getTitle("1454468"));
        i2.setText(MovieDatabase.getTitle("2278388"));
        j2.setText(MovieDatabase.getTitle("2752200"));
        ///////LOADING Years////////////
        a1.setText(Integer.toString(MovieDatabase.getYear("3390572")));
        b1.setText(Integer.toString(MovieDatabase.getYear("1201607")));
        c1.setText(Integer.toString(MovieDatabase.getYear("1723121")));
        d1.setText(Integer.toString(MovieDatabase.getYear("1343092")));
        e1.setText(Integer.toString(MovieDatabase.getYear("1951261")));
        f1.setText(Integer.toString(MovieDatabase.getYear("3678782")));
        g1.setText(Integer.toString(MovieDatabase.getYear("2184339")));
        h1.setText(Integer.toString(MovieDatabase.getYear("1454468")));
        i1.setText(Integer.toString(MovieDatabase.getYear("2278388")));
        j1.setText(Integer.toString(MovieDatabase.getYear("2752200")));


        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String msg = "Action, Adventure, Thriller, Mystery, Horror, Drama, Animation, Biography, \nFantasy, Family, Crime, Musical, Romance, History, Documentary, Sport, Sci-Fi";
                infoBox(msg, "Available Genres");
            }
        });


        filterRecommendationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double[] rates = new double[10];
                rates[0] = Double.parseDouble(comboBox1.getSelectedItem().toString());
                rates[1] = Double.parseDouble(comboBox2.getSelectedItem().toString());
                rates[2] = Double.parseDouble(comboBox3.getSelectedItem().toString());
                rates[3] = Double.parseDouble(comboBox4.getSelectedItem().toString());
                rates[4] = Double.parseDouble(comboBox5.getSelectedItem().toString());
                rates[5] = Double.parseDouble(comboBox6.getSelectedItem().toString());
                rates[6] = Double.parseDouble(comboBox7.getSelectedItem().toString());
                rates[7] = Double.parseDouble(comboBox8.getSelectedItem().toString());
                rates[8] = Double.parseDouble(comboBox9.getSelectedItem().toString());
                rates[9] = Double.parseDouble(comboBox10.getSelectedItem().toString());
                MovieRunnerSimilarRatings ref = new MovieRunnerSimilarRatings();

                ResultPage rp = new ResultPage(ref.printSimiliarRatingsByAllFilters(rates, genreField.getText(), minTextField.getText(), maxTextField.getText(), directorField.getText(), yearField.getText()));
                rp.pack();
                rp.setVisible(true);

            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        RaterPage dialog = new RaterPage();
        dialog.pack();
        dialog.setVisible(true);
//        System.exit(0);
    }

    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayoutManager(14, 5, new Insets(10, 10, 10, 10), -1, -1));
        contentPane.setAlignmentX(0.5f);
        contentPane.setAlignmentY(0.5f);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(10, 5, new Insets(0, 0, 0, 0), -1, -1));
        contentPane.add(panel1, new GridConstraints(13, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, new GridConstraints(0, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JSeparator separator1 = new JSeparator();
        panel1.add(separator1, new GridConstraints(1, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$(null, -1, 18, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-16735835));
        label1.setText("Filters");
        panel1.add(label1, new GridConstraints(3, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Genre");
        panel1.add(label2, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        genreField = new JTextField();
        panel1.add(genreField, new GridConstraints(4, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Director");
        panel1.add(label3, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        directorField = new JTextField();
        panel1.add(directorField, new GridConstraints(5, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Year");
        panel1.add(label4, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        yearField = new JTextField();
        panel1.add(yearField, new GridConstraints(6, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Running Time");
        panel1.add(label5, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        minTextField = new JTextField();
        minTextField.setText("Min");
        panel1.add(minTextField, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(75, -1), new Dimension(75, -1), 0, false));
        maxTextField = new JTextField();
        maxTextField.setText("Max");
        panel1.add(maxTextField, new GridConstraints(7, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(75, -1), new Dimension(75, -1), 0, false));
        final Spacer spacer1 = new Spacer();
        panel1.add(spacer1, new GridConstraints(2, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(-1, 10), null, 0, false));
        final JSeparator separator2 = new JSeparator();
        panel1.add(separator2, new GridConstraints(8, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        filterRecommendationsButton = new JButton();
        filterRecommendationsButton.setFocusPainted(false);
        filterRecommendationsButton.setText("Get Recommendations");
        panel1.add(filterRecommendationsButton, new GridConstraints(9, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        helpButton = new JButton();
        helpButton.setFocusPainted(false);
        helpButton.setFocusable(true);
        helpButton.setText("?");
        helpButton.setToolTipText("Help");
        panel1.add(helpButton, new GridConstraints(4, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(4, 1, new Insets(0, 0, 0, 0), -1, -1));
        contentPane.add(panel3, new GridConstraints(0, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        Font label6Font = this.$$$getFont$$$("Dialog", Font.BOLD, 20, label6.getFont());
        if (label6Font != null) label6.setFont(label6Font);
        label6.setForeground(new Color(-7076841));
        label6.setText("JAVAFLIX");
        panel3.add(label6, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel3.add(spacer2, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(5, 15), null, 0, false));
        final Spacer spacer3 = new Spacer();
        panel3.add(spacer3, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(5, 15), null, 0, false));
        final JLabel label7 = new JLabel();
        Font label7Font = this.$$$getFont$$$("Dialog", Font.PLAIN, 18, label7.getFont());
        if (label7Font != null) label7.setFont(label7Font);
        label7.setForeground(new Color(-3931112));
        label7.setText("Movie Recommendation System");
        panel3.add(label7, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        contentPane.add(spacer4, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, new Dimension(50, -1), null, 0, false));
        final Spacer spacer5 = new Spacer();
        contentPane.add(spacer5, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, new Dimension(50, -1), null, 0, false));
        final Spacer spacer6 = new Spacer();
        contentPane.add(spacer6, new GridConstraints(12, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(-1, 30), null, 0, false));
        final JSeparator separator3 = new JSeparator();
        contentPane.add(separator3, new GridConstraints(1, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        a1 = new JLabel();
        a1.setRequestFocusEnabled(true);
        a1.setText("Label");
        contentPane.add(a1, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox1 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("0");
        defaultComboBoxModel1.addElement("1");
        defaultComboBoxModel1.addElement("2");
        defaultComboBoxModel1.addElement("3");
        defaultComboBoxModel1.addElement("4");
        defaultComboBoxModel1.addElement("5");
        defaultComboBoxModel1.addElement("6");
        defaultComboBoxModel1.addElement("7");
        defaultComboBoxModel1.addElement("8");
        defaultComboBoxModel1.addElement("9");
        defaultComboBoxModel1.addElement("10");
        comboBox1.setModel(defaultComboBoxModel1);
        contentPane.add(comboBox1, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        a2 = new JLabel();
        a2.setText("Label");
        contentPane.add(a2, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        b1 = new JLabel();
        b1.setText("Label");
        contentPane.add(b1, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        b2 = new JLabel();
        b2.setText("Label");
        contentPane.add(b2, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox2 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("0");
        defaultComboBoxModel2.addElement("1");
        defaultComboBoxModel2.addElement("2");
        defaultComboBoxModel2.addElement("3");
        defaultComboBoxModel2.addElement("4");
        defaultComboBoxModel2.addElement("5");
        defaultComboBoxModel2.addElement("6");
        defaultComboBoxModel2.addElement("7");
        defaultComboBoxModel2.addElement("8");
        defaultComboBoxModel2.addElement("9");
        defaultComboBoxModel2.addElement("10");
        comboBox2.setModel(defaultComboBoxModel2);
        contentPane.add(comboBox2, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        c1 = new JLabel();
        c1.setText("Label");
        contentPane.add(c1, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        c2 = new JLabel();
        c2.setText("Label");
        contentPane.add(c2, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        d1 = new JLabel();
        d1.setText("Label");
        contentPane.add(d1, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        d2 = new JLabel();
        d2.setText("Label");
        contentPane.add(d2, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        e1 = new JLabel();
        e1.setText("Label");
        contentPane.add(e1, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        e2 = new JLabel();
        e2.setText("Label");
        contentPane.add(e2, new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        f1 = new JLabel();
        f1.setText("Label");
        contentPane.add(f1, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        f2 = new JLabel();
        f2.setText("Label");
        contentPane.add(f2, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        g1 = new JLabel();
        g1.setText("Label");
        contentPane.add(g1, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        g2 = new JLabel();
        g2.setText("Label");
        contentPane.add(g2, new GridConstraints(8, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        h1 = new JLabel();
        h1.setText("Label");
        contentPane.add(h1, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        h2 = new JLabel();
        h2.setText("Label");
        contentPane.add(h2, new GridConstraints(9, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        i1 = new JLabel();
        i1.setText("Label");
        contentPane.add(i1, new GridConstraints(10, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        i2 = new JLabel();
        i2.setText("Label");
        contentPane.add(i2, new GridConstraints(10, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        j1 = new JLabel();
        j1.setText("Label");
        contentPane.add(j1, new GridConstraints(11, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        j2 = new JLabel();
        j2.setText("Label");
        contentPane.add(j2, new GridConstraints(11, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox3 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        defaultComboBoxModel3.addElement("0");
        defaultComboBoxModel3.addElement("1");
        defaultComboBoxModel3.addElement("2");
        defaultComboBoxModel3.addElement("3");
        defaultComboBoxModel3.addElement("4");
        defaultComboBoxModel3.addElement("5");
        defaultComboBoxModel3.addElement("6");
        defaultComboBoxModel3.addElement("7");
        defaultComboBoxModel3.addElement("8");
        defaultComboBoxModel3.addElement("9");
        defaultComboBoxModel3.addElement("10");
        comboBox3.setModel(defaultComboBoxModel3);
        contentPane.add(comboBox3, new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox4 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel4 = new DefaultComboBoxModel();
        defaultComboBoxModel4.addElement("0");
        defaultComboBoxModel4.addElement("1");
        defaultComboBoxModel4.addElement("2");
        defaultComboBoxModel4.addElement("3");
        defaultComboBoxModel4.addElement("4");
        defaultComboBoxModel4.addElement("5");
        defaultComboBoxModel4.addElement("6");
        defaultComboBoxModel4.addElement("7");
        defaultComboBoxModel4.addElement("8");
        defaultComboBoxModel4.addElement("9");
        defaultComboBoxModel4.addElement("10");
        comboBox4.setModel(defaultComboBoxModel4);
        contentPane.add(comboBox4, new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox5 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel5 = new DefaultComboBoxModel();
        defaultComboBoxModel5.addElement("0");
        defaultComboBoxModel5.addElement("1");
        defaultComboBoxModel5.addElement("2");
        defaultComboBoxModel5.addElement("3");
        defaultComboBoxModel5.addElement("4");
        defaultComboBoxModel5.addElement("5");
        defaultComboBoxModel5.addElement("6");
        defaultComboBoxModel5.addElement("7");
        defaultComboBoxModel5.addElement("8");
        defaultComboBoxModel5.addElement("9");
        defaultComboBoxModel5.addElement("10");
        comboBox5.setModel(defaultComboBoxModel5);
        contentPane.add(comboBox5, new GridConstraints(6, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox6 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel6 = new DefaultComboBoxModel();
        defaultComboBoxModel6.addElement("0");
        defaultComboBoxModel6.addElement("1");
        defaultComboBoxModel6.addElement("2");
        defaultComboBoxModel6.addElement("3");
        defaultComboBoxModel6.addElement("4");
        defaultComboBoxModel6.addElement("5");
        defaultComboBoxModel6.addElement("6");
        defaultComboBoxModel6.addElement("7");
        defaultComboBoxModel6.addElement("8");
        defaultComboBoxModel6.addElement("9");
        defaultComboBoxModel6.addElement("10");
        comboBox6.setModel(defaultComboBoxModel6);
        contentPane.add(comboBox6, new GridConstraints(7, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox7 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel7 = new DefaultComboBoxModel();
        defaultComboBoxModel7.addElement("0");
        defaultComboBoxModel7.addElement("1");
        defaultComboBoxModel7.addElement("2");
        defaultComboBoxModel7.addElement("3");
        defaultComboBoxModel7.addElement("4");
        defaultComboBoxModel7.addElement("5");
        defaultComboBoxModel7.addElement("6");
        defaultComboBoxModel7.addElement("7");
        defaultComboBoxModel7.addElement("8");
        defaultComboBoxModel7.addElement("9");
        defaultComboBoxModel7.addElement("10");
        comboBox7.setModel(defaultComboBoxModel7);
        contentPane.add(comboBox7, new GridConstraints(8, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox8 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel8 = new DefaultComboBoxModel();
        defaultComboBoxModel8.addElement("0");
        defaultComboBoxModel8.addElement("1");
        defaultComboBoxModel8.addElement("2");
        defaultComboBoxModel8.addElement("3");
        defaultComboBoxModel8.addElement("4");
        defaultComboBoxModel8.addElement("5");
        defaultComboBoxModel8.addElement("6");
        defaultComboBoxModel8.addElement("7");
        defaultComboBoxModel8.addElement("8");
        defaultComboBoxModel8.addElement("9");
        defaultComboBoxModel8.addElement("10");
        comboBox8.setModel(defaultComboBoxModel8);
        contentPane.add(comboBox8, new GridConstraints(9, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox9 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel9 = new DefaultComboBoxModel();
        defaultComboBoxModel9.addElement("0");
        defaultComboBoxModel9.addElement("1");
        defaultComboBoxModel9.addElement("2");
        defaultComboBoxModel9.addElement("3");
        defaultComboBoxModel9.addElement("4");
        defaultComboBoxModel9.addElement("5");
        defaultComboBoxModel9.addElement("6");
        defaultComboBoxModel9.addElement("7");
        defaultComboBoxModel9.addElement("8");
        defaultComboBoxModel9.addElement("9");
        defaultComboBoxModel9.addElement("10");
        comboBox9.setModel(defaultComboBoxModel9);
        contentPane.add(comboBox9, new GridConstraints(10, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox10 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel10 = new DefaultComboBoxModel();
        defaultComboBoxModel10.addElement("0");
        defaultComboBoxModel10.addElement("1");
        defaultComboBoxModel10.addElement("2");
        defaultComboBoxModel10.addElement("3");
        defaultComboBoxModel10.addElement("4");
        defaultComboBoxModel10.addElement("5");
        defaultComboBoxModel10.addElement("6");
        defaultComboBoxModel10.addElement("7");
        defaultComboBoxModel10.addElement("8");
        defaultComboBoxModel10.addElement("9");
        defaultComboBoxModel10.addElement("10");
        comboBox10.setModel(defaultComboBoxModel10);
        contentPane.add(comboBox10, new GridConstraints(11, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }


}
