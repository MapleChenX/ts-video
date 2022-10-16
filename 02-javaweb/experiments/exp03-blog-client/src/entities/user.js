export default class User {
  constructor(id, username, password, sex, signature, avatar, age, createDate, fans, follows, showName) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.sex = sex;
    this.signature = signature;
    this.avatar = avatar;
    this.age = age;
    this.createDate = createDate;
    this.fans = fans;
    this.follows = follows;
    this.showName = showName;
  }
}
