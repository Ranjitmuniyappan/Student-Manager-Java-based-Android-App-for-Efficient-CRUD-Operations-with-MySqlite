package com.rsa.spider.AddStudent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.rsa.spider.Constant.Iconstant;
import com.rsa.spider.Gps.GPSTracker;
import com.rsa.spider.Login.Login;
import com.rsa.spider.Pojo.SpiderStudents;
import com.rsa.spider.R;
import com.rsa.spider.Retrofit.ApiClient;
import com.rsa.spider.Retrofit.ApiInterface;
import com.rsa.spider.Util.UtilityManager;

import java.util.List;

public class NewStudent extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static int PLACE_PICKER_REQUEST = 1;
    GPSTracker gps;
    Context context;
    ApiInterface apiInterface;
    private static final String TAG = "StudentRegister";

    String[] mClass = { "1","2","3","4","5","6","7","8","9","10","11","12"};
    String[] section = { "A", "B", "C", "D", "E"};

    Spinner classData;
    Spinner sectionData;

    RadioGroup radioGroup;
    RadioButton radioButton;


    String cls = "", sec = "";

    EditText name,schlName,dob,bldGroup,fatherName,motherName,parentCatactNo,address1,address2,city,state,zip,emrgContactNo,location;
    Button Register;

    EditText latlong;
    ImageView getLocation;

    //Datas to be send
    double lat, lng;
    String gender= "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);

        context = NewStudent.this;
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        classData = (Spinner) findViewById(R.id.classs);
        classData.setOnItemSelectedListener(this);
        ArrayAdapter classSpin = new ArrayAdapter(context ,android.R.layout.simple_spinner_item, mClass);
        classSpin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classData.setAdapter(classSpin);

        sectionData = (Spinner) findViewById(R.id.section);
        sectionData.setOnItemSelectedListener(this);
        ArrayAdapter sectionSpin = new ArrayAdapter(context ,android.R.layout.simple_spinner_item, section);
        sectionSpin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sectionData.setAdapter(sectionSpin);

        name = (EditText) findViewById(R.id.Name);
        schlName = (EditText) findViewById(R.id.SchoolName);
        dob = (EditText) findViewById(R.id.DateOfBirth);
        bldGroup = (EditText) findViewById(R.id.BloodGroup);
        fatherName = (EditText) findViewById(R.id.FatherName);
        motherName = (EditText) findViewById(R.id.MotherName);
        parentCatactNo = (EditText) findViewById(R.id.ParentContactNo);
        address1 = (EditText) findViewById(R.id.AddressOne);
        address2 = (EditText) findViewById(R.id.AddressTwo);
        city = (EditText) findViewById(R.id.City);
        state = (EditText) findViewById(R.id.State);
        zip = (EditText) findViewById(R.id.Zip);
        emrgContactNo = (EditText) findViewById(R.id.EmergencyContactNo);
        location = (EditText) findViewById(R.id.AddLocation);

        Register = (Button) findViewById(R.id.register);
        latlong = (EditText) findViewById(R.id.AddLocation);
        getLocation = (ImageView) findViewById(R.id.getLocation);

        radioGroup = findViewById(R.id.gender);



        getLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                gps = new GPSTracker(getApplicationContext());

                if(gps.canGetLocation()){

                    lat = gps.getLatitude();
                    lng = gps.getLongitude();


                }else{

                    gps.showSettingsAlert();
                }

                latlong.setText("Lat :"+lat+" Long:"+lng);
            }
        });

        //Data Submitter
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                gender = radioButton.getText().toString();

                //name,schlName,dob,bldGroup,fatherName,motherName,parentCatactNo,address1,address2,city,state,zip,emrgContactNo,location
                String Name = name.getText().toString();
                String Class = cls;
                String Section = sec;
                String SchoolName = schlName.getText().toString();
                String Gender = gender;
                String DateOfBirth = dob.getText().toString();
                String BloodGroup = bldGroup.getText().toString();
                String FatherName = fatherName.getText().toString();
                String MotherName = motherName.getText().toString();
                String ParentContactNo = parentCatactNo.getText().toString();
                String Address1 = address1.getText().toString();
                String Address2 = address2.getText().toString();
                String City = city.getText().toString();
                String State = state.getText().toString();
                String Zip = zip.getText().toString();
                String EmergencyContactNo = emrgContactNo.getText().toString();
                String Lattitude = String.valueOf(lat);
                String Longitude = String.valueOf(lng);

                SpiderStudents obj = new SpiderStudents(Name,Class,Section,SchoolName,Gender,DateOfBirth,BloodGroup,FatherName,MotherName,ParentContactNo,Address1,Address2,City,State,Zip,EmergencyContactNo,Lattitude,Longitude);


                putRegistration(obj);

            }
        });


    }






    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

        Spinner spin = (Spinner)parent;
        Spinner spin2 = (Spinner)parent;

        if(spin.getId() == R.id.classs)
        {
            if (!cls.equals("") || !cls.equals(null))
            {
                cls = mClass[position];
            }
            //Toast.makeText(this, "Your choose :" + mClass[position],Toast.LENGTH_SHORT).show();
        }
        if(spin2.getId() == R.id.section)
        {
            if (!sec.equals("") || !sec.equals(null))
            {
                sec = section[position];
            }
            //Toast.makeText(this, "Your choose :" + section[position],Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void addNewStudent()
    {

    }


    public void putRegistration(SpiderStudents student)
    {
        if (UtilityManager.isConnectingToInternet(context))
        {
            Call<String> call = apiInterface.register(Iconstant.register,
                    student.getName(),
                    student.getClass_(),
                    student.getSection(),
                    student.getSchoolName(),
                    student.getGender(),
                    student.getDateOfBirth(),
                    student.getBloodGroup(),
                    student.getFatherName(),
                    student.getMotherName(),
                    student.getParentsContact(),
                    student.getAddress1(),
                    student.getAddress2(),
                    student.getCity(),
                    student.getState(),
                    student.getZip(),
                    student.getEmrgencyContactNo(),
                    student.getLattitude(),
                    student.getLongittude());

            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Log.d(TAG, "onResponse_output : " + response.body());

                    startActivity(new Intent(NewStudent.this, Login.class));
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d(TAG, "onResponse_error  : Somthing went wrong! "+t );
                }
            });
        }else {

            Toast.makeText(context, "Please Check your Internet!", Toast.LENGTH_SHORT).show();
        }
    }
}