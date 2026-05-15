package actividad;

public class Main {
    public static void main(String[] args) {
        LinkedBST<Integer> bst = new LinkedBST<>();
        
        try {
            System.out.println("=== IMPLEMENTACION COMPLETA DE BST ===");
            System.out.println("\nInsertando valores: 15, 8, 22, 5, 12, 18, 30\n");
            
            bst.insert(15);
            bst.insert(8);
            bst.insert(22);
            bst.insert(5);
            bst.insert(12);
            bst.insert(18);
            bst.insert(30);
            
            System.out.println("7. RECORRIDO IN-ORDEN:");
            System.out.println("   " + InOrder.recorrido(bst) + "\n");
            
            System.out.println("8. RECORRIDO PRE-ORDEN:");
            System.out.println("   " + PreOrder.recorrido(bst) + "\n");
            
            System.out.println("9. RECORRIDO POST-ORDEN:");
            System.out.println("   " + PostOrder.recorrido(bst) + "\n");
            
            System.out.println("10. MINIMO Y MAXIMO DEL ARBOL:");
            System.out.println("    Mínimo: " + MinMax.findMin(bst));
            System.out.println("    Máximo: " + MinMax.findMax(bst));
            
        } catch (ItemDuplicated | ItemNotFound e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}