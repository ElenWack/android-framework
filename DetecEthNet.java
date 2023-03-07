
diff --git a/kjdtech/apps/KJDTech/KJDTvService/src/com/kjd/tv/service/TvService.java b/kjdtech/apps/KJDTech/KJDTvService/src/com/kjd/tv/service/TvService.java
index 50cc1e347..97a078914 100755
--- a/kjdtech/apps/KJDTech/KJDTvService/src/com/kjd/tv/service/TvService.java
+++ b/kjdtech/apps/KJDTech/KJDTvService/src/com/kjd/tv/service/TvService.java
@@ -110,6 +110,9 @@ import java.util.function.Consumer;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
+import android.net.ConnectivityManager;
+import android.net.NetworkInfo;
+import android.net.EthernetManager;
public class TvService extends Service{
@@ -153,6 +156,10 @@ public class TvService extends Service{
                
     private int mGpioOpsReset    = 8 * 15 + 2;
+        private int  nettype  = 0;
+       
+       private ConnectivityManager mConnectivityManager;
+       private EthernetManager ethernetManager;
     private final ITvService.Stub mBinder = new ITvService.Stub() {
         @Override
@@ -483,6 +490,9 @@ public class TvService extends Service{
                commonFilter.addAction(Intent.ACTION_TIMEZONE_CHANGED);
                commonFilter.addAction(Intent.ACTION_BOOT_COMPLETED);
   
+               commonFilter.addAction(Intent.ACTION_BOOT_COMPLETED);
+               commonFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
+  
                registerReceiver(mCommonReceiver, commonFilter);
        }
        
@@ -623,9 +633,40 @@ public class TvService extends Service{
                        {
                                Utils.sendKeyDownUpSync(KeyEvent.KEYCODE_SYSRQ);
                }
+                       //
+                       if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)){
+                               
+                               NetworkInfo networkInfo = mConnectivityManager.getActiveNetworkInfo();
+                               if( networkInfo != null ){
+                                       if( networkInfo.getType() != 0){
+                                               nettype = networkInfo.getType();
+                                       }
+                               }
+                               Log.d(TAG,"nettype = " + nettype);
+                               if(nettype == 9){
+                               
+                                       if(isWiredNetConnect()){
+                                               Utils.showToast(context,context.getString(R.string.ethernet_isok));
+                                       }else{
+                                               Utils.showToast(context,context.getString(R.string.ethernet_isno));
+                                       }
+                               }
+                       }
+                       //
         }
     }
        
+       public boolean isWiredNetConnect(){
+               int mNetworkType=0;
+               NetworkInfo networkInfo = mConnectivityManager.getActiveNetworkInfo();
+               if(networkInfo!=null){
+                       mNetworkType=networkInfo.getType();
+               }
+               return mNetworkType == ConnectivityManager.TYPE_ETHERNET;
+       }
+       
+       
+       
        private Handler mHandler = new Handler()
        {
         @Override
@@ -708,6 +749,8 @@ public class TvService extends Service{
     @Override
     public void onCreate() {
         super.onCreate();
+               ethernetManager = (EthernetManager)getSystemService(EthernetManager.class);
+               mConnectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                registerCommonReceiver();
                startOtherFunctions(getApplicationContext());
     }





