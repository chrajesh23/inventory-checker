var app = angular.module('InvSearch', []);

app.controller('MainCtrl', function($scope, $http) {
	$scope.disableResultMessage=false;
	$scope.disableExport= true;
	$scope.loadStatus=false;
	$scope.loadData = function() {
		$scope.loadStatus=true;
		$scope.results = null;
		$scope.disableSubmit=false;
		var url = 'http://'+$scope.hostName+':'+$scope.portNumber+'/inventory-checker/services/v1/search?sku='
		+ $scope.skuValue + "&prodDesc=" + $scope.prodDesc + "&zipCode=" + $scope.zipCode;
		$http.get(url).success(function(data) {
			var searchString = '';;
			if ($scope.skuValue && $scope.skuValue.length > 0) {
				searchString = searchString + $scope.skuValue;
			}
			if (!($scope.skuValue && $scope.skuValue.length > 0) && $scope.prodDesc && $scope.prodDesc.length > 0) {
				searchString = searchString + "  " + $scope.prodDesc;
			}
			if ($scope.zipCode && $scope.zipCode.length > 0) {
				searchString = searchString + "  " + $scope.zipCode;
			}
			
			$scope.inputSearch = searchString;
			$scope.results = data;
			$scope.msg = 'Done';
			$scope.disableExport = false;
			$scope.loadStatus=false;
			$scope.disableResultMessage=true;
		});
	}
	$scope.exportData = function() {
		var blob = new Blob([document.getElementById('exportable').innerHTML], {
            type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"
        })
        saveAs(blob, "Report.xls");
	}
});