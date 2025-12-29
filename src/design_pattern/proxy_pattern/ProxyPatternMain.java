package design_pattern.proxy_pattern;

import java.util.HashMap;
import java.util.Map;

interface VideoDownloader{
    String downloadVideo(String videoUrl);
}

// Actual Video Downloader
class RealVideoDownloader implements VideoDownloader{
    @Override
    public String downloadVideo(String videoUrl) {
        System.out.println("Downloading video from URL: "+videoUrl);
        return "Video content from "+videoUrl;
    }
}

class CacheVideoDownloader implements VideoDownloader{
    private RealVideoDownloader realVideoDownloader;
    Map<String,String> cache;

    public CacheVideoDownloader(){
        this.realVideoDownloader = new RealVideoDownloader();
        this.cache = new HashMap<>();
    }

    @Override
    public String downloadVideo(String videoUrl) {
        if(cache.containsKey(videoUrl)){
            System.out.println("Returning cached video for : "+videoUrl);
            return cache.get(videoUrl);
        }
        System.out.println("Cache miss . Downloading....");
        String video = realVideoDownloader.downloadVideo(videoUrl);
        cache.put(videoUrl,video);
        return video;
    }
}

public class ProxyPatternMain {
    public static void main(String[] args) {
        VideoDownloader cacheVideoDownloader = new CacheVideoDownloader();
        cacheVideoDownloader.downloadVideo("https://webmusic.in");

        cacheVideoDownloader.downloadVideo("https://webmusic.in");
    }
}
