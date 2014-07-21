app.controller('LoginCtrl', ['$scope','$http' , function($scope,$http) {

    $scope.doLogin = function (){
        $http({
            url: "http://localhost:8080/user/login",
            method: "POST",
            data: $scope.user
        }).success(function(data, status, headers, config) {
            $scope.data = data;
            if(data.code == "200"){
                alert('로그인 OK!');
            } else {
                alert('로그인 Fail!');
            }
        }).error(function(data, status, headers, config) {
            $scope.status = status;
        });
    }

}]);
