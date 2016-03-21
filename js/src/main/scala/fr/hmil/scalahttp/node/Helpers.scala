package fr.hmil.scalahttp.node

import scala.scalajs.js

/**
  * collection of helper functions for nodejs related stuff
  */
object Helpers {

  /**
    * Tests whether the current environment is commonjs-like
    * @return true if the function "require" is available on the global scope
    */
  def isRequireAvailable: Boolean = !js.isUndefined(js.Dynamic.global.selectDynamic("require"))

  /**
    * Gets javascript module using either require() or the global context
    *
    * @param module Module descriptor
    * @tparam T Module API facade type
    * @return The requested module as a scala facade
    */
  def require[T](module: Module[T]): Option[T] = {
    if (!js.isUndefined(module.inst)) {
      println("Using context")
      Some(module.inst)
    } else if (isRequireAvailable) {
      println("Using require")
      Some(Global.require[T](module.name))
    } else {
      None
    }
  }
}