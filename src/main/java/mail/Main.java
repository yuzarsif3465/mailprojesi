package mail;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        MailGonder mailGonder=new MailGonder();
//ilk menu kısmı burada
        Scanner sc =new Scanner(System.in);
        TumUyeler uyeler;
        System.out.println("1- Elit uye ekleme");
        System.out.println("2- genel uye ekleme");
        System.out.println("3- mail gonderme");
        System.out.println("yapmak istediginiz işlem nedir:");
        int x= Integer.parseInt(sc.nextLine());

        switch (x){
            case 1:
                System.out.println("uye ismi: ");
                String a=sc.nextLine();
                System.out.println("uye soyismi: ");
                String b=sc.nextLine();
                System.out.println("uye maili: ");
                String c=sc.nextLine();
                uyeler= new ElitUye(a,b,c);
                //burada dosya oluşturup kayıt yapıyor
                dosyaOlustur("ElitUye");
                uyeKaydet(uyeler);
                dosyaKapama();
                break;
            case 2:
                System.out.println("uye ismi: ");
                String d=sc.nextLine();
                System.out.println("uye soyismi: ");
                String f=sc.nextLine();
                System.out.println("uye maili: ");
                String g=sc.nextLine();
                uyeler= new GenelUye(d,f,g);
                dosyaOlustur("GenelUye");
                uyeKaydet(uyeler);
                dosyaKapama();

                break;
            case 3://2. menu kısmı
                System.out.println("1- Elit uyelere mail gpnderme");
                System.out.println("2- genel uyelere mail gonderme");
                System.out.println("3- tum uyelere mail gonderme");
                System.out.println("yapmak istediginiz işlem nedir:");
                int y=Integer.parseInt(sc.nextLine());
                switch (y){
                    case 1:// gonderilecek mesaj isteniyor
                        System.out.println(" gonderilecek mesaj ");
                        String j=sc.nextLine();
                        mailGonder.mailgondertoelite(j);

                        break;
                    case 2:
                        System.out.println(" gonderilecek mesaj ");
                        String k=sc.nextLine();
                        mailGonder.mailgondertogenel(k);

                        break;
                    case 3:
                        System.out.println(" gonderilecek mesaj ");
                        String l=sc.nextLine();
                        mailGonder.mailgondertoAll(l);


                        break;
                }
                break;
        }
    }



    static BufferedWriter fileWriter;
    public static boolean dosyaOlustur(String dosyaAdı){
        String dosyaYolu= "C:/Users/user/OneDrive/Masaüstü/";
        try {


            FileWriter fileWriter2= new FileWriter(dosyaYolu+dosyaAdı+".txt",true);
             fileWriter = new BufferedWriter(fileWriter2);

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
    public static void uyeKaydet(TumUyeler uye){
        // bu kısımda artık tek tek ogrenci bilgilerini alıp yazdırmak yok sadece output alıcaksın
        //bu  bilgileri de ObjectOutput dan alıcaksın objecte ulaşabilmesi için dışarıda objecti tanımlamalısın
        try {

            fileWriter.write(uye.toString());
            fileWriter.flush();

            fileWriter.newLine();
            fileWriter.flush();

        } catch (IOException e) {
            System.err.println("ogrenci kaydedilirken bir hata oluştu.");
            System.err.println("Hata: "+ e);
        }

    }

    public static void dosyaKapama() {
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
}


