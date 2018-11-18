package com.liuh.learn_dagger;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 可以看到：LoginPresenter的实例对象我们并没有进行初始化，但是代码却运行并达到了要实现的效果
 * <p>
 * 这里的重点是 LoginPresenter 和 LoginActivity 实现了解耦，后续无论怎样修改 LoginPresenter 的构造方法都不需要改动LoginActivity的代码。
 * <p>
 * 只改 CommonModule 类的代码就可以了
 */
public class LoginActivity extends AppCompatActivity implements ICommonView {

    @BindView(R.id.btn_login)
    Button btnLogin;
    @Inject
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        DaggerCommonComponent
                .builder()
                .commonModule(new CommonModule(this))
                .build()
                .inject(this);

    }

    @OnClick(R.id.btn_login)
    void login() {
        presenter.login(new User());
    }

    @Override
    public Context getContext() {
        return this;
    }

}
