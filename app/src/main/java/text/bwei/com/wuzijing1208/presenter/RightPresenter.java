package text.bwei.com.wuzijing1208.presenter;

import java.util.List;

import text.bwei.com.wuzijing1208.bean.Rightbean;
import text.bwei.com.wuzijing1208.model.Imodel;
import text.bwei.com.wuzijing1208.model.Onsekectright;
import text.bwei.com.wuzijing1208.model.model;
import text.bwei.com.wuzijing1208.view.Iview;

/**
 * Created by dell on 2017/12/8.
 */

public class RightPresenter {
    Iview iview;
    Imodel imodel;

    public RightPresenter(Iview iview) {
        this.iview = iview;
        imodel = new model();
    }

    public void getRightOk(String url, int cid) {
        imodel.RequestRight(url, cid, new Onsekectright() {
            @Override
            public void dataRightSuccessd(List<Rightbean.DataBean> lists) {
                iview.shouRight(lists);
            }
        });


    }


}
