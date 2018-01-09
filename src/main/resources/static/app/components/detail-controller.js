angular.module('myProduct').controller('ProductDetailController', ProductDetailController);
ProductDetailController.$inject = ['ProductService', '$log', '$stateParams'];
function ProductDetailController(ProductService,$log,$stateParams ) {
    var vm = this;
    ProductService.getById($stateParams.id).then(function (response) {
        vm.getProductId = response.data;
    }, function (response) {
        vm.error = response.data;
    });
    $log.log(vm);
}