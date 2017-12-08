package text.bwei.com.wuzijing1208;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import text.bwei.com.wuzijing1208.adapter.MyLeftAdapter;
import text.bwei.com.wuzijing1208.adapter.MyRightAdapter;
import text.bwei.com.wuzijing1208.api.Api;
import text.bwei.com.wuzijing1208.api.Meventss;
import text.bwei.com.wuzijing1208.bean.Leftbean;
import text.bwei.com.wuzijing1208.bean.Rightbean;
import text.bwei.com.wuzijing1208.presenter.LeftPresenter;
import text.bwei.com.wuzijing1208.presenter.RightPresenter;
import text.bwei.com.wuzijing1208.view.Iview;

public class MainActivity extends AppCompatActivity implements Iview {

    private RecyclerView recycright;
    private RecyclerView recycleft;
    private int cid;
    private RightPresenter rightPresenter;
    private LeftPresenter leftPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        leftPresenter = new LeftPresenter(this);
        leftPresenter.getLeftOk(Api.URL);
        rightPresenter = new RightPresenter(this);
//        rightPresenter.getRightOk(Api.URL, 1);
        recycleft = (RecyclerView) findViewById(R.id.recycleft);
        recycright = (RecyclerView) findViewById(R.id.recycright);

    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED, sticky = true)
    public void noEvent(Meventss meventss) {
        cid = meventss.getCid();
        rightPresenter.getRightOk(Api.URL, cid);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void showLeft(List<Leftbean.DataBean> list) {
        recycleft.setLayoutManager(new LinearLayoutManager(this));
        recycleft.setAdapter(new MyLeftAdapter(list, this));
        rightPresenter.getRightOk(Api.URL, 1);
    }


    @Override
    public void shouRight(List<Rightbean.DataBean> lists) {
        recycright.setLayoutManager(new LinearLayoutManager(this));
        recycright.setAdapter(new MyRightAdapter(lists, this));
    }
}
