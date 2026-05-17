package ejercicio5;

public class Producto implements Comparable<Producto> {
    private int codigo;
    private String nombre;
    private double precio;
    private int cantidad;
    
    public Producto(int codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    @Override
    public int compareTo(Producto otro) {
        return Integer.compare(this.codigo, otro.codigo);
    }
    
    @Override
    public String toString() {
        return "[" + codigo + "] " + nombre + " - S/" + precio + " - Stock: " + cantidad;
    }
}