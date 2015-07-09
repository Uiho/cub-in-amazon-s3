package com.equilar.cubin.resource;


import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.equilar.cubin.ob.ImageUploadObject;
import com.equilar.cubin.service.AmazonS3Service;

@RestController
@Component
@RequestMapping("/cubin/amazon/s3")
public class AmazonS3Resource {
	
	private Logger logger = LoggerFactory.getLogger(AmazonS3Resource.class);
	
	@Autowired
	private AmazonS3Service amazonS3Service; 
	
	@RequestMapping(value = "/upload", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public  Response saveImage(@RequestBody ImageUploadObject imageUploadObject)throws Exception{
		if(imageUploadObject==null){
			logger.error("Input object is null");
			return null;
		}
		
		logger.info("Input Object: "+imageUploadObject.toString());
		String url = amazonS3Service.uploadImageFile(imageUploadObject);
		return Response.status(500).entity(url).build();
	}
}
