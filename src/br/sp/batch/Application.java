package br.sp.batch;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class Application {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost/db_custumer";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    //private static final String DB_PASSWORD = "root";

    public static void main(String[] argv) {

        try {

            batchInsertRecordsIntoTable();

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    private static void batchInsertRecordsIntoTable() throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO tb_custumer_account"
                + "(id_custumer, cpf_cnpj, nm_custumer, is_active, vl_total) VALUES"
                + "(?,?,?,?,?)";

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            dbConnection.setAutoCommit(false);

            UUID uuid = UUID.randomUUID();
            String myRandom = uuid.toString();
            //System.out.println(myRandom.substring(0,20));


            //dados de teste
           /* preparedStatement.setInt(1, 101);
            preparedStatement.setString(2, "111.222.555.666-77");
            preparedStatement.setString(3, "Nome1");
            preparedStatement.setInt(4, 1);
            preparedStatement.setDouble(5, 1.000);
            preparedStatement.addBatch();

            preparedStatement.setInt(1, 102);
            preparedStatement.setString(2, "222.555.666-77");
            preparedStatement.setString(3, "Nome2");
            preparedStatement.setInt(4, 1);
            preparedStatement.setDouble(5, 1.000);
            preparedStatement.addBatch();

            preparedStatement.setInt(1, 103);
            preparedStatement.setString(2, "333.555.666-77");
            preparedStatement.setString(3, "Nome3");
            preparedStatement.setInt(4, 0);
            preparedStatement.setDouble(5, 1.000);
            preparedStatement.addBatch();

            preparedStatement.setInt(1, 104);
            preparedStatement.setString(2, "444.555.666-77");
            preparedStatement.setString(3, "Nome4");
            preparedStatement.setInt(4, 0);
            preparedStatement.setDouble(5, 1.000);
            preparedStatement.addBatch();

            preparedStatement.setInt(1, 105);
            preparedStatement.setString(2, "555.555.666-77");
            preparedStatement.setString(3, "Nome5");
            preparedStatement.setInt(4, 1);
            preparedStatement.setDouble(5, 6.000);
            preparedStatement.addBatch();
            */


            //laço para inserir dados automaticamente
            for(int i = 0; i<=50;i++){
            	preparedStatement.setInt(1, i);
                preparedStatement.setString(2, "222.555.666-77");
                preparedStatement.setString(3, myRandom);
                preparedStatement.setInt(4, 1);
                preparedStatement.setDouble(5, Math.random());
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();

            dbConnection.commit();

            System.out.println("Dados inseridos com sucesso!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            dbConnection.rollback();

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

    }

    private static Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(
                              DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }

}