package com.music.musicserver.dao;

import com.music.musicserver.domain.Singer;
import org.springframework.stereotype.Repository;

import java.util.List;

//歌手dao
@Repository
public interface SingerMapper {
//    增加
    public int insert(Singer singer);
    //修改
    int update(Singer singer);

    //删除
    int delete(Integer id);

    //查询

    Singer selectByPrimaryKey(Integer id);

    //查找所有的歌手
    List<Singer> allSinger();

    //根据歌手名字模糊查询
    List<Singer> singerOfName(String name);

    public List<Singer> singerOfSex(Integer sex);

}
