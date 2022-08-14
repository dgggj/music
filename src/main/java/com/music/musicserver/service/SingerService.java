package com.music.musicserver.service;

import com.music.musicserver.domain.Singer;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SingerService {

    //查询
    Singer selectByPrimaryKey(Integer id);

    //查找所有的歌手
    List<Singer> allSinger();

    //根据歌手名字模糊查询
    List<Singer> singerOfName(String name);

    List<Singer> singerOfSex(Integer sex);

    Object addSinger(Singer singer);

    Object updateSinger(Singer singer);

    boolean deleteSinger(Integer id);

    Object updateSingerPic(MultipartFile avatorFile, int id);
}
