package me.panavtec.cleancontacts.di;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import dagger.Module;
import dagger.Provides;
import me.panavtec.cleancontacts.ui.errors.ErrorManager;
import me.panavtec.cleancontacts.ui.errors.SnackbarErrorManagerImp;
import me.panavtec.cleancontacts.ui.helper_util.HelperUtil;
import me.panavtec.cleancontacts.ui.helper_util.HelperUtilImpl;

@Module(
        addsTo = AppModule.class,
        library = true
)
public class ActivityModule {

    private ActionBarActivity activity;

    public ActivityModule(ActionBarActivity activity) {
        this.activity = activity;
    }

    @Provides ActionBar provideActionBar() {
        return activity.getSupportActionBar();
    }

    @Provides Context provideContext() {
        return activity;
    }

    @Provides ActionBarActivity provideActivity() {
        return activity;
    }

    @Provides ErrorManager provideErrorManager() {
        return new SnackbarErrorManagerImp(activity);
    }

    @Provides HelperUtil provideHelperUtil(Context context) {
        return new HelperUtilImpl(context);
    }
}
