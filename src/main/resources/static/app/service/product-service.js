angular
    .module('myProduct')
    .factory('ProductService', ProductService);
ProductService.$inject = ['$http'];
function ProductService($http) {
    var vm =  this;
    vm.myData = 'my-json/user';
    return {
        getAllProduct: getAllProduct,
        getById: getById
    };
    function  getAllProduct() {
        return $http.get(vm.myData + '.json');
    }
    function getById(id) {
        return $http.get(vm .myData+'/' + id+ '.json');
    }
    
}