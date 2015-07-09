package com.equilar.cubin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CubInAmazonS3 implements CommandLineRunner  {
	
//	@Autowired
//	private AmazonS3Upload amazonS3Upload;
	
	@Override
	public void run(String... arg0) throws Exception {
//		amazonS3Upload.upload();
	}
	
    public static void main(String[] args) {
        SpringApplication.run(CubInAmazonS3.class, args);    
    }
}
