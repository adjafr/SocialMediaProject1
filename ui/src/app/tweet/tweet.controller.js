//import GlobalService from '../global.service'


export default class TweetController {
  /* @ngInject */
  constructor () {
    this.name = 'Tweets'
    this.link = 'tweetDetail'
    this.glyph = 'tweet'
//    this.GlobalService = GlobalService
    if (this.entity) {
      this.info = {
        Tweet: this.entity.tweet,
        User: this.entity.user
      }
      this.setInfo = {
        Users: this.entity.users,
        Users: this.entity.users
      }
    }
  }

  getLink (name) {
    if (name === 'Tweet') {
      return 'tweetDetail'
    } else if (name === 'User') {
      return 'userDetail'
    } 
  }

  getGlyph (name) {
    if (name === 'Tweet') {
      return 'flag'
    } else if (name === 'User') {
      return 'home'
    } 
  }
}