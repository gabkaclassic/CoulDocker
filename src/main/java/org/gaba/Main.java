package org.gaba;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;

import java.io.File;

public class Main {
    public static void main(String[] args) {


        var config
                = DefaultDockerClientConfig.createDefaultConfigBuilder()
                .withRegistryPassword("Ctrimyevgexi1")
                .withRegistryUsername("errodion");
        var client = DockerClientBuilder
                .getInstance(config)
                .build();

        System.out.println(client.buildImageCmd(new File("/home/errodion/Projects/IdeaProjects/Docflow_Server")).start().awaitImageId());
        client.listImagesCmd().exec().forEach(System.out::println);
        client.
    }
}