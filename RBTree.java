import java.util.LinkedList;

import javax.management.RuntimeErrorException;

public class RBTree<T extends Comparable<T>> {
    private RBNode<T> root;

    public boolean isEmpty() {
        return root == null;
    }

    public void insertion(T value) {
        if (root == null) {
            root = new RBNode<>(value, NColor.BLACK);
            // ela se torna preta porque é a raiz
        } else {
            root = insertion(root, value);
        }

    }

    private RBNode<T> insertion(RBNode<T> raiz, T value) {
        if (raiz == null) {
            root = new RBNode<>(value, NColor.BLACK);
        } else if (value.compareTo(raiz.getInfo()) < 0) {
            raiz.setLeft(insertion(raiz.getLeft(), value));
        } else {
            raiz.setRight(insertion(raiz.getRight(), value));
        }
        return raiz;
    }


    public int passeioPorNivel() {
        return passeioPorNivel(this.root);
    }

    private int passeioPorNivel(RBNode<T> noVisitado) {
        if (noVisitado == null) {
            return -1;
        } else {
            /*
             * soma a altura máxima de cada nó (+1)
             * vai visitando cada nó em cada nível, indo para seus filhos da esquerda para a
             * direita e soma +1 a cada nível visitado
             * se um nó tiver 1 filho ele soma +1, se tiver 2, soma +2 em sua altura.
             */
            return 1 + Math.max(passeioPorNivel(noVisitado.getLeft()), passeioPorNivel(noVisitado.getRight()));

        }
    }
    public LinkedList<T> passeioEmOrdem() {
        LinkedList<T> newList = new LinkedList<>();
        passeioEmOrdem(root, newList); // chamada recursiva do método com "root"
        return newList;
    }

    private void passeioEmOrdem(RBNode<T> atual, LinkedList<T> newList) {
        if (atual != null) {
            passeioEmOrdem(atual.getLeft(), newList);
            newList.add(atual.getInfo()); // extraindo o valor de "Integer"
            passeioEmOrdem(atual.getRight(), newList);
        }
    }

    public void removeNode(T value){
        if (value == null) {
           throw new RuntimeErrorException(null, "Não pode ser removida(valor 'null')");
        } else {
            root = removeNode(root, value);
        }
    }
    private RBNode<T> removeNode(RBNode<T> raiz, T value) {
        // verifica se a raiz é nula 
        if (raiz == null) {
            return raiz;
        }
        return raiz;
    }
    

}