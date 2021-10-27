package TAD_ArvBin;

import java.util.Iterator;
import java.util.List;

import TAD_ArvGen.LinkedTree;
import TAD_Pilha.NodeStack;
import exceptions.BoundaryViolationException;
import exceptions.EmptyTreeException;
import exceptions.InvalidPositionException;
import exceptions.NonEmptyTreeException;
import position.Position;
import position.NodePositionList;
import position.PositionList;

public class LinkedBinaryTree<E> implements BinaryTree<E> {
    protected BTPosition<E> root;
    protected int size;

    public LinkedBinaryTree() {
        root = null;
        size = 0;
    }

    public int size() { return size; }

    public boolean isInternal(Position<E> v) throws InvalidPositionException {
        checkPosition(v);
        return (hasLeft(v) || hasRight(v));
    }

    public boolean isRoot(Position<E> v) throws EmptyTreeException, InvalidPositionException {
        checkPosition(v);
        return (v == root());
    }


    public boolean hasLeft(Position<E> v) throws InvalidPositionException {
        BTPosition<E> vv = checkPosition(v);
        return (vv.getLeft() != null);
    }

    public Position<E> root() throws EmptyTreeException {
        if (root == null) throw new EmptyTreeException("The tree is empty");
        return root;
    }

    public Position<E> left(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
        BTPosition<E> vv = checkPosition(v);
        Position<E> leftPos = (Position<E>) vv.getLeft();
        if (leftPos == null) throw new BoundaryViolationException("No left child");
        return leftPos;
    }

    public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
        BTPosition<E> vv = checkPosition(v);
        Position<E> parentPos = (Position<E>) vv.getParent();
        if (parentPos == null) throw new BoundaryViolationException("No parent");
        return parentPos;
    }

    public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException {
        PositionList<Position<E>> children = new NodePositionList<Position<E>>();
        if (hasLeft(v)) children.addLast(left(v));
        if (hasRight(v)) children.addLast(right(v));
        return children;
    }


    public Iterable<Position<E>> positionsInorder() {
        PositionList<Position<E>> positions = new NodePositionList<Position<E>>();
        if (size != 0) inorderPositions(root(), positions);
        return positions;
    }

    public void inorderPositions(Position<E> v, PositionList<Position<E>> pos) throws InvalidPositionException {
        if (hasLeft(v)) inorderPositions(left(v), pos);
        pos.addLast(v);
        if (hasRight(v)) inorderPositions(right(v), pos);
    }

    public Iterable<Position<E>> positions() {
        PositionList<Position<E>> positions = new NodePositionList<Position<E>>();
        if (size != 0) preorderPositions(root(), positions);
        return positions;
    }

    public Iterator<E> iterator() {
        Iterable<Position<E>> positions = positions();
        PositionList<E> elements = new NodePositionList<E>();
        for (Position<E> pos : positions) elements.addLast(pos.element());
        return elements.iterator();
    }

    public E replace(Position<E> v, E o) throws InvalidPositionException {
        BTPosition<E> vv = checkPosition(v);
        E temp = v.element();
        vv.setElement(o);
        return temp;
    }



    public Position<E> sibling(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
        BTPosition<E> vv = checkPosition(v);
        BTPosition<E> parentPos = vv.getParent();
        if (parentPos != null) {
            BTPosition<E> sibPos;
            BTPosition<E> leftPos = parentPos.getLeft();
            if (leftPos == vv) sibPos = parentPos.getRight();
            else sibPos = parentPos.getLeft();
            if (sibPos != null) return sibPos;
        }
        throw new BoundaryViolationException("No sibling");
    }


    public Position<E> addRoot(E e) throws NonEmptyTreeException {
        if (!isEmpty()) throw new NonEmptyTreeException("Tree already has a root");
        size = 1;
        root = createNode(e, null, null, null);
        return root;
    }

    public Position<E> insertLeft(Position<E> v, E e) throws InvalidPositionException {
        BTPosition<E> vv = checkPosition(v);
        Position<E> leftPos = (Position<E>) vv.getLeft();
        if (leftPos != null) throw new InvalidPositionException("Node already has a left child");
        BTPosition<E> ww = createNode(e, vv, null, null);
        vv.setLeft(ww);
        size++;
        return ww;
    }


    public Position<E> insertRight(Position<E> v, E e) throws InvalidPositionException {
        BTPosition<E> vv = checkPosition(v);
        Position<E> rightPos = (Position<E>) vv.getRight();
        if (rightPos != null) throw new InvalidPositionException("Node already has a right child");
        BTPosition<E> ww = createNode(e, vv, null, null);
        vv.setRight(ww);
        size++;
        return ww;
    }


    public E remove(Position<E> v) throws InvalidPositionException {
        BTPosition<E> vv = checkPosition(v);
        BTPosition<E> leftPos = vv.getLeft();
        BTPosition<E> rightPos = vv.getRight();
        if (leftPos != null && rightPos != null) throw new InvalidPositionException("Cannot remove node with two children");
        BTPosition<E> ww;
        if (leftPos != null) ww = leftPos;
        else if (rightPos != null) ww = rightPos;
        else // v é folha
            ww = null;
        if (vv == root) { // v é a raiz
            if (ww != null) ww.setParent(null);
            root = ww;
        } else { // v não é a raiz
            BTPosition<E> uu = vv.getParent();
            if (vv == uu.getLeft()) uu.setLeft(ww);
            else uu.setRight(ww);
            if (ww != null) ww.setParent(uu);
        }
        size--;
        return v.element();
    }


    public void attach(Position<E> v, BinaryTree<E> T1, BinaryTree<E> T2) throws InvalidPositionException {
        BTPosition<E> vv = checkPosition(v);
        if (isInternal(v)) throw new InvalidPositionException("Cannot attach from internal node");
        if (!T1.isEmpty()) {
            BTPosition<E> r1 = checkPosition(T1.root());
            vv.setLeft(r1);
            r1.setParent(vv);
        }
        if (!T2.isEmpty()) {
            BTPosition<E> r2 = checkPosition(T2.root());
            vv.setRight(r2);
            r2.setParent(vv);
        }
    }

    protected BTPosition<E> checkPosition(Position<E> v) throws InvalidPositionException {
        if (v == null || !(v instanceof BTPosition)) throw new InvalidPositionException("The position is invalid");
        return (BTPosition<E>) v;
    }

    protected BTPosition<E> createNode(E element, BTPosition<E> parent, BTPosition<E> left, BTPosition<E> right) {
        return new BTNode<E>(element, parent, left, right);
    }


    protected void preorderPositions(Position<E> v, PositionList<Position<E>> pos) throws InvalidPositionException {
        pos.addLast(v);
        if (hasLeft(v)) preorderPositions(left(v), pos);
        if (hasRight(v)) preorderPositions(right(v), pos);
    }

    public boolean isEmpty() { return (size == 0); }
    public boolean isExternal(Position<E> v) throws InvalidPositionException { return !isInternal(v); }
    public Position<E> right(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
        BTPosition<E> vv = checkPosition(v);
        Position<E> rightPos = (Position<E>) vv.getRight();
        if (rightPos == null) throw new BoundaryViolationException("No right child");
        return rightPos;
    }
    public boolean hasRight(Position<E> v) throws InvalidPositionException {
        BTPosition<E> vv = checkPosition(v);
        return (vv.getRight() != null);
    }

    public LinkedBinaryTree<E> buildExpression(String E){
        NodeStack<LinkedBinaryTree> S = new NodeStack<LinkedBinaryTree>();
        char[] e = E.toCharArray();
        for (int i = 0; i < E.length(); i++) {
            if(e[i] != '(' && e[i] != ')'){
                LinkedBinaryTree T = new LinkedBinaryTree();
                T.addRoot(e[i]);
                S.push(T);
            }else if(e[i] == '('){
                continue;
            }else{
                LinkedBinaryTree T2 = S.pop();
                LinkedBinaryTree T = S.pop();
                LinkedBinaryTree T1 = S.pop();
                T.attach(T.root(),T1,T2);
                S.push(T);
            }
        }
        return S.pop();
    }

    public String binaryPreOrder(LinkedBinaryTree T,BTPosition v,String s){
        s += v.element();
        if(T.hasLeft(v)){
            s = binaryPreOrder(T,v.getLeft(),s);
        }
        if(T.hasRight(v)){
            s = binaryPreOrder(T,v.getRight(),s);
        }
        return s;
    }

    public String binaryPostOrder(LinkedBinaryTree T,BTPosition v,String s){
        if(T.hasLeft(v)){
            s = binaryPostOrder(T,v.getLeft(),s);
        }
        if(T.hasRight(v)){
            s = binaryPostOrder(T,v.getRight(),s);
        }
        s += v.element();
        return s;
    }

    public float evaluateExpression(LinkedBinaryTree<Character> T,BTPosition<Character> v){
        if(T.isInternal(v)){
            Character o = v.element();
            float x = evaluateExpression(T,(BTPosition) T.left(v));
            float y = evaluateExpression(T,(BTPosition) T.right(v));
            switch (o){
                case '+':
                    return x + y;
                case '-':
                    return x - y;
                case '/':
                    return x / y;
                case '*':
                    return x * y;
            }
        }
        return Float.parseFloat(String.valueOf(v.element()));
    }

    public String inorder(LinkedBinaryTree T,BTPosition v, String s){
        BTPosition u = v.getLeft();
        BTPosition w = v.getRight();
        if(u != null) {
            s = inorder(T, u,s);
        }
        s += v.element();
        if(w != null){
            s = inorder(T,w,s);
        }
        return s;
    }

    public String eulerTour(LinkedBinaryTree T,BTPosition v, String s){
        s += v.element();
        if(T.hasLeft(v)) {
            s = eulerTour(T, v.getLeft(),s);
        }
        s += v.element();
        if(T.hasRight(v)){
            s = eulerTour(T,v.getRight(),s);
        }
        s += v.element();
        return s;
    }

    public String printExpression(LinkedBinaryTree T,BTPosition v, String s){
        if(T.isInternal(v)) {
            s += "(";
        }
        if(T.hasLeft(v)){
            s = printExpression(T,(BTPosition) T.left(v),s);
        }
        if(T.isInternal(v)){
            s += v.element();
        }
        else{
            s+= v.element();
        }
        if(T.hasRight(v)){
            s = printExpression(T,(BTPosition) T.right(v),s);
        }
        if(T.isInternal(v)) {
            s += ")";
        }
        return s;
    }

    public double depth(LinkedBinaryTree<E> T, Position<E> v){
        if (isRoot(v)){
            return 0;
        }else{
            return 1 + depth(T,parent(v));
        }
    }

    public int drawTree(LinkedBinaryTree T,BTPosition v,int visitedNodes){
        if(T.hasLeft(v)) {
            visitedNodes = drawTree(T,v.getLeft(),visitedNodes);
        }
        int depth = (int) T.depth(T,v);
        System.out.print("\"" + v.element() + "\" - ( " + visitedNodes + ", " + depth + " ) ");
        visitedNodes++;
        if(T.hasRight(v)){
            visitedNodes = drawTree(T,v.getRight(),visitedNodes);
        }
        return visitedNodes;
    }

    public String makerBTSearch(LinkedBinaryTree T,BTPosition v, String s){
        if(T.hasLeft(v)){
            s = makerBTSearch(T,v.getLeft(),s);
        }
        if(isInternal(v)){
            s += v.element() + ", ";
        }
        if(T.hasRight(v)){
            s = makerBTSearch(T,v.getRight(),s);
        }
        return s;
    }

    public int countLeft(LinkedBinaryTree T,BTPosition v,int numLefts){
        if(T.hasRight(v)){
            numLefts = countLeft(T,v.getRight(),numLefts);
        }
        if(T.hasLeft(v)){
            if(!T.isInternal(v.getLeft())){
                numLefts = countLeft(T,v.getLeft(),numLefts + 1);
            }else{
                numLefts = countLeft(T,v.getLeft(),numLefts);
            }
        }
        return numLefts;
    }

    public int countRight(LinkedBinaryTree T,BTPosition v,int numLefts){
        if(T.hasLeft(v)){
            numLefts = countRight(T,v.getLeft(),numLefts);
        }
        if(T.hasRight(v)){
            if(!T.isInternal(v.getRight())){
                numLefts = countRight(T,v.getRight(),numLefts + 1);
            }else{
                numLefts = countRight(T,v.getRight(),numLefts);
            }
        }
        return numLefts;
    }

}




