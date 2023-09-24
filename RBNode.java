class RBNode<T extends Comparable <T>>{
    private RBNode<T> left;
    private T info;
    private NColor color;
    
    RBNode (T value, NColor color) {
        this.info = value;
        this.color = color;
    }
    public NColor getColor() {
        return color;
    }

    public void setColor(NColor color) {
        this.color = color;
    }
    
   
    private RBNode<T> right;
    
    
    void setLeft (RBNode<T> left) {
        this.left = left;
    }
    
    void setRight (RBNode<T> right) {
        this.right = right;
    }
    
    void setInfo (T value) {
        this.info = value;
    }
    
   
    
    RBNode<T> getLeft () {
        return this.left;
    }
    
    RBNode<T> getRight () {
        return this.right;
    }
    
    T getInfo () {
        return this.info;
    }
    
    
    
}
