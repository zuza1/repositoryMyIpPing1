package mic.zuza;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.PortUnreachableException;
import java.rmi.UnknownHostException;
import java.util.Vector;

/**
 * Created by 1 on 02.02.18.
 */
public class LocalPing implements Runnable {
    String[] ipst, iipfin;
    String ipinet;
    public static Vector str1;
    public boolean flagthread1;


    public LocalPing() {
    }


    public void myAcesUdpInetAdres(String ipinet) {
        String access = " неопределено ";
        int i;


        try {
            InetAddress ia3;
            ia3 = InetAddress.getByName(ipinet);
            DatagramSocket socket1 = new DatagramSocket();
            socket1.connect(ia3, 0);
            int trafclas1 = socket1.getTrafficClass();
            boolean access1 = socket1.isConnected();
            System.out.println("флаг прерывания  " + Thread.currentThread().isInterrupted());

            for (i = 0; i < 5; i++) {
                boolean acces0 = ia3.isReachable(2000);
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Поток принудительно прерван");
                    // Надо обеспечить отсюда переход к концу потока, тогда поток завершится.!
                    break;

                }
                if (acces0 == true) {
                    access = "    доступно ";
                    break;
                } else {
                    access = " не доступно ";
                }
            }
            socket1.disconnect();
            access1 = socket1.isConnected();
            socket1.close();

            System.out.println(ia3.toString() + String.valueOf(access1) + "    " + trafclas1 + "   " + "  " + access + "  циклов= " + i);

            str1 = new Vector();
            str1.addElement(ipinet);
            str1.addElement(access);
            str1.addElement("попыток  " + i);

            MyIpPing.setConttable1(str1);

        } catch (PortUnreachableException e) {
            e.printStackTrace();
            System.out.print("   000  ");

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.print("   111  ");
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.print("   11222  ");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        {


            String[] iiipst = MyIpPing.getIipst();
            String[] iiipfin = MyIpPing.getIipfin();
            ;
            Integer iss1 = Integer.valueOf(iiipst[0]);
            Integer iss2 = Integer.valueOf(iiipst[1]);
            Integer iss3 = Integer.valueOf(iiipst[2]);
            Integer iss4 = Integer.valueOf(iiipst[3]);

            ;
            Integer iff4 = Integer.valueOf(iiipfin[3]);
            System.out.println("Сработал конструктор LocalPing ");
            System.out.print(Thread.activeCount() + Thread.currentThread().toString());


            System.out.println("tt" + iss1 + "." + iss2 + "." + iss3 + "." + iss4);
            String ipinet;

            if (iss4 <= iff4) {
                for (int i1 = iss4; i1 <= iff4; i1++) {
                    ipinet = "" + iss1 + "." + iss2 + "." + iss3 + "." + i1;

                    myAcesUdpInetAdres(ipinet);
                }
            } else {
                for (int i1 = iss4; i1 <= 255; i1++) {
                    ipinet = "" + iss1 + "." + iss2 + "." + iss3 + "." + i1;
                    System.out.println(ipinet);
                }
            }
            Thread ttt002 = Thread.currentThread();
            System.out.print(ttt002.toString());

            MyIpPing.setOkEnable(true);
        }
    }

}


