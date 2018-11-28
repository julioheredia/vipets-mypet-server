package com.vipets.mypet.vipetsmypetserver.controller.rest;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vipets.mypet.vipetsmypetserver.util.ImagesUtil;

@RestController
public class FileResourceRest {

	@RequestMapping(value = "/images/{imageName}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImage(@PathVariable String imageName) throws IOException {
		return ImagesUtil.convertImageJpegInByteArray(imageName);
	}

}
