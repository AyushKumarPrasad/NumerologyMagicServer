package turnup.ideas.numerology.magic.numerologymagicserver.Notification;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService
{
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAdWBNYNg:APA91bG2EZesZqBACzsN1MiSWhZ-v98schBmM-2syGwbOBezJjT0fFppea82lXcH2zfjRoOPmKo2RXpx8K-hpTfxCpVknyFVjFB2MrIjFp0Th6--EK_tz0rIVnJZR9AMgEmOIvUUZ3cN"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}

