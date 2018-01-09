angular.module('myProduct').controller('ProductController', ProductController);
ProductController.inject = ['ProductService', '$log', '$stateParams', '$state'];
function ProductController(ProductService, $log) {
    var vm = this;
    ProductService.getAllProduct().then(function (response) {
        vm.getAll = response;
}, function (response) {
        vm.error = response;
    });
    $log.log(vm);
}

