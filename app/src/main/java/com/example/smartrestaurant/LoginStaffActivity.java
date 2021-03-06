package com.example.smartrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginStaffActivity extends AppCompatActivity {
    EditText edtAccountLogin,edtPasswordLogin;
    Button btnLoginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_staff);
        AnhXa();
        Onclick();
    }

    private void Onclick() {
        btnLoginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ArrayList<User> userArrayList = new ArrayList<>();
//
//                User userAdmin =
//                        new User("Admin","123456789","Quản Lý");
//                userArrayList.add(userAdmin);
//                User userStaff =
//                        new User("Staff1","123456789","Nhân Viên");
//                userArrayList.add(userStaff);
                String accountName = edtAccountLogin.getText().toString().trim();
                String passwordName = edtPasswordLogin.getText().toString().trim();
//                for (int i = 0;i < userArrayList.size();i++){
//                    if (userArrayList.get(i).getmAccount().equals(accountName) &&
//                    userArrayList.get(i).getmPassword().equals(passwordName)){
//                        Intent intent = new Intent(LoginStaffActivity.this,HomeStaffActivity.class);
//                        startActivity(intent);
//                        finish();
//                        Toast.makeText(LoginStaffActivity.this
//                                ,"Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
//                        break;
//
//                    }else {
//                        Toast.makeText(LoginStaffActivity.this
//                                ,"Đăng nhập thất bại,xin hãy kiểm tra tài khoản và mật khẩu"
//                                ,Toast.LENGTH_SHORT).show();
//                        edtAccountLogin.setText("");
//                        edtPasswordLogin.setText("");
//                    }
//                }
              Account account =  new Account();
              account.setPassword(passwordName);
              account.setUserName(accountName);
                ServiceAPI.apiService.login(account).enqueue(new Callback<LoginDTO>() {
                    @Override
                    public void onResponse(Call<LoginDTO> call, Response<LoginDTO> response) {
                        LoginDTO loginDTO = response.body();
                        Toast.makeText(LoginStaffActivity.this,loginDTO + "",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<LoginDTO> call, Throwable t) {
                        Toast.makeText(LoginStaffActivity.this,"Sai Tai Khoan",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


    private void AnhXa() {
        edtAccountLogin = (EditText) findViewById(R.id.edt_LoginAccount);
        edtPasswordLogin = (EditText) findViewById(R.id.edt_LoginPassword);
        btnLoginUser = (Button) findViewById(R.id.btn_LoginAccount);
    }
}