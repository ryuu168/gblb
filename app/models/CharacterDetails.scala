package models

import org.joda.time.DateTime
import com.github.tototoshi.slick.MySQLJodaSupport._
import slick.driver.MySQLDriver.api._
import slick.jdbc.GetResult
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.language.postfixOps


case class CharacterDetails(id: Int, name: String, element: Int,  path: String)

object CharacterDetails extends MysqlConnection {

  def characterShow(id: Int): Seq[CharacterDetails] = {
    implicit val getCharacterResult = GetResult(r => CharacterDetails(r.<<, r.<<, r.<<, r.<<))
    val query = sql"""select
                      characters.id,
                      characters.element,
                      images.path,
                      lb.name,
                      ib_images.path
                      from characters
                      left join images on character.id = images.character_id
                      left join character_has_lbs on characters.id = character_has_lbs.character_id
                      left join lb on lb.id = character_has_lbs.lb_id
                      left join lb_images on lb.id = lb_images.lb_id
                      where characters.id = ${id};
      """.as[CharacterDetails]
    Await.result(database.run(query), Duration.Inf)
  }
}
