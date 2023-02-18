package com.plane.io;

import javax.imageio.ImageIO;
import java.awt.*;

public final class ImageLoader {
    /**
     * 如果width和height都为0，那么不进行缩放
     * @param path 示例："/res/plane.jpg"
     * @return 图片
     */
    public static Image getImage(String path,int width,int height){
        try {
            if (width+height==0){
                return ImageIO.read(ImageLoader.class.getClassLoader().getResource(path));
            }else {
                return ImageIO.read(ImageLoader.class.getClassLoader().getResource(path))
                        .getScaledInstance(width,height,Image.SCALE_SMOOTH);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("图片加载异常");
            System.exit(0);
        }
        return null;
    }
}
