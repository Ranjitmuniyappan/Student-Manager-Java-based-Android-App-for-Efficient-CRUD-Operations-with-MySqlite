package com.rsa.spider.Retrofit;

import com.rsa.spider.Pojo.SpiderStudents;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("webservice.php")
    Call<String> register(@Field("module") String module,
                                        @Field("name") String name,
                                        @Field("class") String mclass,
                                        @Field("section") String section,
                                        @Field("school_name") String school_name,
                                        @Field("gender") String gender,
                                        @Field("date_of_birth") String date_of_birth,
                                        @Field("blood_group") String blood_group,
                                        @Field("father_name") String father_name,
                                        @Field("mother_name") String mother_name,
                                        @Field("parents_contact") String parents_contact,
                                        @Field("address1") String address1,
                                        @Field("address2") String address2,
                                        @Field("city") String city,
                                        @Field("state") String state,
                                        @Field("zip") String zip,
                                        @Field("emrgency_contact_no") String emrgency_contact_no,
                                        @Field("lattitude") String lattitude,
                                        @Field("longittude") String longittude);

}
