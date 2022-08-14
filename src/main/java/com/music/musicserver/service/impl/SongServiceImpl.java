package com.music.musicserver.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.music.musicserver.dao.SongMapper;
import com.music.musicserver.domain.Singer;
import com.music.musicserver.domain.Song;
import com.music.musicserver.service.SongService;
import com.music.musicserver.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private SongMapper songMapper;



    @Override
    public List<Song> allSong() {
        return songMapper.allSong();
    }

    @Override
    public List<Song> songOfName(String name) {
        return songMapper.songOfName(name);
    }

    @Override
    public List<Song> songOfSingerId(Integer singerId) {
        return songMapper.songOfSingerId(singerId);
    }

    @Override
    public Object addSong(HttpServletRequest req, MultipartFile mpFile) {
        JSONObject object=new JSONObject();

        String singer_id = req.getParameter("singerId").trim();
        String name = req.getParameter("name").trim();
        String introduction = req.getParameter("introduction").trim();
        String pic = "/img/songPic/hu.jpg";
        String lyric = req.getParameter("lyric").trim();

        if(mpFile.isEmpty()){
            object.put(Consts.CODE,0);
            object.put(Consts.MSG,"上传文件出错，请重新上传");
            return object;
        }
        //文件名=当前时间毫秒+原来文件名
        String fileName=System.currentTimeMillis()+mpFile.getOriginalFilename();
        //文件路径
        String filePath="D:/学术/java/project/music/music-server/song";
        //如果文件路径不存在，就直接创建
        File file=new File(filePath);
        if(!file.exists()){
            file.mkdir();
        }
        //实际的文件地址
        File dest=new File(filePath+"/"+fileName);
        //相对文件地址
        String storeUrlPath="/song/"+fileName;
        try {
            mpFile.transferTo(dest);
            Song song = new Song();
            song.setSingerId(Integer.parseInt(singer_id));
            song.setName(name);
            song.setIntroduction(introduction);
//            song.setCreateTime(new Date());
//            song.setUpdateTime(new Date());
            song.setPic(pic);
            song.setLyric(lyric);
            song.setUrl(storeUrlPath);
            boolean flag = songMapper.insert(song)>0;
            if(flag){
                object.put(Consts.CODE,1);
                object.put(Consts.MSG,"添加歌曲成功");
                object.put("pic",storeUrlPath);
                return object;
            }else {
                object.put(Consts.CODE,0);
                object.put(Consts.MSG,"歌曲上传失败");
                return object;
            }

        } catch (IOException e) {
            object.put(Consts.CODE,0);
            object.put(Consts.MSG,"上传失败"+e.getMessage());
            return object;
        }
    }

    @Override
    public Object updateSingerPic(MultipartFile avatorFile, int id) {
        JSONObject object=new JSONObject();
        if(avatorFile.isEmpty()){
            object.put(Consts.CODE,0);
            object.put(Consts.MSG,"没有发现文件，请重新上传");
            return object;
        }

        String fileName=System.currentTimeMillis()+avatorFile.getOriginalFilename();//文件名
        String filePath="D:/学术/java/project/music/music-server/img/songPic";//文件路径
        //如果文件路径不存在，新增路径
        File file1=new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }
        //储存到数据库的相对文件地址
        File dest=new File(filePath+"/"+fileName);
        String storeAvatorPath="/img/songPic/"+fileName;
        try {
            avatorFile.transferTo(dest);
            Song song=new Song();
            song.setId(id);
            song.setPic(storeAvatorPath);
            boolean flag = songMapper.update(song)>0;
            if(flag){
                object.put(Consts.CODE,1);
                object.put(Consts.MSG,"更新成功");
                object.put("pic",storeAvatorPath);
                return object;
            }else {
                object.put(Consts.CODE,0);
                object.put(Consts.MSG,"更新失败");
                return object;
            }
        } catch (IOException e) {
            object.put(Consts.CODE,0);
            object.put(Consts.MSG,"更新错误"+e.getMessage());
            return object;
        }
    }

    @Override
    public Object updateSong(Song song) {
        JSONObject object=new JSONObject();
        boolean flag = songMapper.update(song)>0;
        if(flag){
            object.put(Consts.CODE,1);
            object.put(Consts.MSG,"修改歌曲成功");
            return object;
        }else {
            object.put(Consts.CODE,0);
            object.put(Consts.MSG,"修改歌曲失败");
            return object;
        }
    }

    @Override
    public Object deleteSong(Integer id) {
        Song song = songMapper.selectByPrimaryKey(id);
        String filename=song.getUrl();
        String filePath="D:/学术/java/project/music/music-server";
        File file=new File(filePath+filename);
        System.out.println(filePath+filename);
        boolean delete = file.delete();
        System.out.println(delete);
        return songMapper.delete(id)>0;
    }

    @Override
    public Object updateSongUrl(MultipartFile songFile, Integer id) {
        JSONObject object=new JSONObject();
        if(songFile.isEmpty()){
            object.put(Consts.CODE,0);
            object.put(Consts.MSG,"没有发现文件，请重新上传");
            return object;
        }

        String fileName=System.currentTimeMillis()+songFile.getOriginalFilename();//文件名
        String filePath="D:/学术/java/project/music/music-server/song";//文件路径
        //如果文件路径不存在，新增路径
        File file1=new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }
        //储存到数据库的相对文件地址
        File dest=new File(filePath+"/"+fileName);
        String storeAvatorPath="/song/"+fileName;
        try {
            songFile.transferTo(dest);
            Song song=new Song();
            song.setId(id);
            song.setUrl(storeAvatorPath);
            boolean flag = songMapper.update(song)>0;
            if(flag){
                object.put(Consts.CODE,1);
                object.put(Consts.MSG,"更新成功");
                object.put("avator",storeAvatorPath);
                return object;
            }else {
                object.put(Consts.CODE,0);
                object.put(Consts.MSG,"更新失败");
                return object;
            }
        } catch (IOException e) {
            object.put(Consts.CODE,0);
            object.put(Consts.MSG,"更新错误"+e.getMessage());
            return object;
        }
    }


    @Autowired
    public void setSongMapper(SongMapper songMapper) {
        this.songMapper = songMapper;
    }
}
