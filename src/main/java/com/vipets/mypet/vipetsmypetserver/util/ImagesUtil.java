package com.vipets.mypet.vipetsmypetserver.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImagesUtil {

	private final Logger logger = LoggerFactory.getLogger(ImagesUtil.class);
	
	public enum ImagePerformerType { Pet, User, Breed };
	public enum ImageType { jpeg, png };
	public static String point = ".";

	public void convertByteArrayInImageJpeg(byte[] imageInByte, String path, ImagePerformerType imagePerformerType, String nameImage) {
		try {
			InputStream in = new ByteArrayInputStream(imageInByte);
			BufferedImage bImageFromConvert = ImageIO.read(in);
			String image = path + joinImageName(imagePerformerType, nameImage, ImageType.jpeg);
			ImageIO.write(bImageFromConvert, ImageType.jpeg.name(), new File(image));
		} catch (IOException e) {
			logger.error("Error to convert image", e);
		}
	}
	
	private String joinImageName(ImagePerformerType imagePerformerType, String nameImage, ImageType imageType) {
		List<String> fileParts = Arrays.asList(imagePerformerType.name(), nameImage, point, imageType.name());
		return String.join("", fileParts);
	}

}