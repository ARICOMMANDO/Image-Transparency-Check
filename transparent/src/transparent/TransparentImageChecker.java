package transparent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TransparentImageChecker {

    public static void main(String[] args) {
        // Replace "path/to/your/image.png" with the actual path to your image file
        File imageFile = new File("skullicon.png");

        try {
            BufferedImage image = ImageIO.read(imageFile);

            if (hasTransparentBackground(image)) {
                System.out.println("The image has a transparent background.");
            } else {
                System.out.println("The image does not have a transparent background.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean hasTransparentBackground(BufferedImage image) {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int alpha = (image.getRGB(x, y) >> 24) & 0xFF;
                if (alpha != 255) {
                    return true; 
                }
            }
        }
        return false;
    }
}
