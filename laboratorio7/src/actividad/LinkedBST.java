package actividad;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {
    
    private Node<E> root;
    
    public LinkedBST() {
        this.root = null;
    }
    
    @Override
    public boolean isEmpty() {
        return this.root == null;
    }
    
    public Node<E> getRoot() {
        return root;
    }
    
    @Override
    public void insert(E data) throws ItemDuplicated {
        this.root = insertRec(data, this.root);
    }
    
    protected Node<E> insertRec(E x, Node<E> actual) throws ItemDuplicated {
        Node<E> res = actual;
        if (actual == null) {
            res = new Node<>(x);
        } else {
            int resC = actual.data.compareTo(x);
            if (resC == 0) throw new ItemDuplicated(x + " esta duplicada");
            if (resC < 0) res.right = insertRec(x, actual.right);
            else res.left = insertRec(x, actual.left);
        }
        return res;
    }
    
    @Override
    public E search(E data) throws ItemNotFound {
        Node<E> res = searchRec(data, this.root);
        if (res == null) throw new ItemNotFound("El dato " + data + " no esta");
        return res.data;
    }
    
    protected Node<E> searchRec(E x, Node<E> n) {
        if (n == null) return null;
        int resC = n.data.compareTo(x);
        if (resC < 0) return searchRec(x, n.right);
        else if (resC > 0) return searchRec(x, n.left);
        else return n;
    }
    
    @Override
    public void delete(E data) throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("El arbol esta vacio");
        this.root = deleteRec(data, this.root);
    }
    
    protected Node<E> deleteRec(E x, Node<E> actual) throws ItemNotFound {
        Node<E> res = actual;
        if (actual == null) throw new ItemNotFound(x + " no esta");
        int cmp = actual.data.compareTo(x);
        if (cmp < 0) res.right = deleteRec(x, actual.right);
        else if (cmp > 0) res.left = deleteRec(x, actual.left);
        else {
            if (actual.left != null && actual.right != null) {
                Node<E> minNode = minRemove(actual.right);
                actual.data = minNode.data;
                actual.right = minRemove(actual.right);
            } else {
                res = (actual.left != null) ? actual.left : actual.right;
            }
        }
        return res;
    }
    
    protected Node<E> minRemove(Node<E> actual) {
        if (actual.left != null) {
            actual.left = minRemove(actual.left);
        } else {
            actual = actual.right;
        }
        return actual;
    }
}