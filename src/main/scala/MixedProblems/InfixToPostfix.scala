package MixedProblems

import scala.annotation.tailrec
import scala.collection.mutable

object InfixToPostfix {

  private def precedence(char: Char): Int = {
    char match {
      case '+' | '-' => 1
      case '*' | '/' => 2
      case '^' => 3
      case '(' | ')' => 4
      case _ => -1
    }
  }

  private def infixToPostfix(inputExp: String): String = {
    val symbolList: List[Char] = List('+', '-', '*', '/', '^', '(', ')')
    @tailrec
    def inner(inputExp: String, stack: mutable.Stack[Char]): String = {
      if (inputExp.isBlank) {
        if(stack.isEmpty) ""
        else {
//          for(ele <- stack.popAll()){print(ele)}
          stack.popAll().foreach(print)
          ""
        }
      }
      else if (symbolList.contains(inputExp.head)) {
        val c: Char = inputExp.head
        if (c == '(') {
          stack.push(c)
          inner(inputExp.tail, stack)
        }
        else if (c == ')') {
          print(stack.popWhile(x => x != ')'))
          inner(inputExp.tail, stack)
        }
        else{
          while (stack.nonEmpty && precedence(c)<=precedence(stack.head)){
            print(stack.pop)
          }
          stack.push(c)
          inner(inputExp.tail, stack)
        }
      }
      else {
        print(inputExp.head)
        inner(inputExp.tail, stack)
      }
    }

    inner(inputExp, mutable.Stack[Char]())
  }

  def main(args: Array[String]): Unit = {
    val expression: String = "(a*b-c*d)/f"
    print(infixToPostfix(expression))
  }

}
