package actividad;

public class MinMax {
    
    public static <E extends Comparable<E>> E findMin(LinkedBST<E> bst) throws ItemNotFound {
        if (bst.isEmpty()) throw new ItemNotFound("Arbol vacio");
        return findMinNode(bst.getRoot());
    }
    
    private static <E extends Comparable<E>> E findMinNode(Node<E> actual) {
        if (actual.left == null) return actual.data;
        return findMinNode(actual.left);
    }
    
    public static <E extends Comparable<E>> E findMax(LinkedBST<E> bst) throws ItemNotFound {
        if (bst.isEmpty()) throw new ItemNotFound("Arbol vacio");
        return findMaxNode(bst.getRoot());
    }
    
    private static <E extends Comparable<E>> E findMaxNode(Node<E> actual) {
        if (actual.right == null) return actual.data;
        return findMaxNode(actual.right);
    }
}