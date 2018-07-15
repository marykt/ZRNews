package party.hc.zrnews.conn;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.List;

import party.hc.zrnews.bean.NewsBean;

/**
 * Created by QY on 2018/7/13.
 */

public class GetNews {
    private String path;

    //传入参数newsbean类型
    public void getNews(List<NewsBean> newsBeanList) throws JSONException {

        //发送http请求
        path = "http://115.159.205.152:8080/WebNews/DoArticle";
        String str = HttpUtil.sendHttpRequset(path);
        //获得返回数据
        JSONObject json = new JSONObject(str);
        JSONArray array = json.getJSONArray("data");

        for (int i = 0; i < array.length(); i++) {
            JSONObject temp = array.getJSONObject(i);
            NewsBean newsBean = new NewsBean();
            newsBean.setId(temp.optString("uniquekey"));
            newsBean.setTitle(temp.optString("title"));
            newsBean.setDate(temp.optString("date"));
            newsBean.setCategory(temp.optString("category"));
            newsBean.setAuthor(temp.optString("author_name"));
            newsBean.setUrl(temp.optString("url"));
            newsBean.setThumbnail(temp.optString("thumbnail_pic_s0"));
            newsBean.setThumbnail1(temp.optString("thumbnail_pic_s1"));
            newsBean.setThumbnail2(temp.optString("thumbnail_pic_s2"));
            newsBeanList.add(newsBean);

        }
    }
}


