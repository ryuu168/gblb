package models

import org.joda.time.DateTime
import com.github.tototoshi.slick.MySQLJodaSupport._
import slick.driver.MySQLDriver.api._
import slick.jdbc.GetResult
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.language.postfixOps


case class CharacterJoinImage(id: Int, name: String, element: Int, path: String)

object CharacterJoinImages extends MysqlConnection {

  def all(): Seq[CharacterJoinImage] = {
    implicit val getCharacterResult = GetResult(r => CharacterJoinImage(r.<<, r.<<, r.<<, r.<<))
    val query = sql"""select
                  characters.id,
                  characters.name,
                  characters.element,
                  images.path
                  from characters
                  join images on characters.id = images.character_id;
      """.as[CharacterJoinImage]
    Await.result(database.run(query), Duration.Inf)
  }
}