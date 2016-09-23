import GlobalService from '../global.service'


export default class TweetService {
  /* @ngInject */
  constructor ($http, server, GlobalService) {
    this.$http = $http
    this.server = server
    this.GlobalService = GlobalService
  }

  getAllTweets () {
    return this.$http
      .get(this.server + 'api/tweets')
      .then((tweets) => tweets.data)
  }

  getTweet (id) {
    return this.$http
      .get(this.server + 'api/tweets/' + id)
      .then((tweet) => tweet.data)
  }

  editTweet (id, tweet) {
    return () => {
      this.$http.patch(this.server + 'api/tweets/' + id, tweet)
    }
  }
}