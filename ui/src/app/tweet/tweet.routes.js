export default function route ($stateProvider) {
  $stateProvider
  

  
    .state('tweets', {
      url: '/tweets',
      component: 'appTweet',
      resolve: {
        entities: function (tweetService) {
          return tweetService.getAllTweets()
        }
      }
    })
    .state('tweetDetail', {
      url: '/tweets/:id',
      component: 'appTweetDetail',
      resolve: {
        entity: function (tweetService, $stateParams) {
          return tweetService.getTweet($stateParams.id)
        }
      }
    })
}