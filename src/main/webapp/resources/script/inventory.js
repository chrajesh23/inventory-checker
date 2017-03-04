var app = angular.module('InvSearch', []);

app.controller('MainCtrl', function($scope, $http) {
	$scope.disableExport= true;
	$scope.loadStatus=false;
	$scope.loadData = function() {
		$scope.loadStatus=true;
		$http.get(
				'http://'+$scope.hostName+':'+$scope.portNumber+'/inventory-checker/search/'
						+ $scope.skuValue).success(function(data) {
			$scope.inputSKU = $scope.skuValue;
			$scope.results = data;
			$scope.msg = 'Done';
			$scope.disableExport = false;
			$scope.loadStatus=false;
		});
	}
	$scope.exportData = function() {
		var blob = new Blob([document.getElementById('exportable').innerHTML], {
            type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"
        })
        saveAs(blob, "Report.xls");
	}
});