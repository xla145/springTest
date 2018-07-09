//入口
layui.extend({
    common:"/resources2.0/js/common"
}).use(['table', 'layer', 'form', 'common'], function () {
    var $ = layui.jquery, table = layui.table, layer = layui.layer, form = layui.form, common = layui.common,util = layui.util;
    //列表渲染
    var tableIns = table.render({
        id:'generatorTable'
        ,elem: '#generatorTable'
        , url: '/sys/generator/list'
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
            {field: 'tableName', title: '表名', width: 200},
            {field: 'tableComment', title: '表注释', minWidth: 100},
            {field: 'createTime', title: '创建时间', width: 200,templet: '<div>{{layui.util.toDateString(d.createTime)}}</div>'}
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
        // 生成代码
        generator: function (data) {
            data = data || table.checkStatus('generatorTable').data;
            if (data == "") {
                layer.msg("请选择一条数据进行删除！");
                return;
            }
            let tableArr = new Array();
            layui.each(data,function (i,j) {
                tableArr.push(j.tableName);
            })
            location.href = "/sys/generator/code?tables=" + JSON.stringify(tableArr);
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
});