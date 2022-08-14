package com.music.musicserver.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.music.musicserver.dao.SingerMapper;
import com.music.musicserver.domain.Singer;
import com.music.musicserver.service.SingerService;
import com.music.musicserver.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    SingerMapper singerMapper;
    /**
    * 增加
    * */
    @Override
    public Singer selectByPrimaryKey(Integer id) {
        return singerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Singer> allSinger() {
        return singerMapper.allSinger();
    }

    @Override
    public List<Singer> singerOfName(String name) {
        return singerMapper.singerOfName(name);
    }

    @Override
    public List<Singer> singerOfSex(Integer sex) {
        return singerMapper.singerOfSex(sex);
    }

    @Override
    public Object addSinger(Singer singer) {
        JSONObject object=new JSONObject();
        boolean flag = singerMapper.insert(singer)>0;
        if(flag){
            object.put(Consts.CODE,1);
            object.put(Consts.MSG,"添加成功");
            return object;
        }
        object.put(Consts.CODE,0);
        object.put(Consts.MSG,"添加失败");
        return object;
    }

    @Override
    public Object updateSinger(Singer singer) {
        JSONObject object=new JSONObject();
        boolean flag = singerMapper.update(singer)>0;
        if(flag){
            object.put(Consts.CODE,1);
            object.put(Consts.MSG,"添加成功");
            return object;
        }
        object.put(Consts.CODE,0);
        object.put(Consts.MSG,"添加失败");
        return object;
    }

    @Override
    public boolean deleteSinger(Integer id) {
        return singerMapper.delete(id)>0;
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
        String filePath="D:/学术/java/project/music/music-server/img/singerPic";//文件路径
        //如果文件路径不存在，新增路径
        File file1=new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }
        //储存到数据库的相对文件地址
        File dest=new File(filePath+"/"+fileName);
        String storeAvatorPath="/img/singerPic/"+fileName;
        try {
            avatorFile.transferTo(dest);
            Singer singer=new Singer();
            singer.setId(id);
            singer.setPic(storeAvatorPath);
            boolean flag = singerMapper.update(singer)>0;
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
            object.put(Consts.MSG,"更新失败"+e.getMessage());
        } finally {
            return object;
        }
    }
}
