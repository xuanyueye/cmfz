<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="inputForm" method="post">
        <div style="margin-top: 70px;">
            <input name="id" value="id" type="hidden" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            姓名:<input  name="name" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            年龄:<input  name="age" class="easyui-numberbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            生日:<input  name="birthday" class="easyui-datebox" data-options="required:true"/><br/>
        </div>
    </form>
</div>
<script>

    $(function(){
       //构建子页面元素的操作
        console.log("${param.id}");
        $("#inputForm").form('load','${pageContext.request.contextPath}/user/queryOne?id=${param.id}');

    });



</script>

