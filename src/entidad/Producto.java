package entidad;

public class Producto {
	//Atributos privados
		private String idProducto;
		private String descripcion;
		private int stock;
		private double precio;
		private int idCategoria;
		private int estado;
		public Producto() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Producto(String idProducto, String descripcion, int stock, double precio, int idCategoria, int estado) {
			super();
			this.idProducto = idProducto;
			this.descripcion = descripcion;
			this.stock = stock;
			this.precio = precio;
			this.idCategoria = idCategoria;
			this.estado = estado;
		}
		public String getIdProducto() {
			return idProducto;
		}
		public void setIdProducto(String idProducto) {
			this.idProducto = idProducto;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
		public double getPrecio() {
			return precio;
		}
		public void setPrecio(double precio) {
			this.precio = precio;
		}
		public int getIdCategoria() {
			return idCategoria;
		}
		public void setIdCategoria(int idCategoria) {
			this.idCategoria = idCategoria;
		}
		public int getEstado() {
			return estado;
		}
		public void setEstado(int estado) {
			this.estado = estado;
		}

		
		
}
