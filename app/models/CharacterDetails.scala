package models

import org.joda.time.DateTime
import com.github.tototoshi.slick.MySQLJodaSupport._
import slick.driver.MySQLDriver.api._
import slick.jdbc.GetResult
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.language.postfixOps


case class DetailsPage(cha_id: Int, cha_name: String, element: Int, cha_path: String, lb_name: String, lb_path: String)

object DetailsPages extends MysqlConnection {

  def characterShow(id: Int): Seq[DetailsPage] = {
    implicit val getCharacterResult = GetResult(r => DetailsPage(r.<<, r.<<, r.<<, r.<<, r.<<, r.<<))
    val query = sql"""select
                      characters.id,
                      characters.name,
                      characters.element,
                      images.path,
                      lb.name,
                      lb_images.path
                      from characters
                      left join images on characters.id = images.character_id
                      left join character_has_lbs on characters.id = character_has_lbs.character_id
                      left join lb on lb.id = character_has_lbs.lb_id
                      left join lb_images on lb.id = lb_images.lb_id
                      where characters.id = ${id};
      """.as[DetailsPage]
    Await.result(database.run(query), Duration.Inf)
  }
}

case class 