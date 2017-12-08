package text.bwei.com.wuzijing1208.view;

import java.util.List;

import text.bwei.com.wuzijing1208.bean.Leftbean;
import text.bwei.com.wuzijing1208.bean.Rightbean;

/**
 * Created by dell on 2017/12/8.
 */

public interface Iview {

    void showLeft(List<Leftbean.DataBean> list);
    void shouRight(List<Rightbean.DataBean> lists);
}
