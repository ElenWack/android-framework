https://www.bbsmax.com/A/kPzO4aExJx/



路径
\\192.168.1.155\lwr\V100\Android_12_0_0_r2\packages\apps\Bluetooth\src\com\android\bluetooth\opp\BluetoothOppNotification.java


diff --git a/apps/Bluetooth/src/com/android/bluetooth/opp/BluetoothOppNotification.java b/apps/Bluetooth/src/com/android/bluetooth/opp/BluetoothOppNotification.java
index 567fa1940..63927999f 100644
--- a/apps/Bluetooth/src/com/android/bluetooth/opp/BluetoothOppNotification.java
+++ b/apps/Bluetooth/src/com/android/bluetooth/opp/BluetoothOppNotification.java
@@ -565,89 +565,97 @@ class BluetoothOppNotification {
             BluetoothOppUtility.fillRecord(mContext, cursor, info);
             Uri contentUri = Uri.parse(BluetoothShare.CONTENT_URI + "/" + info.mID);
             String fileNameSafe = info.mFileName.replaceAll("\\s", "_");
-            Intent baseIntent = new Intent().setDataAndNormalize(contentUri)
-                    .setClassName(Constants.THIS_PACKAGE_NAME,
-                            BluetoothOppReceiver.class.getName());
-            Notification.Action actionDecline =
-                    new Notification.Action.Builder(Icon.createWithResource(mContext,
-                            R.drawable.ic_decline),
-                            mContext.getText(R.string.incoming_file_confirm_cancel),
-                            // TODO(b/171825892) Please replace FLAG_MUTABLE_UNAUDITED below
-                            // with either FLAG_IMMUTABLE (recommended) or FLAG_MUTABLE.
-                            PendingIntent.getBroadcast(mContext, 0,
-                                    new Intent(baseIntent).setAction(Constants.ACTION_DECLINE),
-                                    PendingIntent.FLAG_IMMUTABLE)).build();
-            Notification.Action actionAccept = new Notification.Action.Builder(
-                    Icon.createWithResource(mContext,R.drawable.ic_accept),
-                    mContext.getText(R.string.incoming_file_confirm_ok),
-                    // TODO(b/171825892) Please replace FLAG_MUTABLE_UNAUDITED below
-                    // with either FLAG_IMMUTABLE (recommended) or FLAG_MUTABLE.
-                    PendingIntent.getBroadcast(mContext, 0,
-                            new Intent(baseIntent).setAction(Constants.ACTION_ACCEPT),
-                            PendingIntent.FLAG_IMMUTABLE)).build();
-            Notification public_n =
-                    new Notification.Builder(mContext, OPP_NOTIFICATION_CHANNEL).setOnlyAlertOnce(
-                            true)
-                            .setOngoing(true)
-                            .setWhen(info.mTimeStamp)
-                            .addAction(actionDecline)
-                            .addAction(actionAccept)
-                            // TODO(b/171825892) Please replace FLAG_MUTABLE_UNAUDITED below
-                            // with either FLAG_IMMUTABLE (recommended) or FLAG_MUTABLE.
-                            .setContentIntent(PendingIntent.getBroadcast(mContext, 0,
-                                    new Intent(baseIntent).setAction(
-                                            Constants.ACTION_INCOMING_FILE_CONFIRM),
-                                    PendingIntent.FLAG_IMMUTABLE))
-                            .setDeleteIntent(PendingIntent.getBroadcast(mContext, 0,
-                                    new Intent(baseIntent).setAction(Constants.ACTION_HIDE),
-                                    PendingIntent.FLAG_IMMUTABLE))
-                            .setColor(mContext.getResources()
-                                    .getColor(
-                                            com.android.internal.R.color
-                                                    .system_notification_accent_color,
-                                            mContext.getTheme()))
-                            .setContentTitle(mContext.getText(
-                                    R.string.incoming_file_confirm_Notification_title))
-                            .setContentText(fileNameSafe)
-                            .setStyle(new Notification.BigTextStyle().bigText(mContext.getString(
-                                    R.string.incoming_file_confirm_Notification_content,
-                                    info.mDeviceName, fileNameSafe)))
-                            .setSubText(Formatter.formatFileSize(mContext, info.mTotalBytes))
-                            .setSmallIcon(R.drawable.bt_incomming_file_notification)
-                            .setLocalOnly(true)
-                            .build();
-            Notification n =
-                    new Notification.Builder(mContext, OPP_NOTIFICATION_CHANNEL).setOnlyAlertOnce(
-                            true)
-                            .setOngoing(true)
-                            .setWhen(info.mTimeStamp)
-                            // TODO(b/171825892) Please replace FLAG_MUTABLE_UNAUDITED below
-                            // with either FLAG_IMMUTABLE (recommended) or FLAG_MUTABLE.
-                            .setContentIntent(PendingIntent.getBroadcast(mContext, 0,
-                                    new Intent(baseIntent).setAction(
-                                            Constants.ACTION_INCOMING_FILE_CONFIRM),
-                                    PendingIntent.FLAG_IMMUTABLE))
-                            .setDeleteIntent(PendingIntent.getBroadcast(mContext, 0,
-                                    new Intent(baseIntent).setAction(Constants.ACTION_HIDE),
-                                    PendingIntent.FLAG_IMMUTABLE))
-                            .setColor(mContext.getResources()
-                                    .getColor(
-                                            com.android.internal.R.color
-                                                    .system_notification_accent_color,
-                                            mContext.getTheme()))
-                            .setContentTitle(mContext.getText(
-                                    R.string.incoming_file_confirm_Notification_title))
-                            .setContentText(fileNameSafe)
-                            .setStyle(new Notification.BigTextStyle().bigText(mContext.getString(
-                                    R.string.incoming_file_confirm_Notification_content,
-                                    info.mDeviceName, fileNameSafe)))
-                            .setSubText(Formatter.formatFileSize(mContext, info.mTotalBytes))
-                            .setSmallIcon(R.drawable.bt_incomming_file_notification)
-                            .setLocalOnly(true)
-                            .setVisibility(Notification.VISIBILITY_PRIVATE)
-                            .setPublicVersion(public_n)
-                            .build();
-            mNotificationMgr.notify(NOTIFICATION_ID_PROGRESS, n);
+                       //**
+                       Intent intent = new Intent(Constants.ACTION_INCOMING_FILE_CONFIRM);//
+
+                       intent.setClassName(Constants.THIS_PACKAGE_NAME, BluetoothOppReceiver.class.getName());
+                        
+                       intent.setDataAndNormalize(contentUri);
+                       mContext.sendBroadcast(intent);
+                       //**
+            // Intent baseIntent = new Intent().setDataAndNormalize(contentUri)
+                    // .setClassName(Constants.THIS_PACKAGE_NAME,
+                            // BluetoothOppReceiver.class.getName());
+            // Notification.Action actionDecline =
+                    // new Notification.Action.Builder(Icon.createWithResource(mContext,
+                            // R.drawable.ic_decline),
+                            // mContext.getText(R.string.incoming_file_confirm_cancel),
+                            // // TODO(b/171825892) Please replace FLAG_MUTABLE_UNAUDITED below
+                            // // with either FLAG_IMMUTABLE (recommended) or FLAG_MUTABLE.
+                            // PendingIntent.getBroadcast(mContext, 0,
+                                    // new Intent(baseIntent).setAction(Constants.ACTION_DECLINE),
+                                    // PendingIntent.FLAG_IMMUTABLE)).build();
+            // Notification.Action actionAccept = new Notification.Action.Builder(
+                    // Icon.createWithResource(mContext,R.drawable.ic_accept),
+                    // mContext.getText(R.string.incoming_file_confirm_ok),
+                    // // TODO(b/171825892) Please replace FLAG_MUTABLE_UNAUDITED below
+                    // // with either FLAG_IMMUTABLE (recommended) or FLAG_MUTABLE.
+                    // PendingIntent.getBroadcast(mContext, 0,
+                            // new Intent(baseIntent).setAction(Constants.ACTION_ACCEPT),
+                            // PendingIntent.FLAG_IMMUTABLE)).build();
+            // Notification public_n =
+                    // new Notification.Builder(mContext, OPP_NOTIFICATION_CHANNEL).setOnlyAlertOnce(
+                            // true)
+                            // .setOngoing(true)
+                            // .setWhen(info.mTimeStamp)
+                            // .addAction(actionDecline)
+                            // .addAction(actionAccept)
+                            // // TODO(b/171825892) Please replace FLAG_MUTABLE_UNAUDITED below
+                            // // with either FLAG_IMMUTABLE (recommended) or FLAG_MUTABLE.
+                            // .setContentIntent(PendingIntent.getBroadcast(mContext, 0,
+                                    // new Intent(baseIntent).setAction(
+                                            // Constants.ACTION_INCOMING_FILE_CONFIRM),
+                                    // PendingIntent.FLAG_IMMUTABLE))
+                            // .setDeleteIntent(PendingIntent.getBroadcast(mContext, 0,
+                                    // new Intent(baseIntent).setAction(Constants.ACTION_HIDE),
+                                    // PendingIntent.FLAG_IMMUTABLE))
+                            // .setColor(mContext.getResources()
+                                    // .getColor(
+                                            // com.android.internal.R.color
+                                                    // .system_notification_accent_color,
+                                            // mContext.getTheme()))
+                            // .setContentTitle(mContext.getText(
+                                    // R.string.incoming_file_confirm_Notification_title))
+                            // .setContentText(fileNameSafe)
+                            // .setStyle(new Notification.BigTextStyle().bigText(mContext.getString(
+                                    // R.string.incoming_file_confirm_Notification_content,
+                                    // info.mDeviceName, fileNameSafe)))
+                            // .setSubText(Formatter.formatFileSize(mContext, info.mTotalBytes))
+                            // .setSmallIcon(R.drawable.bt_incomming_file_notification)
+                            // .setLocalOnly(true)
+                            // .build();
+            // Notification n =
+                    // new Notification.Builder(mContext, OPP_NOTIFICATION_CHANNEL).setOnlyAlertOnce(
+                            // true)
+                            // .setOngoing(true)
+                            // .setWhen(info.mTimeStamp)
+                            // // TODO(b/171825892) Please replace FLAG_MUTABLE_UNAUDITED below
+                            // // with either FLAG_IMMUTABLE (recommended) or FLAG_MUTABLE.
+                            // .setContentIntent(PendingIntent.getBroadcast(mContext, 0,
+                                    // new Intent(baseIntent).setAction(
+                                            // Constants.ACTION_INCOMING_FILE_CONFIRM),
+                                    // PendingIntent.FLAG_IMMUTABLE))
+                            // .setDeleteIntent(PendingIntent.getBroadcast(mContext, 0,
+                                    // new Intent(baseIntent).setAction(Constants.ACTION_HIDE),
+                                    // PendingIntent.FLAG_IMMUTABLE))
+                            // .setColor(mContext.getResources()
+                                    // .getColor(
+                                            // com.android.internal.R.color
+                                                    // .system_notification_accent_color,
+                                            // mContext.getTheme()))
+                            // .setContentTitle(mContext.getText(
+                                    // R.string.incoming_file_confirm_Notification_title))
+                            // .setContentText(fileNameSafe)
+                            // .setStyle(new Notification.BigTextStyle().bigText(mContext.getString(
+                                    // R.string.incoming_file_confirm_Notification_content,
+                                    // info.mDeviceName, fileNameSafe)))
+                            // .setSubText(Formatter.formatFileSize(mContext, info.mTotalBytes))
+                            // .setSmallIcon(R.drawable.bt_incomming_file_notification)
+                            // .setLocalOnly(true)
+                            // .setVisibility(Notification.VISIBILITY_PRIVATE)
+                            // .setPublicVersion(public_n)
+                            // .build();
+            // mNotificationMgr.notify(NOTIFICATION_ID_PROGRESS, n);
         }
         cursor.close();
     }
(END)


路径：
./packages/apps/Bluetooth/src/com/android/bluetooth/opp/BluetoothOppIncomingFileConfirmActivity.java








