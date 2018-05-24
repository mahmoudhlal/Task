package com.hlal.m7moud.task.Remote;

import android.graphics.Bitmap;

import com.hlal.m7moud.task.Shop.ShopItems;

import java.util.Calendar;
import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface UserService {




    @POST("api/v1/shopsList")
    Call<ShopItems> getMarkets(@Query("destination_lat")String lat ,
                               @Query("destination_long")String lon);




  /*
    //region LoginMethod
    @POST("api/login")
    Call<LoginUser> LoginMethod(
            @Query("email") String Username,
            @Query("password") String Password
    );
    //endregion


    //region GetAllLabs
    @GET("api/location")
    Call<AllLabsClass> AllLabs(
            @Query("api_token") String Api_token
    );
    //endregion


    //region AddSession
    @POST("api/session")
    Call<AllSessionsClass> AddSession(
            @Query("courseName") String courseName,
            @Query("labID") int labID,
            @Query("time") String time,
            @Query("notes") String notes,
            @Query("api_token") String Api_token
    );
    //endregion


    //region ReturnAllSession
    @POST("api/session/tutorByDate")
    Call<AllSessionsClass> GetSessionOfDayForDoctor(
            @Query("date") String date,
            @Query("api_token") String Api_token
    );
    //endregion


    //region ReturnAttendsOfSession
    @POST("api/attend/show")
    Call<AllAttendsClass> getAttendsSession(
            @Query("id") int date,
            @Query("api_token") String Api_token
    );
    //endregion


    //region ReturnStudentAttendsOfTutorSessions
    @POST("api/attend/byTutor")
    Call<AllAttendsClass> getStudentAttendsOfTutorSessions(
            @Query("student") String studentID,
            @Query("tutor") String tutorID,
            @Query("api_token") String Api_token
    );
    //endregion


    //region SetAttend
    @POST("api/attend")
    Call<MessageClass> SetAttend(
            @Query("student") String studentUid,
            @Query("api_token") String Api_token,
            @Query("SessionID") int swssionId
    );
    //endregion


    //region DeleteAttend
    @POST("api/attend/delete")
    Call<MessageClass> DeleteAttend(
            @Query("student") int studentUid,
            @Query("api_token") String Api_token,
            @Query("session") int swssionId
    );
    //endregion


    //region SearchAttend
    @POST("api/attend/isAttend")
    Call<MessageClass> SearchAttend(
            @Query("student") String studentUid,
            @Query("api_token") String Api_token,
            @Query("session") String swssionId
    );
    //endregion


    //region ReturnTodaySessionForStudent
    @POST("api/session/byDate")
    Call<AllSessionsClass> GetTodaySessions(
            @Query("date") String date,
            @Query("api_token") String Api_token
    );
    //endregion


    //region SessionForStudentOnDate
    @POST("api/attend/byDate")
    Call<StudentAllAttendsClass> GetSessionsOnDateForStudent(
            @Query("date") String date,
            @Query("api_token") String Api_token
    );
    //endregion


    //region ChangePassword
    @POST("api/password")
    Call<MessageClass> ChangePassword(
            @Query("password") String Password,
            @Query("api_token") String Api_token,
            @Query("old_password") String oldPassword
    );
    //endregion

    //region CheckQR
    @POST("api/attend")
    Call<MessageClass> CheckQR(
            @Query("SessionID") String SessionID,
            @Query("api_token") String Api_token,
            @Query("token") String token
    );


    //region setMacAddress
    @POST("api/MAC")
    Call<MessageClass> setMacAddress(
            @Query("uuid") String studentUuid,
            @Query("api_token") String Api_token,
            @Query("MAC") String mac
    );

    //region UploadImages4
    @Multipart
    @POST("api/images")
    Call<MessageClass> UploadImages(
            @Query("uuid") String studentUuid,
            @Query("api_token") String Api_token,
            @Query("images[]") MultipartBody.Part file
    );


    @GET("api/place/autocomplete/json?types=establishment&key=AIzaSyCgqFwlZrNXFzDwu3Mj3cCshZ0ls9RPBPI")
    Call<Example>Auto(
            @Query("input") String s
    );

    */


}
