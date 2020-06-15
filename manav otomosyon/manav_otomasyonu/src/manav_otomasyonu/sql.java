/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manav_otomasyonu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class sql {
        private int port = 3306;
private String ad="root";
private String parola ="";
private String db_ismi="manav";
private String host ="localhost";
private Connection con =null;
private Statement statment =null;
public sql(){
    String url ="jdbc:mysql://"+host+":"+port+"/"+db_ismi;
    try{
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
        System.out.println("Driver yok");
    }
    try {
     con=(Connection) DriverManager.getConnection(url, ad, parola);
        System.out.println("Başarılı");
    } catch (SQLException ex) {
        System.out.println("Bağlantı başarısız");
    }
}
     public void ekle(String satis,String adi,String alis){
    try {
        statment=con.createStatement();
        // INSERT INTO `hasta`(`tc`, `adsoyad`, `sifre`, `cinsyet`, `yas`, `eposta`, `dogumyeri`) VALUES (12,22,33,44,55,66,123)
String sorgu;
sorgu="INSERT INTO satis (Adi,AlışFiyatı,SatışFiyatı) VALUES ";
String tamamla ="('"+adi+"','"+alis+"','"+satis+"')";
sorgu=sorgu+tamamla;
        System.out.println(tamamla);
        statment.executeUpdate(sorgu);
    } catch (SQLException ex) {
        Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}
       public void sil(String adi){
        try {
            statment = con.createStatement();
               String sorgu="Delete from satis WHERE Adi='"+adi+"'";
               int deger = statment.executeUpdate(sorgu);
        } catch (SQLException ex) {
            Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
       public void duzenle(String eskiadi,String yeniadi,String alis,String satis){
         String sql="UPDATE satis SET Adi = ? , "
                +"Alışfiyatı= ? ,"
                +"SatışFiyatı = ? "
                + "WHERE Adi ='"+eskiadi+"'";
        try {
            Statement ste =con.createStatement();
            PreparedStatement stat =con.prepareStatement(sql);
            stat.setString(1, yeniadi);
            stat.setString(2,alis);
               stat.setString(3,satis);
       stat.executeUpdate();
            
                
        } catch (SQLException ex) {
            Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
        }
}
       public String alis(String ad){
        String sifre="z";
        //SELECT sifre FROM `musteri` WHERE eposta='akifergunduz27@gmail.com'
    String sorgu ="Select AlışFiyatı FROM satis WHERE Adi='"+ad+"'";
    try {
        statment=con.createStatement();
       
        ResultSet rs = statment.executeQuery(sorgu);
      while(rs.next()){
          sifre = rs.getString("AlışFiyatı");
      }
         
    } catch (SQLException ex) {
        Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
    }
   return sifre;
    }
              public String satis(String ad){
        String sifre="z";
        //SELECT sifre FROM `musteri` WHERE eposta='akifergunduz27@gmail.com'
    String sorgu ="Select SatışFiyatı FROM satis WHERE Adi='"+ad+"'";
    try {
        statment=con.createStatement();
       
        ResultSet rs = statment.executeQuery(sorgu);
      while(rs.next()){
          sifre = rs.getString("SatışFiyatı");
      }
         
    } catch (SQLException ex) {
        Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
    }
   return sifre;
    }
          public String kar(String ad){
        String sifre="z";
        //SELECT sifre FROM `musteri` WHERE eposta='akifergunduz27@gmail.com'
    String sorgu ="Select SatışFiyatı FROM ToplamKar WHERE Adi='"+ad+"'";
    try {
        statment=con.createStatement();
       
        ResultSet rs = statment.executeQuery(sorgu);
      while(rs.next()){
          sifre = rs.getString("ToplamKar");
      }
         
    } catch (SQLException ex) {
        Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
    }
   return sifre;
    }   
          public void karguncelle(String yenikar,String eskiadi){
            try {
                statment=con.createStatement();
                String sorgu ="Update satis Set 'ToplamKar' = '"+yenikar+"' Where Adi = '"+eskiadi+"'";
                System.out.println(sorgu);
                statment.executeUpdate(sorgu);
            } catch (SQLException ex) {
                Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
            }
}
}
// UPDATE `satis` SET `Adi`=[value-1] WHERE 1
