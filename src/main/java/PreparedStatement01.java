import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "nesibe123.");
        Statement st = con.createStatement();
        /*
        PreparedStatement interface, birden çok kez çalıştırılabilen önceden derlenmiş bir SQL kodunu temsil eder.
        Paremetrelendirilmiş SQL sorguları(query) ile çalışır. Bur sorguyu 0 veya daha fazla parametre ile kullanabiliriz.
         */

        //1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin.
        //1. Adım: PreparedStatement query'sini oluştur.
        String sql1 = "UPDATE companies SET number_of_employees = ? WHERE company = ? ";

        //2. Adım: PreparedStatement objesini oluştur.
        PreparedStatement pst1 = con.prepareStatement(sql1);

        //3. Adım: setInt(), setString(), ... methodlarını kullanarak soru işaretleri yerlerine değer gir.
        pst1.setInt(1, 9999);
        pst1.setString(2, "IBM");

        //4. Adım: Query'yi çalıştır.

        int guncellenenSatirSayisi = pst1.executeUpdate();
        System.out.println("guncellenenSatirSayisi = " + guncellenenSatirSayisi);

        String sql2= "Select * From companies";
        ResultSet resultSet1= st.executeQuery(sql2);

        while (resultSet1.next()){
            System.out.println(resultSet1.getInt(1)+"--"+resultSet1.getString(2)+"--"+resultSet1.getInt(3));

        }

        //2. Örnek: Prepared statement kullanarak company adı GOOGLE olan number_of_employees değerini 5555 olarak güncelleyin.

        pst1.setInt(1, 5555);
        pst1.setString(2, "GOOGLE");

        int guncellenenSatirSayisi2 = pst1.executeUpdate();
        System.out.println("guncellenenSatirSayisi2 = " + guncellenenSatirSayisi2);

        ResultSet resultSet2= st.executeQuery(sql2);

        while (resultSet2.next()){
            System.out.println(resultSet2.getInt(1)+"--"+resultSet2.getString(2)+"--"+resultSet2.getInt(3));

        }
        con.close();
        st.close();
        resultSet1.close();
        resultSet2.close();
        pst1.close();


    }
}