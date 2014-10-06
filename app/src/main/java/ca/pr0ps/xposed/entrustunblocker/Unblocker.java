package ca.pr0ps.xposed.entrustunblocker;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class Unblocker implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("com.entrust.identityGuard.mobile"))
            return;

        findAndHookMethod("com.entrust.identityGuard.mobile.Splash", lpparam.classLoader, "isDeviceSecure", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
            // Replace the method and don't do anything.
            // This method usually just sets the global isRooted variable.
            return false;
            }
        });
    }
}
