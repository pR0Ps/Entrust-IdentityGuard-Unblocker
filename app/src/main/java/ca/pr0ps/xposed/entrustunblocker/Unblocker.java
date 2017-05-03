package ca.pr0ps.xposed.entrustunblocker;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class Unblocker implements IXposedHookLoadPackage {

  @Override
  public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
    if (!lpparam.packageName.equals("com.entrust.identityGuard.mobile"))
      return;

    //v3.2.0.96 - Released on 2017-05-03
    try {
      findAndHookMethod("com.entrust.identityGuard.mobile.sdk.PlatformDelegate", lpparam.classLoader, "isDeviceRooted", new XC_MethodReplacement() {
        @Override
        protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
          return false;
        }
      });
      return;
    }
    catch (NoSuchMethodError ignored){}

    //v3.1.0.32 - Released on 2015-12-15
    try {
      findAndHookMethod("com.entrust.identityGuard.mobile.sdk.PlatformDelegate", lpparam.classLoader, "isDeviceSecure", new XC_MethodReplacement() {
        @Override
        protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
          return false;
        }
      });
      return;
    }
    catch (NoSuchMethodError ignored){}

    //Before 2015-12-15
    try {
      findAndHookMethod("com.entrust.identityGuard.mobile.Splash", lpparam.classLoader, "isDeviceSecure", new XC_MethodReplacement() {
        @Override
        protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
          return false;
        }
      });
      return;
    }
    catch (NoSuchMethodError ignored){}

    XposedBridge.log("WARNING: Found Entrust IdentityGuard app but couldn't find a method to patch - this version of the app probably isn't supported yet");
  }
}
