package util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class ImageUtils {
    public static Image loadImage(String filePath){
        try{
            return ImageIO.read(ImageUtils.class.getResource(filePath));
        }
        catch (IOException e){
            System.out.println("Couldn't load Image!!");
        }
        return null;
    }
}
