// 请您携带好本人身份证原件或户口本原件(限儿童)及所有既往就诊资料，有条形码和二维码的自费患者，至]诊各楼层自助机签到。超过预约时段不保留号源，爽约后不得退号。请保留短信以资凭证，转发短信无效。如需取消，请在就诊当日0点前取消预约。请保持手机畅通，就诊时请带好本人病历本，挂号费以医院
// 实际收费为准
function popBox(){
    var popBox=document.getElementById("popBox");
    var popLayer = document.getElementById("popLayer");
    popBox.style.display="block";
    popLayer.style.display="block";
}
function closeBox(){
    var popBox=document.getElementById("popBox");
    var popLayer = document.getElementById("popLayer");
    popBox.style.display="none";
    popLayer.style.display="none";
}