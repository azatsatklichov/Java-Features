package features.in.java9;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BaseMultiResolutionImage;
import java.awt.image.MultiResolutionImage;
import java.io.File;
import java.io.IOException;

public class JavaDesktopMultiResolutionImages {

    public static void main(String[] args) throws IOException {
        MultiResolutionImage mr = loadImages();

        Image lowres = mr.getResolutionVariant(50, 50);
        Image highres = mr.getResolutionVariant(200, 200);

        System.out.printf("Width for 50: %d%n", lowres.getWidth(null));
        System.out.printf("Width for 200: %d%n", highres.getWidth(null));
    }

    private static MultiResolutionImage loadImages() throws IOException {
        Image[] sanders = new Image[] {
           ImageIO.read(new File("sander_lowres.png")),
           ImageIO.read(new File("sander.png"))
        };
        return new BaseMultiResolutionImage(sanders);
    }

}
