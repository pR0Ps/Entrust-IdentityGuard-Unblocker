Entrust IdentityGuard Unblocker
===============================

The Entrust IdentityGuard Mobile OTP app refuses to work on devices that are rooted or running custom ROM images, calling them "unsecured".

The validity of that statement notwithstanding, some people need to use the application for work.
It's not something you choose to install, it's something you're forced to install by your IT department.

In the interest of getting some work done (without buying a new phone), I created this Xposed
module to bypass the checks for root and custom ROMs.

Just install, enable, reboot, and you're done. Get back to work.

Building
--------

1. Clone the repository
2. Open the project using [Android Studio](https://developer.android.com/sdk/installing/studio.html)
3. Run/compile the project

Credits
-------
- [XposedBridgeApi-54.jar](http://forum.xda-developers.com/showpost.php?p=51828909) ([source code](https://github.com/rovo89/XposedBridge)) by rovo89 (Apache v2.0)
