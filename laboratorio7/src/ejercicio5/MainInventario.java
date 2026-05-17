package ejercicio5;

import java.util.List;

public class MainInventario {
    public static void main(String[] args) {
        LinkedBST<Producto> inventario = new LinkedBST<>();
        
        try {
            System.out.println("=== SISTEMA DE INVENTARIO - GESTION DE PRODUCTOS ===\n");
            
            System.out.println("a) INSERTANDO PRODUCTOS:");
            System.out.println("   Insertando: 15 (Laptop), 8 (Mouse), 22 (Teclado), 5 (Monitor), 12 (Audifonos), 18 (Webcam), 30 (Tablet)\n");
            
            inventario.insert(new Producto(15, "Laptop", 2500.00, 10));
            inventario.insert(new Producto(8, "Mouse", 45.50, 50));
            inventario.insert(new Producto(22, "Teclado", 120.00, 30));
            inventario.insert(new Producto(5, "Monitor", 850.00, 15));
            inventario.insert(new Producto(12, "Audifonos", 89.90, 40));
            inventario.insert(new Producto(18, "Webcam", 210.00, 20));
            inventario.insert(new Producto(30, "Tablet", 1500.00, 8));
            
            System.out.println("Inventario actual (InOrder):");
            System.out.println("   " + inventario.inOrder() + "\n");
            
            System.out.println("b) BUSQUEDA POR RANGO [10 - 25]:");
            List<Producto> rango = inventario.searchRange(new Producto(10, "", 0, 0), new Producto(25, "", 0, 0));
            if (rango.isEmpty()) {
                System.out.println("   No hay productos en ese rango");
            } else {
                for (Producto p : rango) {
                    System.out.println("   " + p);
                }
            }
            System.out.println();
            
            System.out.println("c) CONTAR NODOS HOJA:");
            System.out.println("   Cantidad de productos en nodos hoja: " + inventario.countLeaves() + "\n");
            
            System.out.println("d) PRODUCTOS EN ORDEN DESCENDENTE (mayor a menor codigo):");
            inventario.printDescending();
            System.out.println();
            
            System.out.println("=== INFORMACION ADICIONAL ===");
            System.out.println("   Total de productos: " + inventario.countLeaves());
            System.out.println("   Inventario vacio? " + inventario.isEmpty());
            
            System.out.println("\n   Buscando producto con codigo 12:");
            Producto encontrado = inventario.search(new Producto(12, "", 0, 0));
            System.out.println("   Encontrado: " + encontrado);
            
        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ItemNotFound e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}