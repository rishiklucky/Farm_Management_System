/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package farmmanagementsystem.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author AzaShem
 */
public class IconProvider {

    public static BufferedImage getImage(){
        try {
            File file = new File("ICON.png");
            return ImageIO.read(file);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
