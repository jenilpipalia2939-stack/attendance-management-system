package com.jenilpipaliya.attendance.service;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.rekognition.RekognitionClient;
import software.amazon.awssdk.services.rekognition.model.CompareFacesRequest;
import software.amazon.awssdk.services.rekognition.model.CompareFacesResponse;
import software.amazon.awssdk.services.rekognition.model.Image;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PhotoVerificationService {

    private static final float SIMILARITY_THRESHOLD = 90.0f;

    private final RekognitionClient rekognitionClient;

    public PhotoVerificationService() {
        this.rekognitionClient = RekognitionClient.builder()
                .region(Region.AP_SOUTH_1)
                .build();
    }

    public boolean verifyFace(String referencePhotoPath, byte[] livePhotoData) {
        try {
            byte[] referencePhotoData = Files.readAllBytes(Path.of(referencePhotoPath));

            Image referenceImage = Image.builder()
                    .bytes(SdkBytes.fromByteArray(referencePhotoData))
                    .build();

            Image liveImage = Image.builder()
                    .bytes(SdkBytes.fromByteArray(livePhotoData))
                    .build();

            CompareFacesRequest request = CompareFacesRequest.builder()
                    .sourceImage(referenceImage)
                    .targetImage(liveImage)
                    .similarityThreshold(SIMILARITY_THRESHOLD)
                    .build();

            CompareFacesResponse response = rekognitionClient.compareFaces(request);

            return !response.faceMatches().isEmpty();

        } catch (IOException e) {
            throw new RuntimeException("Could not read reference photo file", e);
        }
    }
}