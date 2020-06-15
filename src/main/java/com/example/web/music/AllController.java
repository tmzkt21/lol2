package com.example.web.music;



import com.example.web.proxy.Box;
import com.example.web.proxy.Crawler;
import com.example.web.proxy.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AllController {
  @Autowired Proxy proxy;
  @Autowired
  Box box;
  @Autowired HelpRepository helpRepository;
  @Autowired
  Crawler crawler;


    @GetMapping("/list")
    public HashMap<String,Object> help(@RequestBody String searchWord){
        proxy.print("넘어온 키워드:"+ searchWord);
        box.clear();
      if(helpRepository.count() == 0) crawler.memberlist();
      List<Help> list = helpRepository.findAll();
      box.put("list", list);
      box.put("count", list.size());
      return box.get();

    }
}

//  @PostMapping("/bugsmusic")
//  public HashMap<String,Object> bugsmusic(@RequestBody String searchWord){
//    pxy.print("넘어온 키워드: "+searchWord);
//    box.clear();
//    if(musicRepository.count() == 0) crawler.bugsMusic();
//    List<Music> list = musicRepository.findAll();
//    box.put("list", list);
//    box.put("count", list.size());
//    return box.get();
//  }
