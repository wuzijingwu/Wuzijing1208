package text.bwei.com.wuzijing1208.api;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;
import text.bwei.com.wuzijing1208.bean.Leftbean;
import text.bwei.com.wuzijing1208.bean.Rightbean;

/**
 * Created by dell on 2017/12/8.
 */

public interface ApiServer {
    @GET("product/getCatagory")
    Observable<Leftbean> getDaes();


    @POST
    Observable<Rightbean> getDass(@Url String url, @QueryMap Map<String, Integer> map);


}
