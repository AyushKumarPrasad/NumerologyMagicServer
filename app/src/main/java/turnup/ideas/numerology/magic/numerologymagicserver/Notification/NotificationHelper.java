package turnup.ideas.numerology.magic.numerologymagicserver.Notification;


import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Build;

import turnup.ideas.numerology.magic.numerologymagicserver.R;

public class NotificationHelper extends ContextWrapper
{
    private static final String EDMT_CHANNEL_ID = "limited.pvt.global.stachi.glisteradmin.app.Ayush" ;
    private static final String EDMT_CHANNEL_NAME = "Glister Gps" ;

    private NotificationManager manager ;

    public NotificationHelper(Context base) {
        super(base);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            createChannel() ;
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel()
    {
        NotificationChannel edmtChannel = new NotificationChannel(EDMT_CHANNEL_ID , EDMT_CHANNEL_NAME
                , NotificationManager.IMPORTANCE_MIN) ;

        edmtChannel.enableLights(false);
        edmtChannel.enableVibration(true);
        edmtChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(edmtChannel);
    }

    public NotificationManager getManager()
    {
        if (manager == null)
            manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE) ;

        return  manager ;
    }

    @TargetApi(Build.VERSION_CODES.O)
    public Notification.Builder getEatItChannelNotification(String title , String body ,
                                                                        PendingIntent contentIntent , Uri soundUri)
    {
        return new Notification.Builder(getApplicationContext() , EDMT_CHANNEL_ID)
                .setContentIntent(contentIntent)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.mipmap.logo)
         //       .setSound(soundUri)
                .setAutoCancel(false);
    }
}