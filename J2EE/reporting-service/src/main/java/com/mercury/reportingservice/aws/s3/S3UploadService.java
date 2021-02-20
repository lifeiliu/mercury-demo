package com.mercury.reportingservice.aws.s3;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class S3UploadService {
	
	@Autowired
	private AmazonS3 amazonS3;

	@Value("${cloud.aws.s3.bucket}")
	private String bucket;
	
	public void upload(InputStream is) {
		ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("application/pdf");
		amazonS3.putObject(bucket, "test.pdf", is, metadata); // TODO: file name contains uuid
	}

}
