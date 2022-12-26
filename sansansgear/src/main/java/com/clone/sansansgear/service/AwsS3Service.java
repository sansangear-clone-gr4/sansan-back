package com.clone.sansansgear.service;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.clone.sansansgear.s3.S3Component;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import java.io.InputStream;


@RequiredArgsConstructor
@Component
class AwsS3Service implements FileService {
    private final S3Component component;
    private final AmazonS3 amazonS3;


    @Override
    public void uploadFile(InputStream inputStream, ObjectMetadata objectMetadata, String fileName) {
        amazonS3.putObject(new PutObjectRequest(component.getBucket(), fileName, inputStream,objectMetadata).withCannedAcl(
                CannedAccessControlList.PublicRead));
    }

    @Override
    public void deleteFile(String fileName) {
        amazonS3.deleteObject(new DeleteObjectRequest(component.getBucket(), fileName));
    }

    @Override
    public String getFileUrl(String fileName) {
      return amazonS3.getUrl(component.getBucket(), fileName).toString();
    }


}
