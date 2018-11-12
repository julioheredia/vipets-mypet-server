package com.vipets.mypet.vipetsmypetserver.controller.rest;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vipets.mypet.vipetsmypetserver.util.ImagesUtil;
import com.vipets.mypet.vipetsmypetserver.util.ImagesUtil.ImageType;

@RestController
public class ImagesResourceRest {

	@RequestMapping(value = "/images/{imageName}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImage(@PathVariable String imageName) throws IOException {
		String directory = ImagesUtil.getImagesDirectory();
		BufferedImage originalImage = ImageIO.read(new File(directory + imageName));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(originalImage, ImageType.jpeg.name(), baos);
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();
		return imageInByte;
	}

}
