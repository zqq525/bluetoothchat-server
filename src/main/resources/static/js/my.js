$(function () {
    var userid = sessionStorage.getItem("id");
    if (userid == null) {
        location.href = "/"
    }
    $.ajax({
        url: "/users/0",
        type: "get",
        dataType: "json",
        success: function (data) {
            var n = 0;
            $.each(data, function (i, users) {
                n++;
            })

            $('#page').jqPaginator({
                totalPages: Math.ceil(n/15),
                visiblePages: 5,
                currentPage: 1,
                onPageChange: function (num, type) {
                    $.ajax({
                        url: "/users/"+num,
                        type: "get",
                        dataType: "json",
                        success: function (data) {
                            $("#mytable").empty();
                            var html;
                            $.each(data, function (i, users) {
                                var date = new Date();
                                date.format
                                birthday = users.birthday;
                                if (birthday != null) {
                                    date.setTime(users.birthday);
                                    birthday = date.getFullYear() + "年" + (date.getMonth()+1) + "月" + date.getDate() + "日";
                                    if (users.age == 0) {
                                        age = new Date().getFullYear() - date.getFullYear();
                                    } else {
                                        age = users.age;
                                    }
                                }
                                regist = users.time;
                                var registtime="null";
                                if (regist != null) {
                                    now = new Date(regist)
                                    var   year=now.getFullYear();
                                    var   month=now.getMonth()+1;
                                    var   date=now.getDate();
                                    var   hour=now.getHours();
                                    var   minute=now.getMinutes();
                                    var   second=now.getSeconds();
                                    registtime = year+"-"+month+"-"+date+"   "+hour+":"+minute+":"+second
                                }
                                html += "<tr> <td>" + users.mac +
                                    "</td> <td>" + users.id +
                                    "</td> <td>" + users.name +
                                    "</td> <td>" + users.phone +
                                    "</td> <td>" + users.gendar +
                                    "</td> <td>" + age +
                                    "</td> <td>" + birthday +
                                    "</td> <td>" + users.intr +
                                    "</td> <td>" + registtime +
                                    "</td> </tr>";
                            })
                            $("#mytable").html(html);
                        }
                    })
                }
            });

            $("#title").append("(当前注册总人数：" + n + "人)");


        }
    })

})