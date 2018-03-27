package mic.zuza;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Michel on 31-Jan-2018.
 */
public class DialogFrame extends JDialog {
    private static Thread ttt001;


    public DialogFrame(String textframe){
        super(new JFrame(),"Окно запроса",true);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);       //;setDefaultCloseOperation(EXIT_ON_CLOSE);

       setSize(300,160);

        JButton oky=new JButton("ДА");
        oky.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Нажата ДА");
                oky.setEnabled(false);
                MyIpPing.setTab01Revalidate();


                Runnable rrr01= new LocalPing();
                ttt001= new Thread(rrr01,"Поток отдельный из LocalPing ");

                ttt001.start();

                System.out.print(ttt001.getName()+ttt001.getState()+" 111111  ");
                dispose();


//                MyIpPing.getOk().setEnabled(true);

                  // ******************************
            }
        });
        JButton no = new JButton("НЕТ");
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Нажата НЕТ");
//                setVisible(false);
                dispose();

            }
        });
        Object[]n = {oky,no};
        JOptionPane txtyes= new JOptionPane(textframe,JOptionPane.PLAIN_MESSAGE,JOptionPane.YES_NO_OPTION,null,n);
/*        JLabel txtyes = new JLabel("Техт созданный на объекте JLable\n"+" для проверки расположения текста\n");
        txtyes.setHorizontalAlignment(SwingConstants.CENTER);
        txtyes.setVerticalAlignment(SwingConstants.BOTTOM);
   */     add(txtyes, BorderLayout.CENTER);
       /* JPanel dialdown = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        dialdown.add(oky);
        dialdown.add(no);
        add(dialdown,BorderLayout.SOUTH);
*/
        setLocationRelativeTo(null);                // при аргументе null появляется в центре экрана (рабочего стола)
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public static Thread getTtt001() {
        return ttt001;
    }
}
