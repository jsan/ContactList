package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Path;

import entity.ContatoEntity;

// import com.mysql.jdbc.PreparedStatement;

@Path("/principal")
public class ContatoDao {
	
	Connection conexao;
	PreparedStatement stmt;
	Statement st;
	
	public List<ContatoEntity> getLista() throws Exception {

		
		List<ContatoEntity> lista = new ArrayList<ContatoEntity>() ;
		try {

			abrirDb();

			stmt = conexao.prepareStatement("SELECT * FROM contatos");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				ContatoEntity cd = new ContatoEntity();
				cd.setId(rs.getInt("id"));
				cd.setNome(rs.getString("nome"));
				cd.setTelefone(rs.getString("telefone"));
				 
				cd.setIdOperadora(rs.getInt("idOperadora"));
				lista.add(cd);
			} 

		} catch (SQLException e) {
			e.printStackTrace();
		}

		fecharDb();
		
		return lista;
	}

	public boolean adicionarContato(String nome, String telefone, int operadora) throws Exception{
		try {

			abrirDb();

			st = (Statement) conexao.createStatement(); 
			st.executeUpdate("INSERT INTO contatos VALUES (null,'"+nome +"',"+telefone+","+operadora+")");

			fecharDb();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public boolean alterarContato(int id, String nome, String telefone, int operadora) throws Exception{
		try {

			abrirDb();

			st = (Statement) conexao.createStatement(); 
			st.executeUpdate("UPDATE contatos SET nome='"+nome +"',telefone='"+telefone+"',idOperadora="+operadora+" WHERE id="+id);
			fecharDb();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public boolean apagarContato(Integer id) throws Exception{
		try {

			abrirDb();

			st = (Statement) conexao.createStatement(); 
			String sql = "DELETE FROM contatos WHERE id = "+ id;
			st.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		fecharDb();
		
		return true;
	}

	
	public void abrirDb () throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/listatelefonica", "root", "admin");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	
	public void fecharDb () throws Exception {
		conexao.close();
	}

}
