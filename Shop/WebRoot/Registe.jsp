<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Registe.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
  .mystyle{
	        color:red
	  }
</style>
<script language="javascript">
function checkusername()
{
	var name = document.getElementById('user').value;
	var re = /^[a-zA-Z]+/;
	//return re.test(tel);
	 if(name.length>0)
    {
		var ret = re.test(name);
		if(!ret)
	   {
		   var stae = document.getElementById('div_2').style.display;
		   if(stae=="none")
		   {
			  //  alert('用户名以字母开头');
			   document.getElementById('div_2').style.display = "inline";
		   }else{
			   stae = "none";
		   }
		
		}
	} 
}
 function zhuce()
 {
	 var t = new Date();
	  alert(t.getTime());
	 suer=document.getElementById( "suer").text;
	 if(document.getElementById("user").value=="")
	 {
		document.getElementById("div_nicheng").style.display="inline";
			
	  }
	  document.all('user').value;
	  var mes = "您的注册信息：\n";
	  var t = document.getElementsByName('cmb_aihao');
	  var chose="\n";
	for(var i=0;i<t.length;i++)
	{
		if(t[i].checked)
		{
			//多选
			chose=chose+t[i].value+"\n";
			}
	}
	var rad = document.getElementsByName('sex');
	var sess="";
	for(var i = 0 ; i<rad.length ; i++)
	{
		if(rad[i].checked)
		{
			sess = rad[i].value;
			break;
		}
		
	}

	mes = mes + "昵称："+ suer +'\n' +  "密码：" + document.getElementById('pwd').value + '\n' + "性别:"+sess + '\n' + '爱好:' + chose;
	window.confirm(mes);
	//window.confirm('爱好:'+chose);
 }
  function changeFocus(event)
  {
   
/*判断按下回车键的控件类型：不能是提交、重置按钮等类型*/      
if (event.keyCode==13  )
	  
	     //$event.keyCode=9;


 onkeypress = "changeFocus(9)"
 alert(event.keyCode);
  }
   function check(event)
 {

    //keyCode是event事件的属性,对应键盘上的按键,回车键是13,tab键是9,其它的如果不知道 ,查keyCode大全
  if(event.keyCode==13&&event.srcElement.type=="text")
  {

    //srcElement是触发事件的对象,type意思是什么类型
     event.keyCode=9;
  }
 }
   //document.onkeydown=check;
 // window.document.onkeypress = changeFocus;  //dcument对象的onkeydown事件
 function t()
 {
	 var v = window.dialogArguments;
	 document.getElementById('user').value=v;
	 var str = document.forms;
	 for(var i=0;i<str.length;i++)
	 {
		  console.log(i);
	 }
	
	 
 }
 function tt()
 {
	 alert("ok");
	 window.returnValue=document.getElementById('user').value;
	window.close(); 
 }
</script>
  </head>
   
<body onload="t()" >
<form action="userServlet.action">
 <input type="hidden" name="op" value="add"> 
<div style="position:absolute">
        <table border="1" cellpadding="2">
          <tr>
              <td align="center" colspan="2">拍拍用户注册<br /><br />  </td>
          </tr>
          <tr>
              <td>  昵称：</td>
              <td><input  type="text" name="nicheng" id="user" onfocus="checkusername()" onfocusout="checkusername()"/>
                  <div style="display:none" id="div_nicheng" class="mystyle"> 昵称不能为空</div>
                  <div style="display:none" id="div_2" class="mystyle"> 昵称以字母开头</div>
              </td>
          </tr>
          <tr >
              <td> 密码：</td>
              <td><input type="text" name="pwd" id="pwd" /></td>
          </tr>
           <tr>
              <td>确认密码：</td>
              <td><input type="text" name="suerpwd" id="suerpwd"/></td>
          </tr>
           <tr>
              <td>密保问题：</td>
              <td><select>
            <option>请选择一个问题</option>
            <option>父亲姓名</option>
            <option>母亲姓名</option>
            <option>小学老师姓名</option>
             </select></td>
          </tr>
           <tr>
              <td>性别：</td>
              <td><input type="radio" name="sex" id="sex" value="男"/>男
         <input type="radio" name="sex" id="sex" value="女"/>女</td>
          </tr>
          <tr>
               <td>
                    <font size="4">
             请选择关注的商品详情：<br />
         </font>
             <input type="checkbox" name="cmb_aihao" value="数码产品">数码产品
             <input type="checkbox" name="cmb_aihao" value="运动系列">运动系列<br />
             <input type="checkbox" name="cmb_aihao" value="家居用品">家居用品
             <input type="checkbox" name="cmb_aihao" value="音像制品">音像制品<br />
               </td>
          </tr>
           <tr align="center">
              <td> 
                  <input type="submit" value=" 注册"> 
              <!--  <button name="suer" id="suer" value="注册" onclick="zhuce()" >注册</button> --></td>
              <td><button name="reset" id="reset" value="重置">重置</button></td>
              
          </tr>
          <tr>
              <td> 
                   <textarea name="txtarea" cols="30" rows="5">
          嘎嘎发嘎嘎发的回复的呵呵呵呵他合格和法国规定符合发的话
          护手霜色号是恶化时多喝水的</textarea>
              </td>
          </tr>
        </table>
</div>  
   </form>
  </body>
</html>
