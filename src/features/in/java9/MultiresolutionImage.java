package features.in.java9;

import java.awt.Image;
import java.awt.image.BaseMultiResolutionImage;
import java.awt.image.MultiResolutionImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * With Java 9, a new multi-resolution image API has been introduced which
 * supports multiple images with different resolution variants.
 *
 */
public class MultiresolutionImage {
	public static void main(String[] args) throws IOException, MalformedURLException {

		List<String> imgUrls = List.of("http://sahet.net/src/collected/palow.jpg",
				"http://sahet.net/src/software/internet2.jpg",
				"http://sahet.net/src/software/web-development.png");

		List<Image> images = new ArrayList<Image>();

		for (String url : imgUrls) {
			images.add(ImageIO.read(new URL(url)));
		}

		// read all images into one multiresolution image
		MultiResolutionImage multiResolutionImage = new BaseMultiResolutionImage(images.toArray(new Image[0]));

		// get all variants of images
		List<Image> variants = multiResolutionImage.getResolutionVariants();

		System.out.println("Total number of images: " + variants.size());

		for (Image img : variants) {
			System.out.println(img);
		}

		// get a resolution-specific image variant for each indicated size
		Image variant1 = multiResolutionImage.getResolutionVariant(156, 45);
		System.out.printf("\nImage for destination[%d,%d]: [%d,%d]", 156, 45, variant1.getWidth(null),
				variant1.getHeight(null));

		Image variant2 = multiResolutionImage.getResolutionVariant(311, 89);
		System.out.printf("\nImage for destination[%d,%d]: [%d,%d]", 311, 89, variant2.getWidth(null),
				variant2.getHeight(null));

		Image variant3 = multiResolutionImage.getResolutionVariant(622, 178);
		System.out.printf("\nImage for destination[%d,%d]: [%d,%d]", 622, 178, variant3.getWidth(null),
				variant3.getHeight(null));

		Image variant4 = multiResolutionImage.getResolutionVariant(300, 300);
		System.out.printf("\nImage for destination[%d,%d]: [%d,%d]", 300, 300, variant4.getWidth(null),
				variant4.getHeight(null));
	}
}
