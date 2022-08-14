package com.music.musicserver.controller;

import com.music.musicserver.domain.Singer;
import com.music.musicserver.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;




@RestController
@RequestMapping("/singer")
public class SingerController {

    private SingerService service;

    /**
     * 添加歌手
     * */
    @PostMapping("/add")
    public Object addSinger(@RequestBody Singer singer){
        return service.addSinger(singer);
    }
    /**
     * 更新歌手信息
     * */
    @PostMapping("/update")
    public Object updateSinger(@RequestBody Singer singer){
        return service.updateSinger(singer);
    }
    /**
     * 删除歌手
     * */
    @GetMapping("/delete/{id}")
    public Object deleteSinger(@PathVariable(name = "id") Integer id){
        return service.deleteSinger(id);

    }
    /**
     * 通过主键查询歌手
     * */
    @GetMapping("/selectByPrimaryKey")
    public Object selectByPrimaryKey(Integer id){
        return service.selectByPrimaryKey(id);

    }
    /**
     * 查询所有歌手
     * */
    @GetMapping("/allSinger")
    public Object allSinger(){
        return service.allSinger();
    }
    /**
     * 根据名字模糊查询
     * */
    @GetMapping("singerOfName")
    public Object singerOfName(String name){
        return service.singerOfName("%"+name+"%");
    }
    /**
     * 根据性别查询
     * */
    @GetMapping("sexSinger")
    public Object sexSinger(Integer sex){
        return service.singerOfSex(sex);
    }

    /**
     * 更新歌手图片
     * */
    @PostMapping("/updateSingerPic")
    public Object updateSingerPic(@RequestParam("file")MultipartFile avatorFile ,@RequestParam("id") int id){
        return service.updateSingerPic(avatorFile,id);

    }


    @Autowired
    public void setService(SingerService service) {
        this.service = service;
    }
}
