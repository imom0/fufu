package com.imom0.fufu

/**
 * Created by imom0 on 22/2/15.
 */

import java.io._
import java.net.ServerSocket


class HTTPServer {
  def run(port: Int): Unit = {
    try {
      val listener = new ServerSocket(port)
      while (true) {
        val socket = listener.accept()
        val in = new ObjectInputStream(new DataInputStream(socket.getInputStream()))
        val out = new DataOutputStream(socket.getOutputStream())

        out.close()
        in.close()
        socket.close()
      }
      listener.close()
    }
    catch {
      case e: Exception =>
        System.err.println(e.getMessage())
        System.exit(-1)
    }
  }
}

object HTTPServer extends App {
  val server = new HTTPServer()
  server.run(8000)
}