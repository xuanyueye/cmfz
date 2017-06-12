<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>




    <script>
        var $dg,$da;
        $(function () {
            $da=$("#userDa");
            $dg=$("#userDg");
            $dg.datagrid({
                url:'/easyui_stu/user/queryAllByPage',
                width:'100%',
                height:'100%',
                columns:[[
                    {title: "编号", field: "id", width: 200, align: 'center'},
                    {title: "姓名", field: "name", width: 200, align: 'center'},
                    {title: "年龄", field: "age", width: 200, align: 'center'},
                    {title: "生日", field: "birthday", width: 200, align: 'center'},
                    {
                        title: "操作", field: "options", width: 300, align: 'center',
                        formatter: function (value, row, index) {
                            return "<a class='del' onClick=\"del('" + row.id + "')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                                    "<a class='edit' onClick=\"edit('" + row.id + "')\"  href='javascript:;'>修改</a>";
                        }
                    }

                ]],
                onLoadSuccess:function(data){
                    $(".del").linkbutton({
                        plain:true,
                        iconCls:'icon-remove'
                    });
                    $(".edit").linkbutton({
                        plain:true,
                        iconCls:'icon-edit'
                    });
                },
                pagination:true,
                method:'get',
                pageNumber:1,
                pageSize:2,
                pageList:[2,4,6,8,10],
                toolbar:'#tb',
                fitColumns:true,


            });


        });
        //删除的操作
        function del(id){
            $.messager.confirm("提示","您确定删除吗？",function (r) {
               if(r){
                   //发送异步请求删除数据
                   $.post("${pageContext.request.contextPath}/user/remove",{"id":id});
                   console.log("删除");
                   $dg.datagrid("reload");
               }
            });
        }
        //添加的操作
        function userAdd() {
            $da.dialog({
                width:600,
                height:300,
                title:"添加用户",
                iconCls:"icon-add",
                href:'${pageContext.request.contextPath}/manager/user/userAdd.jsp',
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:saveUser,
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:closeDa,
                }],

            });
        }

        //修改的操作
        function edit(id) {
            console.log("修改"),
            $da.dialog({
                width:600,
                height:300,
                title:"员工的详细信息",
                iconCls:"icon-man",
                href:'${pageContext.request.contextPath}/manager/user/userEdit.jsp?id='+id,
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:updateUser,
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:closeDa,
                }],

            });
        }
        //保存用户(修改)
        function updateUser(){
            $("#inputForm").form('submit',{
                url:'${pageContext.request.contextPath}/user/change',
                success:function(){
                    $da.dialog('close',true);
                    $dg.datagrid('reload');
                }
            })
        }
        //保存用户（添加）
        function saveUser(){
            $("#addForm").form('submit',{
                url:'${pageContext.request.contextPath}/user/add',
                success:function(){
                    $da.dialog('close',true);
                    $dg.datagrid('reload');
                }
            })
        }

        //关闭对话框
        function closeDa() {
            $da.dialog('close',true);
        }


        //搜索的处理程序
        function search(value,name){
            console.log(value);
            console.log(name);
            $dg.datagrid('load',{
                name:value
            });
        }

    </script>



    <div class="easyui-layout"data-options="fit:true">
        <div data-options="region:'north'," style="height:50px;">
            <div style="text-align: center;margin: 10px 0px 10px 0px;">
                <input id="ss" class="easyui-searchbox" style="width:300px"
                       data-options="searcher:search,prompt:'Please Input Value',menu:'#mm'"/>
                <div id="mm" style="width:120px">
                    <div data-options="name:'name',iconCls:'icon-ok'">名称</div>
                    <div data-options="name:'age'">年龄</div>
                </div>
            </div>
        </div>
        <div data-options="region:'center',">
            <table id="userDg"></table>

            <div id="userDa"></div>

            <div id="tb">
                <a  id="userAdd"  onClick="userAdd()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
            </div>
        </div>

    </div>





