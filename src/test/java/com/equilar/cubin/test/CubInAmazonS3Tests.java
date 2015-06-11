package com.equilar.cubin.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.equilar.cubin.CubInAmazonS3;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CubInAmazonS3.class)
public class CubInAmazonS3Tests {

	@Test
	public void contextLoads() {
	}

}
