package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import models._
import play.api.i18n.{I18nSupport, MessagesApi}

class DetailsPage @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  def index(id: Int) = Action { implicit request =>
    val chaShow = DetailsCharacters.characterShow(id)
    println(chaShow)
    val lb = DetailsLbs.lbList(id)
    println(lb)
    Ok(views.html.characterDetails(chaShow,lb))
  }
}
