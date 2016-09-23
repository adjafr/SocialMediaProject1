import angular from 'angular'
import uiRouter from 'angular-ui-router'
import angularMaterial from 'angular-material'
import 'bcryptjs'

import appHome from './app.component'
import routes from './app.routes'
import user from './user/user.module'
import tweet from './tweet/tweet.module'
import login from './login/login.module'
import register from './register/register.module'
import forgotpassword from './forgotpassword/forgotpassword.module'
import GlobalService from './global.service'



import '../css/main.css'

export default
  angular
    .module('app', [uiRouter, angularMaterial, user, tweet, login, register, forgotpassword])
    .constant('server', 'http://localhost:8080/')
    .component('appHome', appHome)
    .service('GlobalService', GlobalService)
    .config(routes)
    .name