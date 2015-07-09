package com.equilar.cubin.ob;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ImageUploadObject {
	
	@JsonProperty("username")
	private String username;
	@JsonProperty("image_file_name")
	private String imageFileName;
	@JsonProperty("image_type")
	private String imageType;
	@JsonProperty("image_path_from_local")
	private String imagePathFromLocal;
	@JsonProperty("image_path_to_amazaon_s3")
	private String imagePathToAmazonS3;
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getImagePathFromLocal() {
		return imagePathFromLocal;
	}

	public void setImagePathFromLocal(String imagePathFromLocal) {
		this.imagePathFromLocal = imagePathFromLocal;
	}

	public String getImagePathToAmazonS3() {
		return imagePathToAmazonS3;
	}

	public void setImagePathToAmazonS3(String imagePathToAmazonS3) {
		this.imagePathToAmazonS3 = imagePathToAmazonS3;
	}

	@Override
	public String toString() {
		return "ImageUploadObject [username=" + username + ", imageFileName="
				+ imageFileName + ", imageType=" + imageType
				+ ", imagePathFromLocal=" + imagePathFromLocal
				+ ", imagePathToAmazonS3=" + imagePathToAmazonS3 + "]";
	}
	
	

}
