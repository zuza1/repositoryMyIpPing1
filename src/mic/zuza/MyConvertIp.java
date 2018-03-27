package mic.zuza;


import mic.zuza.DialogFrame;
import mic.zuza.MyIpPing;

/**
 * Created by Michel on 11-Feb-2018.
 */
public class MyConvertIp extends Thread {
    public static String ips;
    public static String ipf;

    public MyConvertIp()

    {

        super("Поток ");
    }

    public void run() {

//        System.out.println("Запуск второго потока");
        try {
            ips = MyIpPing.getSss1() + "." + MyIpPing.getSss2() + "." + MyIpPing.getSss3() + "." + MyIpPing.getSss4();
            ipf = MyIpPing.getF1() + "." + MyIpPing.getF2() + "." + MyIpPing.getF3() + "." + MyIpPing.getF4();

            Integer[] intip1 = convertCompaundIp(MyIpPing.getSss1(), MyIpPing.getSss2(), MyIpPing.getSss3(), MyIpPing.getSss4());
            if (validInData(intip1) == true) {
                Integer[] intip2 = convertCompaundIp(MyIpPing.getF1(), MyIpPing.getF2(), MyIpPing.getF3(), MyIpPing.getF4());
                if (validInData(intip2) == true) {
                    // Можно еще проверить чтобы диапазон был от меньшег ip к большему
                    String text = ("Вы подтверждаете проверку устройств \n" + " из данного диапазона IP адресов?\n" + "с   " + ips + "    по    " + ipf);
                    yield();


                    DialogFrame dialog1 = new DialogFrame(text);
                }
            } else {
                String text = "Не правильно введен IP адресс \n" + " Введите правильно и попробуйте еще раз.\n";
                yield();

                DialogFrame dialog2 = new DialogFrame(text);
            }
        } catch (NumberFormatException e) {
            e.getStackTrace();
        }
    }

    public Integer[] convertCompaundIp(String s1, String st2, String sss3, String st4) {

//        System.out.print(" "+s1+"."+st2+"."+sss3+"."+st4);
//        System.out.println("Начало метода convertCompaundIp"+s1+" "+st2+" "+sss3+" "+st4);
        int is1 = Integer.valueOf(s1);
        int sst2 = Integer.valueOf(st2);
        int sst3 = Integer.valueOf(sss3);
        int sst4 = Integer.valueOf(st4);
        Integer[] intip = {is1, sst2, sst3, sst4};
        return intip;

    }

    public static boolean validInData(Integer[] intip) {
        boolean correct1 = true;
        for (int i = 0; i <= intip.length - 1; i++) {
            if (correct1 == false) break;
            {

                if (intip[i] <= 255 & intip[i] >= 0 & intip[i] != null) {
                    System.out.print(" Введено правильно");
                    System.out.println(" i= " + i + " intip= " + intip[i]);
                    correct1 = true;
                } else {
                    correct1 = false;
                    System.out.print(" Не правильно введен IP ");
                }
            }
        }
        return correct1;
    }

    public static String getIps() {

        return ips;
    }

    public static String getIpf() {
        ipf = MyIpPing.getF1() + "." + MyIpPing.getF2() + "." + MyIpPing.getF3() + "." + MyIpPing.getF4();

        return ipf;
    }
}
