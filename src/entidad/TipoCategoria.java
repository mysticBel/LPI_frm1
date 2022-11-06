package entidad;

public class TipoCategoria {
	private int idtipo;
	private String descripcionTipo;
	public TipoCategoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TipoCategoria(int idtipo, String descripcionTipo) {
		super();
		this.idtipo = idtipo;
		this.descripcionTipo = descripcionTipo;
	}
	public int getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}
	public String getDescripcionTipo() {
		return descripcionTipo;
	}
	public void setDescripcionTipo(String descripcionTipo) {
		this.descripcionTipo = descripcionTipo;
	}
	
	
}
