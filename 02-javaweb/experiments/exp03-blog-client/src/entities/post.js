export default class Post {
  constructor(id, title, content, desc, postDate, views, thumbs, userId) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.desc = desc;
    this.postDate = postDate;
    this.views = views;
    this.thumbs = thumbs;
    this.userId = userId;
  }
}
