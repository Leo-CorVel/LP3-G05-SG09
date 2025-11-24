package Ejercicio1;
//Ejercicio 1
public class Producto {

    private String nombre;
    private double precio;
    private int cantidadStock;
    private String categoria;

    public Producto(String nombre, double precio, int cantidadStock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.categoria = categoria;
    }
    public Producto() {
        this.nombre = "";
        this.precio = 0.0;
        this.cantidadStock = 0;
        this.categoria = "";
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getCantidadStock() { return cantidadStock; }
    public void setCantidadStock(int cantidadStock) { this.cantidadStock = cantidadStock; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    @Override
    public String toString() {
        return "<html>"
                + "<b>Producto Actualizado:</b><br>"
                + "Nombre: " + nombre + "<br>"
                + "Precio: S/ " + precio + "<br>"
                + "Stock: " + cantidadStock + "<br>"
                + "Categoría: " + categoria
                + "</html>";
    }
}
