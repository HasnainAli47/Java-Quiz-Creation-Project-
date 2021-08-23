import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class QuestionPage extends JFrame implements ActionListener {
    JButton jButton;
    JButton jButton1;
    JPanel jPanel,kpanel,Qpanel;
    JFrame jFrame =  new JFrame();
    int y = 50,x=700;
    String name;
    JTextField jTextField;
    JTextField jTextField1;
    JTextField jTextField2;
    ArrayList<String> arrayList = new ArrayList();
    QuestionPage(String name){
        this.name = name;
        ImageIcon imageIcon = new ImageIcon("E:\\Shop Project\\src\\iconimg.jpg");

        //Frame Setting + icon
        jFrame.setSize(700,750);
        jFrame.setLocation(350,5);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setIconImage(imageIcon.getImage());
        jFrame.setTitle( name + " have assigned you Quiz");

        //create new Jpanel (Qpanel) to set JScrollbar
        Qpanel = new JPanel();
        JScrollPane scroll = new JScrollPane(Qpanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.getVerticalScrollBar().setUnitIncrement(10);
        scroll.getHorizontalScrollBar().setUnitIncrement(10);
        //    Qpanel.setPreferredSize(new Dimension(300, x));
        jFrame.setContentPane(scroll);


        //Lable
        JLabel jLabel = new JLabel("   Welcome Sir "+ name + " to Quiz app   ");
        jLabel.setBounds(100,5,600,50);
        jLabel.setFont(new Font(null,Font.BOLD,27));
        Qpanel.add(jLabel);
        Panel();
    }

    void Panel(){

        jPanel = new JPanel();
        jTextField = new JTextField(27);
        JLabel jLabel = new JLabel("Enter Your Question: ");
        JLabel jLabel1 = new JLabel("Enter the Correct Answer: ");
        jTextField1 = new JTextField(27);
        JLabel jLabel2 = new JLabel("Enter Question Marks: ");
        jTextField2 = new JTextField(22);

        // create new JPanel(kpanel) to set JPanel(jpanel) location
        kpanel = new JPanel();
        kpanel.setPreferredSize(new Dimension(400, 200));
//          kpanel.setBorder(BorderFactory.createTitledBorder(""));

        jPanel.setBounds(180,y,300,200);
        jPanel.setBackground(new Color(54, 125, 213));
        jPanel.setPreferredSize(new Dimension(300, 200));

        //set preferred size for Qpanel
        Qpanel.setPreferredSize(new Dimension(300, x));

        //Submit Button
        jButton = new JButton("Student Turn");
        jButton1 = new JButton("Add Question");


        jButton1.addActionListener(this);
        jButton.addActionListener(this);
        Qpanel.add(kpanel);
        kpanel.add(jPanel);
        jPanel.add(jLabel);
        jPanel.add(jTextField);
        jPanel.add(jLabel1);
        jPanel.add(jTextField1);
        jPanel.add(jLabel2);
        jPanel.add(jTextField2);
        jPanel.add(jButton);
        jPanel.add(jButton1);

        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton1) {
            if (jTextField.getText().isEmpty() == true){
                JOptionPane.showMessageDialog(null, "Fill Question Field", "Fill Error", JOptionPane.WARNING_MESSAGE);
            }else if (jTextField1.getText().isEmpty() == true){
                JOptionPane.showMessageDialog(null, "Fill answer Field", "Fill Error", JOptionPane.WARNING_MESSAGE);
            }else if (jTextField2.getText().isEmpty() == true){
                JOptionPane.showMessageDialog(null, "Fill marks Field", "Fill Error", JOptionPane.WARNING_MESSAGE);
            }
            else {
                if (jTextField2.getText().matches("[0-9]+")) {
                    String Q = jTextField.getText();
                    String RA = jTextField1.getText();
                    String m = jTextField2.getText();
                    arrayList.add(Q);
                    arrayList.add(RA);
                    arrayList.add(m);
                    jButton.hide();
                    jButton1.hide();
                    y += 210;
                    x += 205;
                    Panel();
                }else
                    JOptionPane.showMessageDialog(null,"Enter a number in Marks","Wrong marks Filled",JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == jButton) {
            if (jTextField.getText().isEmpty() == true){
                JOptionPane.showMessageDialog(null, "Fill Question Field", "Fill Error", JOptionPane.WARNING_MESSAGE);
            }else if (jTextField1.getText().isEmpty() == true){
                JOptionPane.showMessageDialog(null, "Fill answer Field", "Fill Error", JOptionPane.WARNING_MESSAGE);
            }else if (jTextField2.getText().isEmpty() == true){
                JOptionPane.showMessageDialog(null, "Fill marks Field", "Fill Error", JOptionPane.WARNING_MESSAGE);
            }
            else {
                if (jTextField2.getText().matches("[0-9]+")) {
                    String Q = jTextField.getText();
                    String RA = jTextField1.getText();
                    String m = jTextField2.getText();
                    arrayList.add(Q);
                    arrayList.add(RA);
                    arrayList.add(m);
                    jFrame.dispose();
                    new StudentPage(name, arrayList);
                }else
                    JOptionPane.showMessageDialog(null,"Enter a number in Marks","Wrong marks Filled",JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
