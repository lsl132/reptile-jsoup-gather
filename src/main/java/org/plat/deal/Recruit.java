package org.plat.deal;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * BOSS招聘数据抓取
 */

public class Recruit {

    //
    private static CloseableHttpClient client;

    public void init() {
        try {
            if (client == null) {
                client = HttpClients.createDefault();
            }
            HttpGet httpGet = new HttpGet("https://www.zhipin.com/c101020100-p100101/d_202/?period=1&ka=sel-scale-1");
            // 浏览器表示
            httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.6)");
            // 传输的类型
            httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");

            HttpResponse response = client.execute(httpGet);
            // 获得响应的实体对象
            HttpEntity entity = response.getEntity();
            // 使用Apache提供的工具类进行转换成字符串
            String entityStr = EntityUtils.toString(entity, "UTF-8");

            //System.out.println(entityStr);

            Document doc = Jsoup.parse(entityStr);
            Elements links = doc.getElementsByClass("job-primary");
            for (Element link : links) {
                String linkTitle = link.getElementsByClass("job-title").html();
                System.out.print(linkTitle+", ");
                String linkSalary  = link.getElementsByClass("red").html();
                System.out.print(linkSalary+", ");
                String linkAddr = link.getElementsByTag("p").text();
                System.out.print(linkAddr+", ");
                Elements companys = link.getElementsByClass("company-text");
                for(Element company : companys) {
                    String companyName = company.getElementsByTag("a").html();
                    System.out.print(companyName+", ");
                    String companyType = company.getElementsByTag("p").text();
                    System.out.print(companyType+", ");
                }
                System.out.println("");
                System.out.println("--------------------------------------------");
            }

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}
