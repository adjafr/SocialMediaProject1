//var url = 'api/users/';

//import GlobalService from '../global.service'

export default class LoginService {
  /* @ngInject */
	constructor ($http, GlobalService, $state) {
		this.$http = $http
		this.$state = $state
		this.url = 'http://localhost:8080/api/users/';
		this.GlobalService = GlobalService
	}

//	getUserDetails = function(id) { return this.$http.get(url + id) };
	getUserDetails (user)
	{
		console.dir('login service happened')
		let temp = user.password
		console.log(temp)
		console.log("_____________")
		this.$http.get(this.url + user.username + '/validate' ).then((user) => {
		this.thisUser = user.data

		if(temp === this.thisUser.password){
			console.dir('password is correct')
			this.GlobalService.loggedIn = true
			this.GlobalService.validUser = user
			this.$state.go('users')
		
		}
		else{
			console.dir('password is incorrect')
		}

		})

	};







}
