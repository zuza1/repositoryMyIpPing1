package mic.zuza;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * Created by Michel on 03-Mar-2018.
 */
public class MyWriteToFile extends JFrame {

    public MyWriteToFile() {
        super("Save");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //setSize(500,500);

        setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        JFileChooser fc1 = new JFileChooser();
        int ccc = fc1.showSaveDialog(fc1);
//        int ccc = fc1.showDialog();
        setSize(fc1.getPreferredSize());
        setLocationRelativeTo(null);
        add(fc1);
        setVisible(true);

//        fc1.addChoosableFileFilter();


        if (ccc == JFileChooser.CANCEL_OPTION) {
            File filefc1 = fc1.getSelectedFile();

            System.out.println("Нажали Cancel");
            dispose();


//            System.out.println(filefc1.getName());

        }
        if (ccc == JFileChooser.APPROVE_OPTION) {
            System.out.println("Нажата Save");
            dispose();
        }
        if (ccc == JFileChooser.ERROR_OPTION) {
            FileDialog derr= new FileDialog(this,"ОШИБКА файла");

        }
    }

    public static void myWriteNoChooser() {

        JTable tm1;
        tm1 = MyIpPing.getTab01();
        File myfile1 = new File("\\ttttt\\my1111.jtab");
        ObjectInputStream oist1 = null;
        ObjectOutputStream oout1 = null;


        try {
//            oist1 =new ObjectInputStream(new FileInputStream(myfile1));
            oout1 = new ObjectOutputStream(new FileOutputStream(myfile1));
            oout1.writeObject(tm1);
            oout1.flush();
            oout1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        for(int i=0;i<=)


    }
}
