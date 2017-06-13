/**
 * ngGrid行编辑的实现（功能模块仍然命名为“ngGridExtension”，用到时，请加入到module的依赖中）。
 */
angular.module("ngGridExtension", ["ngGrid"])
    .directive("ngGrid", [function () {//在ngGrid的scope中，添加 “行编辑”变量 enableRowEditOnSelected
        return function ($scope, $element, attrs) {
            $scope.$watch(attrs.ngGrid, function (gridOptions) {
                if(gridOptions) {//对于给定的ng-grid设置
                    //向ng-grid属性中添加 enableRowEditOnSelected，供其他指令读取
                    $scope.enableRowEditOnSelected = gridOptions.enableRowEditOnSelected ? true : false;
                    $scope.rowEditStatus = {//行编辑 辅助对象
                        columnIndexFocusIn: undefined //按“up” “down”箭头时，当前编辑的列
                    };
                    //是否允许 “所有行” 处于编辑状态 enableAllRowEditable
                    $scope.enableAllRowEditable = gridOptions.enableAllRowEditable ? true : false;
                    $scope.gridOptions = gridOptions;//用户的配置项
                }
            });
        };
    }])
    .directive("ngRow", function () {//在“行编辑”模式下，同步行焦点变量 isRowFocused
        return function ($scope, $element, attrs) {
            $scope.isRowFocused = false;
            var dereg = undefined;
            if($scope.enableRowEditOnSelected) {//设置了 “行编辑” 属性，则同步 isRowFocused 的状态为是否选中
                dereg = $scope.$watch("row.selected", function (newvalue) {//如果行被选中
                    $scope.isRowFocused = newvalue ? true : false;
                });
            }
            if($scope.enableAllRowEditable) {//允许 “所有行” 处于编辑状态
                if(dereg) {//如果“行编辑还在”，则取消 “行编辑” 的监听（监听顶多只执行一次）
                    dereg();
                }
                $scope.isRowFocused = true;
            }
            $element.bind("$destroy", function () {
                if(dereg) {
                    dereg();
                }
            });
            $scope.$on("ngGridEventEndRowEdit", function () {
                $scope.row.setSelection(false);
            })

        };
    })
    .directive("ngCell", function () {
        return function ($scope, $element, $attrs) {
            $element.bind('click', function (event) {
                $scope.$apply(function () {
                    $scope.rowEditStatus.columnIndexFocusIn = $scope.col.index;
                });
            });
        };
    })
    .directive("ngInput", [function () {
        function focusThisCellIfPossible($scope, $element, attrs) {
            if($scope.rowEditStatus.columnIndexFocusIn === $scope.col.index) {
                setTimeout(function () {//只好从作用域之外调用，不然会抛出already in digest的错误，哎，真是的
                    $element.click();
                }, 0);
            }
        }
        return function ($scope, $element, attrs) {
            $element.bind('click', function (event) {
                $element.parent().click();//点击 本元素，表示 选中了本行
            });
            var triggerEvent,focusNextRow = function () {
                $scope.gridOptions.ngGrid.$viewport.focus();
                $scope.gridOptions.ngGrid.$viewport.trigger(triggerEvent);
            };
            $element.bind('keydown', function (event) {
                if(event.keyCode === 38 || event.keyCode === 40) {
                    triggerEvent = {keyCode: event.keyCode, type: "keydown"};
                    focusNextRow();
                }
            });
            $element.bind('dblclick', function (event) {
                $element.blur();
                $scope.$apply(function () {
                    $scope.row.setSelection(false);
                });
            });
            var dereg = $scope.$watch("row.selected && rowEditStatus.columnIndexFocusIn == col.index", function (newvalue) {//如果行被选中
                if(newvalue) {
                    focusThisCellIfPossible($scope, $element, attrs);
                }
            });
            $element.bind("$destroy", function () {
                if(dereg) {dereg();}
            });
        };
    }])
    .directive("ngGridSelect2", ["$timeout", function ($timeout) {
        return function (scope, element, attr) {
            scope.$on('ngGridEventStartCellEdit', function () {
                $timeout(function () {
                    element.select2("open");
                });
            });
            element.on('select2-blur', function (event) {
                scope.$emit('ngGridEventEndCellEdit');
            });
            element.bind("click", function (event) {
                event.stopPropagation();
            });
            if(scope.enableAllRowEditable) {
                element.on('select2-focus', function (event) {
                    scope.row.setSelection(true);
                    if(!scope.$$phase) {
                        scope.$apply();
                    }
                });
            }
            element.bind("$destroy", function () {
                element.select2("destroy");
            });
        };
    }])
    .directive("ngGridSelect", function () {
        return function (scope, element, attr) {
            scope.$on('ngGridEventStartCellEdit', function () {
                element.focus();
            });
            element.bind('blur', function () {
                scope.$emit('ngGridEventEndCellEdit');
            });
        };
    })
    .run(["$templateCache", function($templateCache) {
        $templateCache.put("cellEditTemplate.html",
            "<div ng-cell-has-focus ng-dblclick=\"editCell()\">" +
                "	<div ng-edit-cell-if=\"!isRowFocused && !isFocused\">	" +
                "		DISPLAY_CELL_TEMPLATE" +
                "	</div>" +
                "	<div ng-edit-cell-if=\"isRowFocused || isFocused\">" +
                "		EDITABLE_CELL_TEMPLATE" +
                "	</div>" +
                "</div>"
        );
    }]);
