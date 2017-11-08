package entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ContatoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String telefone;
	private int idOperadora;
	
	public ContatoEntity(){
		
	}
	
	public ContatoEntity(Integer id, String nome, String telefone, int idOperadora, String data){
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.idOperadora = idOperadora;
	}
	
	@Override
	public String toString() {
	return "Contato [id=" + id + ", nome=" + nome + ", telefone=" + telefone +  ", operadora=" + idOperadora + "]";
	}
	
	public int getIdOperadora() {
		return idOperadora;
	}

	public void setIdOperadora(int idOperadora) {
		this.idOperadora = idOperadora;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
