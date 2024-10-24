package com.awstraining.backend.config;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.translate.AmazonTranslate;
import com.amazonaws.services.translate.AmazonTranslateClient;
import com.amazonaws.services.translate.AmazonTranslateClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class SNSConfig {

    @Value("${aws.region}")
    private String awsRegion;

    @Value("${aws.accessKey:#{null}}")
    private String snsAccessKey;

    @Value("${aws.secretKey:#{null}}")
    private String snsSecretKey;
    
    // TODO: lab1
    //  0. Uncomment @Bean section.
    //  1. Configure AmazonSNS which will be used by fargate within AWS.
    //  2. Make sure that your task role has access to publish action (ecs-task-role-policy).
    //  3. Think how to connect with AWS Service from your local pc.

    @Bean
    AmazonSNS configureSNSClient() {
        return AmazonSNSClientBuilder.standard()
                        .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
                                .withRegion("eu-central-1")
                .build();
    }

    @Bean
    AmazonTranslate configureTranslate(){
        return AmazonTranslateClientBuilder.standard()
                .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
                .withRegion("eu-central-1")
                .build();
    }

}