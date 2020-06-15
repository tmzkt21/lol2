package com.example.web.proxy;

import com.example.web.music.Help;
import com.example.web.music.HelpRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

public class Crawler extends Proxy{
    @Autowired
    Inventory<Help> inventory;
    @Autowired Box<String> box;
    @Autowired
    HelpRepository  helpRepository;
    public void memberlist(){
        inventory.clear();
        try{
            String url = "https://music.bugs.co.kr/chart";
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                    .execute();
            Document d = homepage.parse();
            Elements title = d.select("p.title");
            Elements artist = d.select("p.artist");
            Elements thumbnail = d.select("a.thumbnail");
            Help help = null;
            for(int i=0;i < title.size(); i++){
//                help = new Help();
//                help = new Help();
//                help.setSeq(string(i+1));
//                help.setTitle(title.get(i).text());
//                help.setArtists(artist.get(i).text());
//                help.setThumbnail(thumbnail.get(i).select("img").attr("src"));
//                helpRepository.save(help);
            }
        }catch(Exception e){
            print("에러 발생");
        }
        print("******************** 크롤링 결과 *****************\n");
        // inventory.get().forEach(System.out::print);
        //print(inventory.get().get(0).toString());

    }

}
