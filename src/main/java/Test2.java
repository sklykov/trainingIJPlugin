import net.imagej.ImageJ;
import net.imagej.ops.Ops;
import net.imglib2.IterableInterval;
import net.imglib2.RandomAccessibleInterval;
import net.imglib2.img.Img;

import java.io.IOException;

public class Test2 {

    public static void main(String[] args) {

        ImageJ ij = new ImageJ();
        ij.ui().showUI();
        Img image; // most generic image container
        IterableInterval image2, saltPepImg;
        RandomAccessibleInterval image3; RandomAccessibleInterval gaussImg;
        try {
            image3 = (RandomAccessibleInterval) ij.io().open("src/main/resources/nesvizh.jpg");
            image2 = (IterableInterval) image3;
            ij.op().convert().uint8(image2); // the conversion operation demands other type of image
            /* TODO: 1) Why converted image from RGB to uint8 still represented as RGB?
            *   2) Salt and pepper noise adding; 3) Old algorithm = denoising with edge preserving*/
            ij.ui().show(image2);
            gaussImg =  ij.op().filter().gauss(image3,2.0);
            ij.ui().show(gaussImg);
            // First complication - adding PoissonNoise
            // saltPepImg = ij.op().filter().addPoissonNoise(null,image2);

        } catch (IOException e) {
            System.out.println("Problem with file opening");
        }

        // ij1.ui().dispose(); // closing the IJ gui and a frame with an opened source image

    }
}
