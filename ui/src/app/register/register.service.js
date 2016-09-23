//var url = 'api/users/';

import GlobalService from '../global.service'

export default class RegisterService {
  /* @ngInject */
	constructor ($http, GlobalService) {
		this.$http = $http
		this.url = 'http://localhost:8080/api/users';
		this.GlobalService = GlobalService
	}
	
	getUserDetails = function(id) { return $http.get(url + id) };
	postUserDetails (user) 
	{ 
		console.dir('more stuff happened')
		return this.$http.post(this.url, user)
	};
	
//  /* @ngInject */
//  constructor ($http, server) {
//    this.$http = $http
//    this.server = server
//  }
//
//  getAllRegisters () {
//    return this.$http
//      .get(this.server + 'api/users')
//      .then((registers) => registers.data)
//  }
//
//  getUserDetails (id) {
//    return this.$http
//      .get(this.server + 'api/users/' + id)
//      .then((register) => register.data)
//  }
//
//  postUserDetails (id, register) {
//    return () => {
//      this.$http.post(this.server + 'api/users/' + id, register)
//    }
//  }
	
	
	
}



//angular.module('app').service('register.service', ['$http', function($http) {
//	
//	var url = 'api/users/';
//	
//	this.getUserDetails = function(id) { return $http.get(url + id) };
//	this.patchUserDetails = function(user) { return $http.patch(url + user.id, user)};
//	
//}])