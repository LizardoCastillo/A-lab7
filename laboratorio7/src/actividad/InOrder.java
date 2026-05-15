package actividad;

public class InOrder {
    
    public static <E extends Comparable<E>> String recorrido(LinkedBST<E> bst) {
        if (bst.getRoot() != null) {
            return recorrido(bst.getRoot());
        }
        return "*";
    }
    
    private static <E> String recorrido(Node<E> actual) {
        String res = "";
        if (actual.left != null) res += recorrido(actual.left);
        res += actual.data.toString() + ", ";
        if (actual.right != null) res += recorrido(actual.right);
        return res;
    }
}