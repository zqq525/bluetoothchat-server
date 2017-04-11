/**
 * Created by zhuqingquan on 2017/4/11.
 */
$(function () {
    var userid = sessionStorage.getItem("id");
    if (userid == null) {
        location.href = "/"
    } else {
        $.ajax({
            url: "/admin/0",
            type: "get",
            dataType: "json",
            success: function (data) {
                var n = 0;
                $.each(data, function (i, users) {
                    n++;
                })

                $('#page').jqPaginator({
                    totalPages: Math.ceil(n / 15),
                    visiblePages: 5,
                    currentPage: 1,
                    onPageChange: function (num, type) {
                        $.ajax({
                            url: "/admin/" + num,
                            type: "get",
                            dataType: "json",
                            success: function (data) {
                                $("#mytable").empty();
                                var html;
                                $.each(data, function (i, admin) {

                                    regist = admin.time;
                                    var registtime = "null";
                                    if (regist != null) {
                                        now = new Date(regist)
                                        var year = now.getFullYear();
                                        var month = now.getMonth() + 1;
                                        var date = now.getDate();
                                        var hour = now.getHours();
                                        var minute = now.getMinutes();
                                        var second = now.getSeconds();
                                        registtime = year + "-" + month + "-" + date + "   " + hour + ":" + minute + ":" + second
                                    }
                                    html += "<tr> <td>" + admin.id +
                                        "</td> <td>" + registtime +
                                        "</td> <td>" +
                                        "<button onclick='content_update("+admin.id+")' class='btn btn-primary'>" + "修改" + "</button>" +
                                        "<button onclick='deleteAdmin("+admin.id+")' class='btn btn-danger col-xs-offset-1'>" + "删除" + "</button>" +
                                        "</td> </tr>";
                                })
                                $("#mytable").html(html);
                            }
                        })
                    }
                });
            }
        })
    }
})
/**
 * 添加管理员页面
 */
function addContent() {
    $("#content").load("content_add.html", function( response, status, xhr ) {
        $("#content").html(response);
    })
}

function addAdmin() {
    var id = $("#id").val();
    var password = $("#password").val();
    var re_password = $("#repeat_password").val();

    if (id != "" && password != "" && re_password != "") {
        if (password != re_password) {
            alert("两次输入密码不相同，请重新输入！");
        } else {
            $.ajax({
                type : "get",
                url : "/admin/id/"+id,
                dataType : "json",
                success : function (data) {
                    if (data.code == 200) {
                        alert("该管理员id已经存在！请重新输入！");
                    } else {
                        $.ajax({
                            type : "post",
                            url : "/admin/add",
                            dataType : "json",
                            data: {
                                "id" : id,
                                "password" : password
                            },
                            success : function (data) {
                                if (data.code == 200) {
                                    alert("添加管理员成功！");
                                    location.href = "/addadmin";
                                }

                            }
                        })
                    }
                }
            })

        }
    } else {
        alert("输入不能为空！")
    }
}

function content_update(id) {
    $("#content").load("content_update.html", function( response, status, xhr ) {
        pre_html = "<div class='panel-heading'>"+"当前修改管理员的ID为:" + "<label class='label label-success' id='updateid'>"+id+"</label>" + "</div>";
        $("#content").html(response)
        $("#content").prepend(pre_html);
    })
}
function updateAdmin() {
    var updateid = $("#updateid").html();
    var password = $("#password").val();
    var re_password = $("#repeat_password").val();
    if (password != "" && re_password != "") {
        if (password != re_password) {
            alert("两次输入密码不相同，请重新输入！");
        } else {
            $.ajax({
                type : "put",
                url : "/admin/update",
                dataType : "json",
                data: {
                    "id" : updateid,
                    "password" : password
                },
                success : function (data) {
                    if (data.code == 200) {
                        alert("修改成功！");
                        location.href = "/addadmin";
                    }
                }
            })
        }
    } else {
        alert("输入不能为空！")
    }
}

function deleteAdmin(id) {
    $.ajax({
        type : "get",
        url : "/admin/delete/" + id,
        dataType : "json",
        success : function (data) {
            if (data.code == 200) {
                alert("删除成功！");
                location.reload();
            }
        }
    })
}
