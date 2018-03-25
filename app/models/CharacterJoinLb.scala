package models

import org.joda.time.DateTime
import com.github.tototoshi.slick.MySQLJodaSupport._
import slick.driver.MySQLDriver.api._
import slick.jdbc.GetResult
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.language.postfixOps


case class CharacterJoinLb(chracter_id: Int, lb_id: Int)

object CharacterJoinLb extends MysqlConnection {

  def all(): Seq[CharacterJoinLb] = {
    implicit val getCharacterResult = GetResult(r => CharacterJoinLb(r.<<, r.<<))
    val query = sql"""select
                  characters.id,
                  character_has_lbs.lb_id
                  from characters
                  join character_has_lbs
                  on characters.id = character_has_lbs.character_id;
      """.as[CharacterJoinLb]
    Await.result(database.run(query), Duration.Inf)
  }
}
