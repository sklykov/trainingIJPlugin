import net.imagej.ImageJ;
import net.imagej.ops.Ops;
import net.imglib2.IterableInterval;
import net.imglib2.RandomAccessibleInterval;
import net.imglib2.img.Img;

import java.io.IOException;

public class Test2 {

    public static void main(String[] args) {

        ImageJ ij1 = new ImageJ();
        ij1.ui().showUI();
        Img image; // most generic image container
        IterableInterval image2;
        RandomAccessibleInterval image3; RandomAccessibleInterval gaussImg;
        try {
            image3 = (RandomAccessibleInterval) ij1.io().open("src/main/resources/lena.jpg");
            image2 = (IterableInterval) image3;
            ij1.op().convert().uint8(image2); // the conversion operation demands other type of image
            ij1.ui().show(image2);
            gaussImg =  ij1.op().filter().gauss(image3,2.0);
            ij1.ui().show(gaussImg);

        } catch (IOException e) {
            System.out.println("Problem with file opening");
        }

        // ij1.ui().dispose(); // closing the IJ gui and a frame with an opened source image

    }
}
