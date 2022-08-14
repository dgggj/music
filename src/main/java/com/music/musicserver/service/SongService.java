package com.music.musicserver.service;

import com.music.musicserver.domain.Singer;
import com.music.musicserver.domain.Song;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface SongService {



    //查找所有的歌手
    List<Song> allSong();

    //根据歌手名字模糊查询
    List<Song> songOfName(String name);

    List<Song> songOfSingerId(Integer singerId);

    Object addSong(HttpServletRequest req, MultipartFile mpFile);

    Object updateSingerPic(MultipartFile avatorFile, int id);

    Object updateSong(Song song);

    Object deleteSong(Integer id);

    Object updateSongUrl(MultipartFile songFile, Integer id);

}
