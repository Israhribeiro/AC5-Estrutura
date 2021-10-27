package TAD_ArvBinCompleta;

import TAD_ArvBin.BinaryTree;
import position.Position;

public interface CompleteBinaryTree<E> extends BinaryTree<E> {

    public Position<E> add(E elem);

    public E remove();
}

