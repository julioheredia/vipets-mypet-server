package com.vipets.mypet.vipetsmypetserver.controller.rest;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vipets.mypet.vipetsmypetserver.model.PetActivity;
import com.vipets.mypet.vipetsmypetserver.model.User;
import com.vipets.mypet.vipetsmypetserver.service.PetActivityService;
import com.vipets.mypet.vipetsmypetserver.util.ImagesUtil;
import com.vipets.mypet.vipetsmypetserver.util.ImagesUtil.ImagePerformerType;

@RestController
public class PetActivityResourceRest {

	@Autowired
	private PetActivityService petActivityService;

	@Autowired
	ServletContext context;

	@PostMapping("/searchPetActivityByUser")
	public List<PetActivity> searchPetActivityByUser(@RequestBody User user) {
		String diretorio = context.getRealPath("WEB-INF/images/");
		ImagesUtil imagesUtil = new ImagesUtil();
		List<PetActivity> atcis = petActivityService.searchPetActivityByUser(user);
		for (PetActivity petActivity : atcis) {
			imagesUtil.convertByteArrayInImageJpeg(petActivity.getPet().getPhoto(), diretorio, ImagePerformerType.Pet,
					String.valueOf(petActivity.getPet().getPetId()));
		}
		return petActivityService.searchPetActivityByUser(user);
	}

}
