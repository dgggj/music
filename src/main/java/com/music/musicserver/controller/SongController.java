package com.music.musicserver.controller;

import com.music.musicserver.domain.Song;
import com.music.musicserver.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/song")
public class SongController {
    private SongService service;

    /*搜索所有歌曲*/
    @GetMapping("allSong")
    public Object allSong(){
        return service.allSong();
    }

    /*添加歌曲*/
    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public Object addSong(HttpServletRequest req, @RequestParam(name = "file")MultipartFile mpFile){
       return service.addSong(req,mpFile);
    }

    /*根据歌手id的查询*/
    @GetMapping("/singer/detail/{id}")
    public Object songOfSingerId(@PathVariable("id") Integer id){
        return service.songOfSingerId(id);
    }

    /*更新歌曲图片*/
    @PostMapping("/updateSongPic")
    public Object updateSingerPic(@RequestParam("file")MultipartFile avatorFile ,@RequestParam("id") int id){
        return service.updateSingerPic(avatorFile,id);

    }
    /*修改歌曲*/
    @PostMapping("/update")
    public Object update(@RequestBody Song song){
        return service.updateSong(song);
    }

    /*删除歌曲*/
    @GetMapping("/delete/{id}")
    public Object deleteSong(@PathVariable(name = "id") Integer id){
        return service.deleteSong(id);
    }
    /**
     * 修改歌曲
     * */
    @PostMapping("/updateSongUrl")
    public Object updateSongUrl(@RequestParam("file") MultipartFile songFile,@RequestParam("id") Integer id){
        return service.updateSongUrl(songFile,id);
    }

    @Autowired
    public void setService(SongService service) {
        this.service = service;
    }
}
