import GlobalService from '../global.service'
import user from './user.component'
import userDetail from './user-detail.component'

import UserService from './user.service'

import routes from './user.routes'

export default angular.module('app.user', [])
  .service('userService', UserService)
  .service('GlobalService', GlobalService)
  .component('appUser', user)
  .component('appUserDetail', userDetail)
  .config(routes)
  .name