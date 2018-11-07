package com.vipets.mypet.vipetsmypetserver.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImagesUtil {

	public void convertByteArrayInImage(byte[] imageInByte, String path, String nameImage) {
		try {
			InputStream in = new ByteArrayInputStream(imageInByte);
			BufferedImage bImageFromConvert = ImageIO.read(in);
			String image = path + nameImage + ".jpeg";
			ImageIO.write(bImageFromConvert, "jpeg", new File(image));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}