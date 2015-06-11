package com.equilar.cubin.service.impl;

import java.io.File;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.equilar.cubin.service.AmazonS3Service;
import com.equilar.cubin.util.AmazonS3Property;

@Component
public class AmazonS3ServiceImpl implements AmazonS3Service {
	
	private static AmazonS3 s3client;
	private static String BUCKET_NAME = AmazonS3Property.BUCKET_NAME.getValue();
	private static String AMAZON_BASE_URL = AmazonS3Property.AMAZON_BASE_URL.getValue();
	private static String AMAZON_DOMAIN = AmazonS3Property.AMAZON_DOMAIN.getValue();
	private static String ENVIRONMENT = AmazonS3Property.ENVIRONMENT.getValue();
	private static String PATH_SEPARATOR = "/";
	private static String JPEG = ".jpg";
	
	
	private static final Logger logger = Logger.getLogger(AmazonS3ServiceImpl.class);
	
	static{
		AWSCredentials credentials = new BasicAWSCredentials(
			AmazonS3Property.AMAZON_ACCESS_KEY.getValue(), 
			AmazonS3Property.AMAZON_SECRET_KEY.getValue());
		if(s3client == null){
			s3client = new AmazonS3Client(credentials);
		}
	}

	@Override
	public String uploadFile(String personId, String path) {
		logger.info("****    Starting upload file    ****");
		
		logger.info("personId: "+personId);
		logger.info("path: "+path);
		logger.info("BUCKET_NAME: "+BUCKET_NAME);
		logger.info("AMAZON_BASE_URL: "+AMAZON_BASE_URL);
		logger.info("AMAZON_DOMAIN: "+AMAZON_DOMAIN);
		logger.info("ENVIRONMENT: "+ENVIRONMENT);
		
		if (!s3client.doesBucketExist(BUCKET_NAME)) {
			String errorMessage = "The specified bucket :[" + BUCKET_NAME + "] doesn't exist.";
			logger.warn(errorMessage);
			throw new IllegalArgumentException(errorMessage);
		}
		
		String url = null;
		File file = new File(path+PATH_SEPARATOR+personId+JPEG);
		logger.info("file path: "+file);
		
		try{
			if (file.exists()) {
				String fileName = ENVIRONMENT + PATH_SEPARATOR + file.getName();
	
				logger.info("Found the image file to upload to amazon s3: [" + path + "]. Start to upload...");
				
				logger.info("Checking file name : [" + fileName+ "]. To be ready to upload.");
				
				PutObjectResult result = s3client.putObject(BUCKET_NAME, fileName, file);
				String bucketLocation = s3client.getBucketLocation(BUCKET_NAME);
				
				logger.info("Image uploaded into amazon s3 Object repository:" + result);
				
				if (result != null) {
					url = AMAZON_BASE_URL + bucketLocation + AMAZON_DOMAIN + BUCKET_NAME +
							PATH_SEPARATOR + fileName;
				}
			}
			else {
				logger.warn("File does not exist. No uploading for: [" + path + "].");
			}
		
		} catch (AmazonClientException ace) {
			logger.info("Exception while uploading file:" + path);
			logger.error(ace);
		}
		return url;
	}

}
