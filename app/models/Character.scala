package models

import org.joda.time.DateTime
import com.github.tototoshi.slick.MySQLJodaSupport._
import slick.driver.MySQLDriver.api._
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.language.postfixOps

case class Character(id: Int, name: String, element: Int, created_at: DateTime, updated_at: DateTime)


trait MysqlConnection {
  //DBコネクション
  val database = Database.forConfig("gblb")
}


object Characters extends MysqlConnection {

  //テーブル定義
  class CharacterTag(tag: Tag) extends Table[Character](tag, "characters") {
    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

    def name = column[String]("name")

    def element = column[Int]("element")

    def created_at = column[DateTime]("created_at")

    def updated_at = column[DateTime]("updated_at")

    def * = (id, name, element, created_at, updated_at) <> (Character.tupled, Character.unapply)
  }

  val characters = TableQuery[CharacterTag]

  /**
    * charactersテーブル全権取得
    *
    * @return
    */
  def all(): Seq[Character] = Await.result(database.run(characters.result), Duration.Inf)
}