var myApp = angular.module("myApp",[]);
myApp.factory('testDate', function () {
    var datas = [
        {
            id: 1,
            name: "张三",
            gender: "男",
            age: 12,
            nation: "汉族",
            hobby: [1, 2, 3]

        },
        {
            id: 2,
            name: "李四",
            gender: "女",
            age: 17,
            nation: "汉族",
            hobby: [4, 5, 6]
        },
        {
            id: 3,
            name: "王五",
            gender: "男",
            age: 19,
            nation: "回族",
            hobby: [2, 3, 5]
        },
        {
            id: 4,
            name: "马六",
            gender: "女",
            age: 18,
            nation: "汉族",
            hobby: [2, 4, 5]
        },
        {
            id: 5,
            name: "郑七",
            gender: "男",
            age: 13,
            nation: "维吾尔族",
            hobby: [1, 5, 6]
        },
        {
            id: 6,
            name: "钱八",
            gender: "男",
            age: 20,
            nation: "蒙古族",
            hobby: [1, 2, 4, 5]
        },
        {
            id: 7,
            name: "吴九",
            gender: "女",
            age: 34,
            nation: "朝鲜族",
            hobby: [1, 2, 5]
        },
        {
            id: 8,
            name: "王十",
            gender: "男",
            age: 24,
            nation: "契丹族",
            hobby: [2, 3, 5]
        },
        {
            id: 9,
            name: "啊十二",
            gender: "女",
            age: 34,
            nation: "汉族",
            hobby: [6, 3, 5]
        },
        {
            id: 10,
            name: "玩儿",
            gender: "男",
            age: 20,
            nation: "汉族",
            hobby: [2, 3, 5]
        },
        {
            id: 11,
            name: "阿斯蒂",
            gender: "男",
            age: 26,
            nation: "蒙古族",
            hobby: [4, 1, 5]
        },
        {
            id: 12,
            name: "与发个",
            gender: "男",
            age: 54,
            nation: "汉族",
            hobby: [2, 4, 5]
        },
        {
            id: 13,
            name: "帮忙的",
            gender: "男",
            age: 78,
            nation: "契丹族",
            hobby: [5, 2, 4]
        },
        {
            id: 14,
            name: "家收到",
            gender: "男",
            age: 22,
            nation: "汉族",
            hobby: [2, 4, 5]
        },
        {
            id: 15,
            name: "爱玩",
            gender: "女",
            age: 22,
            nation: "汉族",
            hobby: [2, 3, 5]
        },
        {
            id: 16,
            name: "里十一",
            gender: "男",
            age: 24,
            nation: "汉族",
            hobby: [2, 3, 5]
        },
        {
            id: 17,
            name: "王十六",
            gender: "女",
            age: 24,
            nation: "契丹族",
            hobby: [2, 3, 5]
        }
    ]
    var hobby = [
        {
            id: 1,
            value: "篮球"
        },
        {
            id: 2,
            value: "足球"
        },
        {
            id: 3,
            value: "乒乓球"
        },
        {
            id: 4,
            value: "羽毛球"
        },
        {
            id: 5,
            value: "游泳"
        },
        {
            id: 6,
            value: "唱歌"
        }

    ]

    var nation = [
        {
            id: 1,
            name: "汉族"
        },
        {
            id: 2,
            name: "蒙古族"
        },
        {
            id: 3,
            name: "回族"
        },
        {
            id: 4,
            name: "壮族"
        },
        {
            id: 5,
            name: "彝族"
        },
        {
            id: 6,
            name: "维吾尔族"
        },
        {
            id: 7,
            name: "朝鲜族"
        },
        {
            id: 8,
            name: "土家族"
        },
        {
            id: 9,
            name: "哈萨克族"
        },
        {
            id: 10,
            name: "仫佬族"
        }

    ]

    _getHobbies = function () {
        return hobby;
    };
    _getDatas = function () {
        return datas;
    };
    _getNations = function () {
        return nation;
    };

    return {
        getData: _getDatas(),
        getHobby: _getHobbies(),
        getNation: _getNations()
    };
})

myApp.controller("loginController", ['$scope', '$http', '$timeout', function ($scope, $http, $timeout) {

    $scope.username="";
    $scope.password = "";
    $scope.login = login();
    $scope.getPathUri = getPathUri();
    function getPathUri (path) {
        return window.location.hostname+":"+window.location.port+'/'+path+".do"
    }
    $http.get().success(function (data) {

    });

    function login() {
        $http.get(getPathUri("main/login")+"?username="+$scope.username+"&password="+$scope.password).success(function (data) {
            console.log(data);
        })

    }
}]);