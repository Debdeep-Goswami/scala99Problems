package MixedProblems

import scala.concurrent.{Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global

object MyFuture2 extends App {

//  val aFuture = Future {
//    42
//  }

  //  Given Multithreaded Service
  object MyService{

    //  Deterministic Function
    def produceValue(arg:Int) : String = "The value is "+arg

    def submitTask[A](actualArg:A)(function: A=>Unit): Boolean = {
      //  Run the function on arg at some point
      true
    }

    //  Promise
    //  Step 1 - Create a Promise
    val myPromise = Promise[String]

    //  Step 2 - Extract its Future
    val myFuture = myPromise.future

    //  Step 3 - Consume the Future
    val output = myFuture.map(_.toUpperCase())

    //  Step 4
    def asyncCall(promise:Promise[String]) : Unit = {
      promise.success("Promise kept")
    }

    //  Step 5 - Call the producer
    asyncCall(myPromise)


    //  Target
    def giveValue(arg: Int): Future[String] = {
      //  Step 1 - Create the Promise
      val thePromise = Promise[String]()

      //  Step 5 -
      MyService.submitTask(arg){
        x: Int =>
          //  Step 4 - Producer Logic
          val ans = MyService.produceValue(x)
          thePromise.success(ans)
      }

      //  Step 2 - Extract the Future
      thePromise.future

      //  Step 3 - Consume the Future

    }

    println(giveValue(10))
  }
}
