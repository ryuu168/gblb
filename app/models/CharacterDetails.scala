package models

import org.joda.time.DateTime
import com.github.tototoshi.slick.MySQLJodaSupport._
import slick.driver.MySQLDriver.api._
import slick.jdbc.GetResult
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.language.postfixOps


case class DetailsCharacter(cha_id: Int, cha_name: String, element: Int, cha_path: String)

object DetailsCharacters extends MysqlConnection {

  def characterShow(id: Int): Seq[DetailsCharacter] = {
    implicit val getCharacterResult = GetResult(r => DetailsCharacter(r.<<, r.<<, r.<<, r.<<))
    val query = sql"""select
                      characters.id,
                      characters.name,
                      characters.element,
                      images.path
                      from characters
                      join images on characters.id = images.character_id
                      where characters.id = ${id};
      """.as[DetailsCharacter]
    Await.result(database.run(query), Duration.Inf)
  }
}


case class DetailsLb(cha_id: Int, lb_id: Int, lb_name: String, lb_path: String)

object DetailsLbs extends MysqlConnection {

  def lbList(id: Int): Seq[DetailsLb] = {
    implicit val getCharacterResult = GetResult(r => DetailsLb(r.<<, r.<<, r.<<, r.<<))
    val query = sql"""select
                      characters.id,
                      lb.id,
                      lb.name,
                      lb_images.path
                      from characters
                      left join character_has_lbs on characters.id = character_has_lbs.character_id
                      left join lb on lb.id = character_has_lbs.lb_id
                      left join lb_images on lb.id = lb_images.lb_id
                      where characters.id = ${id};
          """.as[DetailsLb]
    Await.result(database.run(query), Duration.Inf)
  }
}

