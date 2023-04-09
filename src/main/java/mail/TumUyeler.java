package mail;
//burada uye ozellilklerini tanımladık
public class TumUyeler {
    String isim;
    String soyisim;
    String mail;

    public TumUyeler(String isim, String soyisim, String mail) {
        this.isim=isim;
        this.soyisim=soyisim;
        this.mail=mail;
    }

    public String getIsim() {
        return isim;
    }
    public void setIsim(String isim) {
        this.isim = isim;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getSoyisim() {
        return soyisim;
    }
    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    @Override
    public String toString() {
        return "adı='" + isim + '\'' +
                ", soyadı='" + soyisim + '\'' +
                ", mail='" + mail + '\'';
    }
}
