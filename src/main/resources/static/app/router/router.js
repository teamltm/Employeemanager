angular.module('myApp').config(['$stateProvider','$urlRouterProvider',
    function config($stateProvider,$urlRouterProvider ) {
        $urlRouterProvider.otherwise('/product');
        $stateProvider
            .state('product', {
                url: '/product',
                views: {
                    "viewA": {
                        templateUrl: "components/product.template.html",
                        controller: 'ProductController',
                        controllerAs: '$ctrl'
                    }

                }
            })
            .state('detail', {
                    url: '/product/:id',
                    views: {
                        "viewA": {
                            templateUrl: "components/detail.template.html",
                            controller: 'ProductDetailController',
                            controllerAs: '$ctrl'
                        }

                    }
                })
    }
    ]);