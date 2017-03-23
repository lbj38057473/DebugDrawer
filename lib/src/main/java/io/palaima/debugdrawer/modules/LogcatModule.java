package io.palaima.debugdrawer.modules;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;

import io.palaima.debugdrawer.BaseDebugModule;
import io.palaima.debugdrawer.DebugWidgets;
import io.palaima.debugdrawer.util.LibUtil;
import kale.debug.log.ui.LogActivity;

/**
 * @author Kale
 * @date 2016/3/26
 */
public class LogcatModule extends BaseDebugModule {

    private Activity activity;

    public LogcatModule() {
        if (!LibUtil.hasDependency("kale.debug.log.ui.LogActivity")) {
            throw new RuntimeException("Logcat dependency is not found");
        }
    }

    @NonNull
    @Override
    public String getName() {
        return "Logcat";
    }

    @Override
    public void onCreate(Activity activity) {
        super.onCreate(activity);
        this.activity = activity;
    }

    @Override
    public DebugWidgets createWidgets(DebugWidgets.DebugWidgetsBuilder builder) {
        return builder.addButton("Show App Log", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(new Intent(activity, LogActivity.class));
            }
        }).build();
    }

}
