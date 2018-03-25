package models

import org.joda.time.DateTime
import com.github.tototoshi.slick.MySQLJodaSupport._
import slick.driver.MySQLDriver.api._
import slick.jdbc.GetResult
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.language.postfixOps


case class LbJoinImage(id: Int, name: String, path: String)

object LbJoinImage extends MysqlConnection {

  def all(): Seq[LbJoinImage] = {
    implicit val getCharacterResult = GetResult(r => LbJoinImage(r.<<, r.<<, r.<<))
    val query = sql"""select
                  lb.id,
                  lb.name,
                  lb_images.path
                  from lb
                  join lb_images
                  on lb.id = lb_images.lb_id;
      """.as[LbJoinImage]
    Await.result(database.run(query), Duration.Inf)
  }
}

