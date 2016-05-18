package basics

import java.util.Scanner

import scala.reflect.io.File

object Main {
  def withScanner(f: File, op: Scanner => Unit): Unit = {
    val scanner = new Scanner(f.bufferedReader)
    try {
      op(scanner)
    } finally {
      scanner.close()
    }

    def main(args: Array[String]) = {
      withScanner(File("/proc/self/stat"),
        scanner => println("pid is " + scanner.next()))

      println("hi")

    }


  }
}

/*
  // loan pattern
  import scala.reflect.io.File
  import java.util.Scanner
  // 2nd param is a function op with Scanner arg and Unit return type
  def withScanner(f: File, op: Scanner => Unit) = {
    val scanner = new Scanner(f.bufferedReader)
    try {
      /*
    Function op has been loaned with resource scanner
     */
      op(scanner)
    } finally {
      scanner.close()
    }
  }

  withScanner(File("/proc/self/stat"),
    scanner => println("pid is " + scanner.next()))

}
*/



