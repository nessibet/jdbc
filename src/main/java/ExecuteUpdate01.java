import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "nesibe123.");

        Statement st = con.createStatement();
//1. Örnek: number_of_employees değeri ortalama çalışan sayısından az
// olan number_of_employees değerlerini 16000 olarak UPDATE edin.
        String sql1 = "update companies set number_of_employees =16000\n" +
                "where number_of_employees < (select avg (number_of_employees) from companies)";

        int updateEdilenSatirSayisi = st.executeUpdate(sql1);
        System.out.println("updateEdilenSatirSayisi = " + updateEdilenSatirSayisi);

        ResultSet resultSet1 = st.executeQuery("select * from companies");
        while (resultSet1.next()) {

            System.out.println(resultSet1.getString(1) + "--" + resultSet1.getString(2) + "--" + resultSet1.getInt(3));
        }

        con.close();
        st.close();
        resultSet1.close();


    }
}
