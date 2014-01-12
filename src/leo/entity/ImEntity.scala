package leo.entity

import java.util.Date

import scala.beans.BeanProperty

trait LeoImEntity {

}

class ImUser extends LeoImEntity {
  @BeanProperty var id: Long = EntityDefaulVal.intDefaultVal
  @BeanProperty var num: String = EntityDefaulVal.stringDefaulVal
  @BeanProperty var nickname: String = EntityDefaulVal.stringDefaulVal
  @BeanProperty var pwd: String = EntityDefaulVal.stringDefaulVal
  @BeanProperty var creationTime: Date = EntityDefaulVal.dateDefaultVal
  @BeanProperty var age: String = EntityDefaulVal.stringDefaulVal
  @BeanProperty var gender: String = EntityDefaulVal.stringDefaulVal
}

class ImRelation extends LeoImEntity {
  @BeanProperty var id: Long = EntityDefaulVal.intDefaultVal
  @BeanProperty var fromUserNum: String = EntityDefaulVal.stringDefaulVal
  @BeanProperty var toUserNum: String = EntityDefaulVal.stringDefaulVal
  @BeanProperty var toUserNumAlias: String = EntityDefaulVal.stringDefaulVal
  @BeanProperty var creationTime: Date = EntityDefaulVal.dateDefaultVal

  //cascading begin
  @BeanProperty var fromUser: ImUser = null
  @BeanProperty var toUser: ImUser = null
}

class ImFriendGroup extends LeoImEntity {
  @BeanProperty var id: Long = EntityDefaulVal.intDefaultVal
  @BeanProperty var num: String = EntityDefaulVal.stringDefaulVal //fromNum
  @BeanProperty var listName: String = null
  @BeanProperty var creationTime: Date = EntityDefaulVal.dateDefaultVal
  //cascading begin
  @BeanProperty var user: ImUser = null
  @BeanProperty var toUsers: collection.mutable.Map[String, ImRelation] = null //toUserNum is key
}

class ImRelFriendGroup extends LeoImEntity {
  @BeanProperty var id: Long = EntityDefaulVal.intDefaultVal
  //  @BeanProperty var relId: Long= EntityDefaulVal.intDefaultVal
  @BeanProperty var toUserNum: String = EntityDefaulVal.stringDefaulVal

  @BeanProperty var listId: Long = EntityDefaulVal.intDefaultVal
  @BeanProperty var creationTime: Date = EntityDefaulVal.dateDefaultVal
  //cascading begin
  @BeanProperty var rel: ImRelation = null
  @BeanProperty var list: ImFriendGroup = null
}

class ImMsg extends LeoImEntity {
  @BeanProperty var id: Long = EntityDefaulVal.intDefaultVal
  @BeanProperty var msgUuid: String = EntityDefaulVal.stringDefaulVal
  @BeanProperty var fromUserNum: String = EntityDefaulVal.stringDefaulVal
  @BeanProperty var toUserNum: String = EntityDefaulVal.stringDefaulVal
  @BeanProperty var content: String = EntityDefaulVal.stringDefaulVal
  @BeanProperty var creationTime: Date = EntityDefaulVal.dateDefaultVal
  @BeanProperty var isRead: String = EntityDefaulVal.stringDefaulVal
}

class ImAddFriendMsg extends LeoImEntity {
  @BeanProperty var id: Long = EntityDefaulVal.intDefaultVal
  @BeanProperty var fromUserNum: String = EntityDefaulVal.stringDefaulVal
  @BeanProperty var toUserNum: String = EntityDefaulVal.stringDefaulVal
  @BeanProperty var content: String = EntityDefaulVal.stringDefaulVal
  @BeanProperty var creationTime: Date = EntityDefaulVal.dateDefaultVal
  @BeanProperty var isRead: String = EntityDefaulVal.stringDefaulVal
}

