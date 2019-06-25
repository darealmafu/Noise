package zone.mafu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int width = 0;
        int height = 0;

        while(width < 1 || height < 1) {
            System.out.println("yo what should the width be");
            width = sc.nextInt();

            System.out.println("and the height?");
            height = sc.nextInt();
        }

        String type = "png"; //i made this a variable for easy changing although i don't really see a reason in implementing this being something that could be changed, seeing as jpg doesn't work and no one will actually use this

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for(int i = 0; i < image.getWidth(); i++){
            for(int j = 0; j < image.getHeight(); j++){
                image.setRGB(i,j,new Color((int)(Math.random() * 256),(int)(Math.random() * 256),(int)(Math.random() * 256)).getRGB());
            }
        }


        File outputfile = new File("noise." + type);
        try {
            ImageIO.write(image, type, outputfile);
        } catch (IOException e){
            System.out.println("Failed to write image.");
            System.exit(1);
        }

        System.out.println("Done!");
    }
}
