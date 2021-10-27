package TAD_ArvBin;

import TAD_ArvGen.LinkedTree;
import TAD_ArvGen.TreeNode;
import org.junit.jupiter.api.Test;
import position.NodePositionList;
import position.Position;
import position.PositionList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedBinaryTreeTest {
    @Test
    public void test(){
        LinkedBinaryTree<Character> T = new LinkedBinaryTree<Character>();
        T = T.buildExpression("((((3+1)*3)/((9-5)+2))-((3*(7-4))+6))");
        assertEquals(-13.0,T.evaluateExpression(T,(BTPosition) T.root()));

        assertEquals("3+1*3/9-5+2-3*7-4+6",T.inorder(T,(BTPosition) T.root(),""));

        assertEquals("-/*+313+-952+*3-746",T.binaryPreOrder(T,(BTPosition) T.root(),""));

        assertEquals("31+3*95-2+/374-*6+-",T.binaryPostOrder(T,(BTPosition) T.root(),""));

        assertEquals("((((3+1)*3)/((9-5)+2))-((3*(7-4))+6))",T.printExpression(T,(BTPosition) T.root(),""));

        T.drawTree(T,(BTPosition) T.root(),0);

        LinkedBinaryTree<String> T1 = criarArvoreT();

        String mkBTsearch = T1.makerBTSearch(T1,(BTPosition<String>) T1.root(),"");

        assertEquals("12, 25, 31, 36, 42, 56, 62, 75, 90",mkBTsearch.substring(0,mkBTsearch.length() - 2));

        int lefts = T.countLeft(T,(BTPosition) T.root(),0);
        assertEquals(4,lefts);


        int rights = T.countRight(T,(BTPosition) T.root(),0);
        assertEquals(6,rights);

        assertEquals("-/*+333+111+*333*/+-999-555-+222+/-+*333*-777-444-*+666+-",T.eulerTour(T,(BTPosition) T.root(),""));

    }

    public LinkedBinaryTree<String> criarArvoreT() {
        LinkedBinaryTree<String> T = new LinkedBinaryTree<String>();
        BTPosition<String> raiz, ninet, trt1, sixt2, sevent5, tUnt5, forT2,trt6,twelv;

        T.addRoot("56");

        raiz = (BTPosition) T.root();

        trt1 = (BTPosition<String>) T.insertLeft(raiz,"31");
        ninet = (BTPosition<String>) T.insertRight(raiz,"90");

        sixt2 = (BTPosition<String>) T.insertLeft(ninet,"62");
        T.insertRight(ninet,"");

        sevent5 = (BTPosition<String>) T.insertRight(sixt2,"75");
        T.insertLeft(sixt2,"");

        T.insertLeft(sevent5,"");
        T.insertRight(sevent5,"");

        tUnt5 = (BTPosition<String>) T.insertLeft(trt1,"25");
        forT2 = (BTPosition<String>) T.insertRight(trt1,"42");

        twelv = (BTPosition<String>) T.insertLeft(tUnt5,"12");
        T.insertRight(tUnt5,"");

        T.insertRight(twelv,"");
        T.insertLeft(twelv,"");

        trt6 = (BTPosition<String>) T.insertLeft(forT2,"36");
        T.insertRight(forT2,"");

        T.insertLeft(trt6,"");
        T.insertRight(trt6,"");

        return T;
    }
}
