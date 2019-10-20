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
        var accessToken = "${accessToken}";
        function beforeDrag(treeId, treeNodes, targetNode, moveType) {
            console.log("beforeDrag");
            return true;
        }

        function beforeDrop(treeId, treeNodes, targetNode, moveType) {
            console.log("beforeDrop");
            return true;
        }

        function onDrop(event, treeId, treeNodes, targetNode, moveType) {
            var treeNode = treeNodes[0];
            var id = treeNode["id"];
            var parentId = treeNode["pId"];
            if (!parentId) {
                parentId = 0;
            }
            $.post("../organization/setRelationship?access_token=" + accessToken, {id: id, parentId: parentId}, function (result) {
                if (result["successful"]) {
                    alert(result["message"]);
                } else {
                    alert(result["error"]["message"]);
                }
            }, "json");
        }
        var setting = {
            data: {
                simpleData: {
                    enable: true,
                    idKey: "id",
                    pIdKey: "pId",
                    rootId: "0"
                }
            },
            view: {
                selectedMulti: false
            },
            check: {
                enable: false
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
            $.get("../organization/obtainAllOrganizations?access_token=" + accessToken, {}, function (result) {
                if (result["successful"]) {
                    var organizations = result["data"];
                    zTreeObj = $.fn.zTree.init($("#zTree"), setting, organizations);
                } else {
                    alert(result["error"]);
                }
            }, "json");
        });
    </script>
</head>
<body>
<div id="zTree" class="ztree"></div>
</body>
</html>
