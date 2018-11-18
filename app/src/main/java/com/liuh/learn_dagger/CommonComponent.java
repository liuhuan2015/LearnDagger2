package com.liuh.learn_dagger;

import dagger.Component;

/**
 * 接口
 */
@ActivityScope
@Component(modules = CommonModule.class)
public interface CommonComponent {

    void inject(LoginActivity activity);
}
