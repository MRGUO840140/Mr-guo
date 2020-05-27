package com.example.healthcare;

import com.example.healthcare.Service.HospitalService;
import com.example.healthcare.Service.IUserService;
import com.example.healthcare.bean.*;
import com.example.healthcare.mapper.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HealthcareApplicationTests {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private HospitalMapper hospitalMapper;
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private PriceMapper priceMapper;
    @Autowired
    private IUserMapper iUserMapper;
    @Autowired
    private  OrdinglistMapper ordinglistMapper;

    @Test
    public void test01(){
        User user = new User();
        user.setUid("143cd4aa-deb7-11e9-bb5d-08606edc9819");
        user.setUcount(25.0);
        iUserMapper.UpdateUserCount(user);
    }
    @Test
    public void TestO(){
        List<Doctor> sameDoc = doctorMapper.getSameDoc(1);
        for(Doctor d:sameDoc){
            System.out.println(sameDoc);
        }
    }

    @Test
    public void TestOrd(){
        List<Ordinglist> ords = ordinglistMapper.getOrds("143cd4aa-deb7-11e9-bb5d-08606edc9819");
        for (Ordinglist ordinglist:ords) {
            System.out.println(ordinglist.getOrdingId()+ordinglist.getDoctor().getDName()+ordinglist.getUser()+ordinglist.getIsPay()+ordinglist.getPrice().getPrice());
            System.out.println(ordinglist.getTime().getData()+ordinglist.getTime().getMorAfter());
        }
    }
    @Test
    public void TestInfo(){
        iUserMapper.InsertUserInfo("12345678911","王五啊","123456789876543212","1");
    }

    @Test
    public void TestPrice(){
//        挂号测试
        Price priceByGuhao = priceMapper.getPriceByGuhao(1);
        Price priceByChat = priceMapper.getPriceByChat(1);
        Price priceByTuwen = priceMapper.getPriceByTuwen(1);
        Price priceByFast = priceMapper.getPriceByFast(1);
        System.out.println(priceByGuhao);
        System.out.println(priceByChat);
        System.out.println(priceByTuwen);
        System.out.println(priceByFast);
    }

    @Test
    public void testDocInfo(){
        Doctor doc = doctorMapper.getDoc("1");
        System.out.println(doc);
    }

    @Test
    public void testInfo(){
        Hospital docInfo = hospitalMapper.getDocInfo(1, 1,1);
        System.out.println(docInfo);
        List<Doctor> doctors = docInfo.getDoctors();
        for(Doctor doctor:doctors){
            doctor.getDisease().getArticle();
        }
    }

    @Test
    public void testSubject(){
        Subject sub = subjectMapper.getDiseases("内科");
        System.out.println(sub);
        System.out.println(sub.getDiseases());
    }

    @Test
    public void contextLoads() {
        //iUserService.Insert(new User("张三","男","123","18151130050","321084199710103615",1000.00));
    }

    @Test
    public void getUser(){
        User user=new User();
        user.setUname("张三");
        user.setUpassword("123");
        User login = iUserService.Login(user);
        System.out.println(login);
    }
    @Test
    public void lala(){
        List<Hospital> list = hospitalService.getHospital("苏州");
        System.out.println(list);
    }
}
