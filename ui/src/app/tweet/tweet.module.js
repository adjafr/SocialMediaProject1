import tweet from './tweet.component'
import tweetDetail from './tweet-detail.component'

import TweetService from './tweet.service'

import routes from './tweet.routes'

export default angular.module('app.tweet', [])
  .service('tweetService', TweetService)
  .component('appTweet', tweet)
  .component('appTweetDetail', tweetDetail)
  .config(routes)
  .name