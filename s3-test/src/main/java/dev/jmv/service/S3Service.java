package dev.jmv.service;

import dev.jmv.config.S3Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class S3Service {

    private final S3Properties s3Properties;

    private final S3Client s3Client;

    public String uploadFile(MultipartFile file) throws IOException {
        String key = file.getOriginalFilename();

        s3Client.putObject(
                PutObjectRequest.builder()
                        .bucket(s3Properties.getBucket())
                        .key(key)
                        .contentType(file.getContentType())
                        .build(),
                RequestBody.fromBytes(file.getBytes())
        );

        return key; // returning the S3 object key
    }

    // Download file
    public byte[] downloadFile(String key) {
        ResponseBytes<GetObjectResponse> response = s3Client.getObject(
                GetObjectRequest.builder()
                        .bucket(s3Properties.getBucket())
                        .key(key)
                        .build(),
                ResponseTransformer.toBytes()
        );
        return response.asByteArray();
    }
}