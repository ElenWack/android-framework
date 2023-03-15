修改了Camera2录像无声音的问题

diff --git a/apps/Camera2/AndroidManifest.xml b/apps/Camera2/AndroidManifest.xml
index 7024d4065..5835cd598 100644
--- a/apps/Camera2/AndroidManifest.xml
+++ b/apps/Camera2/AndroidManifest.xml
@@ -28,7 +28,11 @@
     <uses-permission android:name="android.permission.WAKE_LOCK" />
     <uses-permission android:name="android.permission.WRITE_SETTINGS" />
     <uses-permission android:name="android.permission.WRITE_SYNC_SETTINGS" />
-
+    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
+    <uses-permission android:name="android.permission.WRITE_SETTINGS" />
+    <uses-permission android:name="android.permission.WRITE_SYNC_SETTINGS" />
+    <uses-permission android:name="android.permission.WRITE_MEDIA_STORAGE"/>
+    
     <supports-screens
         android:anyDensity="true"
         android:largeScreens="true"
diff --git a/apps/Camera2/src/com/android/camera/VideoModule.java b/apps/Camera2/src/com/android/camera/VideoModule.java
index f81ad919e..b0daceb53 100755
--- a/apps/Camera2/src/com/android/camera/VideoModule.java
+++ b/apps/Camera2/src/com/android/camera/VideoModule.java
@@ -1145,7 +1145,8 @@ public class VideoModule extends CameraModule
         }
         mMediaRecorder.setCamera(camera);
-        mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
+        //mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
+        mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);          
         mMediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
         mMediaRecorder.setProfile(mProfile);
         mMediaRecorder.setVideoSize(mProfile.videoFrameWidth, mProfile.videoFrameHeight);
