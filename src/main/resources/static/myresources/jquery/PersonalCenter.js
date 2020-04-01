var nav_body=document.getElementsByClassName("nav_body");
function showOrderList(){
    var orderdiv= document.getElementById("orderdiv");
    orderdiv.style.display="block";
    questiondiv.style.display="none";
    carediv.style.display="none";
    walletdiv.style.display="none";
    Setupdiv.style.display="none";
    Requestdiv.style.display="none";
    nav_body[0].style.backgroundColor="rgba(94, 210, 214, 0.37)";
    nav_body[0].style.borderLeft="4px #6cdde1 solid";
    nav_body[0].style.paddingLeft="81px";
    nav_body[1].style="none";
    nav_body[2].style="none";
    nav_body[3].style="none";
    nav_body[4].style="none";
    nav_body[5].style="none";
}

function  showQuestionList(){
    var questiondiv=document.getElementById("questiondiv");
    questiondiv.style.display="block";
    orderdiv.style.display="none";
    carediv.style.display="none";
    walletdiv.style.display="none";
    Setupdiv.style.display="none";
    Requestdiv.style.display="none";
    nav_body[1].style.backgroundColor="rgba(94, 210, 214, 0.37)";
    nav_body[1].style.borderLeft="4px #6cdde1 solid";
    nav_body[1].style.paddingLeft="81px";
    nav_body[0].style="none";
    nav_body[2].style="none";
    nav_body[3].style="none";
    nav_body[4].style="none";
    nav_body[5].style="none";
}
function showFree(){
    var freeList=document.getElementById("freeList");
    var freeListdiv=document.getElementById("freeListdiv");
    freeListdiv.style.display="block";
    notFreeListdiv.style.display="none";
    freeList.style.color="#6cdde1";
    freeList.style.borderBottom="#6cdde1 2px solid";
    notFreeList.style="none";
}
function showNotFree(){
    var notFreeList=document.getElementById("notFreeList");
    var notFreeListdiv=document.getElementById("notFreeListdiv");
    notFreeListdiv.style.display="block";
    freeListdiv.style.display="none";
    notFreeList.style.color="#6cdde1";
    notFreeList.style.borderBottom="#6cdde1 2px solid";
    freeList.style.color="#C2C2C2";
    freeList.style.borderBottom="none";
}
function showCare(){
    var carediv=document.getElementById("carediv");
    carediv.style.display="block";
    questiondiv.style.display="none";
    orderdiv.style.display="none";
    walletdiv.style.display="none";
    Setupdiv.style.display="none";
    Requestdiv.style.display="none";
    nav_body[2].style.backgroundColor="rgba(94, 210, 214, 0.37)";
    nav_body[2].style.borderLeft="4px #6cdde1 solid";
    nav_body[2].style.paddingLeft="81px";
    nav_body[0].style="none";
    nav_body[1].style="none";
    nav_body[3].style="none";
    nav_body[4].style="none";
    nav_body[5].style="none";
}
function showDoctor(){
    var doctordiv=document.getElementById("doctordiv");
    var doctorList=document.getElementById("doctorList");
    var hospitalList=document.getElementById("hospitalList");
    doctordiv.style.display="block";
    hospitaldiv.style.display="none";
    doctorList.style.color="#6cdde1";
    doctorList.style.borderBottom="#6cdde1 2px solid";
    hospitalList.style="none";
}
function showHospital(){
    var hospitaldiv=document.getElementById("hospitaldiv");
    hospitaldiv.style.display="block";
    doctordiv.style.display="none";
    hospitalList.style.color="#6cdde1";
    hospitalList.style.borderBottom="#6cdde1 2px solid";
    doctorList.style.color="#C2C2C2";
    doctorList.style.borderBottom="none";
}
function showWallet(){
    var walletdiv=document.getElementById("walletdiv");
    walletdiv.style.display="block";
    carediv.style.display="none";
    questiondiv.style.display="none";
    orderdiv.style.display="none";
    Setupdiv.style.display="none";
    Requestdiv.style.display="none";
    nav_body[3].style.backgroundColor="rgba(94, 210, 214, 0.37)";
    nav_body[3].style.borderLeft="4px #6cdde1 solid";
    nav_body[3].style.paddingLeft="81px";
    nav_body[0].style="none";
    nav_body[1].style="none";
    nav_body[2].style="none";
    nav_body[4].style="none";
    nav_body[5].style="none";
}
function showSetup(){
    var Setupdiv=document.getElementById("Setupdiv");
    Setupdiv.style.display="block";
    walletdiv.style.display="none";
    carediv.style.display="none";
    questiondiv.style.display="none";
    orderdiv.style.display="none";
    Requestdiv.style.display="none";
    nav_body[4].style.backgroundColor="rgba(94, 210, 214, 0.37)";
    nav_body[4].style.borderLeft="4px #6cdde1 solid";
    nav_body[4].style.paddingLeft="81px";
    nav_body[1].style="none";
    nav_body[2].style="none";
    nav_body[3].style="none";
    nav_body[0].style="none";
    nav_body[5].style="none";
}
function showRequest(){
    var Requestdiv=document.getElementById("Requestdiv");
    Requestdiv.style.display="block";
    Setupdiv.style.display="none";
    walletdiv.style.display="none";
    carediv.style.display="none";
    questiondiv.style.display="none";
    orderdiv.style.display="none";
    nav_body[5].style.backgroundColor="rgba(94, 210, 214, 0.37)";
    nav_body[5].style.borderLeft="4px #6cdde1 solid";
    nav_body[5].style.paddingLeft="81px";
    nav_body[1].style="none";
    nav_body[2].style="none";
    nav_body[3].style="none";
    nav_body[4].style="none";
    nav_body[0].style="none";
}
function showUserInfo(){
    var userInfo=document.getElementById("userInfo");
    var userInfodiv=document.getElementById("userInfodiv");
    userInfodiv.style.display="block";
    upsetPassworddiv.style.display="none";
    setHeaddiv.style.display="none";
    userInfo.style.color="#6cdde1";
    userInfo.style.borderBottom="#6cdde1 2px solid";
    upsetPassword.style="none";
    setHead.style="none";
}
function showUpsetPassword(){
    var upsetPassword=document.getElementById("upsetPassword");
    var upsetPassworddiv=document.getElementById("upsetPassworddiv");
    upsetPassworddiv.style.display="block";
    userInfodiv.style.display="none";
    setHeaddiv.style.display="none";
    upsetPassword.style.color="#6cdde1";
    upsetPassword.style.borderBottom="#6cdde1 2px solid";
    userInfo.style.color="#C2C2C2";
    userInfo.style.borderBottom="none";
    setHead.style.color="#C2C2C2";
    setHead.style.borderBottom="none";
}
function showSetHead(){
    var setHead=document.getElementById("setHead");
    var setHeaddiv=document.getElementById("setHeaddiv");
    setHeaddiv.style.display="block";
    userInfodiv.style.display="none";
    upsetPassworddiv.style.display="none";
    setHead.style.color="#6cdde1";
    setHead.style.borderBottom="#6cdde1 2px solid";
    userInfo.style.color="#C2C2C2";
    userInfo.style.borderBottom="none";
    upsetPassword.style.color="#C2C2C2";
    upsetPassword.style.borderBottom="none";
}
