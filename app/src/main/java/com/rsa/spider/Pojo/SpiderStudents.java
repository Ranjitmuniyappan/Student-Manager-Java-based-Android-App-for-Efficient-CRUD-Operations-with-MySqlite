package com.rsa.spider.Pojo;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class SpiderStudents {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("class")
    @Expose
    private String _class;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("school_name")
    @Expose
    private String schoolName;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("blood_group")
    @Expose
    private String bloodGroup;
    @SerializedName("father_name")
    @Expose
    private String fatherName;
    @SerializedName("mother_name")
    @Expose
    private String motherName;
    @SerializedName("parents_contact")
    @Expose
    private String parentsContact;
    @SerializedName("address1")
    @Expose
    private String address1;
    @SerializedName("address2")
    @Expose
    private String address2;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("zip")
    @Expose
    private String zip;
    @SerializedName("emrgency_contact_no")
    @Expose
    private String emrgencyContactNo;
    @SerializedName("lattitude")
    @Expose
    private String lattitude;
    @SerializedName("longittude")
    @Expose
    private String longittude;

    public SpiderStudents(String name, String _class, String section, String schoolName, String gender, String dateOfBirth, String bloodGroup, String fatherName, String motherName, String parentsContact, String address1, String address2, String city, String state, String zip, String emrgencyContactNo, String lattitude, String longittude) {
        this.name = name;
        this._class = _class;
        this.section = section;
        this.schoolName = schoolName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.bloodGroup = bloodGroup;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.parentsContact = parentsContact;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.emrgencyContactNo = emrgencyContactNo;
        this.lattitude = lattitude;
        this.longittude = longittude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getParentsContact() {
        return parentsContact;
    }

    public void setParentsContact(String parentsContact) {
        this.parentsContact = parentsContact;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmrgencyContactNo() {
        return emrgencyContactNo;
    }

    public void setEmrgencyContactNo(String emrgencyContactNo) {
        this.emrgencyContactNo = emrgencyContactNo;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLongittude() {
        return longittude;
    }

    public void setLongittude(String longittude) {
        this.longittude = longittude;
    }

}

