package text.bwei.com.wuzijing1208.presenter;

import java.util.List;

import text.bwei.com.wuzijing1208.bean.Leftbean;
import text.bwei.com.wuzijing1208.model.Imodel;
import text.bwei.com.wuzijing1208.model.Onselectleft;
import text.bwei.com.wuzijing1208.model.model;
import text.bwei.com.wuzijing1208.view.Iview;

/**
 * Created by dell on 2017/12/8.
 */

public class LeftPresenter {
    Imodel imodel;
    Iview iview;

    public LeftPresenter(Iview iview) {
        this.iview = iview;
        imodel = new model();

    }

    public void getLeftOk(String url) {
        imodel.RequestLeft(url, new Onselectleft() {
            @Override
            public void dataLeftSuccess(List<Leftbean.DataBean> list) {
                iview.showLeft(list);

            }
        });

    }


}
