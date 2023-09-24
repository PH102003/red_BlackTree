import java.util.LinkedList;

import javax.management.RuntimeErrorException;
import javax.management.relation.RoleNotFoundException;

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
            return new RBNode<>(value, NColor.BLACK);
        } else if (value.compareTo(raiz.getInfo()) < 0) {
            raiz.setLeft(insertion(raiz.getLeft(), value));
            raiz = new RBNode<>(value, NColor.RED);
        } else {
            raiz.setRight(insertion(raiz.getRight(), value));
            raiz = new RBNode<>(value, NColor.RED);
            if(raiz.getLeft().getColor() == raiz.getColor().RED){
                raiz = rotaco
            }
        }
        return raiz;
    }
    public void rotaçaoSimplesEsq() {
        if (root != null && root.getRight() != null) {
                root = rotacaoSimplesEsq(root);
            }
        
    }
    private RBNode<T> rotacaoSimplesEsq(RBNode<T> raiz){
        if(raiz != null && raiz.getRight()!= null){

            RBNode <T> raizAux = raiz.getRight();
            /*
            visto que só é possivel fazer uma rotação à esq através de uma inserção a dir,
            estou me baseando no nó inserido a direita (raiz.getRight)
             */
            raiz.setRight(raizAux.getLeft());
            raizAux.setLeft(raiz);
            return raizAux;
        }
        //lógica de transformar o filho a direita como 'raiz'
        
        return raiz;
        

    }

    public void rotaçaoDuplaEsq() {
        if(root != null && root.getLeft() != null){
            root = rotaçaoDuplaEsq(root);
        }
    }
    private RBNode<T> rotaçaoDuplaEsq(RBNode<T> raiz){
        if (raiz != null && raiz.getRight() != null) {

        raiz.setRight(rotacaoSimplesDirt(raiz.getRight()));
        /*utilização do método de rotação simples a direita seguido de rotação simples a esquerda,
        visto que uma rotação dupla é composta de duas rotações simples 
        */
        return rotacaoSimplesEsq(raiz);
        }
        return raiz;
    }

    public void rotaçaoSimplesDirt(){
        if(root != null && root.getLeft()!= null){
            root = rotacaoSimplesDirt(root);
        }
        
    }
    private RBNode<T> rotacaoSimplesDirt(RBNode<T> raiz){
        if(raiz != null && raiz.getLeft() != null){

            RBNode<T> raizAux = raiz.getLeft();
            /* 
            visto que só é possivel fazer uma rotação a direita através de uma inserção a esq,
            estou me baseando no nó inserido a esq (raiz.getLeft)
             */
            raiz.setLeft(raizAux.getRight());
            
            raizAux.setRight(raiz);
            //lógica para transformar um filho da esquerda como 'raiz'
            
            return raizAux;
        }
        return raiz;
    }

    public void rotaçaoDuplaDirt(){
        if(root != null && root.getLeft()!= null){
            root = rotaçaoDuplaDirt(root);
        }

    }
    private RBNode<T> rotaçaoDuplaDirt(RBNode<T> raiz){
        if(raiz != null && raiz.getLeft() != null){

            raiz.setLeft(rotacaoSimplesEsq(raiz.getLeft()));
            //lógica contrária à rotaçao dupla a esquerda
            return rotacaoSimplesDirt(raiz);
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