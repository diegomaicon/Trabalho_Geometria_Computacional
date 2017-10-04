import Libs.Avl;

public class index {


    public static void main(String[] args) {
        Avl s = new Avl();

        s.insert(1);
        s.insert(2);

        System.out.println(s.member(3));

        s.insert(3);
        s.delete(2);
        System.out.println(s.member(3));

    }
}
