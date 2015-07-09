package com.equilar.cubin.service;

import com.equilar.cubin.ob.ImageUploadObject;

public interface AmazonS3Service {
	public String uploadImageFile(ImageUploadObject imageObject);
}
