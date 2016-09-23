import templateUrl from '../templates/entity-detail.template.html'
import TweetController from './tweet.controller'

export default {
  templateUrl,
  controllerAs: 'ctrl',
  controller: TweetController,
  bindings: {
    entity: '<'
  }
}