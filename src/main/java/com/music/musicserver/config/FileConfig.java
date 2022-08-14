package com.music.musicserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
* 定位歌手头像地址的*/
@Configuration
public class FileConfig implements WebMvcConfigurer {
    /**
     * Add handlers to serve static resources such as images, js, and, css
     * files from specific locations under web application root, the classpath,
     * and others.
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/singerPic/**").addResourceLocations(
                "file:D:/学术/java/project/music/music-server/img/singerPic/"
        );
        registry.addResourceHandler("/img/songPic/**").addResourceLocations(
                "file:D:/学术/java/project/music/music-server/img/songPic/"
        );
        registry.addResourceHandler("/img/songListPic/**").addResourceLocations(
                "file:D:/学术/java/project/music/music-server/img/songListPic/"
        );
        registry.addResourceHandler("/song/**").addResourceLocations(
                "file:D:/学术/java/project/music/music-server/song/"
        );
    }
}
