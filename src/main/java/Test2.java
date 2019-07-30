import ij.ImageJ;

public class Test2 {

    public static void main(String[] args) {

        ImageJ ij1 = new ImageJ();
        String info = ij1.getInfo();
        System.out.println(info);
    }
}
