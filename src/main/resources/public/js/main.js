var app = angular.module("AppStackExchange", ['ngTable', 'ngToast', 'ngAnimate']);

app.controller("AppCtrl", function ($scope, $http, NgTableParams, ngToast) {
    $scope.search = {};
    $scope.questions = [];

    $scope.onSearchClick = function (search) {

        $http.get('/search?' + $.param(search),
            {
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            })
            .then(function successCallback(response) {
                //window.alert("Success");
                $scope.questions = response.data;

                $scope.questionTable = new NgTableParams({
                        page: 1,
                        count: 10
                    }, {dataset:  $scope.questions});
                ngToast.create({
                    className: 'success',
                    content: '<a href="#" class="">Load success</a>'
                });
            }, function errorCallback(response) {
                ngToast.create({
                    className: 'warning',
                    content: '<span class="text-muted">The server is not available. Error code: ' + response.status + '</span>'
                });
            });
    };

});

app.config(['ngToastProvider', function(ngToastProvider) {
    ngToastProvider.configure({
        animation: 'slide', // or 'fade'
        verticalPosition: 'bottom',
        horizontalPosition: 'center'
    });
}]);