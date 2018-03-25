package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import models._
import play.api.i18n.{I18nSupport, MessagesApi}

class DetailsPages @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport {

  def index(id: Int) = Action { implicit request =>
    val a = DetailsPages.characterShow(id)
    println(a)
    Ok(views.html.characterDetails(a))
  }
}