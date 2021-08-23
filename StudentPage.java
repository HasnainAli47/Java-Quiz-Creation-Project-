import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentPage extends JFrame implements ActionListener {

    //All fields
    int y = 50, x=800;
    int len;
    int count = 0;
    int c = 0;

    ArrayList<String> arrayList;
    ArrayList<String> arrayList1 = new ArrayList<>();

    JButton jButton,jButton1;

    JFrame jFrame;
    JPanel jPanel,Qpanel,kpanel;

    String sname;

    JTextField jTextField;


    StudentPage(String name,ArrayList<String> Qs){


        ImageIcon imageIcon = new ImageIcon("E:\\Shop Project\\src\\iconimg.jpg");
        //length of Array
        len = Qs.size();
        //Question Array
        arrayList = Qs;
        //Teacher name
        sname = name;

        //Main Frame
        jFrame = new JFrame( name + " have assigned you the test");
        jFrame.setSize(700,800);
        jFrame.setLocation(350,5);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setIconImage(imageIcon.getImage());
        jFrame.setTitle("Welcome Sir "+ name + " to Quiz app");

        //create new Jpanel (Qpanel) to set JScrollbar
        Qpanel = new JPanel();
        JScrollPane scroll = new JScrollPane(Qpanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.getVerticalScrollBar().setUnitIncrement(10);
        scroll.getHorizontalScrollBar().setUnitIncrement(10);
        //    Qpanel.setPreferredSize(new Dimension(300, x));
        jFrame.setContentPane(scroll);


        //Label
        JLabel jLabel = new JLabel("Sir " + name + " have assigned you the test");
        jLabel.setBounds(100,5,600,50);
        jLabel.setFont(new Font(null,Font.BOLD,27));
        Qpanel.add(jLabel);
        QA();
    }

    void QA(){
        count++;

        //Main panel
        jPanel = new JPanel();
        jPanel.setBounds(180,y,300,200);
        jPanel.setBackground(new Color(54, 125, 213));
        jPanel.setLayout(null);
        jPanel.setPreferredSize(new Dimension(300, 200));

        //Set preferred size for Qpanel
        Qpanel.setPreferredSize(new Dimension(300, x));

        // create new JPanel(kpanel) to set JPanel(jpanel) location
        kpanel = new JPanel();
        kpanel.setPreferredSize(new Dimension(400, 200));
        //  kpanel.setBorder(BorderFactory.createTitledBorder(""));

        //Question Display lable
        JLabel jLabel = new JLabel("Question "+ count + ": " + arrayList.get(c) + " ?");
        c += 3;
        jLabel.setLayout(null);
        jLabel.setBounds(0,0,300,30);

        //Answer lable
        JLabel jLabel1 = new JLabel("\n Write Your Answer: ");
        jLabel.setLayout(null);
        jLabel1.setBounds(0,30,300,30);

        //Student Answer textfield
        jTextField = new JTextField(27);
        jTextField.setLayout(new BorderLayout());
        jTextField.setBounds(10,55,280,30);

        // Create JButton
        jButton = new JButton("Next");
        jButton1 = new JButton("Submit");

        //Next Button
        jButton.setLayout(null);
        jButton.setBounds(120,110,80,30);

        //Submit Button
        jButton1.setLayout(null);
        jButton1.setBounds(210,110,80,30);
        jButton1.setEnabled(false);

        //Adding ActionListener to Buttons
        jButton.addActionListener(this);
        jButton1.addActionListener(this);

        //Adding to Frame and Panel
        Qpanel.add(kpanel);
        kpanel.add(jPanel);
        jPanel.add(jLabel);
        jPanel.add(jLabel1);
        jPanel.add(jTextField);
        jPanel.add(jButton);
        jPanel.add(jButton1);

        //Submit and Next Button
        int a = len-c;
        if (a >= 3){
            //   jPanel.add(jButton);
            jButton.setEnabled(true);
            jButton1.setEnabled(false);

        }else if (a < 3){
            //   jPanel.add(jButton1);
            jButton1.setEnabled(true);
            jButton.setEnabled(false);
        }

        jFrame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Action for next Butoon
        if (e.getSource() == jButton){
            String ans;
            ans = jTextField.getText();
            arrayList1.add(ans);
            jButton.setEnabled(false);
            jButton1.setEnabled(false);
            y += 210;
            x +=205;
            QA();
        }

        //Submit Buttoon Action
        else if (e.getSource() == jButton1){
            String ans;
            ans = jTextField.getText();
            arrayList1.add(ans);
            jFrame.dispose();
            new Result(arrayList,sname,arrayList1);
        }
    }
}