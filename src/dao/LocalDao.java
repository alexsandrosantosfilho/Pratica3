package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Local;

public class LocalDao {

	private ArrayList<Local> locais;
	private Connection conn;

	public LocalDao() {
		this.locais = new ArrayList<>();

		try {
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost/jaoandmary", "root", "");
		} catch (SQLException e) {
			System.out.println("erro mysql " + e.getSQLState() + e.getMessage());
			e.printStackTrace();
		}

	}

	public void insert(Local local) {

		/*
		 * 
		 * 
		 * //Prepara a instru��o SQL PreparedStatement ps =
		 * conexao.prepareStatement(sql); //Executa a instru��o SQL
		 * ps.execute();
		 */

		System.out.println(local);
		// our SQL SELECT query.
		// if you only need a few columns, specify them by name instead of using
		// "*"
		// String sql = "INSERT INTO Cadastro (nome) VALUES ('TESTE10')";
		//
		// // create the java statement
		// PreparedStatement ps;
		// try {
		// ps = this.conn.prepareStatement(sql);
		// ps.execute();
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	public void remove(Local local) {
		String sql = "DELETE FROM `cadastro` WHERE `cadastro`.`id_cadastro` = 9";

		// create the java statement
		PreparedStatement ps;
		try {
			ps = this.conn.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Local local) {
		Statement stmt = null;

		// ResultSet rs = null;
		System.out.println(local);
		String sql = " UPDATE `cadastro` SET `nome` = 'alexxxxx' WHERE `cadastro`.`id_cadastro` = 1;";

		// create the java statement
		PreparedStatement ps;
		try {
			ps = this.conn.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Local consultById(Integer localId) {
		Local local = new Local();
		return local;
	}

	public List<Local> get() {
		String query = "SELECT id, cadastro from locais";
		// create the java statement
		Statement st;
		// execute the query, and get a java resultset
		try {
			st = (Statement) this.conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			Local local;
			while (rs.next()) {
				local = new Local();
				local.setCadastro(rs.getString("cadastro"));
				local.setId(rs.getInt("id"));

				this.locais.add(local);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return this.locais;
	}

	public Integer getById(Integer localId) {
		return localId;
	}

	public void closeConnection() {

		try {
			this.conn.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("erro mysql " + e.getMessage());
		}
	}

}