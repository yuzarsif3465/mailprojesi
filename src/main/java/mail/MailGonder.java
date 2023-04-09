package mail;

import java.io.*;
import java.nio.charset.Charset;

public class MailGonder {
    static BufferedWriter fileWriter;
    File mailFile;

    public void mailgondertoelite(String message){
    BufferedReader reader;

    try {
        reader = new BufferedReader(new FileReader("C:/Users/user/OneDrive/Masaüstü/ElitUye.txt", Charset.forName("UTF8")));
        String line = reader.readLine();
        dosyaOlustur("Mail.txt","Elit ");

        while (line != null) {
            System.out.println(line);
            //line = reader.readLine();//Satır satır okuyor ve alttaki kod ile konsola yazdırıyor
            int mailIndex = line.indexOf("mail='");
            String mail=line.substring(mailIndex+6);
            int lastcharacter = mail.indexOf("'");
            String sonmail=mail.substring(0,lastcharacter);
            System.out.println(sonmail);
            System.out.println(line);
            elitMailGonder(sonmail,message);
            dosyaKapama();
            line = reader.readLine();

        }

        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public void mailgondertogenel(String message){
        BufferedReader reader;
        dosyaOlustur("Mail.txt","Genel ");

        try {
            reader = new BufferedReader(new FileReader("C:/Users/user/OneDrive/Masaüstü/GenelUye.txt", Charset.forName("UTF8")));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                int mailIndex = line.indexOf("mail='");
                String mail=line.substring(mailIndex+6);
                int lastcharacter = mail.indexOf("'");
                String sonmail=mail.substring(0,lastcharacter);
                System.out.println(sonmail);
                System.out.println(line);
                genelMailGonder(sonmail,message);
                dosyaKapama();
                line = reader.readLine();

            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mailgondertoAll(String message){
        BufferedReader reader;
        BufferedReader reader2;
        dosyaOlustur("Mail.txt","Tüm ");

        try {
            reader = new BufferedReader(new FileReader("C:/Users/user/OneDrive/Masaüstü/GenelUye.txt", Charset.forName("UTF8")));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                //line = reader.readLine();//Satır satır okuyor ve alttaki kod ile konsola yazdırıyor
                int mailIndex = line.indexOf("mail='");
                String mail=line.substring(mailIndex+6);
                int lastcharacter = mail.indexOf("'");
                String sonmail=mail.substring(0,lastcharacter);
                System.out.println(sonmail);
                System.out.println(line);
                topluMailGonder(sonmail,message);
                dosyaKapama();
                line = reader.readLine();

            }

            reader.close();

            reader2 = new BufferedReader(new FileReader("C:/Users/user/OneDrive/Masaüstü/ElitUye.txt", Charset.forName("UTF8")));
            String line2 = reader2.readLine();

            while (line2 != null) {
                System.out.println(line2);
                //line = reader.readLine();//Satır satır okuyor ve alttaki kod ile konsola yazdırıyor
                int mailIndex = line2.indexOf("mail='");
                String mail=line2.substring(mailIndex+6);
                int lastcharacter = mail.indexOf("'");
                String sonmail=mail.substring(0,lastcharacter);
                System.out.println(sonmail);
                System.out.println(line2);
                topluMailGonder(sonmail,message);
                dosyaKapama();
                line2 = reader2.readLine();

            }

            reader2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean dosyaOlustur(String dosyaAdı,String uyetipi){

        String dosyaYolu= "C:/Users/user/OneDrive/Masaüstü/";
        try {


            FileWriter fileWriter2= new FileWriter(dosyaYolu+dosyaAdı+".txt",true);
            fileWriter = new BufferedWriter(fileWriter2);
            fileWriter.write(uyetipi+"Hesaplara Gönderilen Mailler\n");

            return true;

        } catch (FileNotFoundException e) {
            System.err.println("FileOutputStream da bir hata oluştu.");
            System.err.println("Hata: "+ e);
        }
        catch (IOException e) {
            System.err.println("ObjectOutputStream da bir hata oluştu. ");
            System.err.println("Hata: "+e);
        }

        return false;
    }

    public void dosyaKapama() {
        if (fileWriter != null) {
        } else {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.err.println("dosyayı kapatırken hata oluştu");
                System.err.println("hata:" + e);
            }
        }
    }

    public static void elitMailGonder(String mail,String message){
        try {

            fileWriter.write("to : "+mail+" message : "+message+"\n");
            // fileWriter.write("\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.err.println("uye kaydedilirken bir hata oluştu.");
            System.err.println("Hata: "+ e);
        }
    }

    public static void genelMailGonder(String mail,String message){
        try {
            fileWriter.write("to : "+mail+" message : "+message+"\n");
            // fileWriter.write("\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.err.println("ogrenci kaydedilirken bir hata oluştu.");
            System.err.println("Hata: "+ e);
        }
    }

    public static void topluMailGonder(String mail,String message){
        try {
            fileWriter.write("to : "+mail+" message : "+message+"\n");
            // fileWriter.write("\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.err.println("ogrenci kaydedilirken bir hata oluştu.");
            System.err.println("Hata: "+ e);
        }
    }
}
