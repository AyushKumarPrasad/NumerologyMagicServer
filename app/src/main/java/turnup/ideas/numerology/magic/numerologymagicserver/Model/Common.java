package turnup.ideas.numerology.magic.numerologymagicserver.Model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import turnup.ideas.numerology.magic.numerologymagicserver.Notification.APIService;
import turnup.ideas.numerology.magic.numerologymagicserver.Notification.FCMRetrofitClient;
import turnup.ideas.numerology.magic.numerologymagicserver.Notification.RetrofitClient;


public class Common
{
    public static User currentUser;

    public static String PHONE_TEXT = "userPhone" ;

    public static final String UPDATE = "Update";

    public static final String DELETE = "Delete";

    public static final int PICK_IMAGE_REQUEST = 71 ;

    public static final String baseUrl = "https://maps.googleapis.com";

    public static final String fcmUrl = "https://fcm.googleapis.com/";

    //   public static final String DELETE = "Delete" ;
    public static final String USER_KEY = "User" ;
    public static final String PWD_KEY = "Password" ;

    public static APIService getFCMClient()
    {
        return FCMRetrofitClient.getClient(fcmUrl).create(APIService.class);
    }

    public static boolean isConnectedToInternet(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null)
        {
            NetworkInfo [] info = connectivityManager.getAllNetworkInfo();
            if (info != null)
            {
                for (int i = 0 ; i < info.length; i++)
                {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                        return true;
                }
            }
        }
        return false ;
    }

}
