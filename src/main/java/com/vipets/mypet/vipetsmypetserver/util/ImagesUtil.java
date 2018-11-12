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

import com.vipets.mypet.vipetsmypetserver.Application;

public class ImagesUtil {

	private final static Logger logger = LoggerFactory.getLogger(ImagesUtil.class);
	
	public enum ImagePerformerType { Pet, User, Breed };
	public enum ImageType { jpeg, png };
	public static String point = ".";
	
	public static String getImagesDirectory() {
		String directory = Application.getInstance().getServletContext().getRealPath("WEB-INF/images/");
		return directory;
	}

	public static void convertByteArrayInImageJpeg(byte[] imageInByte, ImagePerformerType imagePerformerType,
			String nameImage) {
		try {
			InputStream in = new ByteArrayInputStream(imageInByte);
			BufferedImage bImageFromConvert = ImageIO.read(in);
			String image = getImagesDirectory() + joinImageName(imagePerformerType, nameImage, ImageType.jpeg);
			ImageIO.write(bImageFromConvert, ImageType.jpeg.name(), new File(image));
		} catch (IOException e) {
			logger.error("Error to convert image", e);
		}
	}

	public static String joinImageName(ImagePerformerType imagePerformerType, String nameImage, ImageType imageType) {
		List<String> fileParts = Arrays.asList(imagePerformerType.name(), nameImage, point, imageType.name());
		return String.join("", fileParts);
	}

}