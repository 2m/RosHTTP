package fr.hmil.roshttp.node

import fr.hmil.roshttp.node.http.{Http, HttpJsModule, Https, HttpsJsModule}


/**
  * This object allows to access nodejs builtin modules without explicitely calling require.
  *
  * If a browser shim is used and is accessible in the global context, it will be returned
  * and no call to require() will take place
  */
private[roshttp] object Modules {

  object HttpModule extends Module("http", Http, HttpJsModule)
  object HttpsModule extends Module("https", Https, HttpsJsModule)

  lazy val http: Http = HttpModule.api
  lazy val https: Https = HttpsModule.api
}
