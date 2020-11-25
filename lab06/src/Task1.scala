object Task1 {
  def main(args: Array[String]): Unit = {
    urlChecker("http://fis.agh.edu.pl/dziekanat?test=true&asdf=false")
    urlChecker("me no URL :(")
  }

  object URL{
    def unapply(arg: String): Option[(String, String, String, Map[String,String])] = {
      val regex = "((([A-Za-z]{3,9}:(?:\\/\\/)?)(?:[-;:&=\\+\\$,\\w]+@)?[A-Za-z0-9.-]+|(?:www.|[-;:&=\\+\\$,\\w]+@)[A-Za-z0-9.-]+)((?:\\/[\\+~%\\/.\\w-_]*)?\\??(?:[-\\+=&;%@.\\w_]*)#?(?:[\\w]*))?)"
      if(arg.matches(regex)) {
        val protocol = arg.split("://")
        val host = protocol.apply(1).split("/")
        val path = host.apply(1).split("\\?")
        val query = path.apply(1)
        val maptmp = query.split("&")
        val resultMap = maptmp.map(x=> x.split("=").apply(0) -> x.split("=").apply(1)).toMap
        Some(protocol.apply(0),host.apply(0),path.apply(0),resultMap)
      } else
        None
    }
  }

  def urlChecker(url: String): Unit = {
    url match {
      case URL(protocol, host, path, query) => println(s"protocol=$protocol, host=$host, path=$path, query=$query")
      case _ => println("Wrong URL")
    }
  }
}
