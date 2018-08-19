<%--
  Created by IntelliJ IDEA.
  User: Kingsley
  Date: 2018/8/5
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../common/IncludeHead.jsp" %>
<%@ include file="../common/IncludeNavbar.jsp" %>
<%@ include file="../common/IncludeJsVendor.jsp" %>
<link href="../css/AllCategorylist.css" rel="stylesheet">
<link href="../vendor/css/bootstrap-table.min.css" rel="stylesheet"/>
<script src="../vendor/js/bootstrap-table.min.js" type="text/javascript"></script>
<script src="../vendor/js/bootstrap-table-zh-CN.min.js" type="text/javascript"></script>
<script src="../vendor/js/bootstrapValidator.min.js" type="text/javascript"></script>
<link href="../vendor/css/bootstrapValidator.min.css" rel="stylesheet"/>
<script src="../vendor/js/bootstrap3-typeahead.min.js" type="text/javascript"></script>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            查询条件
        </div>
        <div class="panel-body form-group">
            <div class="container">
                <form class="form form-inline" id="query_condition">
                    <div class="form-group">
                        <label class="control-label" style="text-align: right; margin-top:5px">层级：</label>
                    </div>
                    <div class="form-group">
                        <select class="form-control" id="q_level">
                            <option value="0">所有</option>
                            <option value="1">一级</option>
                            <option value="2">二级</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="control-label" style="text-align: right; margin-top:5px">编码：</label>
                    </div>
                    <div class="form-group">
                        <input class="form-control" placeholder="编码" id="q_code"></input>
                    </div>
                    <div class="form-group">
                        <label class="control-label" style="text-align: right; margin-top:5px">名称：</label>
                    </div>
                    <div class="form-group">
                        <input class="form-control" placeholder="名称" id="q_name"></input>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-info" type="button">查询</button>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-info" type="button" id="btn_reset">重置</button>
                    </div>
                </form>
            </div>

        </div>

    </div>
    <table id="category_table" class="table table-hover"></table>
    <hr style="filter: alpha(opacity=100,finishopacity=0,style=3)" width="100%" color="#6f5499" size="3"/>
    <form class="form form-inline" id="toolbar">
        <div class="form-group">
            <button id="btn_add" class="btn btn-info" type="button" data-toggle="modal" data-target="#add_modal">新增
            </button>

        </div>
    </form>

    <div class="modal fade" id="add_modal" tabindex="-1" role="dialog" aria-labelledby="add_modal_label"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">×
                    </button>
                    <h4 class="modal-title" id="add_modal_label">
                        添加一级或二级名称
                    </h4>
                </div>
                <div class="modal-body">
                    <form class="form" id="add_form">
                        <div class="form-group">
                            <select class="form-control" id="add_select_level" onchange="changelevel(event)" name="add_select_level" required>
                                <option value="1">一级</option>
                                <option value="2">二级</option>
                            </select>
                        </div>


                        <div id="add_parent_formgroup" class="form-group hide">
                            <br/>
                            <label class="control-label">输入一级名称</label>
                            <input id="add_parent_code" class="form-control" name="add_parent_code" data-provide="typeahead" data-items="4" onchange="validateparent()"/>
                        </div>

                        <%--<label for="add_code" class="control-label">编码:</label>--%>
                        <br/>
                        <div class="form-group">
                            <input id="add_code" class="form-control" type='text' name="add_code" placeholder="编码"
                                   required/>
                        </div>

                        <br/>
                        <div class="form-group">
                            <input id="add_name" class="form-control" type='text' name="add_name" placeholder="名称"
                                   required/>
                        </div>
                    </form>
                    <div id="submit_alert" class="alert alert-warning hide" aria-hidden="true">
                        <a href="#" class="close" data-dismiss="alert">
                            &times;
                        </a>
                        <strong>输入参数不符合要求！</strong>
                    </div>
                    <div id="submit_failed_alert" class="alert alert-danger hide" aria-hidden="true">
                        <a href="#" class="close" data-dismiss="alert">
                            &times;
                        </a>
                        <strong>保存失败！</strong>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default"
                            data-dismiss="modal">关闭
                    </button>
                    <button id="add_name_submit" type="button" class="btn btn-primary">
                        确定
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->


</div>


<script type="text/javascript">
    function queryParams(params) {
        console.log('parameter:' + params);
        return {
            pageSize: params.limit,
            pageIndex: params.pageNumber
        }
    }

    $('#category_table').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded",
        url: "/categorylist/page",
        striped: true, //是否显示行间隔色
        dataField: "res",
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination: true,//是否分页
        queryParamsType: 'limit',
        queryParams: queryParams,
        sidePagination: 'server',
        pageSize: 10,//单页记录数
        pageList: [5, 10, 20, 30],//分页步进值
        showRefresh: false,//刷新按钮
        showColumns: false,
        clickToSelect: true,//是否启用点击选中行
        toolbarAlign: 'left',
        buttonsAlign: 'left',//按钮对齐方式
        toolbar: '#toolbar',//指定工作栏
        locale: 'zh-CN'//中文支持,
    });

    /**
     * 重置查询条件
     */
    $('#btn_reset').click(function () {
        $('#query_condition input').val('');
        $('#query_condition select').val(0);
    });

    /**
     * 表单校验
     */
    $('#add_form').bootstrapValidator({
        live: 'enabled',
        message: '输入的值不规范',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            add_code: {
                message: '编码不符合规范',
                validators: {
                    notEmpty: {
                        message: '编码不能为空'
                    },
                    stringLength: {
                        min: 0,
                        max: 64,
                        message: '编码长度必须在64位以内'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: '编码只能是数字'
                    },
                    callback:{
                        message:"编码已存在",
                        callback:function (value, validator, $field) {
                            return allCodes.indexOf(parseInt(value)) < 0;
                        }
                    }
                }
            },
            add_name: {
                validators: {
                    notEmpty: {
                        message: '名称不能为空'
                    },
                    stringLength: {
                        min: 0,
                        max: 64,
                        message: '名称长度必须在64位以内'
                    }
                }
            },
            add_parent_code:{
                validators:{
                    callback:{
                        message: "一级名称必须已存在",
                        callback : function(value, validator, $field) {
                            console.log('这是一级名称:' + value);
                            return parentCodeAndName.indexOf(value) >= 0;
                        }
                    }
                }
            }
        }
    });

    /**
     * 提交前做校验
     */
    $('#add_name_submit').click(function () {
        if (!$('#add_form').data('bootstrapValidator').isValid()) {
            $('#submit_alert').removeClass('hide');
            return;
        }
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/categorylist",
            contentType: "application/json",
            data: JSON.stringify({
                level: $('#add_select_level').val(),
                code: $('#add_code').val(),
                name: $('#add_name').val(),
                parentCode:$('#add_parent_code').val().split('-')[0]
            }),
            success: function (resp) {
                $('#add_modal').modal('hide');
                resetModal();
            },
            error: function (xhr) {
                console.log('failed');
                $('#submit_failed_alert').removeClass('hide');
            }
        })
    });


    var resetModal = function () {
        $('#add_form').data('bootstrapValidator').resetForm(true);
    }

    /**
     * 用户开始输入，去掉警告
     */
    $('#add_code').focus(function () {
        $('#submit_alert').addClass('hide');
        $('#submit_failed_alert').addClass('hide');

    });

    /**
     * 用户开始输入，去掉警告
     */
    $('#add_name').focus(function () {
        $('#submit_alert').addClass('hide');
        $('#submit_failed_alert').addClass('hide');
    });

    var parentCodeAndName = [];
    var allCodes = [];
    $.ajax({
        type: "GET",
        url: "${pageContext.request.contextPath}/categorylist/allcategory",
        contentType: "application/json",
        success: function (data) {
            if(null != data) {

                data.forEach(function(obj, index){
                    if(obj.level == 1) {
                        parentCodeAndName.push(obj.code + '-' + obj.name);
                    }
                    allCodes.push(obj.code);
                })

            }
        },
        error: function (xhr) {
            console.log('failed');
        }
    })
    var initializeParents = function () {
        $('#add_parent_code').typeahead({source: parentCodeAndName})
    };

    var changelevel = function (event) {
        var level = $('#add_select_level').val();
        if(level == 1) {
            $('#add_parent_formgroup').addClass('hide');
        } else {
            $('#add_parent_formgroup').removeClass('hide');
        }
    }

    initializeParents();

    var validateparent = function() {
        //重新校验输入框之前，需要将其状态置为NOT_VALIDATED
        $('#add_form').data("bootstrapValidator").updateStatus('add_parent_code', 'NOT_VALIDATED')
            .validateField('add_parent_code');
    }

</script>
