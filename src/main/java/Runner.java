import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Runner {

    public static void main(String[] args) {
        //1. Adım: Driver'a kaydol
        //2. Adım: Datbase'e bağlan
        JdbcUtils.connectToDataBase("localhost", "techproed", "postgres", "nesibe123.");

        //3. adim Statement olustur
        Statement statement = JdbcUtils.createStatement();

        //4.adim  Query calistir

       // JdbcUtils.execute("Create table students (name Varchar (20), id Int, address Varchar(80))");

        JdbcUtils.createTable("Def","Clases Varchar(20)","Teacher_Name Varchar (20)", "id int");

        //5. adim baglanti ve Statementi kapat

        JdbcUtils.closeConnectionAndStatement();

    }
}