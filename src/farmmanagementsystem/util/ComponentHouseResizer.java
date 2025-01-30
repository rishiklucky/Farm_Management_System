/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmmanagementsystem.util;

/**
 *
 * @author Administrator
 */
/*
 * Copyright (c) 2007 Component House (Hugo Vidal Teixeira). All Rights Reserved.
 * Visit: http://www.componenthouse.com
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  o Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  o Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  o Neither the name of Component House (Hugo Vidal Teixeira) nor the names of
 *    its contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
 


import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * High-Quality Image Resize with Java
 * http://www.componenthouse.com/article-20
 *
 * @author Hugo Teixeira
 */
public class ComponentHouseResizer {

	/*
     public static void main(String[] args) {
		try {
			BufferedImage image = ImageIO.read(new File("c:\\VALMORIA, LEGEE BOY G. CIT.jpg"));
			ImageIO.write(resizeTrick(image, 500, 500), "png", new File("c:\\picture3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
    

	private static BufferedImage resize(BufferedImage image, int width, int height) {
		//int type = image.getType() == 0? BufferedImage.OPAQUE: image.getType();
                int type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB : image.getType();
		BufferedImage resizedImage = new BufferedImage(width, height, type);
		Graphics2D g = resizedImage.createGraphics();
		g.setComposite(AlphaComposite.Src);
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(image, 0, 0, width, height, null);
		g.dispose();
		
                return resizedImage;
	}
        
        public static BufferedImage getScaledImage(BufferedImage image, int width, int height) throws IOException {
            int imageWidth  = image.getWidth();
            int imageHeight = image.getHeight();

            double scaleX = (double)width/imageWidth;
            double scaleY = (double)height/imageHeight;
            AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
            AffineTransformOp bilinearScaleOp = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_BILINEAR);

        return bilinearScaleOp.filter(
        image,
        new BufferedImage(width, height, image.getType()));
       }

        /*private static BufferedImage resizeTrick(BufferedImage image, int width, int height) {
         * image = createCompatibleImage(image);
         * image = resize(image, width, height);
         * 
         * //image = blurImage(image);
         * return resize(image, width, height);
         * }*/

        public static BufferedImage resizeImageWithHint(BufferedImage originalImage,int IMG_WIDTH, int IMG_HEIGHT){
            BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = resizedImage.createGraphics();
            AffineTransform at = null;
            try {
                at = AffineTransform.getScaleInstance((double) IMG_WIDTH / originalImage.getWidth(),
                        (double) IMG_HEIGHT / originalImage.getHeight());
            } catch (Exception e) {
            }
            g.drawRenderedImage(originalImage, at);
            return resizedImage;
        }

        public static BufferedImage OrientImageWithHint(BufferedImage originalImage,int IMG_WIDTH, int IMG_HEIGHT){
            BufferedImage resizedImage = new BufferedImage(IMG_HEIGHT, IMG_WIDTH, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = resizedImage.createGraphics();
            AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(-90),0,0);
            at.translate(-IMG_WIDTH,0);
            g.drawRenderedImage(originalImage, at);
            return resizedImage;
        }

//    @SuppressWarnings("empty-statement")
//   public static BufferedImage resizeImageWithHint(BufferedImage originalImage,int IMG_WIDTH, int IMG_HEIGHT) throws IOException{
//
//       // originalImage = createCompatibleImage(originalImage);
//        int thumbWidth = IMG_WIDTH;//Specify image width in px
//        int thumbHeight = IMG_HEIGHT;//Specify image height in px
//
//        int imageWidth = originalImage.getWidth(null);//get image Width
//        int imageHeight = originalImage.getHeight(null);//get image Height
//
//        double thumbRatio = (double)thumbWidth/(double)thumbHeight;
//        double imageRatio = (double)imageWidth/(double)imageHeight;
//        if(thumbRatio<imageRatio) {
//            thumbHeight = (int) (thumbWidth/imageRatio);
//        } else {
//            thumbWidth = (int) (thumbHeight*imageRatio);
//        }
//        //This calculation is used to convert the image size according to the pixels mentioned above
//        if(thumbRatio<imageRatio) {
//            thumbHeight = (int) (thumbWidth/imageRatio);
//        } else {
//            thumbWidth = (int) (thumbHeight*imageRatio);
//        }
//	BufferedImage resizedImage = new BufferedImage(thumbWidth,thumbHeight,BufferedImage.TYPE_INT_RGB);;
//        resizedImage = resize(resizedImage, IMG_WIDTH, IMG_HEIGHT);
//	Graphics2D graphics = resizedImage.createGraphics();
//        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//        graphics.drawImage(originalImage,0, 0, IMG_WIDTH, IMG_HEIGHT,null);
//        graphics.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
//        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//
//        JPEGImageEncoder encoder = (JPEGImageEncoder) JPEGCodec.createJPEGEncoder(out);
//        JPEGEncodeParam param  = encoder.getDefaultJPEGEncodeParam(resizedImage);
//
//        int quality = 100;
//        quality = Math.max(0,Math.min(quality,100));
//        param.setQuality((float)quality/100.0f,false);
//
//        //output image type.
//        // String format = "png";
//
//        encoder.setJPEGEncodeParam(param);
//        encoder.encode(resizedImage);
//	return resizedImage;
//    }

	private static BufferedImage blurImage(BufferedImage image) {
		float ninth = 1.0f/9.0f;
		float[] blurKernel = {
				ninth, ninth, ninth,
				ninth, ninth, ninth,
				ninth, ninth, ninth
		};

		Map<RenderingHints.Key, Object> map = new HashMap<>();
		map.put(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		map.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		map.put(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		RenderingHints hints = new RenderingHints(map);
		BufferedImageOp op = new ConvolveOp(new Kernel(3, 3, blurKernel), ConvolveOp.EDGE_NO_OP, hints);
		return op.filter(image, null);
	}

        /*private static BufferedImage createCompatibleImage(BufferedImage image) {
         * GraphicsConfiguration gc = BufferedImageGraphicsConfig.getConfig(image);
         * int w = image.getWidth();
         * int h = image.getHeight();
         * BufferedImage result = gc.createCompatibleImage(w, h, Transparency.OPAQUE);
         * Graphics2D g2 = result.createGraphics();
         * g2.drawRenderedImage(image, null);
         * g2.dispose();
         * return result;
         * }*/
//
//  public BufferedImage ImageRescale(BufferedImage originalimage,int IMG_WIDTH, int IMG_HEIGHT) throws IOException
//  {
//
//   Image image = originalimage;
//
//   int thumbWidth = IMG_WIDTH;//Specify image width in px
//   int thumbHeight = IMG_HEIGHT;//Specify image height in px
//
//   int imageWidth = image.getWidth(null);//get image Width
//   int imageHeight = image.getHeight(null);//get image Height
//
//   double thumbRatio = (double)thumbWidth/(double)thumbHeight;
//   double imageRatio = (double)imageWidth/(double)imageHeight;
//
////This calculation is used to convert the image size according to the pixels mentioned above
//   if(thumbRatio<imageRatio) {
//    thumbHeight = (int) (thumbWidth/imageRatio);
//   } else {
//    thumbWidth = (int) (thumbHeight*imageRatio);
//   }
//
//   BufferedImage thumbImage = new BufferedImage(thumbWidth,thumbHeight,BufferedImage.TYPE_INT_RGB);
//
//   Graphics2D graphics = thumbImage.createGraphics();
//   graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//   graphics.drawImage(image,0, 0, thumbWidth, thumbHeight,null);
//   graphics.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
//   graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
//
//   ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//   JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//   JPEGEncodeParam param  = encoder.getDefaultJPEGEncodeParam(thumbImage);
//
//   int quality = 100;
//   quality = Math.max(0,Math.min(quality,100));
//   param.setQuality((float)quality/100.0f,false);
//
//    //output image type.
//   // String format = "png";
//
//   encoder.setJPEGEncodeParam(param);
//   encoder.encode(thumbImage);
//   //ImageIO.write(thumbImage,format, new File("E://NetBeansProjects//ImageResize//src//splashImage_1.png"));//Specify the location for output image .
//
//    return thumbImage;
//
//  }
        
}
