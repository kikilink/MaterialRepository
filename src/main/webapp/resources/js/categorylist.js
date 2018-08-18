$('#myTable').bootstrapTable({
    method: 'post',
    contentType: "application/x-www-form-urlencoded",
    url:"/category/page",
    striped: true, //是否显示行间隔色
    dataField: "res",
    pageNumber: 1, //初始化加载第一页，默认第一页
    pagination:true,//是否分页
    queryParamsType:'limit',
    queryParams:queryParams,
    sidePagination:'server',
    pageSize:10,//单页记录数
    pageList:[5,10,20,30],//分页步进值
    showRefresh:true,//刷新按钮
    showColumns:true,
    clickToSelect: true,//是否启用点击选中行
    toolbarAlign:'right',
    buttonsAlign:'right',//按钮对齐方式
    toolbar:'#toolbar',//指定工作栏
    columns:[
        {
            title:'全选',
            field:'select',
            checkbox:true,
            width:25,
            align:'center',
            valign:'middle'
        },
        {
            title:'ID',
            field:'ID',
            visible:false
        },
        {
            title:'登录名',
            field:'LoginName',
            sortable:true
        },
        {
            title:'姓名',
            field:'Name',
            sortable:true
        },
        {
            title:'手机号',
            field:'Tel',
        },
        {
            title:'邮箱',
            field:'Email'
        },
        {
            title:'注册日期',
            field:'CreateTime',
            sortable:true
        },
        {
            title:'状态',
            field:'Attribute',
            align:'center',
            formatter:operateFormatter
        }
    ],
    locale:'zh-CN'//中文支持,
})