package com.music.musicserver.dao;

import com.music.musicserver.domain.Singer;
import com.music.musicserver.domain.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongMapper {
    //    增加
    int insert(Song song);
    //修改
    int update(Song song);

    //删除
    int delete(Integer id);

    Song selectByPrimaryKey(Integer id);

    List<Song> allSong();

    List<Song> songOfName(String name);

    List<Song> songOfSingerId(Integer singerId);

}
