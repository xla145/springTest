//入口
layui.extend({
    common:"/resources2.0/js/common"
}).use(['table', 'layer', 'form', 'common'], function () {
    var $ = layui.jquery, table = layui.table, layer = layui.layer, form = layui.form, common = layui.common;
    //列表渲染
    var t = table.render({
        elem: '#couponTable'
        , url: '/coupon/list'
        , where: common.formatForm($('#filterForm'))
        , height: 'full-100'
        , page: true
        , method: 'post'
        , request: {
            pageName: 'pageNo' //页码的参数名称，默认：page
            , limitName: 'pageSize' //每页数据量的参数名，默认：limit
        }
        , limits: [15, 30, 50]
        , limit: 15
        , size: 'sm'
        , cols: [[
            {checkbox: true, fixed: true},
            {field: 'cid', title: 'cid', width: 100},
            {field: 'name', title: 'name', width: 100},
            {field: 'info', title: 'info', width: 100},
            {field: 'type', title: 'type', width: 100},
            {field: 'msg', title: 'msg', width: 100},
            {field: 'price', title: 'price', width: 100},
            {field: 'stock', title: 'stock', width: 100},
            {field: 'remaining', title: 'remaining', width: 100},
            {field: 'status', title: 'status', width: 100},
            {field: 'remark', title: 'remark', width: 100},
            {field: 'endTime', title: 'end_time', width: 100},
            {field: 'startTime', title: 'start_time', width: 100},
            {field: 'createTime', title: 'create_time', width: 100},
            {field: 'updateTime', title: 'update_time', width: 100},
            {field: 'useRange', title: 'use_range', width: 100},
            {field: 'aging', title: 'aging', width: 100},
            {field: 'url', title: 'url', width: 100},
            {fixed: 'right', width: 200, title: '操作', toolbar: '#bar'}
        ]],
    });
    //操作
    var active = {
        search: function () {
            dataReload();
        },
        reset: function () {
            $("#filterForm")[0].reset();
            dataReload();
        },
        add: function () {
            common.addForm({
                content: $('#add-form'),
                title: "xxxxxxx",
                yes: function (index, layero) {
                    var formEm = $(layero).find('form');
                    if (!form.onVerify(formEm)) {
                        return false;
                    }
                    /**表单提交 **/
                    $.post('${ctx}coupon/add', formEm.serialize(), function (result) {
                        if (result.code == 0) {
                            formEm[0].reset();	//清空弹框表单内容
                            layer.close(index);	//关闭弹框
                            dataReload();
                            return;
                        }
                        layer.msg(result.msg);
                    });
                }
            });
        },
        edit: function (data) {
            common.editForm({
                content: "${ctx}coupon/getView?id=" + data.id,
                title: '修改卡包信息',
                yes: function (index, layero) {
                    var formEm = $(layero).find('iframe').contents().find("#edit-form");
                    if (!form.onVerify(formEm)) {
                        return false;
                    }
                    /**表单提交 **/
                    $.post('${ctx}coupon/edit', formEm.serialize(), function (result) {
                        if (result.code == 0) {
                            formEm[0].reset();	//清空弹框表单内容
                            layer.close(index);	//关闭弹框
                            dataReload(true);
                            return;
                        }
                        layer.msg(result.msg);
                    });
                },
                isFull: true
            });
        },
        del: function (data) {
            data = data || table.checkStatus('coupon-table').data;
            if (data == "") {
                layer.msg("请选择一条数据进行删除！");
                return;
            }
            console.log(data)
            var ids = new Array();
            layui.each(data, function (i, j) {
                ids.push(j.cid); // 加入对应的编号
            })
            layer.confirm('真的删除行么', function (index) {
                layer.close(index);
                $.ajax({
                    type: "POST",
                    url: "/coupon/del",
                    dataType : 'json',
                    contentType : 'application/json;charset=UTF-8',
                    data: JSON.stringify(ids),
                    success: function (result) {
                        if (result.code == 0) {
                            layer.close(index);	//关闭弹框
                            dataReload(true);
                            return;
                        }
                        layer.msg(result.msg)
                    }
                });
                // $.post("/coupon/del", {cids:JSON.stringify(ids)}, function (result) {
                //     if (result.code == 0) {
                //         layer.close(index);	//关闭弹框
                //         dataReload(true);
                //         return;
                //     }
                //     layer.msg(result.msg)
                // })
            });
        },
    }


    //加载数据
    var dataReload = function (isEdit) {
        if (isEdit) {
            $(".layui-laypage-btn")[0].click();
            return;
        }
        tableIns.reload({
            where: common.formatForm($('#filterForm')), page: {
                pageNo: 1 //重新从第 1 页开始
            }
        });
    }
    //绑定操作按钮
    $(document).on('click', '.operator-btn', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    //监听工具条
    table.on('tool(couponTable)', function (obj) {
        var type = obj.event;
        active[type] ? active[type].call(this, [obj.data]) : '';
    });
});