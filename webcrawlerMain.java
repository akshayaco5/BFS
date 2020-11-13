import java.net.URL;
import java.util.*;
import java.io.*;

public class webcrawler{
  private Queue<String>queue;
  private List<String> websites;
  
  public webcrawler(){
    this.queue = new LinkedList();
    this.websites = new ArrayList();
  }
  
  public void discoverWeb(String root){
    this.queue.add(root);
    this.Websites.add(root);
    while(!queue.isEmpty()){
      String site= this.queue.remove();
      String rawHtml=realUrl(site);
      String regex="http://(\\w+\\.)*(\\w+)";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.match(rawHtml);
      while(matcher.find()){
        String actualUrl=matcher.group();
        if(!websites.contains(actualUrl)){
          websites.add(actualUrl);
          System.out.println(actualUrl);
          queue.add(actualUrl);
        }
      }
    }
  }
  
  private String readurl(String site){
    String rawHtml="";
    try{
      URL url = new URL(site);
      Bufferedreader in = new BufferedReader(new InputStreamReader(url.openStream()));
      String inputLine = " ";
      while(inputLine=in.readLine() != null){
        rawHtml=inputLine;
      }
      in.close();
    }
    catch(Exception e){
      e.printStackTrace();
    }
    return rawHtml;
  }
}
  
  
  public class webcrawlerMain{
    public static void main(String[] args){
      webcrawler crawler = new Webcrawler();
      string root ="http://www.bbc.com";
      crawler.discoverWeb(root)
    }
  }
