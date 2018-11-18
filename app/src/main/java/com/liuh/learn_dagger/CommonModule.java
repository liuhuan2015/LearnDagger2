package com.liuh.learn_dagger;

import dagger.Module;
import dagger.Provides;

@Module
public class CommonModule {

    private ICommonView iView;

    public CommonModule(ICommonView iView) {
        this.iView = iView;
    }

    @Provides
    @ActivityScope
    public ICommonView provideICommonView() {
        return this.iView;
    }

}
