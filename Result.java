import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Result extends JFrame {


    //All Fields
    JFrame jFrame;
    ArrayList<String> arrayList;
    ArrayList<String> arrayList1;
    String name;
    int count = 1;
    int count1 = 0;
    int count2 = 0;
    int count3 = 2;
    int y = 60,x = 800;
    int finalmarks = 0;
    int total = 0;
    JPanel jPanel,Qpanel,kpanel;


    Result(ArrayList<String> Qs,String sname,ArrayList<String> Ans){


        ImageIcon imageIcon = new ImageIcon("E:\\Shop Project\\src\\iconimg.jpg");
        //Question Array
        arrayList = Qs;
        //Answer Array
        arrayList1 = Ans;
        //name of teacher
        name = sname;

        //Main Frame
        jFrame = new JFrame("Sir " + name + " have assigned you the test");
        jFrame.setSize(700,800);
        jFrame.setLocation(350,5);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setIconImage(imageIcon.getImage());
        jFrame.setTitle("Welcome Sir "+ name + " to Quiz app");

        //create new Jpanel (Qpanel) to set JScrollbar
        Qpanel = new JPanel();
        JScrollPane scroll = new JScrollPane(Qpanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.getVerticalScrollBar().setUnitIncrement(2);
        scroll.getHorizontalScrollBar().setUnitIncrement(2);
        //    Qpanel.setPreferredSize(new Dimension(300, x));
        jFrame.setContentPane(scroll);

        //Lable
        JLabel jLabel = new JLabel("Sir " + name + " have assigned you the test");
        jLabel.setBounds(100,5,600,50);
        jLabel.setFont(new Font(null,Font.BOLD,27));
        jFrame.add(jLabel);
        jFrame.setVisible(true);
        check();
    }
    void check() {
        while (true) {

            //Set preferred size for Qpanel
            Qpanel.setPreferredSize(new Dimension(300, x));

            // create new JPanel(kpanel) to set JPanel(jpanel) location
            kpanel = new JPanel();
            kpanel.setPreferredSize(new Dimension(400, 200));
            //  kpanel.setBorder(BorderFactory.createTitledBorder(""));

            //Panel
            jPanel = new JPanel();
            jPanel.setBounds(180,y,300,200);
            jPanel.setBackground(new Color(54, 125, 213));
            jPanel.setLayout(null);
            jPanel.setPreferredSize(new Dimension(300, 200));

            // Adding panels
            Qpanel.add(kpanel);
            kpanel.add(jPanel);

            //Question Lable
            JLabel jLabel = new JLabel("Question: " + arrayList.get(count2) + "?");
            jLabel.setLayout(null);
            jLabel.setBounds(0,0,300,30);
            jPanel.add(jLabel);

            //Student Answer Lable
            JLabel jLabel1 = new JLabel("Your Answer: " + arrayList1.get(count1));
            jLabel1.setLayout(null);
            jLabel1.setBounds(0,40,300,20);
            jPanel.add(jLabel1);

            //Getting correct Answer of teacher
            String correctans = arrayList.get(count);
            JLabel jLabel9 = new JLabel("Correct Answer: " + correctans);
            jLabel9.setLayout(null);
            jLabel9.setBounds(0,70,300,30);
            jPanel.add(jLabel9);


            //Checking answer and matching + marking
            if (correctans.compareToIgnoreCase(arrayList1.get(count1)) == 0) {
                JLabel jLabel2 = new JLabel("Your Answer is correct.");


                ImageIcon imageIcon = new ImageIcon("E:\\Shop Project\\src\\smile.jpg");
                Image scale = imageIcon.getImage();
                Image mi = scale.getScaledInstance(30,30,Image.SCALE_SMOOTH);
                ImageIcon imageIcon1 = new ImageIcon(mi);
                jLabel2.setIcon(imageIcon1);


                jLabel2.setLayout(null);
                jLabel2.setForeground(new Color(227, 72, 72));
                jLabel2.setBounds(5,120,300,20);
                jPanel.add(jLabel2);

                JLabel jLabel3 = new JLabel("Your got " + arrayList.get(count3) + " marks.");
                jLabel3.setLayout(null);
                jLabel3.setForeground(new Color(227, 72, 72));
                jLabel3.setBounds(5,140,180,20);
                jPanel.add(jLabel3);

                String marks = arrayList.get(count3);
                int ma = Integer.parseInt(marks);
                finalmarks += ma;
            } else {
                JLabel jLabel2 = new JLabel("Your Answer is incorrect.");

                ImageIcon imageIcon1 = new ImageIcon("E:\\Shop Project\\src\\wrong.png");
                Image scale = imageIcon1.getImage();
                Image mi1 = scale.getScaledInstance(30,30,Image.SCALE_SMOOTH);
                ImageIcon imageIcon2 = new ImageIcon(mi1);
                jLabel2.setIcon(imageIcon2);

                jLabel2.setLayout(null);
                jLabel2.setForeground(new Color(227, 72, 72));
                jLabel2.setBounds(5,120,300,20);
                jPanel.add(jLabel2);

                JLabel jLabel3 = new JLabel("Your got 0 marks " + " out of " + arrayList.get(count3) + ".");
                jLabel3.setLayout(null);
                jLabel3.setForeground(new Color(227, 72, 72));
                jLabel3.setBounds(5,140,300,20);
                jPanel.add(jLabel3);
            }
            count += 3;
            count1++;
            count2 += 3;
            count3 += 3;
            y += 190;
            x += 200;
            if ((arrayList.size()-count) < 2){

                int cou = 2;
                int l = arrayList.size();
                while(cou <= l){
                    int mark = Integer.parseInt(arrayList.get(cou)) ;
                    total += mark;
                    cou += 3;
                }

                //Result Panel
                JPanel jPanel1 = new JPanel();
                jPanel1.setBounds(180,y,300,50);
                jPanel1.setBackground(new Color(98, 222, 63));
                jPanel1.setLayout(null);
                jPanel1.setPreferredSize(new Dimension(300, 50));
                Qpanel.add(jPanel1);

                //Result label
                JLabel jLabel5 = new JLabel("Your got " + finalmarks + " marks out of " + total + ".");
                jLabel5.setLayout(null);
                jLabel5.setForeground(new Color(227, 72, 72));
                jLabel5.setBackground(new Color(176, 54, 186));
                jLabel5.setForeground(new Color(20, 34, 104));
                jLabel5.setFont(new Font(null,Font.BOLD,16));
                jLabel5.setBounds(5,15,300,20);
                jPanel1.add(jLabel5);
                break;
            }
        }
    }
}