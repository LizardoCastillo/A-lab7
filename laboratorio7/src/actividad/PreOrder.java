package actividad;

public class PreOrder {
    
    public static <E extends Comparable<E>> String recorrido(LinkedBST<E> bst) {
        if (bst.getRoot() != null) {
            return recorrido(bst.getRoot());
        }
        return "*";
    }
    
    private static <E> String recorrido(Node<E> actual) {
        String res = "";
        res += actual.data.toString() + ", ";
        if (actual.left != null) res += recorrido(actual.left);
        if (actual.right != null) res += recorrido(actual.right);
        return res;
    }
}