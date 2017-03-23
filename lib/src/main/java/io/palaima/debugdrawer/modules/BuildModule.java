/*
 * Copyright (C) 2015 Mantas Palaima
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.palaima.debugdrawer.modules;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;

import io.palaima.debugdrawer.BaseDebugModule;
import io.palaima.debugdrawer.DebugWidgets;


public class BuildModule extends BaseDebugModule {

    private PackageInfo info;

    @NonNull
    @Override
    public String getName() {
        return "Build Information";
    }

    @Override
    public void onCreate(Activity activity) {
        super.onCreate(activity);
        try {
            info = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DebugWidgets createWidgets(DebugWidgets.DebugWidgetsBuilder builder) {
        return builder
                .addText("Version", String.valueOf(info.versionCode))
                .addText("Name", info.versionName)
                .addText("Package", info.packageName)
                .build();
    }
    
}
