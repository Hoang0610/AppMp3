package com.example.hoangmp3.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class QuangCao  implements Serializable {

@SerializedName("Idquangcao")
@Expose
private String idquangcao;
@SerializedName("Hinhanh")
@Expose
private String hinhanh;
@SerializedName("Noidung")
@Expose
private String noidung;
@SerializedName("Idbaihat")
@Expose
private String idbaihat;
@SerializedName("Tenbaihat")
@Expose
private String tenbaihat;
@SerializedName("Hinhbaihat")
@Expose
private String hinhbaihat;

public String getIdquangcao() {
return idquangcao;
}

public void setIdquangcao(String idquangcao) {
this.idquangcao = idquangcao;
}

public String getHinhanh() {
return hinhanh;
}

public void setHinhanh(String hinhanh) {
this.hinhanh = hinhanh;
}

public String getNoidung() {
return noidung;
}

public void setNoidung(String noidung) {
this.noidung = noidung;
}

public String getIdbaihat() {
return idbaihat;
}

public void setIdbaihat(String idbaihat) {
this.idbaihat = idbaihat;
}

public String getTenbaihat() {
return tenbaihat;
}

public void setTenbaihat(String tenbaihat) {
this.tenbaihat = tenbaihat;
}

public String getHinhbaihat() {
return hinhbaihat;
}

public void setHinhbaihat(String hinhbaihat) {
this.hinhbaihat = hinhbaihat;
}

}