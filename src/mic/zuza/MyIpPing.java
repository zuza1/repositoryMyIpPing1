package mic.zuza;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Created by 1 on 28.01.18.
 */
public class MyIpPing extends JFrame {
    public static String sss1,sss2,sss3,sss4,f1,f2,f3,f4;
//    private static String[] iipst, iipfin;
    public static Integer is1,is2,is3,is4,if1,if2,if3,if4;
   // private static JTextField instart1,instart2,instart3,instart4;
//    public static  Integer[] intip1,intip2,intip;
      public static JButton ok;
      public static Vector conttable1;
      public static Vector str1;
      private static JTable tab01;
//    private MyIpPing mainframe;
     public MyIpPing(){
        super("Main frame");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setSize(350,500);
//        setLocationRelativeTo(null);                //при аргументе null появляется в центре экрана (рабочего стола)
//        setLocation(getX()+300,getY()+300);
        JPanel mainn,a,b;
        JTextField instart1,instart2,instart3,instart4;
        JTextField infin1,infin2,infin3,infin4;
        JLabel pix1,pix2,pix3,pix4,pix5,pix6;


        JMenuBar menu1 = new JMenuBar();
        menu1.setBorderPainted(true);
        JMenu menum1 = new JMenu("File");
        JButton save1= new JButton("Save");
        save1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
//                MyWriteToFile.myWriteNoChooser();
                MyWriteToFile savef1=new MyWriteToFile();
            }
        });
        menum1.add(save1);
         JButton load1= new JButton("Load");

         menum1.add(load1);
        menu1.add(menum1);


        JLabel txtstart =new JLabel("Введите начальный IP");

         instart1 = new JTextField(2);
         instart2 = new JTextField(2);
         instart3 = new JTextField(2);
         instart4 = new JTextField(2);



         pix1 = new JLabel(".");
         pix2 = new JLabel(".");
         pix3 = new JLabel(".");


        JPanel a1up =new JPanel(new FlowLayout());
        a1up.add(txtstart);
        a1up.add(instart1); a1up.add(pix1); a1up.add(instart2);a1up.add(pix2);a1up.add(instart3);a1up.add(pix3);a1up.add(instart4);



        JLabel txtfin = new JLabel("Введите конечный IP");
        infin1 = new JTextField(2);
//        infin1.setText(instart1.getText());
        infin2 = new JTextField(2);
        infin3 = new JTextField(2);
        infin4 = new JTextField(2);


        pix4 = new JLabel(".");
        pix5 = new JLabel(".");
        pix6 = new JLabel(".");

        JPanel a2up =new JPanel(new FlowLayout());
        a2up.add(txtfin);
        a2up.add(infin1);a2up.add(pix4);a2up.add(infin2);a2up.add(pix5);a2up.add(infin3);a2up.add(pix6);a2up.add(infin4);

        JPanel a3up = new JPanel(new FlowLayout());
        a3up.add(menu1);
        //a3up.add(new JButton("b3"));

        JPanel aup =new JPanel(new GridLayout(3,1));
        aup.add(a3up);
        aup.add(a1up);
        aup.add(a2up);

        mainn =new JPanel(new BorderLayout(0,0));
        mainn.add(aup,BorderLayout.NORTH);

        JPanel adown = new JPanel();

        ok= new JButton("ОК");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Нажата ОК");

                sss1=instart1.getText();
                sss2=instart2.getText();
                sss3=instart3.getText();
                sss4=instart4.getText();

                f1=infin1.getText();
                f2=infin2.getText();
                f3=infin3.getText();
                f4=infin4.getText();




                MyConvertIp t1 = new MyConvertIp();
                t1.start();
                ok.setEnabled(false);


            }
        });
        JButton cancel= new JButton("Омена");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Нажата Отмена"+"  Х= "+ getX()+ "  Y="+getY());
                System.out.print("  "+ Thread.currentThread().isAlive());


                    Thread tt01 = DialogFrame.getTtt001();

                    tt01.interrupt();

                MyIpPing.setOkEnable(true);





//                Thread.currentThread().interrupt();
            }
        });
        JButton eexit= new JButton("Выход");
        eexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(EXIT_ON_CLOSE);                 //Не лучший способ, рубый, не учитывает возможные исключения.
               // dispose();

            }
        });
        adown.add(ok);
        adown.add(cancel);
        adown.add(eexit);
        mainn.add(adown,BorderLayout.SOUTH);

         JPanel centr1= new JPanel(new BorderLayout());
//        JTextPane txttabl =new JTextPane();
                                                                              //Основная таблица для результатов
         Vector head=new Vector();
         head.add(0,"IP адресс");
         head.add(1,"Доступность");
         head.add(2,"циклов");
         conttable1 = new Vector();



          //   DefaultTableModel dtm1 = new DefaultTableModel(conttable1, head);
         tab01 = new JTable(conttable1,head);


         JScrollPane scroll01=new JScrollPane(tab01);



//        centr1.add(txttabl, BorderLayout.CENTER);
        centr1.add(scroll01, BorderLayout.CENTER);
        mainn.add(centr1, BorderLayout.CENTER);


        setContentPane(mainn);
        setLocationRelativeTo(null);                     //при аргументе null появляется в центре экрана (рабочего стола)
        setVisible(true);

    }
    public static void setOkEnable(Boolean b1){
         ok.setEnabled(b1);

    }
    public static void setConttable1(Vector str01){
        str1=str01;

        conttable1.addElement(str1);
        tab01.revalidate();




    }

    public static JTable getTab01() {
        return tab01;
    }

    public static void setTab01Revalidate(){
        DefaultTableModel dtm1=(DefaultTableModel) tab01.getModel();
        dtm1.getDataVector().removeAllElements();
       // tab01.removeAll();
        tab01.revalidate();
    }

    public static String getSss1() {

         return sss1;

    }


    public static String getSss2() {
         return sss2;
    }

    public static String getSss3() {
        return sss3;
    }

    public static String getSss4() {
        return sss4;
    }

    public static String[] getIipst() {
        String [] iipst ={sss1,sss2,sss3,sss4};
        return iipst;
    }




    public static String[] getIipfin() {
        String[] iipfin = {f1,f2,f3,f4};
        return iipfin;
    }

    public static String getF1() {
        return f1;
    }

    public static String getF2() {
        return f2;
    }

    public static String getF3() {
        return f3;
    }

    public static String getF4() {
        return f4;
    }


    public static void main(String[] args){
      MyIpPing mainframe = new MyIpPing();
    }


}
