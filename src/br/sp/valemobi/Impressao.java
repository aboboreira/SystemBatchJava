package br.sp.valemobi;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Impressao {
	 public static void main (String[] args) {
	        try {
	            String url = "jdbc:mysql://localhost/db_custumer";
	            Connection conn = (Connection) DriverManager.getConnection(url,"root","root");
	            Statement stmt = (Statement) conn.createStatement();
	            ResultSet rs;

	            rs = stmt.executeQuery("SELECT AVG(vl_total) AS media  FROM tb_custumer_account WHERE vl_total > 560 and id_custumer BETWEEN 1500 and 2700;");
	           /* while ( rs.next() ) {
	                String media = rs.getString("media");
	                System.out.println("A média Final é :"+media);
	            }*/


	            rs = stmt.executeQuery("SELECT  id_custumer, cpf_cnpj, nm_custumer, is_active, vl_total FROM tb_custumer_account WHERE vl_total > 560 and id_custumer BETWEEN 1500 and 2700 ORDER BY vl_total desc;");

	            System.out.println("Clientes utilizados para o cálculo da média (ordenados do maior para o menor saldo):\n");

	            while ( rs.next() ) {
	            	String	id_custumer = rs.getString("id_custumer");
	            	String cpf_cnpj = rs.getString("cpf_cnpj");
	            	String nm_custumer = rs.getString("nm_custumer");
	            	String is_active = rs.getString("is_active");
	            	String vl_total = rs.getString("vl_total");

	            	System.out.println("Cliente: "+ id_custumer +"\t"+ cpf_cnpj +"\t"+ nm_custumer  +"\t"+ is_active +"\t"+ vl_total);

	            }



	            conn.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	        }
	    }

}



