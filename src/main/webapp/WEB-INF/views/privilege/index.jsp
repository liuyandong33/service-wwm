<%--
  Created by IntelliJ IDEA.
  User: liuyandong
  Date: 2017-12-29
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../libraries/zTree_v3-v3.5.16/css/zTreeStyle/zTreeStyle.css">
    <script type="text/javascript" src="../libraries/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../libraries/zTree_v3-v3.5.16/js/jquery.ztree.all-3.5.js"></script>
    <script type="text/javascript">
        function beforeDrag() {
            console.log("beforeDrag");
        }

        function beforeDrop() {
            console.log("beforeDrop");
        }

        function onDrop(event, treeId, treeNodes, targetNode, moveType) {
            console.log("onDrop");
        }
        var setting = {
            data: {
                simpleData: {
                    enable: true,
                    idKey: "id",
                    pidKey: "pId",
                    rootId: "0"
                }
            },
            view: {
                selectedMulti: false
            },
            check: {
                enable: true,
                chkStyle: "checkbox"
            },
            edit: {
                enable: true,
                showRemoveBtn: false,
                showRenameBtn: false,
                drag: {
                    isCopy: false,
                    isMove: true,
                    prev: true,
                    next: true,
                    inner: true
                }
            },
            callback: {
                beforeDrag: beforeDrag,
                beforeDrop: beforeDrop,
                onDrop: onDrop
            }
        };

        var zTreeObj = null;
        $(function () {
            $.get("../role/obtainRoleInfo?access_token=4e28ec2c-a3ba-4b59-bc94-fbe7cad49b23", {roleId: 1}, function (result) {
                if (result["successful"]) {
                    var data = result["data"];
                    var privileges = data["privileges"];
                    var rolePrivileges = data["rolePrivileges"];
                    zTreeObj = $.fn.zTree.init($("#zTree"), setting, privileges);

                    for (var index = 0; index < rolePrivileges.length; index++) {
                        var rolePrivilege = rolePrivileges[index];
                        var node = zTreeObj.getNodeByParam("id", rolePrivilege["id"]);
                        if(node != null) {
                            zTreeObj.checkNode(node, true);
                        }
                    }
                } else {
                    alert(result["error"]);
                }
            }, "json");
        });

        function save() {
            var checkedNodes = zTreeObj.getCheckedNodes(true);
            var privilegeIds = [];
            for (var index in checkedNodes) {
                privilegeIds.push(checkedNodes[index]["id"]);
            }
        }
    </script>
</head>
<body>
<div id="zTree" class="ztree"></div>

<button onclick="save();">保存</button>
</body>
</html>
